def mergeSort(list: List[Int]): List[Int] = {
  val n = list.length / 2
  if (n == 0) list
  else {
    val parts = list splitAt n
    merge(mergeSort(parts._1), mergeSort(parts._2))
  }
}

def merge(list1: List[Int], list2: List[Int]): List[Int] = (list1, list2) match {
  case (Nil, ls2) => ls2
  case (ls1, Nil) => ls1
  case (e1 :: ls1, e2 :: ls2) =>
    if (e1 < e2) e1 :: merge(ls1, list2)
    else e2 :: merge(list1, ls2)
}

mergeSort(List(1, 2, 3, 4, 5))
mergeSort(List(1, 2, 3, 4, 5).reverse)
mergeSort(List())
mergeSort(List(10))
mergeSort(List(23, 4, 5, 67, 105, 67))
