def mergeSort[T](list: List[T])(less: (T, T) => Boolean): List[T] = {
  val n = list.length / 2
  if (n == 0) list
  else {
    val parts = list splitAt n
    merge(mergeSort(parts._1)(less), mergeSort(parts._2)(less))(less)
  }
}

def merge[T](list1: List[T], list2: List[T])
            (less: (T, T) => Boolean): List[T] = (list1, list2) match {
  case (Nil, ls2) => ls2
  case (ls1, Nil) => ls1
  case (e1 :: ls1, e2 :: ls2) =>
    if (less(e1, e2)) e1 :: merge(ls1, list2)(less)
    else e2 :: merge(list1, ls2)(less)
}

mergeSort(List(1, 2, 3, 4, 5))((x, y) => x < y)
mergeSort(List(1, 2, 3, 4, 5).reverse)((x, y) => x < y)
//mergeSort(List())((x, y) => x < y)
mergeSort(List())((x: Int, y: Int) => x < y)
mergeSort(List(10))((x, y) => x < y)
mergeSort(List(23, 4, 5, 67, 105, 67))((x, y) => x < y)
mergeSort(List("23", "4", "5", "67", "105", "67")) (Ordering.String.lt)
