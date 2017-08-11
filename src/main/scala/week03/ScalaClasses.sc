import java.util._

classOf[AnyRef]
classOf[AnyVal]
classOf[String]
classOf[Int]
classOf[Double]
classOf[Array[Int]]
classOf[Object]
classOf[Nothing]
classOf[Null]

"777" == new String("777")
new Object == new Object
new ArrayList

def error[A](msg: A) = throw new RuntimeException(msg.toString)
//error("777")

var nullRef = null
var str: String = null
//nullRef = "777"
str = "777"
//var int: Int = null


