val stringsToIntsMap = Map("a" -> 1, "A" -> 1, "b" -> 2)
stringsToIntsMap("a")
//stringsToIntsMap("c")
(stringsToIntsMap get "a").getOrElse("not found")
(stringsToIntsMap get "c").getOrElse("not found")
stringsToIntsMap get "a"
stringsToIntsMap get "c"

val fruits = List("apple", "orange", "pineapple", "peach")
fruits.sorted
fruits.sortWith(_.length < _.length)
fruits.groupBy(s => s.head)