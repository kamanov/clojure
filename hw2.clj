  (ns hw2)

  ; 1)
  (defmulti factorial identity)
  (defmethod factorial 0 [_] 1)
  (defmethod factorial :default [x] (* x (factorial (dec x))))

  (println (factorial 5))

  ; 2)
  (def account1 (ref 100))
  (def account2 (ref 0))

  (defn transfer [amount from to]
    (dosync
        (alter from - amount)
        (alter to   + amount)))

  (transfer 100 account1 account2)

  ; 3)
  (defmacro my-or
    ([] nil)
    ([x] x)
    ([x & next]
        `(let [or# ~x]
           (if or# true (my-or ~@next)))))

  ; 4)
  (defmacro my-let
    [bindings & body]
    `((fn ~(vec (keep-indexed #(if (even? %1) %2) bindings)) ~@body) ~@(keep-indexed #(if (odd? %1) %2) bindings)))
