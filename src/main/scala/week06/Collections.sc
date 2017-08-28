import scala.collection.immutable.HashSet

val v = Vector(1, 4, 5)
3 +: v
v :+ 0
v(1)

v exists (x => x > 3)
v forall (x => x > 3)
v zip "abcdef"
(v zip "abcdef").unzip
v flatMap (x => List(x, x * 10, x * 100))

val s = HashSet(1, 3, 4, 1)
s - 1
s + 56

val ar = Array(1, 3, 4)
ar(2)

(2 to 5).toList
(2 to 0).toList
(2 until 5).toList
(1 to 10 by 2).toList
(1 to 10 by -2).toList
(10 to 1 by -2).toList

(2 to 5).sum
(2 to 5).product

"abc" flatMap(x => List('7' , x))

