(ns kingpin.core-test
  (:require
   [clojure.test :refer :all]
   [kingpin.helper :as helper]
   [kingpin.core :refer :all]))

;Test 1: Score a gutter game

;Test 2: Score a game of 1 pin frames

;Test 3: Score a game of 1 spare frame, a 3 pin frame, and gutters

;Test 4: Score a game of 1 strike frame, an 8 pin frame, and gutters

;Test 5: Score a perfect game

; Have realtime results in LightTable
(helper/insta-repl-tests)
