class Polynomial(_elems: Map[Int, Double]) {

  def this(pairs: (Int, Double)*) = this(pairs.toMap)

  val elems = _elems withDefaultValue 0.0

  def +(other: Polynomial) = new Polynomial(elems ++ (other.elems map sumMls))

  /**
    * concatenation with foldLeft
    * @param other
    * @return
    */
  def ++(other: Polynomial) =
    new Polynomial(other.elems.foldLeft(elems)(addTerm))

  def addTerm(elems: Map[Int, Double], elem: (Int, Double)): Map[Int, Double] = {
    elems + ((elem._1, elem._2 + elems(elem._1)))
  }

  def sumMls(elem: (Int, Double)): (Int, Double) = {
    (elem._1, elem._2 + elems(elem._1))
  }

  override def toString: String =
    elems.toList.sorted.reverse.foldRight("")((elem, s) => elem match {
      case (_, 0) => "" + s
      case (0, ml) => ml + " + " + s
      case (dg, ml) => ml + "x^" + dg + " + " + s
    }
    ).stripSuffix(" + ")

}

val p1 = new Polynomial(Map(3 -> 4.0, 1 -> 2.0, 0 -> 6.0))
val p2 = new Polynomial(Map(3 -> 4.0, 0 -> 0.0, 5 -> 7.0))
val p3 = new Polynomial(3 -> 4.0, 0 -> 0.0, 5 -> 7.0)

p1 + p2
p1 ++ p2

