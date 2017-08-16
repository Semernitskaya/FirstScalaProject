package main.scala.week03.list

/**
  * Created by Semernitskaya on 11.08.2017.
  */
trait List[+T] {
  def isEmpty: Boolean

  def head: T

  def tail: List[T]

  def add[U >: T](elem: U): List[U]

}
