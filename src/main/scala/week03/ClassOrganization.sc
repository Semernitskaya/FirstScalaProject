//predef
Predef.assume(0 < 1)
//Predef.???
Predef.classOf[String]
Predef.DummyImplicit
Predef.identity(5)
Predef.locally(7)

//imports
import java.util.ArrayList
new ArrayList()

import java.util.concurrent._
new ConcurrentHashMap()

import java.sql.{Clob, Blob}
import java.sql.{Date => SqlDate}
import java.util.Date
new SqlDate(1)
new Date(1)

//traits
trait A {
  val aa = ""

  var aaa = ""

  def a = "aaa"
}

trait B {
  def b = "bbb"

  def abstractB
}

trait C {
  def c = "ccc"
}

class AB extends A with B with C {
  override def c = "ab ccc"

  override def abstractB: Unit = ???
}

object AB extends A with B with C {
  override def abstractB: Unit = ???
}
AB.c

new AB().c