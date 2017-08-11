package main.scala.week03.list

/**
  * Created by Semernitskaya on 11.08.2017.
  */
class LinkedList[T](val head: T, val tail: List[T]) extends List[T] {

  override def isEmpty: Boolean = false

  override def add(elem: T) = new LinkedList[T](elem, this)
}
