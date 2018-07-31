package patterns.functional.observerpattern

class BankAccount extends Publisher {
  val ZERO = BigDecimal.valueOf(0)

  private var balance: BigDecimal = ZERO

  def currentBalance: BigDecimal = balance

  def deposit(amount: BigDecimal): Unit = {
    if (amount > ZERO) {
      balance += amount
      publish()
    }
  }

  def withdraw(amount: BigDecimal): Unit = {
    if (amount > ZERO && amount <= balance) {
      balance -= amount
      publish()
    } else throw new Error("Insufficient Balance to withdraw")
  }
}
