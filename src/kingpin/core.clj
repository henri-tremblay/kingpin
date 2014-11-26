(ns kingpin.core)

(defn to-frame
  "Score of a frame"
  [rolls]
  (if (empty? rolls ) rolls
  (cons (take 2 rolls) (to-frame (drop 2 rolls)))
  )
)

(defn score-frame
  [frames]
)
(defn score
  "Calculate the score of a bowling game"
  [rolls]
  (reduce + rolls))
