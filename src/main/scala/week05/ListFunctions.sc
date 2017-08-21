def init[T](xs: List[T]): List[T] = xs match {
  case List() => throw new Error("init of empty list")
  case List(x) => List()
  case y :: ys => y :: init(ys)
}

def concat[T](xs: List[T], ys: List[T]): List[T] = xs match {
  case List() => ys
  case z :: zs => z :: concat(zs, ys)
}

def reverse[T](xs: List[T]): List[T] = xs match {
  case List() => xs
  case y :: ys => reverse(ys) ::: List(y)
}

def removeAt[T](n: Int, xs: List[T]): List[T] = {
  xs match {
    case List() => xs
    case y :: ys => if (n == 0) ys else y :: removeAt(n - 1, ys)
  }
}

def flatten(xs: List[Any]): List[Any] = xs match {
  case List() => xs
  case y :: ys => y match {
    case l: List[Any] => flatten(l) ::: flatten(ys)
    case k => k :: flatten(ys)
  }
}

flatten(List(List(1, 1), 2, List(3, List(5, 8))))


removeAt(1, List('a', 'b', 'c', 'd'))
removeAt(10, List('a', 'b', 'c', 'd'))

val empty = List()
val list = List(1, 2, 3, 4, 5)

init(list)
//init(empty)

list.length
list.head
list.tail
list.last
list.init
list take 3
list drop 2
list take 0
list drop 0
list take 100
list drop 100
list(2)
list.apply(2)
reverse(list)
list.reverse
list updated(1, 200)
list contains 1
concat(list, empty)
list ::: empty
concat(list, List(10, 20))
list ::: List(10, 20)


empty.length
//empty.head
//empty.tail
//empty.last
//empty.init
empty take 3
empty drop 2
//empty(1)
