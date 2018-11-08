(ns nilt.language.morphophonology-test
  (:require [clojure.test :as test]
            [instaparse.core :as insta]
            [nilt.language.core :refer [parser]]))

(defn Ca-parse [s] (insta/parse parser s :start :Ca-test))
(def failure? insta/failure?)
(def success? (complement failure?))

(test/deftest test-Ca-peg-rule
  (test/are [s] (success? (Ca-parse s))
    "x"
    "xa")
  (test/are [s] (failure? (Ca-parse s))
    "w"
    "wa"
    "cm"
    "cma"))

;; TODO add more tests
