trait Planar {
  val pi = 3.14

  def height: Int

  def width: Int

  def surface: Int = height * width
}

trait Colored {
  def fill(color: Int)
}

abstract class Shape extends Colored {

}

class Square(h: Int, w: Int) extends Shape with Planar {
  override def height: Int = h

  override def width: Int = w

  override def fill(color: Int): Unit = print("fill with color %s", color)
}

var shape = new Square(4, 2)
shape.surface
shape.fill(1)

