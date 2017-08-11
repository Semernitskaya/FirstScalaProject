package main.scala.week03.list

/**
  * Created by Semernitskaya on 11.08.2017.
  */
class Nil[T] extends List[T] {

  override def isEmpty: Boolean = true

  override def head = throw new NoSuchElementException("Nil.head")

  override def tail = throw new NoSuchElementException("Nil.tail")

  override def add(elem: T) = new LinkedList(elem, this)
}
