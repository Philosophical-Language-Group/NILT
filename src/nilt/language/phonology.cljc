(ns nilt.language.phonology)


;; This file deals exclusively with lowercase letters; everything should be
;; lowercased before passing it through here.


(defn double-map
  "Assoc each key to its value so that the map can be used to do lookups
   backwards and forwards."
  [m]
  (reduce-kv
   (fn [new-map k v]
     (assoc new-map v k))
   m m))

(def consonants
  (double-map
   {\p [:-v :labial             :stop]
    \b [:+v :labial             :stop]
    \t [:-v :apicodental        :stop]
    \d [:+v :apicodental        :stop]
    \k [:-v :velar              :stop]
    \g [:+v :velar              :stop]
    \' [:-v :glottal            :stop]
    \f [:-v :labiodental        :fricative]
    \v [:+v :labiodental        :fricative]
    \ţ [:-v :interdental        :fricative]
    \ḑ [:+v :interdental        :fricative]
    \s [:-v :apicoalveolar      :fricative]
    \z [:+v :apicoalveolar      :fricative]
    \š [:-v :alveolopalatal     :fricative]
    \ž [:+v :alveolopalatal     :fricative]
    \x [:-v :uvular             :fricative]
    \h [:-v :glottal            :fricative]
    \ļ [:-v :lateral            :fricative]
    \c [:-v :apicoalveolar      :affricate]
    \ż [:+v :apicoalveolar      :affricate]
    \č [:-v :alveolopalatal     :affricate]
    \j [:+v :alveolopalatal     :affricate]
    \m [:+v :labial             :nasal]
    \n [:+v :apicodental        :nasal]
    \ň [:+v :velar              :nasal]
    \r [:+v :alveolar-retroflex :liquid]
    \l [:+v :lateral            :liquid]
    \w [:+v :labiodental        :appoximant]
    \y [:+v :palatal            :appoximant]
    \ř [:+v :uvular             :appoximant]}))

; (def consonants-set (set "pbtdkg'fvţḑszšžxhļcżčjmnňrlwyř"))

(def consonants-by-type (dissoc (group-by #(get-in % [1 2]) consonants) nil))

(def affricates
  (double-map
   {\c "ts", \ż "dz", \č "tš", \j "dž"}))

(def vowels
  (double-map
   {\i [:high :front   :-r]
    \ü [:high :front   :+r]
    \u [:high :back    :+r]
    \e [:mid  :front   :-r]
    \ö [:mid  :front   :+r]
    \ë [:mid  :back    :-r]
    \o [:mid  :back    :+r]
    \a [:low  :central :-r]
    \ä [:low  :back    nil]}))

(def diphthongs
  #{"ai" "ei" "ëi" "oi" "öi" "ui" "au" "eu" "ëu" "iu" "ou" "öu"})

(defn +v
  "Get the voiced variants of all consonants in a string. If a consonant cannot
   be voiced, return the original."
  [string]
  (apply str (map #(get consonants (assoc (consonants %) 0 :+v) %) string)))

(defn -v
  "Get the devoiced variants of all consonants in a string. If a consonant
   cannot be devoiced, return the original."
  [string]
  (apply str (map #(get consonants (assoc (consonants %) 0 :-v) %) string)))

(def geminate-chars
  "The set of consonant characters that are phonotactically allowed to be
   geminated.

   Basically, all consonants except 'w', 'y', and the glottal stop."
  (set "bcčdḑfghjklļmnňprřsštţvxzżž"))

(defn geminate
  "Return a vector possible geminate forms of a consonant cluster. The
   consonants 'w' and 'y' cannot be geminated."
  [cluster]
  (->> cluster
    (map-indexed (fn [i char]
                   (when (geminate-chars char)
                     (str (subs cluster 0 (inc i))
                          (subs cluster i)))))
    (filter identity)
    (vec)))
