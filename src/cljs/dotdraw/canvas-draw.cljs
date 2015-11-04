(ns dotdraw.canvas-draw)

"Draws a line on the canvas from start to end"
(defn draw-line [start end]
  (def c (.getElementById js/document "mainCanvas"))
  (def context (.getContext c "2d"))
  (set! (.-strokeStyle context) "#000000")
  (.moveTo context (first start) (second start))
  (.lineTo context (first end) (second end))
  (.stroke context))


"Draws a grid on 10 pixels wide"
(defn draw-grid [width height pixel-size]
  (def w (+ (/ width pixel-size) 1))
  (def h (+ (/ height pixel-size) 1))
  (dotimes [x w] (draw-line [(* x pixel-size), 0] [(* x pixel-size), height]))
  (dotimes [y h] (draw-line [0, (* y pixel-size)] [width, (* y pixel-size)])))
