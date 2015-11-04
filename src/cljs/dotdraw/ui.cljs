(ns dotdraw.ui
  (:require [reagent.core :as r]))

(defn main-canvas []
   "Creates the main canvas object that will take over the whole view"
    [:canvas])

(def draw-state (r/atom "Pencil"))

(defn tool-box [props]
  "Generic component for toolbox element"
  [:div {:style {:background "lightgrey"}}
    [:h6 "Toolbox - " (get props :name)]
    [:div {:class (if (= (get props :orientation) :vertical) "btn-group-vertical" "btn-group")
           :role "group"}
      (get props :elements)]])

(defn render-toolbox-button [name]
  [:button {:class "btn btn-default"
            :type "button"
            :key name
            :on-click #(swap! draw-state (fn [] (str name)))} name])

(defn get-toolbox-items []
  (list
    (render-toolbox-button "Pencil")
    (render-toolbox-button "Paintbrush")
    (render-toolbox-button "Eraser")))

(defn main-grid []
  "Puts together all the elements of the main window"
  [:div.container
    [main-canvas]
    [:div @draw-state]
    [tool-box {:name "Elements"
               :orientation :vertical
               :elements (get-toolbox-items)}]
    [tool-box {:name "Layers"
               :orientation :horizontal
               :elements (get-toolbox-items)}]])
