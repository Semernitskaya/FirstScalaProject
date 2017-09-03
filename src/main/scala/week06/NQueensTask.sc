def nQueens(n: Int): Set[List[Int]] = {

  def placeQueens(queensCount: Int): Set[List[Int]] = {
    if (queensCount == 0) Set(List())
    else for {
      queens <- placeQueens(queensCount - 1)
      col <- 0 until n
      if (isSafe(col, queens))
    } yield col :: queens
  }

  def onDiagonal(pair1: (Int, Int), pair2: (Int, Int)) =
    Math.abs(pair1._1 - pair2._1) == Math.abs(pair1._2 - pair2._2)

  def isSafe(col: Int, queens: List[Int]) = {
    val row = queens.length
    val queensWithRows = (row - 1 to 0 by -1) zip queens
    queensWithRows forall (pair => pair._2 != col
      && !onDiagonal(pair, (row, col)))
  }

  placeQueens(n);
}

def printQueensSolution(solution: List[Int]) = {
  "\n" + ((solution.reverse map (col =>
    Vector.fill(solution.length)("* ")
      .updated(col, "q ").mkString)) mkString "\n")
}

(nQueens(5) map printQueensSolution) mkString "\n"
