class GrandParent

class Parent extends GrandParent

class Child extends Parent

def method1[T] (v: T): T = v
method1(new Object)
method1(new GrandParent)
method1(new Child)

def method2[T <: Child] (v: T): T = v
//method2(new Object)
//method2(new GrandParent)
method2(new Child)

def method3[T <: Parent] (v: T): T = v
//method3(new Object)
method3(new Parent)
method3(new Child)

def method4[T >: Parent] (v: T): T = v
method4(new Object)
method4(new Parent)
//method4(new Child)

def method5[T >: Parent <: GrandParent] (v: T): T = v
//method5(new Object)
method5(new GrandParent)
method5(new Parent)
//method5(new Child)

//an array problem
val childs: Array[Child] = Array()
//val objects: Array[Object] = childs