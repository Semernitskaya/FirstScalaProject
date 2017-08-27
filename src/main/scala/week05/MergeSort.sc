def mergeSort[T](list: List[T])(implicit ord: Ordering[T]): List[T] = {

  def merge(list1: List[T], list2: List[T]): List[T] = (list1, list2) match {
    case (Nil, ls2) => ls2
    case (ls1, Nil) => ls1
    case (e1 :: ls1, e2 :: ls2) =>
      if (ord.lt(e1, e2)) e1 :: merge(ls1, list2)
      else e2 :: merge(list1, ls2)
  }

  val n = list.length / 2
  if (n == 0) list
  else {
    val parts = list splitAt n
    merge(mergeSort(parts._1), mergeSort(parts._2))
  }
}



mergeSort(List(1, 2, 3, 4, 5))(Ordering.Int)
mergeSort(List(1, 2, 3, 4, 5).reverse)(Ordering.Int)
//mergeSort(List())((x, y) => x < y)
mergeSort(List())(Ordering.Int)
mergeSort(List(10))(Ordering.Int)
mergeSort(List(23, 4, 5, 67, 105, 67))(Ordering.Int)
mergeSort(List("23", "4", "5", "67", "105", "67")) (Ordering.String)

implicit object MyInt extends Ordering[Int] {

  override def compare(x: Int, y: Int): Int =
    java.lang.Integer.compare(y, x)
}


//implicit object MySecondInt extends Ordering[Int] {
//
//  override degf compare(x: Int, y: Int): Int =
//    java.lang.Integer.compare(y, x)
//}

//mergeSort(List())
mergeSort(List(23, 4, 5, 67, 105, 67))
mergeSort(List("23", "4", "5", "67", "105", "67"))
