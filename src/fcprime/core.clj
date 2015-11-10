(ns fcprime.core
  (:gen-class))

;; Please refer to test/fcprime/core_test.clj for the unit tests

(defn evenly-div? [num div]
  "Determines if a number is evenly divisible"
  (zero? (mod num div)))

(defn prime? [num]
  "Determines if a number is prime or not. Based on method #1 step 4 of this website (the solution of the website is mistaken as it should be inclusive of 2): http://www.wikihow.com/Check-if-a-Number-Is-Prime"
  (if-not (= 2 num)
    (let [sqrt-ceil (Math/ceil (Math/sqrt num))
          rng (range 2 (+ 1 sqrt-ceil))]
      (nil? (some true? (map (partial evenly-div? num) rng))))
    true)
)

(defn primes []
  "Returns lazily a list of prime numbers to infinity and beyond"
  (filter prime? (drop 2 (range)))
)

(defn primes-multip [prm-range]
  "Returns a list of lists containing the multiplication of a series of prime numbers with each other"
  (for [p1 prm-range] {p1 (for [p2 prm-range] (* p1 p2))}))

(defn primes-range [n] (take n (primes)))

(def primes-range-memo (memoize primes-range))

(defn pretty-prn-primes [n]
  "Outputs in a nicely formatted table the result of a prime range multiplication"
  (let [prm-range (primes-range-memo n)
        multip-result (primes-multip prm-range)]

    (print "    |")
    (doseq [col prm-range] (print (format "%5d" col)))
    (println)
    (print "----+")
    (doseq [col (range n)] (print "-----"))
    (doseq [prime-row multip-result]
      (println)
      (let [multiplier (first (first prime-row))
            rng (second (first prime-row))]
        (print (format "%3d |" multiplier))
        (doseq [col rng]
          (print (format "%5d" col))))))
  (println)
)



(defn -main
  "Prime number table generator for Funding Circle"
  [& args]
  (pretty-prn-primes (Integer. (first args))))
