(ns dotdraw.ui)

(defn main-canvas []
   "Creates the main canvas object that will take over the whole view"
    [:canvas])

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

(defn get-toolbox-items []
  (list
    (render-toolbox-button "e1")
    (render-toolbox-button "e2")
    (render-toolbox-button "e3")))

(defn main-grid []
  "Puts together all the elements of the main window"
  [:div.container
    [main-canvas]
    [tool-box {:name "Elements"
               :orientation :vertical
               :elements (get-toolbox-items)}]
    [tool-box {:name "Layers"
               :orientation :horizontal
               :elements (get-toolbox-items)}]])
