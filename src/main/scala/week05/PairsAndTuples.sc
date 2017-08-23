val pair = (1, "hi")
val tuple = (1, 3, "hi", new Object, List(2, 3))

pair._1
tuple._5

def matchExample(o: Object) = o match {
  case (e1, e2) => println(f"pair of ${e1}, ${e2}")
  case (e1, _, _, _, _) => println(f"tuple starts from ${e1}")
}

matchExample(pair)
matchExample(tuple)