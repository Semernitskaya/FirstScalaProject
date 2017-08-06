//identifiers
def i = 0
def r_ = 1
def * = 3
def & = 7
def % = 100



class Rational(x: Int, y: Int) {
  def this(x: Int) = this(x, 1)

  require(y != 0, "Denom must be not null")

  private val commonDivisor = gcd(x, y)

  def numer = x / commonDivisor

  def denom = y / commonDivisor

  private def gcd(a: Int, b: Int): Int =
    if (b == 0) a else gcd(b, a % b)

  override def toString = f"${numer}/${denom}"

  def + (that: Rational) = new Rational(
    that.denom * numer + that.numer * denom,
    that.denom * denom
  )

  def unary_- = new Rational(-numer, denom)

  def - (that: Rational) = this + (- that)

  def -&# (that: Rational) = this

  def unary_! = this

  def < (that: Rational) = numer * that.denom < that.numer * denom

  def max(that: Rational) = if (this < that) that else this
}

val r1 = new Rational(1, 4)
val r2 = new Rational(2, 4)
r1 + r2
r1 - r2
r1 -&# r2
- r2
! r1
r1.unary_-
r1 < r2

