def f(x: Int, y: Int) = x * y

class F extends Function2[Int, Int, Int] {

  override def apply(v1: Int, v2: Int) = v1 * v2
}

new F().apply(2, 3)

{
  class Anon extends Function1[Int, Int] {

    override def apply(v1: Int) = v1 * v1
  }
  new Anon
}.apply(4)

object List extends (() => Array[Int])
  with ((Int) => Array[Int])
  with ((Int, Int) => Array[Int]) {

  override def apply(v1: Int) = Array(v1)

  override def apply(): Array[Int] = Array()

  override def apply(v1: Int, v2: Int) = Array(v1, v2)
}

List(1, 2)
List()
List(3)