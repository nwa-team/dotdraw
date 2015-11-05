(ns dotdraw.core
  (:require [reagent.core :as reagent]
            [dotdraw.ui :as ui]
            [cljsjs.react]))

(defn main-page
  []
  [ui/mainGrid])

(defn mount-root
  []
  (reagent/render [main-page] (.getElementById js/document "app")))

(defn init!
  []
  (mount-root))
