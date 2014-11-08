(require '[clojure.java.jdbc :as sql]
         '[environ.core :refer [env]]
         '[kingpin.web :as w])

(sql/db-do-commands (env :database-url "postgres://localhost:5432/kebabs")
  (sql/create-table-ddl :sayings
                        [:id "serial primary key"]
                        [:content "text"]))

(w/record "HelloComputer")
