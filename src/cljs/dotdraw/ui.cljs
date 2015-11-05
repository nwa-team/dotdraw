(ns dotdraw.ui
  (:require [dotdraw.canvas-draw :as draw]
            [reagent.core :as r]))

(defn main-canvas [props]
   "Creates the main canvas object that will take over the whole view"
    [:canvas {:id (get props :id)
              :width (get props :width)
              :height (get props :height)}])

"Should hold application wide state"
(defonce app-state (r/atom {:drawState "Pencil"}))

(defn tool-box [props]
  "Generic component for toolbox element"
  [:div.toolbox
    [:h6 "Toolbox - " (:name props)]
    [:div {:class (if (= (:orientation props) :vertical) "btn-group-vertical" "btn-group")
           :role "group"}
      (:elements props)]])

(defn render-toolbox-button [name]
  [:button {:class "btn btn-default"
            :type "button"
            :key name
            :on-click #(swap! app-state update-in [:drawState] (fn [] (str name)))} name])

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
    [:div (:drawState @app-state)]
    [tool-box {:name "Elements"
               :orientation :horizontal
               :elements (get-toolbox-items)}]
    ;[tool-box {:name "Layers"
    ;           :orientation :vertical
    ;           :elements (get-toolbox-items)}]
    [render-checkbox "Show Grid" false]])
