package patterns.functional.tailrecursion

object BigDecimalUtils {
  val ZERO = BigDecimal.valueOf(0)
  val ONE = BigDecimal.valueOf(1)

  implicit def intToBigDecimal(input: Int): BigDecimal = BigDecimal.valueOf(input)
  implicit def bigDecimalToInt(input: BigDecimal): Int = input.intValue()
}
