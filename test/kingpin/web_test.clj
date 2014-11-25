(ns kingpin.web-test
  (:use midje.sweet)
  (:require
   [kingpin.web :refer :all]))

(defn sum [x y] (+ y x))

(fact "The sum of two numbers should sum two numbers"
      (sum 3 4) => 7)
