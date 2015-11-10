(ns fcprime.core-test
  (:require [clojure.test :refer :all]
            [fcprime.core :refer :all]))


(deftest test-is-evenly-divisible
  (testing "Can I successfuly determine if a number is evenly divisible?"
    (is (= false (evenly-div? 37 3)))
    (is (= false (evenly-div? 45 2)))
    (is (= false (evenly-div? 63 8)))
    (is (= true (evenly-div? 24 4)))
    (is (= true (evenly-div? 144 2)))
    (is (= true (evenly-div? 800 100)))))

(deftest test-is-prime
  (testing "Can I successfuly determine if a whole number is prime?"
    (is (= true (prime? 7)))
    (is (= true (prime? 593)))
    (is (= true (prime? 997)))
    (is (= false (prime? 406)))
    (is (= false (prime? 128)))
    (is (= false (prime? 2000)))))

(deftest test-primes
  (testing "Can I lazily generate a list of prime numbers?"
    (is (= '(2 3 5 7 11 13 17 19 23 29 31 37 41 43 47) (take 15 (primes))))
))

(deftest test-prime-multip
  (testing "Can I return a list of lists of prime multiplications?"
    (let [test-range (take 4 (primes))]
      (is (= '(2 3 5 7) test-range))
      (is (= '({2 (4 6 10 14)} {3 (6 9 15 21)} {5 (10 15 25 35)} {7 (14 21 35 49)}) (primes-multip test-range)))
)))



