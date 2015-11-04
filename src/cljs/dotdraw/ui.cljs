(ns dotdraw.ui
  (:require [dotdraw.canvas-draw :as draw]
            [reagent.core :as r]))

(defn main-canvas [props]
   "Creates the main canvas object that will take over the whole view"
    [:canvas {:id (get props :id)
              :width (get props :width)
              :height (get props :height)}])

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

(defn render-checkbox [name state]
  "Creates a checkbox for the grid"
  [:input {:class "chbox chbox-default"
           :type "checkbox"
           :checked state
           :on-change #(draw/draw-grid 350 250 10)} name])

(defn get-toolbox-items []
  (list
    (render-toolbox-button "Pencil")
    (render-toolbox-button "Paintbrush")
    (render-toolbox-button "Eraser")))

(defn main-grid []
  "Puts together all the elements of the main window"
  [:div.container
    [main-canvas {:id "mainCanvas"
                  :width 350
                  :height 250}]
    [:div @draw-state]
    [tool-box {:name "Elements"
               :orientation :vertical
               :elements (get-toolbox-items)}]
    [tool-box {:name "Layers"
               :orientation :horizontal
               :elements (get-toolbox-items)}]
    [render-checkbox "Show Grid" false]])
