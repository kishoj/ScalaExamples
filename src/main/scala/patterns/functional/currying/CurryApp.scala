package patterns.functional.currying

object CurryApp {
  def adder(a: Int)(b: Int): Int = a + b
  def multiply(a: Int)(b: Int): Int = a * b

  def threeParameteradder(a: Int)(b: Int)(c: Int): Int = a + b + c
  def threeParametermultiply(a: Int)(b: Int)(c: Int): Int = a * b * c

  def main(args: Array[String]): Unit = {
    println("Testing curry in Scala")
    println("adder(2)(3): " + adder(2)(3))
    println("threeParameteradder(1)(2)(3): " + threeParameteradder(1)(2)(3))

    println("multiply(2)(3): " + multiply(2)(3))
    println("threeParametermultiply(4)(2)(3): " + threeParametermultiply(4)(2)(3))

    val curriedAdd = adder _
    println("CurriedAdd: " + curriedAdd)

    val curriedAddForThreeParameters = threeParameteradder _
    println("curriedAddForThreeParameters: " + curriedAdd)

    val addTwo = curriedAdd(2)
    println("addTwo: " + addTwo)

    val addTwoForThreeParameters = curriedAddForThreeParameters(2)
    println("addTwoForThreeParameters: " + addTwoForThreeParameters)

    val addThreeForThreeParameters = addTwoForThreeParameters(3)
    println("addThreeForThreeParameters: " + addThreeForThreeParameters)

    val timesTwo = multiply(2) _
    println("timesTwo: " + timesTwo)

    val timesFourForThreeParameters = threeParametermultiply(4) _
    println("timesFourForThreeParameters: " + timesFourForThreeParameters)

    val timesTwoTimesFourForThreeParameters = timesFourForThreeParameters(2)
    println("timesTwoTimesFourForThreeParameters: " + timesTwoTimesFourForThreeParameters)

    val timesThreetimesTwoTimesFourForThreeParameters = timesTwoTimesFourForThreeParameters(3)
    println("timesThreetimesTwoTimesFourForThreeParameters: " + timesThreetimesTwoTimesFourForThreeParameters)
  }

}
