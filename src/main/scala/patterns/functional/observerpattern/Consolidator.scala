package patterns.functional.observerpattern

class Consolidator (observed: List[BankAccount]) extends Subscriber {

  observed.foreach(_.subscribe(this))

  private var total: BigDecimal = _

  compute()

  private def compute() = {
    total = observed.map(_.currentBalance).sum
  }

  def totalBalance = {
    total
  }

  override def notify(publisher: Publisher): Unit = {
    compute()
  }
}
