(ns kingpin.core)

(defn spare? [rolls]
  (= 10 (reduce + (take 2 rolls))))

(defn strike? [rolls]
  (= 10 (first rolls)))

(defn rolls-in-frame-score [rolls]
  "Return the number of rolls to include in this frame score"
  (cond
    (strike? rolls) 3
    (spare? rolls) 3
    :else 2))

(defn rolls-in-frame [rolls]
  "Return the number of rolls that were thrown in this frame"
  (if (strike? rolls) 1 2))

(defn to-frames [rolls]
  "Separate rolls into frames"
  (lazy-seq
   (cons
    (take (rolls-in-frame-score rolls) rolls)
    (to-frames (drop (rolls-in-frame rolls) rolls)))))

(defn to-game [rolls]
  "Get the 10 frames of a game"
  (take 10 (to-frames rolls)))

(defn score-frame [rolls]
  "Calculate the score of a single frame"
  (reduce + rolls))

(defn score
  "Calculate the score of a bowling game"
  [rolls]
  (reduce +
    (map score-frame (to-game rolls))))
