package patterns.functional.mixin

class DecemberSalary extends Salary with Bonus {
  override val month: String = Month.DEC
  override val salaryAmount : BigDecimal = BigDecimal.valueOf(1000.00)

  override def getSalary: BigDecimal = salaryAmount + bonus

  def getBonus: BigDecimal = bonus
}
