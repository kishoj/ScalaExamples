package patterns.functional.implicits.example

import java.util.UUID


sealed trait Event
case class BankAccountCreated(id: UUID, name: String, accountNumber: String) extends Event
case class DepositMoney(accountNumber: String, amount: BigDecimal) extends Event
case class WithDrawMoney(accountNumber: String, amount: BigDecimal) extends Event

case class BankAccount(var id: UUID, var accountName: String, var  accountNumber: String, var balance: BigDecimal)

trait EventListener[EVENT] {
  def onEvent(a:EVENT): Unit
}

object EventBasedApp {
  var bankAccount: BankAccount = new BankAccount(UUID.randomUUID(), "", "", BigDecimal.valueOf(0))

  implicit object BankAccountCreatedListener extends EventListener[BankAccountCreated] {
    override def onEvent(event: BankAccountCreated): Unit = {
      bankAccount.accountNumber = event.accountNumber
      bankAccount.balance =  BigDecimal.valueOf(0)
      bankAccount.accountName = event.name
      println("BankAccount is created " + bankAccount.toString)
    }
  }

  implicit object DepositMoneyListener extends EventListener[DepositMoney] {
    override def onEvent(event: DepositMoney): Unit = {
      bankAccount.accountNumber = event.accountNumber
      bankAccount.balance +=  event.amount
      println("DepositMoney " + event.toString)
      println("BankAccount detail " + bankAccount.toString)
    }
  }

  implicit object WithDrawMoneyListener extends EventListener[WithDrawMoney] {
    override def onEvent(event: WithDrawMoney): Unit = {
      bankAccount.accountNumber = event.accountNumber
      bankAccount.balance -=  event.amount
      println("WithDrawMoney " + event.toString)
      println("BankAccount detail " + bankAccount.toString)
    }
  }

  def fireEvent[A: EventListener](event: A): Unit = {
    implicitly[EventListener[A]].onEvent(event)
  }

  def main(args: Array[String]): Unit = {
    // One event at a time
    fireEvent(BankAccountCreated(UUID.randomUUID(), "Kishoj Bajracharya", "0123456789"))
    fireEvent(DepositMoney("0123456789", BigDecimal.valueOf(1000.00)))
    fireEvent(WithDrawMoney("0123456789", BigDecimal.valueOf(200.00)))
  }
}
