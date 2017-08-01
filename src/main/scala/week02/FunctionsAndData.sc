new Object()

class Rational(x: Int, y: Int) {
  def this(x: Int) = this(x, 1)

  require(y != 0, "Denom must be not null")

  private val commonDivisor = gcd(x, y)

  def numer = x / commonDivisor

  def denom = y / commonDivisor

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString = f"${numer}/${denom}"

  def add(that: Rational) = new Rational(
    that.denom * numer + that.numer * denom,
    that.denom * denom
  )

  def neg = new Rational(-numer, denom)

  def sub(that: Rational) = add(that.neg)

  def less(that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this.less(that)) that else this
}

val r1 = new Rational(1, 4)
val r2 = new Rational(2, 4)
r1.add(r2)
r1.neg
r2.sub(r1)

val x = new Rational(1, 3)
val y = new Rational(5, 7)
val z = new Rational(3, 2)
x.sub(y).sub(z)
x.less(y)
z.less(x)
x.max(y)

//val incorrect = new Rational(1, 0)
val correct = new Rational(0, 2)

assert(1 < 2, "Correct assertion")

//assert(1 > 2, "Incorrect assertion")

new Rational(1)



