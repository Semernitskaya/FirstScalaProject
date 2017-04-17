import scala.annotation.tailrec

def factorial(n: Int): Int =
  if (n == 1) 1 else n * factorial(n - 1)

factorial(1)
factorial(2)
factorial(5)
factorial(10)
factorial(100)

def tailRecursiveFactorial(n: Int) = {

  @tailrec
  def increment(n: Int, res: Int): Int =
    if (n == 1) res else increment(n - 1, res * n)

  increment(n, 1)
}

tailRecursiveFactorial(1)
tailRecursiveFactorial(2)
tailRecursiveFactorial(5)
tailRecursiveFactorial(10)
tailRecursiveFactorial(100)