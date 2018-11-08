(ns nilt.language.morphophonology)


(defn multi-invert-map
  "Invert a map (swap keys and values), but create a separate entry for each
   element when a new key would be a vector."
  [m]
  (reduce-kv
   (fn [new-map old-k old-v]
     (if (vector? old-v)
       (into new-map (map vector old-v (repeat old-k)))
       (assoc new-map old-v old-k)))
   {} m))


(defn make-affix
  "Makes an affix, which is a map containing the keys [:category :values
   :gloss]. :category can be a single keyword or a vector of keywords."
  [category affix-values]
  {:category category
   :values affix-values
   :gloss (multi-invert-map affix-values)})


(def main-vowel-sequences
  "The 'main vowel sequences' are defined as the vowels of the VxC affix, from
   degrees 1 to 9. There are four main vowels sequences, numbered 1-4, taken
   from suffix types 1-4 respectively."
  [["a" "e" "o" "u" "i" "ü" "ö" "ë" "â"]
   ["ai" "ei" "oi" "ui" "ëi" "iu" "ou" "eu" "au"]
   [["ia" "aì"] ["ie" "eì"] ["io" "oì"] ["iö" "öì"] "ëu" ["uö" "öù"] ["uo" "où"] ["ue" "eù"] ["ua" "aù"]]
   ["ao" "eo" "oa" "oe" "ea" "öe" "öa" "eö" "aö"]])
(defn get-vowel-sequence [n] (get main-vowel-sequences (dec n)))


(defn apply-recursively
  "Takes a function and a value; if the value is a vector, maps the function
   over each value in the vector recursively. If no val is given, a function
   that takes a val is returned."
  ([func] (fn [val] (apply-recursively func val)))
  ([func val] (if (vector? val)
                (mapv (apply-recursively func) val)
                (func val))))


(defn make-affix-table [multi-category-values affix-values]
  "Make a map from a multidimensional table. The first vector in
   category-values represents the largest/outermost movement within the array.

   Example:
   category-values = [[:a :b] [:c :d] [:e :f]]
   (three categories, each with two values)
   affix-values = [[[1 2] [3 4]] [[5 6] [7 8]]]
   (2x2x2 array = 8 values)
   output = {[:a :c :e] 1
             [:a :c :f] 2
             [:a :d :e] 3
             [:a :d :f] 4
             [:b :c :e] 5
             [:b :c :f] 6
             [:b :d :e] 7
             [:b :d :f] 8}"
  (into {} (reduce
            (fn [kv-pairs category-values]
              (for [[k v] kv-pairs
                    i (range (count category-values))
                    :let [category-value (get category-values i)
                          new-v (get v i)]]
                [(conj k category-value) new-v]))
            {[] affix-values}
            multi-category-values)))


(def Ca1-values {:m nil :p "l" :n "r" :a "n"})
(def Ca2-values-v {:del nil :prx "s" :icp "š" :atv "ţ" :gra "f" :dpl "ç"})
(def Ca2-values+v {:del nil :prx "z" :icp "ž" :atv "ḑ" :gra "v" :dpl "ps"})
(def Ca3-values-v {:csl "x" :aso "k" :var "p" :coa "t"})
(def Ca3-values+v {:csl "ks" :aso "g" :var "b" :coa "d"})
(def Ca4-values {:uni nil :dpx nil :dct "l" :agg "l" :seg "r" :cpn "r" :coh "w" :cst "w" :mlt "y"})
(defn get-valid-Ca-values
  "Find all valid forms of the Ca affix for the given morphological values.

   The Ca affix is complex enough to warrant a function of its own."
  [persp exten affil confg geminate?]
  (let [voiced (#{:dpx :agg :cpn :cst} confg)
        Ca1 (Ca1-values persp)
        Ca2 ((if voiced Ca2-values+v Ca2-values-v) exten)
        Ca3 ((if voiced Ca3-values+v Ca3-values-v) affil)
        Ca4 (Ca4-values confg)
        ;; Footnote 1
        empty-Ca3 (and (boolean Ca2) (= "x" Ca2))
        Ca3 (if-not empty-Ca3 Ca3)
        ;; Gemination rules
        geminate-affix (cond
                         (not geminate?) [nil]
                         (and (nil? Ca1) (nil? Ca2)) [:Ca3]
                         (nil? Ca1) [:Ca2]
                         (nil? Ca2) [:Ca1]
                         :else [:Ca1 :Ca2])
        ;; Footnote 3
        [Ca2 Ca3 Ca4] (case (str Ca2 Ca3 Ca4)
                        "çy" ["p" nil "š"]
                        "xy" [nil "k" "š"]
                        [Ca2 Ca3 Ca4])
        ;; Ca1 asterisk
        Ca1 (if (and (= "n" Ca1)
                     ((set "pbfv") (first (str Ca2 Ca3))))
              "m" Ca1)]
    (vec
      (for [affix geminate-affix]
        (case affix
          :Ca1 (str Ca1 Ca1 Ca2 Ca3 Ca4)
          :Ca2 (str Ca1 Ca2 Ca2 Ca3 Ca4)
          :Ca3 (str Ca1 Ca2 Ca3 Ca3 Ca4)
          (str Ca1 Ca2 Ca3 Ca4))))))


(defn make-Ca-table [geminate?]
  (make-affix-table
   [:perspective :extension :affiliation :configuration]
   (for [persp [:m :p :n :a]
         exten [:del :prx :icp :atv :gra :dpl]
         affil [:csl :aso :var :coa]
         confg [:uni :dpx :dct :agg :seg :cpn :coh :cst :mlt]]
     (get-valid-Ca-values persp exten affil confg geminate?))))


(def affixes

  {:Cv
   (make-affix
    [:version :version] ; [main-stem-valence incorp-stem-valence]
    {[:prc  nil] ["'" nil]
     [:cpt  nil] "h"
     [:prc :prc] "hl"
     [:prc :cpt] "hr"
     [:cpt :prc] "hm"
     [:cpt :cpt] "hn"})

   :Vv
   (make-affix
    :valence
    {:mno nil
     :prl ["ai" "au"]
     :cro ["ei" "eu"]
     :rcp ["oi" "ou"]
     :cpl ["ui" "iu"]
     :dup ["ëi" "ëu"]
     :dem ["iö" "uö"]
     :imt ["io" "uo"]
     :cng ["ie" "ue"]
     :pti ["ia" "ua"]
     :idc "ea"
     :mut "oa"})

   :Vk
   (make-affix
    :illocution
    {:cnf ["a" nil]
     :inf "e"
     :itu "o"
     :sbj "u"
     :hsy "i"
     :usp "ü"
     :dir "ö"
     :irg "ae"
     :pot "â"
      nil "ë"})

   :Vs
   (make-affix
    :sanction
    {:pps nil
     :epi "wa"
     :alg "we"
     :ipu "wo"
     :rfu "wu"
     :reb "wi"
     :thr "wü"
     :exv "wö"
     :axm "wâ"})

   :Vp
   (make-affix
    :phase
    {:ctx nil
     :pct "ya"
     :itr "ye"
     :rep "yo"
     :itm "yu"
     :rct "yi"
     :fre "yü"
     :frg "yö"
     :flc "yâ"})

   :Vl
   (make-affix
    [:level-type :level]
    (make-affix-table [[:r :a] [:min :sbe :ifr :dfc :equ :sur :spl :spq :max]]
     [(apply-recursively #(str "w" %) (get-vowel-sequence 2))
      (apply-recursively #(str "y" %) (get-vowel-sequence 2))]))

   :Va
   (make-affix
    :aspect
    (into {}
     (map vector
      [:rtr :prs :hab :prg :imm :pcs :reg :exp :atp
       :rsm :css :rcs :pau :rgr :pcl :cnt :ics :irp
       :pmp :clm :dlt :tmp :mtv :sqn :epd :ptc :ppr
       :dcl :ccl :cul :imd :trd :tns :itc :csm :lim]
      (apply concat (assoc-in main-vowel-sequences [0 7] "ae")))))

   :Vr
   (make-affix
    [:context :stem :function]
    (make-affix-table
     [[:exs :fnc :rps :amg] [:stem-1 :stem-2 :stem-3] [:sta :dyn :mnf :ich]]
     [[["a" "â" "ae" "a'"] ["ai" ["ia" "aì"] "ao" "ai'"] ["au" ["ua" "aù"] "aö" "au'"]]
      [["e" "i" "ea" "e'"] ["ei" ["ie" "eì"] "eo" "ei'"] ["eu" ["ue" "eù"] "eö" "eu'"]]
      [["o" "ö" "oa" "o'"] ["oi" ["io" "oì"] "oe" "oi'"] ["ou" ["uo" "où"] "öe" "ou'"]]
      [["u" "ü" "öa" "u'"] ["ui" ["iö" "öì"] "ëi" "ui'"] ["iu" ["uö" "öù"] "ëu" "iu'"]]]))

   :Cm
   (make-affix
    :mood
    {:fac ["l" nil]
     :sub "r"
     :asm "m"
     :spc "n"
     :cou "ll"
     :hyp "rr"
     :imp "mm"
     :asc "nn"})

   :Ca-no-gem
   (make-affix
    [:perspective :extension :affiliation :configuration]
    (make-Ca-table nil))

   :Ca-with-gem
   (make-affix
    [:perspective :extension :affiliation :configuration]
    (make-Ca-table :geminate))

   :Vx
   (make-affix
    [:suffix-type :suffix-degree]
    (make-affix-table
     [[:t1 :t2 :t3 :t4 :t5 :t6] [:d1 :d2 :d3 :d4 :d5 :d6 :d7 :d8 :d9]]
     (conj
      main-vowel-sequences
      (apply-recursively #(str % "wë") (get-vowel-sequence 1))
      (apply-recursively #(str % "yë") (get-vowel-sequence 1)))))

   :Vc-no-alt
   (make-affix
    :case
    (into {}
     (map vector
      [:thm :abs :erg :ind :aff :dat :eff :der :ins
       :pos :prp :gen :att :pdc :itp :ogn :idp :par
       :apl :pur :ben :dfr :tsp :crs :cmm :csd :cfm
       :con :avr :cvs :sit :tfm :fun :cla :rst :rsl]
      (apply concat (assoc-in main-vowel-sequences [0 7] "ae")))))

   :Vc-with-alt
   (make-affix
    :case
    (into {}
     (map vector
      [:loc :atd :ori :all :abl :nav :int :irl :prt
       :ass :acs :cnr :per :pro :pcv :pcr :elp :plm
       :ref :cor :cps :dep :pvs :prd :ess :asi :sbl
       :voc :eps :com :cnj :utl :dsc :rlt :trm :cmp]
      (apply concat (assoc-in main-vowel-sequences [0 7] "ae")))))

   :boreg ; boreg = Beginning of register clause
   (make-affix
    :register
    {:dsv "ha"
     :pth "he"
     :cog "ho"
     :exm "hö"
     :ipr "hu"
     :math "hai"})

   :eoreg ; eoreg = End of register clause
   (make-affix
    :register
    {:dsv "hia"
     :pth "hie"
     :cog "hio"
     :exm "hiö"
     :ipr "hiù"
     :math "hau"})

   :Cref ; Cref = Consontal PRA referent
   (make-affix
    :referent
    {:_1m "s"
     :_2m "k"
     :_2p "t"
     :ma  "r"
     :pa  "l"
     :mi  "m"
     :pi  "f"
     :IPa "n"
     :IPi "p"
     :Obv "ţ"
     :Col "ç"
     :Abt "š"})})
