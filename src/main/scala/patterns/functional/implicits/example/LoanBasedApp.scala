package patterns.functional.implicits.example

sealed trait LoanApplication
case class SMELoanApplication(var name: String) extends LoanApplication
case class StaffLoanApplication(var name: String) extends LoanApplication
case class RevolvingLoanApplication(var name: String) extends LoanApplication

sealed trait Loan[T] {
  def apply(application: T): Unit
}

object LoanBasedApp {

  implicit object SMELoan extends Loan[SMELoanApplication] {
    override def apply(application: SMELoanApplication): Unit = {
      println("Apply for SME Loan")
      println(application.toString)
    }
  }

  implicit object StaffLoan extends Loan[StaffLoanApplication] {
    override def apply(application: StaffLoanApplication): Unit = {
      println("Apply for Staff Loan")
      println(application.toString)
    }
  }

  implicit object RevolvingLoan extends Loan[RevolvingLoanApplication] {
    override def apply(application: RevolvingLoanApplication): Unit = {
      println("Apply for Revolving Loan")
      println(application.toString)
    }
  }

  def submitApplications[T: Loan](applications: List[T]): Unit = {
    for(application <- applications) {
      implicitly[Loan[T]].apply(application)
    }
  }

  def main(args: Array[String]): Unit = {
    val smeloans: List[SMELoanApplication] = List(SMELoanApplication("SME Loan1"), SMELoanApplication("SME Loan2"), SMELoanApplication("SME Loan3"))
    submitApplications(smeloans)

    val staffloans: List[StaffLoanApplication] = List(StaffLoanApplication("Staff Loan1"), StaffLoanApplication("Staff Loan2"), StaffLoanApplication("Staff Loan3"))
    submitApplications(staffloans)

    val revolvingloans: List[RevolvingLoanApplication] = List(RevolvingLoanApplication("Revolving Loan1"), RevolvingLoanApplication("Revolving Loan2"), RevolvingLoanApplication("Revolving Loan3"))
    submitApplications(revolvingloans)
  }
}
