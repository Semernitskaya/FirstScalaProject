def sum(fun: Int => Int): (Int, Int) => Int = {
  def innerSum(left: Int, right: Int): Int =
    if (left > right) 0
    else fun(left) + innerSum(left + 1, right)

  innerSum
}

def cubeSum = sum(x => x * x * x)
cubeSum(0, 2)

def sumShort(fun: Int => Int)(left: Int, right: Int): Int =
  if (left > right) 0 else fun(left) + sumShort(fun)(left + 1, right)

sumShort(x => x * x)(0, 2)

def dummyCurryingABС(a: Int)(b: Int)(c: Int) = a + b + c
def dummyCurryingBC(b: Int)(c: Int) = dummyCurryingABС(1)(b: Int)(c: Int)
def dummyCurryingC(c: Int) = dummyCurryingBC(2)(c: Int)
dummyCurryingC(3)

def product(fun: Int => Int)(left: Int, right: Int): Int =
  if (left > right) 1 else fun(left) * product(fun)(left + 1, right)

def factorial(n: Int) = product(x => x)(1, n)
factorial(4)

def accumulate(initialValue: Int, accumulator: (Int, Int) => Int)
              (fun: Int => Int)
              (left: Int, right: Int): Int =
  if (left > right) initialValue
  else accumulator(fun(left), accumulate(initialValue, accumulator)(fun)(left + 1, right))

accumulate(1, (x, y) => x*y)(x => x)(1, 4)
