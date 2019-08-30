(ns nilt.language.phonotactics-test
  (:require [clojure.test :refer [deftest is]]
            [nilt.language.phonotactics :as phonotax]))

(deftest test-split-syllables
  ;; Vowel-only
  (is (= (phonotax/split-syllables "a")
         [[nil nil nil nil]
          [:vowel false "a" nil]]))
  (is (= (phonotax/split-syllables "è")
         [[nil nil nil nil]
          [:vowel false "è" nil]]))
  (is (= (phonotax/split-syllables "ie")
         [[nil nil nil nil]
          [:vowel false "i" nil]
          [:vowel false "e" nil]]))
  (is (= (phonotax/split-syllables "ei")
         [[nil nil nil nil]
          [:diphthong false "ei" nil]]))
  (is (= (phonotax/split-syllables "í")
         [[nil nil nil nil]
          [:vowel true "í" nil]]))
  ;; CVCVC with diphthong
  (is (= (phonotax/split-syllables "šleitörk")
         [[nil nil nil "šl"]
          [:diphthong false "ei" "t"]
          [:vowel false "ö" "rk"]]))
  ;; Many syllables
  (is (= (phonotax/split-syllables "mraiköìtéulìa")
         [[nil nil nil "mr"]
          [:diphthong false "ai" "k"]
          [:vowel false "ö" nil]
          [:explicit-disyllabic false "ì" "t"]
          [:diphthong true "éu" "l"]
          [:vowel false "ì" nil]
          [:vowel false "a" nil]]))
  ;; Word-initial syllabic consonant (from Phonotaxis v0.4 PDF)
  (is (= [[nil nil nil nil]
          [:syllabic-consonant false "m" "b"]
          [:vowel false "a" "k"]
          [:vowel false "a" "t"]]
         (phonotax/split-syllables "mbakat"))))
