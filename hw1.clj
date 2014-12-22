 (ns hw1)
  ; 1)
  (defn call-twice [fun x]
      (do (fun x) (fun x)))
  (defn hello [x]
      (println x))
  (call-twice hello 1)


  ; 2)
  (spit "test.txt" "test")
  (defn readFile [filename]
      (let [content (slurp filename)] (do (println content) content)) )
  (def x (readFile "test.txt"))
  (println x)

  ; 3)
  (def cub-anonymous
      (fn [x] (* x x x)))
  (println (cub-anonymous 7))

  ; 4)
  (defn concat-reverse [seq1 seq2]
      (concat (reverse seq1) (reverse seq2)))
  (println (concat-reverse [1,2,3] '(4,5,6)))

  ; 5)
  (defn contains [seq1 val]
      (some (fn [x] (= val x)) seq1))
  (println (contains [1 2 5] 5))

  ; 6)
  (defn diff-pairs [seq1 seq2]
      (for [x seq1 y seq2 :when (not= x y)] [x y]))
  (def x [1 2 3])
  (println (diff-pairs x x))

  ; 7)
  (defn repeatN [elem n]
      (repeat n elem))
  (println (repeatN 5 5))

