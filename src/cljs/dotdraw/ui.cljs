(ns dotdraw.ui)

(defn main-canvas []
  ; creates the main canvas object that will take over the whole view
    [:canvas])

(defn tool-box []
  ; toolbox objects on the main view
  [:div "Toolbox"])

(defn layers-box []
  ; layers box on the main view
  [:div "Layers"])

(defn brush-box []
  ; creates the main brush
  [:div "Brush"])

(defn main-grid []
  ; puts together the all the elements of the main window
  [:div.box 
    [main-canvas]
    [tool-box]
    [layers-box]
    [brush-box]
  ])
