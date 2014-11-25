(ns kingpin.core-test
  (:use midje.sweet)
  (:use kingpin.core))

(defn zero-frames [number]
  (repeat (* 2 number) 0))

(facts "When calculating the score of a bowling game"

  ;Test 1: Score a gutter game
  (fact "it returns 0 for a complete gutter game"
    (score (zero-frames 10)) => 0)

  ;Test 2: Score a game of all one rolls
  (fact "it returns 20 if we roll only 1s"
    (score (repeat 20 1)) => 20)

  ;Test 3: Score a game of 1 spare frame, a 3 pin frame, and gutters
  (fact "it's a spare if the two rolls sum 10"
    (spare? [1 5]) => false
    (spare? [4 6]) => true)

  (fact "we calculate the score of a frame"
    (score-frame [1 2]) => 3
    (score-frame [5 5 3]) => 13)

  (fact "normal rolls are reparated in frames"
    (take 2 (to-frames [1 2 3 4])) => [[1 2] [3 4]]
    (take 2 (to-frames [5 5 3 4])) => [[5 5 3] [3 4]])

  (fact "a game has 10 frames"
    (count (to-game (repeat 12 10))) => 10)

  (fact "a 1 spare frame, a 3 pin frame and gutters scores 16"
    (score (concat [5 5 3 0] (zero-frames 8))) => 16)

  ;Test 4: Score a game of 1 strike frame, an 8 pin frame, and gutters
  (fact "it's a strike if one roll is 10"
    (strike? [5 5]) => false
    (strike? [10]) => true)

  (fact "a frame includes 3 rolls if it's a spare or a strike"
    (rolls-in-frame-score [5 5]) => 3
    (rolls-in-frame-score [10]) => 3
    (rolls-in-frame-score [2 3]) => 2)

  (fact "a strike should count the next two rolls"
    (score (concat [10 5 3] (zero-frames 8))) => 26)

  ;Test 5: Score a perfect game
  (fact "only strikes makes 300 points"
    (score (repeat 12 10)) => 300)
)

