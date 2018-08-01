package patterns.functional.tailrecursion

object Sum {
  def sum(number: BigDecimal): BigDecimal = {
    def calculateSum(number: BigDecimal, result: BigDecimal): BigDecimal = {
      if (BigDecimalUtils.ZERO.equals(number)) result
      else calculateSum(number - BigDecimalUtils.ONE, result + number)
    }
    if (BigDecimalUtils.ZERO.equals(number)) BigDecimalUtils.ZERO
    else calculateSum(number, BigDecimalUtils.ZERO)
  }

  def main(args: Array[String]) : Unit = {
    println("Sum using Tail Recursion")
    (1 to 10)
      .map(number => BigDecimal.valueOf(number))
      .map(sum)
      .foreach(println)

    println(sum(BigDecimal.valueOf(4)))
  }
}
