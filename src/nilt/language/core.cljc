(ns nilt.language.core
  (:require [instaparse.core :as insta #?(:clj :refer :default :refer-macros) [defparser]]
            [nilt.utils.macros #?(:clj :refer :default :refer-macros) [get-resource]]
            [nilt.language.morphology]
            [nilt.language.morphophonology]
            [nilt.language.phonotactics]))

; (nilt.language.phonotactics/say-hi)

; #?(:cljs enable-console-print!)

; (println (get-resource "ebnf/grammar.ebnf"))

; (insta/defparser parser (get-resource "grammar.ebnf"))
