(ns nilt.language.morphophonology)

;; [:a1 :a2 :a3] - sequence of affixes
;; (:choice :a1 :a2 :a3) - mutually exclusive affixes
;; (:optional :a) - optional affix
;; (:optional [:a1 :a2 :a3]) - multiple codedependent optional affixes
;; (:repeatable :a) - repeatable affix (zero or more)
;; :Ca - single affix
;; "h" - literal string

(defn optional [a]
  (list :choice a))

(defn choice [& affixes]
  (conj (seq affixes) :choice))

(defn repeatable [a]
  (list :repeatable a))

(def CmV-module
  (optional [:Cm (choice :Vk :Vs :Vp :Vv :Vl)]))

(def wyVa-module
  (optional [(choice "'w" "'y") :Va]))

(def C1 [:Cref (repeatable :Cref)])
(def C2 C1)
(def C1+2 [:Cref :Cref (repeatable :Cref)])

(def formative
  [(choice
    [(optional [:Cv (choice :Vk :Vv)])
     (optional (choice :Vs :Vp :Vl))
     wyVa-module]
    [:Cv :Vf :Ci :Vi])
   :Cr
   :Vr
   CmV-module
   :Ca
   (repeatable :VxC)
   (optional :Vc)])

(def carrier-adjunct
  ["h" :Vr :Ca :Vc])

(def general-adjunct
  ["hw"
   (choice :Vk :Vv "ë")
   (optional (choice :Vs :Vp :Vl))
   wyVa-module
   CmV-module
   (optional :Ca (repeatable :VxC) (choice :Va "ë"))])

(def case-adjunct
  ["hl"
   :Vc
   CmV-module])

(def aspect-adjunct
  [(optional "hm")
   :Va
   wyVa-module])

(def single-affix-adjunct
  [(optional "hn")
   :VxC
   (choice "ë" :Va)])

(def multi-affix-adjunct
  [(optional "hr")
   :VxC
   (choice :Va "ë")
   (choice "x" "xw" "ň" "ňw") ; TODO: This affix depends on what the 6th slot conveys
   (repeatable :VxC)
   (choice "ë" :Va :Vl :Vv :Vc)])

(def register-adjunct
  (choice :boreg :eoreg))

(def pra
  ["h" :Vc C1])

(def dual-pra
  [(optional :Va) C1 :Vc "ps" :Vc C2])

(def complex-pra
  [(optional "h") :Vc C1+2 :Vr (choice "pš" "kš") (repeatable :VxC) (choice "ë" :Va)])
