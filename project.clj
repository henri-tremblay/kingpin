(defproject kingpin "1.0.0-SNAPSHOT"
  :description "Calculate your bowling score online"
  :url "https://github.com/henri-tremblay/kingpin"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/org/documents/epl-v10.php"}
  :dependencies [[org.clojure/clojure "1.6.0"]
                 [compojure "1.1.8"]
                 [ring/ring-jetty-adapter "1.2.2"]
                 [ring/ring-devel "1.2.2"]
                 [ring-basic-authentication "1.0.5"]
                 [environ "0.5.0"]
                 [com.cemerick/drawbridge "0.0.6"]
                 [camel-snake-kebab "0.2.4"]
                 [org.clojure/java.jdbc "0.3.5"]
                 [postgresql "9.1-901-1.jdbc4"]]
  :dev-dependencies [[leiningen-interactive "0.1.1"]]
  :min-lein-version "2.0.0"
  :plugins [[environ/environ.lein "0.2.1"]]
  :hooks [environ.leiningen.hooks]
  :uberjar-name "kingpin-standalone.jar"
  :profiles {:production {:env {:production true}}})
