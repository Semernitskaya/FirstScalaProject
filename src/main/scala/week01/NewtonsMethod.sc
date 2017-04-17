def sqrtIteration(guess: Double, target: Double): Double =
  if (isGoodEnough(guess, target)) guess
  else sqrtIteration(improve(guess, target), target)

def improve(guess: Double, target: Double) =
  (guess + target / guess) / 2

def isGoodEnough(guess: Double, target: Double) =
  Math.abs(guess * guess - target) / target < 0.0001

def sqrt(x: Double) = sqrtIteration(x/2, x)

sqrt(1e-6) * sqrt(1e-6)

sqrt(1.0e90)
