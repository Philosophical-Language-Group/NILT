(ns nilt.language.phonotactics
  (:require [clojure.string :as str]
            [instaparse.core :as insta]
            [nilt.language.parsers :as parsers]
            [nilt.language.phonology :as phono]))


(defn split-syllables
  "Split a word into syllables. The zeroth syllable contains all consonants
   before the first vowel; all subsequent syllables begin with a vowel (or
   syllabic consonant). Thus the number of syllables is one less than the length
   of the return value of this function.

   Each syllable consists of a vector with three elements: [syllable-type
   stressed nucleus following-consonants]. syllable-type is one of #{nil
   :consonant :vowel :diphthong :explicit-disyllabic}. :consonant is used for
   syllabic consonants and :explicit-disyllabic is used for explicitly
   stressed/unstressed vowels that could otherwise be part of a diphthong.

   Note that stressed is only true when marked in the word; default stress
   patterns are not considered by this function."
  [word]
  ;; Example parse for 'mbakat':
  ; [:word [:unstressed-syllabic-consonant "m"]
  ;        [:initial-cluster "b"]
  ;        [:unstressed-vowel "a"]]
  ;        [:intervocalic-cluster "k"]
  ;        [:unstressed-vowel "a"]]
  ;        [:final-cluster "t"]]
  ;; This is then converted into the following form:
  ; ([nil nil nil ""]
  ;  [:consonant false "m" "b"]
  ;  [:vowel false "a" "k"]
  ;  [:vowel false "a" "t"])

  ;; Example parse for 'mraiköìtéulìa':
  ; [:word [:initial-cluster "mr"]
  ;        [:unstressed-diphthong "ai"]
  ;        [:intervocalic-cluster "k"]
  ;        [:unstressed-vowel "ö"]
  ;        [:unstressed-explicit-disyllabic "ì"]
  ;        [:intervocalic-cluster "t"]
  ;        [:stressed-diphthong "éu"]
  ;        [:intervocalic-cluster "l"]
  ;        [:unstressed-vowel "ì"]
  ;        [:unstressed-vowel "a"]
  ;; This is then converted into the following form:
  ; ([nil                  nil   nil  "mr"]
  ;  [:diphthong           false "ai" "k"]
  ;  [:explicit-disyllabic false "öì" "t"]
  ;  [:diphthong           true  "éu" "l"]
  ;  [:vowel               false "ì"  ""]
  ;  [:vowel               false "a"  ""])
  (->> word
    (insta/parse parsers/syllables)
    ; (letfn [(consonant-transform [s] [:consonant s])] ;; TODO won't work with threading macro
    ;   (insta/transform {:initial-cluster consonant-transform
    ;                     :intervocalic-cluster consonant-transform
    ;                     :final-cluster consonant-transform
    ;                     :word vector}))
    (#(if (insta/failure? %)
        (throw (ex-info
                 "Error parsing word"
                 {:word word
                  :parse-failure (insta/get-failure %)}))
        %))
    ;; Ignore the :word tag at the root.
    (rest)
    (reduce (fn [[current-syllable & remaining-syllables] [chunk-type chunk-str]]
              (if (#{:initial-cluster :intervocalic-cluster :final-cluster}
                   chunk-type)
                ;; Append non-syllabic consonants to the end of the previous
                ;; syllable.
                (conj remaining-syllables
                      (update current-syllable 3 str chunk-str))
                ;; Append a new syllable for a vowel or syllabic consonant.
                (let [;; Split a keyword like :stressed-explicit-disyllabic
                      ;; into "stressed" and "explicit-disyllabic".
                      [stressed type] (str/split (name chunk-type) #"-" 2)
                      type (keyword type)
                      ;; Convert "stressed" or "unstressed" into a boolean.
                      stressed (case stressed
                                 "stressed" true
                                 "unstressed" false
                                 (throw (ex-info
                                         "Unknown whether this chunk is stressed or unstressed"
                                         {:chunk-type chunk-type
                                          :chunk-str chunk-str})))]
                  (conj remaining-syllables
                        current-syllable
                        [type stressed chunk-str nil]))))
            ;; Start with a single empty syllable to house an initial
            ;; consonant cluster.
            '([nil nil nil nil]))
    ;; Put the syllables back in order again.
    (reverse)))

;; TODO Also remember to explicitly unstress < ìV > at the beginning of a cluster to distinguish it from < yV >
