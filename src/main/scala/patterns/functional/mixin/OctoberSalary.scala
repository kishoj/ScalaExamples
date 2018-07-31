package patterns.functional.mixin

class OctoberSalary extends Salary {
  override val month: String = Month.OCT
  override val salaryAmount : BigDecimal = BigDecimal.valueOf(1000.00)
}
