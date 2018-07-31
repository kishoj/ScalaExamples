package patterns.functional.mixin

abstract class Salary {
  val month : String
  val salaryAmount : BigDecimal

  def getSalary: BigDecimal = salaryAmount
}
