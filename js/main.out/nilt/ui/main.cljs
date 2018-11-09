(ns nilt.ui.main
  (:require [reagent.core :as r]))

(enable-console-print!)

(defn main-ui []
  [:center
   [:h1 "Hello, world!"]])

(defonce app-state (r/atom {}))

(defn init! []
  (r/render-component
    (fn [] [main-ui])
    (.getElementById js/document "app")))

(init!)
