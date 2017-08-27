def map[T, U](list: List[T])(f: T => U): List[U] = list match {
  case Nil => Nil
  case e :: ls => f(e) :: map(ls)(f)
}

def filter[T](list: List[T])(predicate: T => Boolean): List[T] = list match {
  case Nil => Nil
  case e :: ls =>
    if (predicate(e)) e :: filter(ls)(predicate)
    else filter(ls)(predicate)
}

def scale(list: List[Int], factor: Int) =
  map(list)(e => e * factor)

def square(list: List[Int]) =
  map(list)(e => e * e)

scale(List(1, 2, 3), 7)
square(List(1, 2, 3))
filter(List(1, 2, 5, 67, 10))(e => e % 2 == 0)

List(1, 2, 5, -67, 10) filter (x => x > 0)
List(1, 2, 5, -67, 10) filterNot (x => x > 0)
List(1, 2, 5, -67, 10) partition (x => x > 0)

List(1, 2, 5, -67, 10) takeWhile (x => x > 0)
List(1, 2, 5, -67, 10) dropWhile (x => x > 0)
List(1, 2, 5, -67, 10) span (x => x > 0)

def pack[T](xs: List[T]): List[List[T]] = xs match {
  case Nil => Nil
  case x :: _ =>
    (xs takeWhile (e => e == x)) :: pack(xs dropWhile (e => e == x))
}


def encode[T](xs: List[T]): List[(T, Int)] =
  pack(xs) map (l => (l.head, l.length))

pack(List("a", "a", "a", "b", "c", "c", "a"))
encode(List("a", "a", "a", "b", "c", "c", "a"))