trait Expression {

  def eval: Int
}

class Number(n: Int) extends Expression {

  override def eval = n
}

class Sum(left: Expression, right: Expression)
  extends Expression {

  override def eval = left.eval + right.eval
}

val expr1 = new Sum(new Number(1), new Number(10))
expr1.eval
val expr2 = new Sum(expr1, new Number(23))
expr2.eval
