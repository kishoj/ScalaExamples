package patterns.functional.implicits

import patterns.functional.tailrecursion.BigDecimalUtils._

object ImplicitTestApp {

  // Implicit Default Value
  implicit val DEFAULT: Int = 100

  // Implicit Class
  implicit class TimeInt(i: Int) {
    def days = i * 1000 * 60 * 60 * 24
    def hours = i * 1000 * 60 * 60
    def minutes = i * 1000 * 60
    def seconds = i * 1000
  }

  implicit object StringBuilderForString extends StringBuilder[String, String] {
    override def build(value: String): String = value
  }

  implicit object StringBuilderForInt extends StringBuilder[Int, String] {
    override def build(value: Int): String = value.toString
  }

  def buildStrings[A](xs: List[A])(implicit m:StringBuilder[A, String]): Unit = {
    for ( x <- xs ) { println(m.build(x)) }
  }

  // method with implicit value
  def squareInt(implicit value: Int): Int = value * value

  def main(args: Array[String]): Unit = {
    buildStrings(List(1, 2, 3, 4, 5))

    val INT: Int = 5

    val bigDecimalValue:BigDecimal = INT
    val intValue: Int = ONE

    println("bigDecimalValue: " + bigDecimalValue)
    println("intValue: " + intValue)

    implicit def intToOperation(i: Int): IntOperator = new IntOperator(i)
    Thread.sleep(1.seconds)
    println("Square of int value 100: " + 100.square)
    Thread.sleep(2.seconds)
    println("Double of int value 100: " + 100.double)

    println("Square of int with default value: " + squareInt)
    println("Square of 5: " + squareInt(5))
  }
}
