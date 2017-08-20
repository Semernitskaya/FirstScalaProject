trait Expression {

  def show: String = this match {
    case Number(n) => n.toString
    case Var(name) => name
    case Product(Sum(expr1, expr2), Sum(expr3, expr4)) =>
      f"(${expr1.show} + ${expr2.show}) * (${expr3.show} + ${expr4.show})"
    case Product(Sum(expr1, expr2), expr3) =>
      f"(${expr1.show} + ${expr2.show}) * ${expr3.show}"
    case Product(expr1, Sum(expr2, expr3)) =>
      f"${expr1.show} * (${expr2.show} + ${expr3.show})"
    case Product(expr1, expr2) => f"${expr1.show} * ${expr2.show}"
    case Sum(expr1, expr2) => f"${expr1.show} + ${expr2.show}"
  }
}

case class Number(n: Int) extends Expression

case class Var(name: String) extends Expression

case class Sum(left: Expression, right: Expression) extends Expression

case class Product(left: Expression, right: Expression) extends Expression

Number(1)
Sum(Number(1), Number(9))

def eval(e: Expression): Int = e match {
  case Number(n) => n
  case Sum(left, right) => eval(left) + eval(right)
}


def funnyEval(e: Expression): Int = e match {
  case Number(1) => 0
  case Number(n) => n * 100
  case Sum(_, _) => 1000
}

eval(Number(1))
eval(Sum(Number(1), Number(22)))
//eval(Product(Number(1), Number(22)))

funnyEval(Number(1))
funnyEval(Number(5))
funnyEval(Sum(Number(1), Number(22)))

Number(3).show
Sum(Sum(Number(1), Number(2)), Number(5)).show
Product(Number(1), Number(3)).show
Sum(Number(5), Product(Number(1), Number(3))).show
Sum(Product(Number(1), Number(3)), Number(5)).show
Product(Sum(Number(1), Number(4)), Number(10)).show
Product(Number(10), Sum(Number(1), Number(4))).show
Product(Sum(Number(3), Number(7)), Sum(Number(1), Number(4))).show