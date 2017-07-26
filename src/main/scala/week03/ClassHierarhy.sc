//object type
var anyRef = new AnyRef
anyRef.toString
anyRef.hashCode
anyRef.equals(anyRef)
anyRef.equals(new AnyRef)
anyRef == anyRef
anyRef != 7

//primitive types
var int = 10
int = 10L.toInt

var long = 10L
long = int

var byte: Byte = 10
byte = 1000.toByte

var double = 100.0
double = 10
double = .0

//nothing return function
var exc = new Error("test error")

def error = throw exc

//null object
var n = null
var nullStr: String = n
//var nullInt: Int = null










