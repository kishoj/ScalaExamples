package patterns.functional.tailrecursion

import scala.annotation.tailrec

object Factorial {

  def factorial(number: BigDecimal): BigDecimal = {
    @tailrec
    def calculateFactorial(number: BigDecimal, result: BigDecimal): BigDecimal = {
      if (BigDecimalUtils.ONE.equals(number)) result
      else calculateFactorial(number - BigDecimalUtils.ONE, result * number)
    }
    if (BigDecimalUtils.ONE.equals(number)) BigDecimalUtils.ONE
    else calculateFactorial(number, BigDecimalUtils.ONE)
  }

  def main(args: Array[String]) : Unit = {
    (1 to 10)
      .map(number => BigDecimal.valueOf(number))
      .map(factorial)
      .foreach(println)

    println(factorial(BigDecimal.valueOf(100)))
  }
}
