(defproject pyria "0.1.0-SNAPSHOT"
  :description "Procurement app"
  :url "https://github.com/mariusz-jachimowicz-83/pyria"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}

  :main pyria.main

  :dependencies [[org.clojure/clojure "1.9.0-alpha14"]
                 [org.clojure/clojurescript "1.9.229"]
                 [io.replikativ/replikativ "0.2.4"]
                 [org.omcljs/om "1.0.0-alpha46"]
                 [sablono "0.7.6"]
                 [http-kit "2.2.0"]
                 [compojure "1.5.2"]]

  ; lein plugins
  :plugins [[lein-figwheel "0.5.8"]
            [lein-cljsbuild "1.1.4" :exclusions [[org.clojure/clojure]]]]

  :source-paths ["src/cljs" "src/clj"]
  :test-paths   ["test/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :cljsbuild {:builds
              [{:id "dev"
                :source-paths ["src/cljs"]
                :figwheel {:on-jsload "pyria.core/on-js-reload"
                           :open-urls ["http://localhost:3449/index.html"]}

                :compiler {:main pyria.core
                           :asset-path "js/compiled/out"
                           :output-to "resources/public/js/compiled/pyria.js"
                           :output-dir "resources/public/js/compiled/out"
                           :source-map-timestamp true
                           ;; To console.log CLJS data-structures make sure you enable devtools in Chrome
                           ;; https://github.com/binaryage/cljs-devtools
                           :preloads [devtools.preload]}}]}

  :figwheel {:css-dirs ["resources/public/css"] ;; watch and update CSS
            }
  :profiles {:dev {:dependencies [[binaryage/devtools "0.8.2"]
                                  [figwheel-sidecar "0.5.8"]
                                  [com.cemerick/piggieback "0.2.1"]]
                   :source-paths ["src" "dev"]
                   :repl-options {; for nREPL dev you really need to limit output
                                  :init (set! *print-length* 50)
                                  :nrepl-middleware [cemerick.piggieback/wrap-cljs-repl]}}}
)
