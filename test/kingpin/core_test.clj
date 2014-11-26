(ns kingpin.core-test
  (:use midje.sweet)
  (:use kingpin.core))

(facts "When calculating the score of a bowling game"

  ;Test 1: Score a gutter game
  (fact "The gutter game has to return 0"
      (score (repeat 20 0)) => 0)

  ;Test 2: Score a game of all one rolls
  (fact "The game of all one rolls shoult return 20"
       (score (repeat 20 1)) => 20)

  ;Test 3: Score a game of 1 spare frame, a 3 pin frame, and gutters
  ;(fact "1 spare frame 3 pin "
  ;      (score (concat [5 5 3] (repeat 17 0))) => 16)
  (fact "Decompose rolls in frames"
        (to-frame (repeat 20 0)) => (repeat 10 (repeat 2 0)))

  (fact "Calculate the score of a frame"
        (score-frame (repeat 2 3)) => 6
  )
  ;Test 4: Score a game of 1 strike frame, an 8 pin frame, and gutters


  ;Test 5: Score a perfect game
)
