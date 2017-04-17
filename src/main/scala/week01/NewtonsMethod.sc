def sqrt(target: Double) = {

  def sqrtIteration(guess: Double): Double =
    if (isGoodEnough(guess)) guess
    else sqrtIteration(improve(guess))

  def improve(guess: Double) =
    (guess + target / guess) / 2

  def isGoodEnough(guess: Double) =
    Math.abs(guess * guess - target) / target < 0.0001

  sqrtIteration(target / 2)
}

sqrt(4)
sqrt(2)
sqrt(1e-6) * sqrt(1e-6)
sqrt(1.0e90)
