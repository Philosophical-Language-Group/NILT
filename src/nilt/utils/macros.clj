(ns nilt.utils.macros
  (:refer-clojure))

(defmacro get-resource [resource-path]
  (clojure.core/slurp (clojure.java.io/resource resource-path)))
