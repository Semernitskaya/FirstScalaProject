var ints: List[Int] = List(1, 2, 3)
var strings: List[String] = List("aa", "bbb", "fff")
var empty: List[Nothing] = List()

ints = 1 :: 2 :: 3 :: 4 :: Nil
5 :: ints

ints.head
ints.tail
//empty.head
//empty.tail

def matching(l: List[Int]) = l match {
  case List() => "empty list"
  case x :: Nil => "single elem"
  case 1 :: xs => "starts from one"
}

matching(ints)
matching(empty)
matching(List(2))

def insertionSort(l: List[Int]): List[Int] = {

  def insert(i: Int, ints: List[Int]): List[Int] = ints match {
    case List() => List(i)
    case head :: tail =>
      if(i <= head) i :: ints
      else head:: insert(i, tail)
  }

  l match {
    case List() => List()
    case head :: tail => insert(head, insertionSort(tail))
  }
}

insertionSort(empty)
insertionSort(List(4, 2, 67, 54, 20))