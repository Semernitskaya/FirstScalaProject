//A2 <: A1
class A1

class A2 extends A1

//B2 <: B1
class B1

class B2 extends B1

def f(a: A2): B1 = new B1

def f_covariant(a: A1): B2 = new B2

def ff(function: Function1[A2, B1]) = function(new A2)
ff(f)
ff(f_covariant)