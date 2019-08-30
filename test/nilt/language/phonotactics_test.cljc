(ns nilt.language.phonotactics-test
  (:require [clojure.test :refer [deftest is]]
            [nilt.language.phonotactics :as phonotax]))

(deftest test-split-syllables
  ;; Vowel-only
  (is (= [[nil nil nil nil]
          [:vowel false "a" nil]]
         (phonotax/split-syllables "a")))
  (is (= [[nil nil nil nil]
          [:vowel false "è" nil]]
         (phonotax/split-syllables "è")))
  (is (= [[nil nil nil nil]
          [:vowel false "i" nil]
          [:vowel false "e" nil]]
         (phonotax/split-syllables "ie")))
  (is (= [[nil nil nil nil]
          [:diphthong false "ei" nil]]
         (phonotax/split-syllables "ei")))
  (is (= [[nil nil nil nil]
          [:vowel true "í" nil]]
         (phonotax/split-syllables "í")))
  ;; CVCVC with diphthong
  (is (= [[nil nil nil "šl"]
          [:diphthong false "ei" "t"]
          [:vowel false "ö" "rk"]]
         (phonotax/split-syllables "šleitörk")))
  ;; Many syllables
  (is (= [[nil nil nil "mr"]
          [:diphthong false "ai" "k"]
          [:vowel false "ö" nil]
          [:explicit-disyllabic false "ì" "t"]
          [:diphthong true "éu" "l"]
          [:vowel false "ì" nil]
          [:vowel false "a" nil]]
         (phonotax/split-syllables "mraiköìtéulìa")))
  ;; Word-initial syllabic consonant (from Phonotaxis v0.4 PDF)
  (is (= [[nil nil nil nil]
          [:syllabic-consonant false "m" "b"]
          [:vowel false "a" "k"]
          [:vowel false "a" "t"]]
         (phonotax/split-syllables "mbakat"))))
