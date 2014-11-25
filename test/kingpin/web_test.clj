(ns kingpin.web-test
  (:require
   [clojure.test :refer :all]
   [kingpin.helper :as helper]
   [kingpin.web :refer :all]))

(defn sum [x y] (+ y x))

(deftest
  sum-test
  "The sum of two numbers should sum two numbers"
  (is (= 7 (sum 3 4))))

; Have realtime results in LightTable
(helper/insta-repl-tests)
