package patterns.factory

trait ThaiCurrencyConverter {
  def convert(amount: BigDecimal): BigDecimal
}