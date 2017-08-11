trait Planar {
  val pi = 3.14

  def height: Int

  def width: Int

  def surface: Int = height * width
}

//diamond problem
trait Lined {
  def line(color: Int): String
}

trait SlashLined extends Lined {
  override def line(color: Int) = f"---------${color}---------"
}

trait DotLined extends Lined {
  override def line(color: Int) = f"-.-.-.-.-.-.-${color}-.-.-.-.-.-.-"
}

//last win
class Square(h: Int, w: Int) extends Planar with SlashLined with DotLined   {
  override def height: Int = h

  override def width: Int = w

  def fill(color: Int): Unit = print("fill with color %s", color)
}

var shape = new Square(4, 2)
shape.surface
shape.fill(1)
shape.line(3)


