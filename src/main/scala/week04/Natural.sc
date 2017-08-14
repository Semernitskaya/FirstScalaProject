abstract class Natural {

  def isZero: Boolean

  def predecessor: Natural

  def successor: Natural = new Successor(this)

  def +(that: Natural): Natural = {
    if (that.isZero) this
    else successor + that.predecessor
  }

  def -(that: Natural): Natural = {
    if(that.isZero) this
    else predecessor - that.predecessor
  }

  override def toString = {
    if(isZero) ">"
    else "| " + predecessor.toString
  }
}

object Zero extends Natural {

  override def isZero = true

  override def predecessor = throw new IllegalStateException

}

class Successor(val pred: Natural) extends Natural {

  override def isZero: Boolean = false

  override def predecessor = pred

}

val val2 = Zero.successor.successor
val val1 = Zero.successor
val1 - Zero
val2 + Zero
val1 + val2
val2 - val1
