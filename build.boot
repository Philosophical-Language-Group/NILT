(set-env!
  :source-paths #{"src"}
  :resource-paths #{"html"}

  :dependencies '[[org.clojure/clojure "1.9.0"]
                  [org.clojure/clojurescript "1.9.946"]
                  [adzerk/boot-cljs "2.1.4"]
                  [pandeiro/boot-http "0.8.3"]
                  [adzerk/boot-reload "0.5.2"]
                  [adzerk/boot-cljs-repl "0.3.3"]
                  [com.cemerick/piggieback "0.2.1" :scope "test"]     ;; needed by bREPL
                  [weasel "0.7.0" :scope "test"]                      ;; needed by bREPL
                  [org.clojure/tools.nrepl "0.2.12"]
                  [instaparse "1.4.9"]])

(require '[adzerk.boot-cljs :refer [cljs]]
         '[pandeiro.boot-http :refer [serve]]
         '[adzerk.boot-reload :refer [reload]]
         '[adzerk.boot-cljs-repl :refer [cljs-repl start-repl]])

(deftask build []
  (comp
    (target :dir #{"target"})))

(deftask dev []
  (comp
    (serve :dir "target")
    (watch)
    (reload)
    (cljs-repl)
    (cljs)
    (build)))
