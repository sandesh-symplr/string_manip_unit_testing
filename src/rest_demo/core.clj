(ns rest-demo.core
  (:require [org.httpkit.server :as server]
            [compojure.core :refer :all]
            [compojure.route :as route]
            [ring.middleware.defaults :refer :all]
            [clojure.pprint :as pp]
            [clojure.string :as str]
            [clojure.set :as set]
            [clojure.data.json :as json])
  (:gen-class))

; Simple Body Page
(defn simple-body-page [req] ;(3)
  {:status  200
   :headers {"Content-Type" "text/html"}
   :body    "Hello Clojur World"})
;
; request-example
(defn request-example [req]
     {:status  200
      :headers {"Content-Type" "text/html"}
      :body    (->
                (pp/pprint req)
                (str "Request Object: " req))})

; Hello-name handler
(defn hello-name [req]
     {:status  200
      :headers {"Content-Type" "text/html"}
      :body    (->
                (pp/pprint req)
                (str "Hello " (:name (:params req))))})

; my people-collection mutable collection vector
(def people-collection (atom []))

;Collection Helper functions to add a new person
(defn addperson [firstname surname]
  (swap! people-collection conj {:firstname (str/capitalize firstname)
                                     :surname (str/capitalize surname)}))

; Example JSON objects
(addperson "Rishi" "Karuna")
(addperson "Rohit" "jha")
(addperson "Simi" "Thakral")
(addperson "Rupa" "ji")
(addperson "Rahul" "Singh")
(addperson "Nayasa" "Tim")

; Return List of People
(defn people-handler [req]
        {:status  200
         :headers {"Content-Type" "text/json"}
         :body    (str (json/write-str @people-collection))})

; Helper to get the parameter specified by pname from :params object in req
(defn getparameter [req pname] (get (:params req) pname))

; Add a new person into the people-collection
(defn addperson-handler [req]
        {:status  200
         :headers {"Content-Type" "text/json"}
         :body    (-> (let [p (partial getparameter req)]
                        (str (json/write-str (addperson (p :firstname) (p :surname))))))})

; Our main api
(defroutes app-routes
  (GET "/" [] simple-body-page)
  (GET "/request" [] request-example)
  (GET "/hello" [] hello-name)
  (GET "/people" [] people-handler)
  (GET "/people/add" [] addperson-handler)
  (route/not-found "Error, page not found!"))

; this is string concatenation
 ; (defn hello-world []
   ;(println (str "Hello" "Clojure"))
 ; (println (str "Hello" "Clojure" "World")))
;(hello-world)

; this is string count
(defn hello-count []
  ( println "this is for count")
   (count "Clojure"))
(hello-count)

; this is string substring
(defn hello-sub []
   (println  "this is for substring" )
    (subs "HelloClojure" 2 5))
   ;(println (subs "HelloClojure" 5 7)))
(hello-sub)
; this is string compare
(defn hello-compare []
   (println "this is comparing String")
   (compare "B" "A")
   (compare "A" "A"))
(hello-compare)
;this is for make lowercase of string
(defn hello-lowercase []
(println "this is making String lowercase")
   (println (clojure.string/lower-case "HelloWorld"))
   (println (clojure.string/lower-case "HELLOWORLD")))
(hello-lowercase)
;this is for makemake uppercase of string
(defn hello-uppercase []
  (println "this is making String uppercase")
   ;(println (clojure.string/upper-case "HelloWorld"))
   (clojure.string/upper-case "helloworld"))
(hello-uppercase)
; this for string join
(defmacro dbg[x] `(let [x# ~x] (println "dbg:" '~x "=" x#) x#))
(defn hello-join []
  (println "this is making String join")
   (clojure.string/join ", " [1 2 3]))
(hello-join)
; this is for split of string
(defn hello-split []
(println "this is split String ")
   (clojure.string/split "Hello:World" #":"))
(hello-split)
; this is for split string by lines
(defn hello-splitlines []
  (println "this is split String  by lines")
   (clojure.string/split-lines "Hell\noWorld"))
(hello-splitlines)
; this is for reverse string by revers method
(defn hello-reverse []
   (println "this is reverse String  by reverse method")
   (println (reverse "Hello clojure")))
(hello-reverse)
; this for replace string by replace method
(defn hello-replace []
   (println "this is replace String  by replace method")
   (clojure.string/replace "The tutorial is about Groovy" #"Groovy"
      "Clojure"))
(hello-replace)
;this for trim in string
(defn hello-trim []
  (println "this is trim String  by trim method")
   (clojure.string/trim " White spaces sanu "))
(hello-trim)
; this is for trim left side
(defn hello-trimleft []
    (println "this is trim left side of String  by triml method")
   (clojure.string/triml " White spaces "))
(hello-trimleft)
; this is for trim right side
(defn hello-trimr []
    (println "this is trim right side of String  by trimr method")
   (clojure.string/trimr " White spaces "))
(hello-trimr)
; this is for recursive method
(defn recursive []
(println "this is for recursives method")
     (loop [x 10]
        (when (> x 1)
           (println x)
           (recur (- x 1)))))
 (recursive)
; list data structure
(defn listExample []
   (println "this is for list")
   (list* 1 [2,3]))
(listExample)
; this is for list first item
(defn listfirst []
   (println "this is for list first item")
   (first (list 1 2,3)))
(listfirst)
; this is for list last item
(defn list []
   (println "this is for list last item")
   (println (last (list 1 2,3))))
(listfirst)
; list nth item
;(defn listnth []
    ;(println "this is for list nth item")
  ; (println (nth (list 1 2,3) 0))
  ;(nth (clojure.core/list 1 2,3) 2)))
;(listnth)
; this for list cons example
(defn listcons []
   (println "this is for list cons")
   (cons 0 (clojure.core/list 1 2,3)))
(listcons)
;this for conj example
(defn listconj []
   (println "this is for list conj")
   (println (conj (clojure.core/list 1 2,3) 4 5)))
(listconj)
; this is for set 
(defn setexample []
   (println "this is for set") 
   (set '(1 1 2 2)))
(setexample)
; this is for sorted set
(defn sortedsetexample []
    (println "this is for sorted set") 
   (sorted-set 3 2 1))
(sortedsetexample)
;this for  set contains check
(defn setcontainsexample []
   (println "this is for contains check") 
   ;(println (contains? (set '(3 2 1)) 2))
   (contains? (set '(3 2 1)) 5))
(setcontainsexample)
;this for set conj
(defn setconjexample []
   (println "this is for set conj") 
   (conj (set '(3 2 1)) 5))
(setconjexample)
; this is for disj set
(defn disjsetexample []
    (println "this is for disj of set") 
    (disj (set '(3 2 1)) 2))
(disjsetexample)
; this is for union of set
(defn unionsetexample []
   (println "this is for union of set") 
    (set/union #{1 2} #{3 4}))
(unionsetexample)
; this is for diffrence of sets
(defn diffrencesetexample []
   (println "this is for diffrence of set") 
   (set/difference #{1 2} #{4 3}))
(diffrencesetexample)
;this for intersection
(defn setintersectionexample []
   (println "this is for intersection of set") 
   (set/intersection #{1 2} #{2 3}))
(setintersectionexample)
;this is for subset of set
(defn subsetexample []
   (println "this is for subset of set") 
   (set/subset? #{1 2} #{2 3}))
  (subsetexample)
; this is for superset of set
(defn supersetexample []
   (println "this is for superset of set") 
   (set/superset? #{1 2 3} #{1 2}))
(supersetexample)
;this is for vector-of example
(defn vectorexample []
   (println "this is for vector-of example") 
   (vector-of :int 1 2 3))
(vectorexample)
; this is for vector nth example
(defn vectornthexample []
   (println "this is for vector nth example") 
   ;(println (nth (vector 1 2,3) 0))
   (nth (vector 1 2,3) 2))
(vectornthexample)
(defn vectoregetexample []
   (println "this is for vector get example") 
   (get (vector 3 2 1) 2))
(vectoregetexample)
; this is for vector conj
(defn vectoreconjexample []
   (println "this is for vector conj example") 
   (conj (vector 3 2 1) 5))
(vectoreconjexample)
; this for vector pop method
(defn vectorpopexample []
   (println "this is for vector pop example") 
   (pop (vector 3 2 1)))
(vectorpopexample)
; this is for vector of subvec
(defn vectorsubvecexample []
   (println "this is for vector subvec example") 
   (subvec (vector 1 2 3 4 5 6 7) 2 5))
(vectorsubvecexample)
;this is for map 
(defn mapexample []
   (println "this is for map example") 
   (def demokeys (hash-map "z" "1" "b" "2" "a" "3"))
   (println demokeys))
(mapexample)
; this is for sorted map
(defn sortedmapexample []
   (println "this is for sorted map") 
   (def demokeys (sorted-map "z" "1" "b" "2" "a" "3"))
   ( println demokeys))
(sortedmapexample)
;this is for map get
(defn mapgetexample []
   (println "this is for get map") 
   (def demokeys (hash-map "z" "1" "b" "2" "a" "3"))
   (get demokeys "b"))
(mapgetexample)
;this is for map contains
(defn mapcontainsexample []
   (println "this is for contains map") 
   (def demokeys (hash-map "z" "1" "b" "2" "a" "3"))
   (contains? demokeys "b"))
  (mapcontainsexample)
(defn findmapexample []
   (println "this is for find map") 
   (def demokeys (hash-map "z" "1" "b" "2" "a" "3"))
   (find demokeys "b"))
   (findmapexample)
;this is for map keys
(defn mapkeysexample []
   (println "this is for key map") 
   (def demokeys (hash-map "z" "1" "b" "2" "a" "3"))
   (keys demokeys))
(mapkeysexample)
;this for  map vals example
(defn valsmapexample []
   (println "this is for vals of map") 
   (def demokeys (hash-map "z" "1" "b" "2" "a" "3"))
   (vals demokeys))
(valsmapexample)
; this is for dissoc of map
(defn dissocmapexample []
   (println "this is for dissoc of map") 
   (def demokeys (hash-map "z" "1" "b" "2" "a" "3"))
   (dissoc demokeys "b"))
(dissocmapexample)
;this is for merge of map
(defn mergemapexample []
   (println "this is for merge of map") 
   (def demokeys (hash-map "z" 1 "b" 2 "a" 3))
   (def demokeys1 (hash-map "a" 2 "h" 5 "i" 7))
   (merge-with + demokeys demokeys1))
(mergemapexample)
; this is for select key of map
(defn selectkeymapexample []
   (println "this is for select key of map") 
   (def demokeys (hash-map "z" 1 "b" 2 "a" 3))
   (select-keys demokeys ["z" "a"]))
(selectkeymapexample)

;this is for invert map
;;debugging parts of expressions

(defn invertmapexample []
    (println "this is for invert of key in map") 
   (def demokeys (hash-map "z" 1 "b" 2 "a" 3))
   (def demonew (set/map-invert demokeys))
   (println ( dbg (println demonew))))
  ; (println (dbg (println "yo")))
(invertmapexample)

 
;; Examples of dbg
(println (+ (* 2 3) (dbg (* 8 9))))
(println (dbg (println "yo")))
(defn factorial[n] (if (= n 0) 1 (* n (dbg (factorial (dec n))))))
(factorial 8)

(def integers (iterate inc 0))
(def squares  (map #(dbg(* % %))   integers))
(def cubes    (map #(dbg(* %1 %2)) integers squares))
(take 5 cubes)
(take 5 cubes)
; Our main entry function
(defn -main
  "This is our main entry point"
  [& args]
  (let [port (Integer/parseInt (or (System/getenv "PORT") "3000"))]
    ; Run the server with Ring.defaults middleware
    (server/run-server (wrap-defaults #'app-routes site-defaults) {:port port})))
    ; Run the server without ring defaults
    ;(server/run-server #'app-routes {:port port})
    ;(println (str "Running webserver at http:/127.0.0.1:" port "/"))))

