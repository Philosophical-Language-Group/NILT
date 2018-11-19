(ns nilt.language.morphology)


(defn make-ordered-lookup [keys data]
  (let [data-by-key (into {} (map vector keys (apply map vector data)))
        first-data (mapv first data)]
    (into {(first keys) first-data}
          (for [key (rest keys)]
            [key (into {} (map vector first-data (get data-by-key key)))]))))


;;; Example:
;;
;; (def perspective
;;   (make-ordered-lookup
;;    [ :abbrs :names     :descs]
;;    [[:m     "Monadic"  "Basic singular"]
;;     [:p     "Polyadic" "Basic plural"]
;;     [:n     "Nomic"    "All instances of X"]
;;     [:a     "Abstract" "The idea of X / X-ness"]]))
;;
;;; is equivalent to:
;;
;; (def perspective
;;   {:abbrs [:m :p :n :a],
;;    :names {:m "Monadic",
;;            :p "Polyadic",
;;            :n "Nomic",
;;            :a "Abstract"},
;;    :descs {:m "Basic singular",
;;            :p "Basic plural",
;;            :n "All instances of X",
;;            :a "The idea of X / X-ness"}})


;;; Keys used:
;;
;; :abbrs - Abbreviations (required)
;; :names - Human-friendly names (required)
;; :gloss - Gloss (defaults to uppercased :abbrs if not present)
;; :descs - Short human-friendly descriptions
;; :links - Links to relevant documentation


(defn get-gloss [category abbr]
  (get-in category [:gloss abbr] (clojure.string/upper-case (name abbr))))


(def cases
  (make-ordered-lookup
   [:categories :members]

   [[:transrelative
     (make-ordered-lookup
      [:abbrs :names]
      [[:thm "Thematic"]
       [:abs "Absolutive"]
       [:erg "Ergative"]
       [:ind "Inducive"]
       [:aff "Affective"]
       [:dat "Dative"]
       [:eff "Effectuative"]
       [:der "Derivative"]
       [:ins "Instrumental"]])]

    [:appositive
     (make-ordered-lookup
      [:abbrs :names]
      [[:pos "Possessive"]
       [:prp "Proprietive"]
       [:gen "Genitive"]
       [:att "Attributive"]
       [:pdc "Productive"]
       [:itp "Interpretive"]
       [:ogn "Originative"]
       [:idp "Interdependent"]
       [:par "Partitive"]])]

    [:associative
     (make-ordered-lookup
      [:abbrs :names]
      [[:apl "Applicative"]
       [:pur "Purposive"]
       [:ben "Benefactive"]
       [:dfr "Deferential"]
       [:tsp "Transpositive"]
       [:crs "Contrastive"]
       [:cmm "Commutative"]
       [:csd "Considerative"]
       [:cfm "Conformative"]])]

    [:adverbial
     (make-ordered-lookup
      [:abbrs :names]
      [[:con "Concessive"]
       [:avr "Aversive"]
       [:cvs "Conversive"]
       [:sit "Situative"]
       [:tfm "Transformative"]
       [:fun "Functive"]
       [:cla "Classificative"]
       [:rst "Restrictive"]
       [:rsl "Resultative"]])]

    [:spatio-temporal-1
     (make-ordered-lookup
      [:abbrs :names]
      [[:loc "Locative"]
       [:atd "Attendant"]
       [:ori "Orientative"]
       [:all "Allative"]
       [:abl "Ablative"]
       [:nav "Navigative"]
       [:int "Intrative"]
       [:irl "Interrelative"]
       [:prt "Precurrent"]])]

    [:spatio-temporal-2
     (make-ordered-lookup
      [:abbrs :names]
      [[:ass "Assessive"]
       [:acs "Accessive"]
       [:cnr "Concursive"]
       [:per "Periodic"]
       [:pro "Prolapsive"]
       [:pcv "Precursive"]
       [:pcr "Postcursive"]
       [:elp "Elapsive"]
       [:plm "Prolimitive"]])]

    [:relational-1
     (make-ordered-lookup
      [:abbrs :names]
      [[:ref "Referential"]
       [:cor "Correlative"]
       [:cps "Compositive"]
       [:dep "Dependent"]
       [:pvs "Provisional"]
       [:prd "Predicative"]
       [:ess "Essive"]
       [:asi "Assimilative"]
       [:sbl "Semblative"]])]

    [:relational-2
     (make-ordered-lookup
      [:abbrs :names]
      [[:voc "Vocative"]
       [:eps "Episodic"]
       [:com "Comitative"]
       [:cnj "Conjunctive"]
       [:utl "Utilitative"]
       [:dsc "Descriptive"]
       [:rlt "Relative"]
       [:trm "Terminative"]
       [:cmp "Comparative"]])]]))


(def categories

  {:version
   (make-ordered-lookup
    [:abbrs :names]
    [[:prc "Processual"]
     [:cpt "Completive"]])

   :valence
   (make-ordered-lookup
    [:abbrs :names]
    [[:mno "Monoactive"]
     [:prl "Parallel"]
     [:cro "Corollary"]
     [:rcp "Reciprocal"]
     [:cpl "Complementary"]
     [:dup "Duplicative"]
     [:dem "Demonstrative"]
     [:imt "Imitative"]
     [:cng "Contingent"]
     [:pti "Participative"]
     [:idc "Indicative"]
     [:mut "Mutual"]])

   :illocution
   (make-ordered-lookup
    [:abbrs :names]
    [[:cnf "Confirmative"]
     [:inf "Inferential"]
     [:itu "Intuitive"]
     [:sbj "Revelatory"]
     [:hsy "Hearsay"]
     [:usp "Unspecified"]
     [:dir "Directive"]
     [:pot "Potentiative"]
     [:irg "Interrogative"]])

   :sanction
   (make-ordered-lookup
    [:abbrs :names]
    [[:pps "Propositional"]
     [:epi "Epistemic"]
     [:alg "Allegative"]
     [:ipu "Imputative"]
     [:rfu "Refutative"]
     [:reb "Rebuttative"]
     [:thr "Theoretical"]
     [:exv "Expatiative"]
     [:axm "Axiomatic"]])

   :phase
   (make-ordered-lookup
    [:abbrs :names]
    [[:ctx "Contextual"]
     [:pct "Punctual"]
     [:itr "Iterative"]
     [:rep "Repetitive"]
     [:itm "Intermittent"]
     [:rct "Recurrent"]
     [:fre "Frequentative"]
     [:frg "Fragmentative"]
     [:flc "Fluctuative"]])

   :level
   (make-ordered-lookup
    [:abbrs :names]
    [[:min "Minimal"]
     [:sbe "Subequative"]
     [:ifr "Inferior"]
     [:dfc "Deficient"]
     [:equ "Equative"]
     [:sur "Surpassive"]
     [:spl "Superlative"]
     [:spq "Superequative"]
     [:max "Maximal"]])

   :level-type
   (make-ordered-lookup
    [:abbrs :gloss :names]
    [[:r "r" "Relative"]
     [:a "a" "Absolute"]])

   :aspect
   (make-ordered-lookup
    [:abbrs :names]
    [[:rtr "Retrospective"]
     [:prs "Prospective"]
     [:hab "Habitual"]
     [:prg "Progressive"]
     [:imm "Imminent"]
     [:pcs "Precessive"]
     [:reg "Regulative"]
     [:exp "Experiential"]
     [:atp "Anticipatory"]
     [:rsm "Resumptive"]
     [:css "Cessative"]
     [:pau "Pausal"]
     [:rgr "Regressive"]
     [:pcl "Preclusive"]
     [:cnt "Continuative"]
     [:ics "Incessative"]
     [:rcs "Summative"]
     [:irp "Interruptive"]
     [:pmp "Preemptive"]
     [:clm "Climactic"]
     [:dlt "Dilatory"]
     [:tmp "Temporary"]
     [:mtv "Motive"]
     [:sqn "Sequential"]
     [:epd "Expeditive"]
     [:ptc "Protractive"]
     [:ppr "Preparatory"]
     [:dcl "Disclusive"]
     [:ccl "Conclusive"]
     [:cul "Culminative"]
     [:imd "Intermediative"]
     [:trd "Tardative"]
     [:tns "Transitional"]
     [:itc "Intercommutative"]
     [:csm "Consumptive"]
     [:lim "Limitative"]])

   :context
   (make-ordered-lookup
    [:abbrs :names]
    [[:exs "Existential"]
     [:fnc "Functional"]
     [:rps "Representational"]
     [:amg "Amalgamative"]])

   :function
   (make-ordered-lookup
    [:abbrs :names]
    [[:sta "Stative"]
     [:dyn "Dynamic"]
     [:mnf "Manifestive"]
     [:ich "Incohative"]])

   :stem
   (make-ordered-lookup
    [:abbrs :gloss :names]
    [[:stem-1 "S1" "Stem 1"]
     [:stem-2 "S2" "Stem 2"]
     [:stem-3 "S3" "Stem 3"]])

   :mood
   (make-ordered-lookup
    [:abbrs :names]
    [[:fac "Factual"]
     [:sub "Subjunctive"]
     [:asm "Assumptive"]
     [:spc "Speculative"]
     [:cou "Counterfactive"]
     [:hyp "Hypothetical"]
     [:imp "Implicative"]
     [:asc "Ascriptive"]])

   :perspective
   (make-ordered-lookup
    [:abbrs :names]
    [[:m "Monadic"]
     [:p "Polyadic"]
     [:n "Nomic"]
     [:a "Abstract"]])

   :extension
   (make-ordered-lookup
    [:abbrs :names]
    [[:del "Delimitive"]
     [:prx "Proximative"]
     [:icp "Inceptive"]
     [:atv "Attenutive"]
     [:gra "Gradual"]
     [:dpl "Depletive"]])

   :affiliation
   (make-ordered-lookup
    [:abbrs :names]
    [[:csl "Consolidative"]
     [:aso "Associative"]
     [:var "Variadic"]
     [:coa "Coalescent"]])

   :configuration
   (make-ordered-lookup
    [:abbrs :names]
    [[:uni "Uniplex"]
     [:dpx "Duplex"]
     [:dct "Discrete"]
     [:agg "Aggregative"]
     [:seg "Segregative"]
     [:cpn "Componential"]
     [:coh "Coherent"]
     [:cst "Composite"]
     [:mlt "Multiform"]])

   :suffix-type
   (make-ordered-lookup
    [:abbrs :gloss :names]
    [[:t1 "¹" "Type 1"]
     [:t2 "²" "Type 2"]
     [:t3 "³" "Type 3"]
     [:t4 "⁴" "Type 4"]
     [:t5 "⁵" "Type 5"]
     [:t6 "⁶" "Type 6"]])

   :suffix-degree
   (make-ordered-lookup
    [:abbrs :gloss :names]
    [[:d1 "₁" "Degree 1"]
     [:d2 "₂" "Degree 2"]
     [:d3 "₃" "Degree 3"]
     [:d4 "₄" "Degree 4"]
     [:d5 "₅" "Degree 5"]
     [:d6 "₆" "Degree 6"]
     [:d7 "₇" "Degree 7"]
     [:d8 "₈" "Degree 8"]
     [:d9 "₉" "Degree 9"]])

   :case
   (let [case-members (-> cases :members vals)]
     (merge {:abbrs (->> case-members (mapcat :abbrs) vec)}
            (dissoc (apply merge-with merge case-members) :abbrs)))

   :designation
   (make-ordered-lookup
    [:abbrs :names]
    [[:inf "Informal"]
     [:fml "Formal"]])

   :register ; These abbreviations are inferred, not listed in the NLRv0.2
   (make-ordered-lookup
    [:abbrs :names]
    [[:dsv "Discursive"]
     [:pth "Parenthetical"]
     [:cog "Cogitant"]
     [:exm "Exemplificative"]
     [:ipr "Impressionistic"]
     ;; TODO: No official abbreviation for Mathematical register
     [:math "Mathematical"]])

   :referent
   (make-ordered-lookup
    [:abbrs :gloss :names]
    [[:_1m "1m"  "monadic speaker"]
     [:_2m "2m"  "monadic addressee"]
     [:_2p "2p"  "polyadic addressee"]
     [:ma  "ma"  "monadic animate 3rd party"]
     [:pa  "pa"  "polyadic animate 3rd party"]
     [:mi  "mi"  "monadic inanimate 3rd party"]
     [:pi  "pi"  "polyadic inanimate 3rd party"]
     [:IPa "IPa" "impersonal animate"]
     [:IPi "IPi" "impersonal inanimate"]
     [:Obv "Obv" "obviative"]
     [:Col "Col" "Collective"]
     [:Abt "Abt" "Abstract"]])})
