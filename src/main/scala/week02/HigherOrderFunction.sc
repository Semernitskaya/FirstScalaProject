import scala.annotation.tailrec

def sum(left: Int, right: Int): Int =
  if (left > right) 0 else left + sum(left + 1, right)

sum(1, 10)
//sum(1, 1000000000)

def tailRecSum(left: Int, right: Int) = {

  @tailrec
  def loop(acc: Int, left: Int): Int =
    if (left > right) acc else loop(acc + left, left + 1)

  loop(0, left);
}

tailRecSum(1, 10)
tailRecSum(1, 1000000000)

def sumF(f: Int => Int, left: Int, right: Int): Int =
  if (left > right) 0 else f(left) + sumF(f, left + 1, right)

def cube(x: Int) = x * x * x
def same(x: Int) = x

sumF(same, 1, 10)
sumF(cube, 1, 10)

def sumCubes(left: Int, right: Int) = sumF(cube, left, right)
sumCubes(1, 10)

def sumSqr(left: Int, right: Int) = sumF(x => x * x, left, right)
sumSqr(1, 10)

def tailRecSumF(f: Int => Int, left: Int, right: Int) = {

  @tailrec
  def loop(acc: Int, left: Int): Int =
    if (left > right) acc else loop(acc + f(left), left + 1)

  loop(0, left)
}

tailRecSumF(same, 1, 10)
tailRecSumF(cube, 1, 10)

def tailRecProductF(f: Int => Int, left: Int, right: Int) = {

  @tailrec
  def loop(acc: Int, left: Int): Int =
    if (left > right) acc else loop(acc * f(left), left + 1)

  loop(1, left)
}

def factorial(n: Int) = tailRecProductF(same, 1, n)
factorial(5)

def


