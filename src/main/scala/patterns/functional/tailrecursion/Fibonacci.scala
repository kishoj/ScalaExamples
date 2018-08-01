package patterns.functional.tailrecursion

import scala.annotation.tailrec

object Fibonacci {

  def fibonacci(number: BigDecimal): BigDecimal = {
    @tailrec
    def calculateFibonacci(x: BigDecimal, y: BigDecimal, result: BigDecimal): BigDecimal = {
      if (BigDecimalUtils.ZERO.equals(number)) x else calculateFibonacci(y, x + y, result - BigDecimalUtils.ONE)
    }
    if (number > BigDecimalUtils.ONE) calculateFibonacci(BigDecimalUtils.ZERO, BigDecimalUtils.ONE, number)
    else if (BigDecimalUtils.ZERO.equals(number)) BigDecimalUtils.ZERO
    else BigDecimalUtils.ONE
  }

  def main(args: Array[String]): Unit = {
    (0 to 10)
      .map(number => BigDecimal.valueOf(number))
      .map(fibonacci)
      .foreach(println)

    println(fibonacci(BigDecimal.valueOf(1000)))
  }
}
