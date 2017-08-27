def sum(list: List[Int]) =
  0 :: list reduceLeft (_ + _)

def product(list: List[Int]) =
  1 :: list reduceLeft (_ * _)

def sumWithFold(list: List[Int]) =
  (list foldLeft (0)) (_ + _)

def productWithFold(list: List[Int]) =
  (list foldLeft (1)) (_ * _)

//reduce left
def myReduceLeft[T](list: List[T])(op: (T, T) => T): T = list match {
  case Nil => throw new Exception("List is empty")
  case x :: xs => myFoldLeft(xs)(x)(op)
}

def myFoldLeft[T, U](list: List[T])(init: U)(op: (U, T) => U): U = list match {
  case Nil => init
  case x :: xs => myFoldLeft(xs)(op(init, x))(op)
}

//reduce right
def myReduceRight[T](list: List[T])(op: (T, T) => T): T = list match {
  case Nil => throw new Exception("List is empty")
  case x :: Nil => x
  case x :: xs => op(x, myReduceRight(xs)(op))
}

def myFoldRight[T, U](list: List[T])(init: U)(op: (T, U) => U): U = list match {
  case Nil => init
  case x :: xs => op(x, myFoldRight(xs)(init)(op))
}

myReduceLeft(List(1, 5, 8))(_ + _)
myReduceLeft(List(1, 5, 8))(_ - _)
myReduceLeft(List(1, 5, 8))(_ * _)
//myReduceLeft(List[Int]())(_ + _)

myReduceRight(List(1, 5, 8))(_ + _)
myReduceRight(List(1, 5, 8))(_ - _)

myFoldLeft(List(1, 5, 8))(0)(_ + _)
myFoldLeft(List(1, 5, 8))(0)(_ - _)
myFoldLeft(List(1, 5, 8))(1)(_ * _)
myFoldLeft(List[Int]())(0)(_ + _)

myFoldRight(List(1, 5, 8))(0)(_ + _)
myFoldRight(List(1, 5, 8))(0)(_ - _)

sum(List(1, 5, 8))
sum(List())
product(List(1, 5, 8))
product(List())

sumWithFold(List(1, 5, 8))
sumWithFold(List())
productWithFold(List(1, 5, 8))
productWithFold(List())

def mapFun[T, U](xs: List[T], f: T => U): List[U] =
  (xs foldRight List[U]()) (f(_) :: _)

def lengthFun[T](xs: List[T]): Int =
  (xs foldRight 0) ((_, y) => y + 1)


mapFun[Int, Int](List(1, 2, 5), x => x + 2)
lengthFun(List(1, 2, 5))