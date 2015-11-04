(ns dotdraw.ui
  (:require [dotdraw.canvas-draw :as draw]))

(defn main-canvas [props]
   "Creates the main canvas object that will take over the whole view"
    [:canvas {:id (get props :id)
              :width (get props :width)
              :height (get props :height)}])

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
            :key name} name])

(defn render-checkbox [name state]
  "Creates a checkbox for the grid"
  [:input {:class "chbox chbox-default"
           :type "checkbox"
           :checked state
           :on-change #(draw/draw-grid 250 250)} name])

(defn get-toolbox-items []
  (list
    (render-toolbox-button "e1")
    (render-toolbox-button "e2")
    (render-toolbox-button "e3")))

(defn main-grid []
  "Puts together all the elements of the main window"
  [:div.container
    [main-canvas {:id "mainCanvas"
                  :width 250
                  :height 250}]
    [tool-box {:name "Elements"
               :orientation :vertical
               :elements (get-toolbox-items)}]
    [tool-box {:name "Layers"
               :orientation :horizontal
               :elements (get-toolbox-items)}]
    [render-checkbox "Show Grid" false]])
