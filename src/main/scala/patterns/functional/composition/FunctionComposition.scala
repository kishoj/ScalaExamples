package patterns.functional.composition

object FunctionComposition {
  val DISCOUNT_RATE = BigDecimal.valueOf(0.2)
  val VAT_RATE = BigDecimal.valueOf(0.07)

  def discount(markedPrice: BigDecimal): BigDecimal = {
    markedPrice * (1 - DISCOUNT_RATE)
  }

  def vat(discountedPrice: BigDecimal): BigDecimal = {
    discountedPrice * (1 + VAT_RATE)
  }

  def roundOff(value: BigDecimal): BigDecimal = {
    value.setScale(2, BigDecimal.RoundingMode.HALF_EVEN);
  }

  val applyDiscount = (markedPrice: BigDecimal) => markedPrice * (1 - DISCOUNT_RATE)
  val applyVat = (discountedPrice: BigDecimal) => discountedPrice * (1 + VAT_RATE)
  val applyRoundOff = (value: BigDecimal) => value.setScale(2, BigDecimal.RoundingMode.HALF_EVEN)

  def main(args: Array[String]): Unit = {
    val MP = BigDecimal.valueOf(100.00)

    // Difference between andThen and composite is just the order of functions
    val discountAndThenVatAndThenRoundOff = discount _ andThen vat _ andThen roundOff
    println("Selling Price (way 1): " + discountAndThenVatAndThenRoundOff(MP))

    // Looks good
    println("Selling Price (way 2): " + applyDiscount.andThen(applyVat).andThen(applyRoundOff)(MP))

    // Function composition here
    val compositeFunction = roundOff _ compose vat _ compose discount _
    println("Selling Price (way 3): " + compositeFunction(MP))

    // Looks good
    println("Selling Price (way 4): " +  applyRoundOff.compose(applyVat).compose(applyDiscount)(MP))
  }
}