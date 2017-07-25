(ns pyria.test-runner
  (:require
   [doo.runner :refer-macros [doo-tests]]
   [pyria.core-test]
   [pyria.common-test]))

(enable-console-print!)

(doo-tests 'pyria.core-test
           'pyria.common-test)
