(ns pyria.common-test
  #? (:cljs (:require-macros [cljs.test :refer (is deftest testing)]))
  (:require [pyria.common :as sut]
            #?(:clj [clojure.test :refer :all]
               :cljs [cljs.test])))

(deftest example-passing-test-cljc
  (is (= 1 1)))
