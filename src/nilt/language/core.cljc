(ns nilt.language.core
  (:require [instaparse.core :as insta #?(:clj :refer :default :refer-macros) [defparser]]
            [nilt.utils.macros #?(:clj :refer :default :refer-macros) [get-resource]]
            [nilt.language.morphology]
            [nilt.language.morphophonology]))

#?(:cljs enable-console-print!)

(insta/defparser parser (get-resource "grammar.peg"))
