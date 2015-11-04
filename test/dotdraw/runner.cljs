(ns dotdraw.runner (:require [doo.runner :refer-macros [doo-tests]]
              [dotdraw.tests]))

(doo-tests 'dotdraw.tests)
