(ns nilt.language.core
  (:require [instaparse.core :as insta #?(:clj :refer :default :refer-macros) [defparser]]
            [nilt.utils.macros #?(:clj :refer :default :refer-macros) [get-resource]]))

(enable-console-print!)

(insta/defparser p (get-resource "grammar.peg"))

(prn p)
