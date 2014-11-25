(ns kingpin.helper
  (:require
   [clojure.test :refer :all]
   [clojure.string :as string]))

(defn in-lein? []
  "Check if we are running in leiningen by looking at an environment variable"
  (not (string/blank? (System/getenv "LEIN_HOME"))))

(defn insta-repl-tests []
  "Run clojure tests if we are not in leiningen"
  (if-not (in-lein?) (run-tests)))
