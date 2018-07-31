package patterns.functional.mixin

object MixinObject {

  // This collections will be of type list of Salary so we need different mechanism for DecemberSalary
  val mySalaries2018 = Seq(new OctoberSalary, new NovemberSalary, new DecemberSalary)

  def printSalary(salary: Salary) : Unit = {
    println("<------------- " + salary.month + " ------------->")
    println("Salary: " + salary.salaryAmount)
    salary.month match {
      case Month.DEC => println("Bonus: " + salary.getSalary.-(salary.salaryAmount))
      case _ => None
    }
    println("Total Amount Received: " + salary.getSalary)
  }

  def main(args: Array[String]): Unit = {
    mySalaries2018.foreach(printSalary)

    val decemberSalary = new DecemberSalary
    println("<------------- " + decemberSalary.month + " ------------->")
    println("Salary: " + decemberSalary.salaryAmount)
    println("Bonus: " + decemberSalary.bonus)
    println("Total Amount Received: " + decemberSalary.getSalary)
  }
}
