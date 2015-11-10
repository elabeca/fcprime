(defproject fcprime "0.1.0-SNAPSHOT"
  :description "Prime number multiplication generator"
  :url "http://github.com/elabeca"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]]
  :main ^:skip-aot fcprime.core
  :target-path "target/%s"
  :profiles {:uberjar {:aot :all}})
