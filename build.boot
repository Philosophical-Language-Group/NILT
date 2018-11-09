(set-env!
  :source-paths #{"src" "test"}
  :resource-paths #{"html"}

  :dependencies '[[org.clojure/clojure "1.9.0"]
                  [org.clojure/clojurescript "1.10.439"]
                  [adzerk/boot-cljs "2.1.5"]
                  [pandeiro/boot-http "0.8.3"]
                  [reagent "0.8.1"]
                  [adzerk/boot-reload "0.6.0"]
                  [adzerk/boot-cljs-repl "0.4.0"]
                  [adzerk/boot-test "1.2.0" :scope "test"]
                  [cider/piggieback "0.3.9" :scope "test"]  ;; needed by bREPL
                  [weasel "0.7.0" :scope "test"]            ;; needed by bREPL
                  [nrepl "0.4.5"]
                  [instaparse "1.4.9"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]]
         '[adzerk.boot-reload :refer [reload]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]]
         '[adzerk.boot-test :refer :all])

(deftask build []
  (comp
    (target :dir #{"target"})))

(deftask dev []
  (comp
    (serve :dir "target")
    (watch)
    (reload :on-jsload 'nilt.ui.main/init!)
    (cljs-repl)
    (cljs)
    (build)))
