(ns rest-demo.core-test
  (:require [clojure.test :refer :all]
            [rest-demo.core :as c]))

(deftest a-test
  (testing "FIXME, I fail."
    (is (= 0 0))))
(deftest uppercase-test
  (is (= "HELLOWORLD" (c/hello-uppercase))))

(deftest hello-count-test
  (is (= 7 (c/hello-count))))

(deftest hello-sub-test
  (is (= "llo" (c/hello-sub))))

(deftest hello-compare-test
  (is (= 0 (c/hello-compare))))

(deftest hello-join-test
  (is (= "1, 2, 3" (c/hello-join))))

(deftest hello-split-test
  (is (= ["Hello" "World"] (c/hello-split))))

(deftest hello-splitlines-test
  (is (= ["Hell" "oWorld"] (c/hello-splitlines))))

(deftest hello-replace-test
  (is (= "The tutorial is about Clojure" (c/hello-replace))))

(deftest hello-trim-test
  (is (= "White spaces sanu" (c/hello-trim))))

(deftest hello-trimleft-test
  (is (= "White spaces " (c/hello-trimleft))))

(deftest hello-trimr-test
  (is (= " White spaces" (c/hello-trimr))))

(deftest listExample-test
  (is (= (list 1 2 3) (c/listExample))))

(deftest listcons-test
  (is (= (list 0 1 2 3) (c/listcons))))

(deftest setexample-test
  (is (= #{1 2} (c/setexample))))

(deftest sortedsetexample-test
  (is (= #{1 2 3} (c/sortedsetexample))))

(deftest setcontainsexample-test
  (is (= false (c/setcontainsexample))))

(deftest setconjexample-test
  (is (= #{1 3 2 5} (c/setconjexample))))

(deftest disjsetexample-test
  (is (= #{1 3} (c/disjsetexample))))

(deftest unionsetexample-test
  (is (= #{1 4 3 2} (c/unionsetexample))))

(deftest diffrencesetexample-test
  (is (= #{1 2} (c/diffrencesetexample))))

(deftest setintersectionexample-test
  (is (= #{2} (c/setintersectionexample))))

(deftest subsetexample-test
  (is (= false (c/subsetexample))))

(deftest supersetexample-test
  (is (= true (c/supersetexample))))

(deftest vectorexample-test
  (is (= [1 2 3] (c/vectorexample))))

(deftest vectornthexample-test
  (is (= 3 (c/vectornthexample))))

(deftest vectoregetexample-test
  (is (= 1 (c/vectoregetexample))))

(deftest vectoreconjexample-test
  (is (= [3 2 1 5] (c/vectoreconjexample))))

(deftest vectorsubvecexample-test
  (is (= [3 4 5] (c/vectorsubvecexample))))

(deftest mapgetexample-test
  (is (= "2" (c/mapgetexample))))

(deftest mapcontainsexample-test
  (is (= true (c/mapcontainsexample))))

(deftest findmapexample-test
  (is (= ["b" "2"] (c/findmapexample))))

(deftest valsmapexample-test
  (is (= '("1" "3" "2") (c/valsmapexample))))

(deftest mapkeysexample-test
  (is (= '("z" "a" "b") (c/mapkeysexample))))

(deftest dissocmapexample-test
  (is (= {"z" "1", "a" "3"} (c/dissocmapexample))))

(deftest mergemapexample-test
  (is (= {"z" 1, "a" 5, "i" 7, "b" 2, "h" 5} (c/mergemapexample))))

(deftest selectkeymapexample-test
  (is (= {"z" 1, "a" 3} (c/selectkeymapexample))))


  

  
  
  



   