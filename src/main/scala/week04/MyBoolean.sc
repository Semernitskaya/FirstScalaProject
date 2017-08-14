abstract class MyBoolean {

  def ifThenElse[T](t: => T, e: => T): T

  def &&(b: => MyBoolean) = ifThenElse(b, cool_false)

  def ||(b: => MyBoolean) = ifThenElse(cool_true, b)

  def unary_! : MyBoolean = ifThenElse(cool_false, cool_true)

  def ==(b: => MyBoolean) = ifThenElse(b, !b)

  def !=(b: => MyBoolean) = ifThenElse(!b, b)

  def < (b: => MyBoolean) = ifThenElse(cool_false, b)
}

object cool_true extends MyBoolean {

  override def ifThenElse[T](t: => T, e: => T) = t
}

object cool_false extends MyBoolean {

  override def ifThenElse[T](t: => T, e: => T) = e
}

!cool_false
!cool_true
cool_true || cool_false
cool_false || cool_false
cool_true && cool_false

cool_false < cool_false
cool_false < cool_true
cool_true < cool_true