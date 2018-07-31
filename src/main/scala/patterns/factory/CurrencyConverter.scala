package patterns.factory

object CurrencyConverter {

  private object EuroToTHB extends ThaiCurrencyConverter {
    @Override override def convert(amount: BigDecimal): BigDecimal = BigDecimal.valueOf(40.00) * amount
  }

  private object USDToTHB extends ThaiCurrencyConverter {
    @Override override def convert(amount: BigDecimal): BigDecimal = BigDecimal.valueOf(32.33) * amount
  }

  private object JYPToTHB extends ThaiCurrencyConverter {
    @Override override def convert(amount: BigDecimal): BigDecimal = amount / BigDecimal.valueOf(3)
  }

  private object THBToTHB extends ThaiCurrencyConverter {
    @Override override def convert(amount: BigDecimal): BigDecimal = amount
  }

  def apply(currencyType: String): ThaiCurrencyConverter = currencyType match {
    case CurrencyType.EUR => EuroToTHB
    case CurrencyType.USD => USDToTHB
    case CurrencyType.JYP => JYPToTHB
    case _ => THBToTHB
  }

  def main(args: Array[String]): Unit = {
    println("Convert 50 EUR to THB: " + CurrencyConverter(CurrencyType.EUR).convert(50))
    println("Convert 200 USD to THB: " + CurrencyConverter(CurrencyType.USD).convert(200))
    println("Convert 6000 JYP to THB: " + CurrencyConverter(CurrencyType.JYP).convert(6000))
    println("Convert 1000 Undefined to THB: " + CurrencyConverter("UNDEFINED").convert(1000))
  }
}
