package main.scala.week03.list

/**
  * Created by Semernitskaya on 11.08.2017.
  */
class Nil[T] extends List[T] {

  override def isEmpty: Boolean = true

  override def head = throw new NoSuchElementException("Nil.head")

  override def tail = throw new NoSuchElementException("Nil.tail")

  override def add[U >: T](elem: U) = new LinkedList(elem, this)
}
