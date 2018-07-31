package patterns.functional.mixin

class NovemberSalary extends Salary {
  override val month: String = Month.NOV
  override val salaryAmount : BigDecimal = BigDecimal.valueOf(1000.00)
}
