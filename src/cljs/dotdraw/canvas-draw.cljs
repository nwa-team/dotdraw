(ns dotdraw.canvas-draw)

"Draws a line on the canvas from start to end"
(defn draw-line [start end]
  (def c (.getElementById js/document "mainCanvas"))
  (def context (.getContext c "2d"))
  (set! (.-strokeStyle context) "#000000")
  ;(.beginPath context)
  (.moveTo context (first start) (second start))
  (.lineTo context (first end) (second end))
  (.stroke context))


"Draws a grid on 10 pixels wide"
(defn draw-grid [width height]
  (def w (+ (/ width 10) 1))
  (def h (+ (/ height 10) 1))
  (dotimes [n w] (draw-line [(* n 10), 0] [(* n 10), height]))
  (dotimes [n h] (draw-line [0, (* n 10)] [width, (* n 10)])))
