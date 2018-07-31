package patterns.functional.mixin

trait Bonus extends Salary {
  val MONTH_MULTIPLIER = 6

  def bonus: BigDecimal = salaryAmount * MONTH_MULTIPLIER
}
