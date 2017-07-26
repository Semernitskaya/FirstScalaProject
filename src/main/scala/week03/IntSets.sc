abstract class IntSet {
  def include(e: Int): IntSet

  def contains(e: Int): Boolean

  def union(other: IntSet): IntSet
}

object EmptyIntSet extends IntSet {
  override def include(e: Int): IntSet = {
    new NonEmptyIntSet(e, EmptyIntSet, EmptyIntSet)
  }

  override def contains(e: Int): Boolean = false

  override def toString = "{}"

  override def union(other: IntSet): IntSet = other
}

class NonEmptyIntSet(value: Int, left: IntSet, right: IntSet) extends IntSet {
  override def include(e: Int): IntSet = {
    if (e < value) new NonEmptyIntSet(value, left include e, right)
    else if (e > value) new NonEmptyIntSet(value, left, right include e)
    else this
  }

  override def contains(e: Int): Boolean = {
    if (e < value) left contains e
    else if (e > value) right contains e
    else true
  }

  override def toString = "{" + left.toString + "{" + value + "}" + right.toString + "}"

  override def union(other: IntSet): IntSet = {
    ((left union right) union other) include value
  }
}

val t1 = new NonEmptyIntSet(2, EmptyIntSet, EmptyIntSet)
t1.include(3).include(5).include(4)
