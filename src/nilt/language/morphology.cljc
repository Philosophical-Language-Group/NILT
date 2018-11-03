(ns nilt.language.morphology)


(def cases

  {:transrelative
   {:thm "Thematic"
    :abs "Absolutive"
    :erg "Ergative"
    :ind "Inducive"
    :aff "Affective"
    :dat "Dative"
    :eff "Effectuative"
    :der "Derivative"
    :ins "Instrumental"}

   :appositive
   {:pos "Possessive"
    :prp "Proprietive"
    :gen "Genitive"
    :att "Attributive"
    :pdc "Productive"
    :itp "Interpretive"
    :ogn "Originative"
    :idp "Interdependent"
    :par "Partitive"}

   :associative
   {:apl "Applicative"
    :pur "Purposive"
    :ben "Benefactive"
    :dfr "Deferential"
    :tsp "Transpositive"
    :crs "Contrastive"
    :cmm "Commutative"
    :csd "Considerative"
    :cfm "Conformative"}

   :adverbial
   {:con "Concessive"
    :avr "Aversive"
    :cvs "Conversive"
    :sit "Situative"
    :tfm "Transformative"
    :fun "Functive"
    :cla "Classificative"
    :rst "Restrictive"
    :rsl "Resultative"}

   :spatio-temporal-1
   {:loc "Locative"
    :atd "Attendant"
    :ori "Orientative"
    :all "Allative"
    :abl "Ablative"
    :nav "Navigative"
    :int "Intrative"
    :irl "Interrelative"
    :prt "Precurrent"}

   :spatio-temporal-2
   {:ass "Assessive"
    :acs "Accessive"
    :cnr "Concursive"
    :per "Periodic"
    :pro "Prolapsive"
    :pcv "Precursive"
    :pcr "Postcursive"
    :elp "Elapsive"
    :plm "Prolimitive"}

   :relational-1
   {:ref "Referential"
    :cor "Correlative"
    :cps "Compositive"
    :dep "Dependent"
    :pvs "Provisional"
    :prd "Predicative"
    :ess "Essive"
    :asi "Assimilative"
    :sbl "Semblative"}

   :relational-2
   {:voc "Vocative"
    :eps "Episodic"
    :com "Comitative"
    :cnj "Conjunctive"
    :utl "Utilitative"
    :dsc "Descriptive"
    :rlt "Relative"
    :trm "Terminative"
    :cmp "Comparative"}})


(def categories

  {:version
   {:prc "Processual"
    :cpt "Completive"}

   :valence
   {:mno "Monoactive"
    :prl "Parallel"
    :cro "Corollary"
    :rcp "Reciprocal"
    :cpl "Complementary"
    :dup "Duplicative"
    :dem "Demonstrative"
    :imt "Imitative"
    :cng "Contingent"
    :pti "Participative"
    :idc "Indicative"
    :mut "Mutual"}

   :illocution
   {:cnf "Confirmative"
    :inf "Inferential"
    :itu "Intuitive"
    :sbj "Subjective"
    :hsy "Hearsay"
    :usp "Unspecified"
    :dir "Directive"
    :irg "Interrogative"
    :pot "Potentiative"}

   :sanction
   {:pps "Propositional"
    :epi "Epistemic"
    :alg "Allegative"
    :ipu "Imputative"
    :rfu "Refutative"
    :reb "Rebuttative"
    :thr "Theoretical"
    :exv "Expatiative"
    :axm "Axiomatic"}

   :phase
   {:ctx "Contextual"
    :pct "Punctual"
    :itr "Iterative"
    :rep "Repetitive"
    :itm "Intermittent"
    :rct "Recurrent"
    :fre "Frequentative"
    :frg "Fragmentative"
    :flc "Fluctuative"}

   :level
   {:min "Minimal"
    :sbe "Subequative"
    :ifr "Inferior"
    :dfc "Deficient"
    :equ "Equative"
    :sur "Surpassive"
    :spl "Superlative"
    :spq "Superequative"}

   :aspect
   {:rtr "Retrospective"
    :prs "Prospective"
    :hab "Habitual"
    :prg "Progressive"
    :imm "Imminent"
    :pcs "Precessive"
    :reg "Regulative"
    :exp "Experiential"
    :atp "Anticipatory"
    :rsm "Resumptive"
    :css "Cessative"
    :rcs "Recessative"
    :pau "Pausal"
    :rgr "Regressive"
    :pcl "Preclusive"
    :cnt "Continuative"
    :ics "Incessative"
    :irp "Interruptive"
    :pmp "Preemptive"
    :clm "Climactic"
    :dlt "Dilatory"
    :tmp "Temporary"
    :mtv "Motive"
    :sqn "Sequential"
    :epd "Expeditive"
    :ptc "Protractive"
    :ppr "Preparatory"
    :dcl "Disclusive"
    :ccl "Conclusive"
    :cul "Culminative"
    :imd "Intermediative"
    :trd "Tardative"
    :tns "Transitional"
    :itc "Intercommutative"
    :csm "Consumptive"
    :lim "Limitative"}

   :context
   {:exs "Existential"
    :fnc "Functional"
    :rps "Representational"
    :amg "Amalgamative"}

   :function
   {:sta "Stative"
    :dyn "Dynamic"
    :mnf "Manifestive"
    :ich "Incohative"}

   :mood
   {:fac "Factual"
    :sub "Subjunctive"
    :asm "Assumptive"
    :spc "Speculative"
    :cou "Counterfactive"
    :hyp "Hypothetical"
    :imp "Implicative"
    :asc "Ascriptive"}

   :perspective
   {:m "Monadic"
    :p "Polyadic"
    :n "Nomic"
    :a "Abstract"}

   :extension
   {:del "Delimitive"
    :prx "Proximative"
    :icp "Inceptive"
    :atv "Attenutive"
    :gra "Gradual"
    :dpl "Depletive"}

   :affiliation
   {:csl "Consolidative"
    :aso "Associative"
    :var "Variadic"
    :coa "Coalescent"}

   :configuration
   {:uni "Uniplex"
    :dpx "Duplex"
    :dct "Discrete"
    :agg "Aggregative"
    :seg "Segregative"
    :cpn "Componential"
    :coh "Coherent"
    :cst "Composite"
    :mlt "Multiform"}

   :case (apply merge (vals cases))

   :designation
   {:inf "Informal"
    :fml "Formal"}

   :register ; These abbreviations are inferred, not listed in the NLRv0.2
   {:dsv "Discursive"
    :pth "Parenthetical"
    :cog "Cogitant"
    :exm "Exemplificative"
    :ipr "Impressionistic"}})


(def pra-referents
 ;; Note that, unlike those listed above, these keywords are case-sensitive
 ;; The hyphen at the start of each symbol is only present because symbols cannot start with a number
 {:_1m "monadic speaker"
  :_2m "monadic addressee"
  :_2p "polyadic addressee"
  :ma "monadic animate 3rd party"
  :pa "polyadic animate 3rd party"
  :mi "monadic inanimate 3rd party"
  :pi "polyadic inanimate 3rd party"
  :IPa "impersonal animate"
  :IPi "impersonal inanimate"
  :Obv "obviative"
  :Col "Collective"
  :Abt "Abstract"})
