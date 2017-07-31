def findFixedPoints(f: Double => Double)(initialValue: Double) = {

  def isCloseEnough(value1: Double, value2: Double): Boolean = {
    (Math.abs(value1 - value2) / (value1 * value1)) < 0.0001
  }

  def find(value: Double): Double = {
    val nextValue = f(value)
    println(f"next value $nextValue")
    if (isCloseEnough(value, nextValue)) nextValue
    else find(nextValue)
  }

  find(initialValue)
}

findFixedPoints(x => 1 + x/2)(1)

def average(f: Double => Double)(x: Double) = (f(x) + x)/2

def sqrt(x: Double) = findFixedPoints(y => (y + x / y) / 2)(1)
sqrt(2)

def improvedSqrt(x: Double) = findFixedPoints(average(y => x/y))(1)
improvedSqrt(2)



