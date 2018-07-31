package patterns.functional.observerpattern

object ObserversApp extends App {
  val kasikornBank = new BankAccount
  val scbBank = new BankAccount
  val bangkokBank = new BankAccount

  val bankLists = List(kasikornBank, scbBank, bangkokBank)

  val allBanks = new Consolidator(bankLists)
  println("Total Balance in all banks: " + allBanks.totalBalance)
  kasikornBank deposit 10000
  println("Total Balance in all banks: " + allBanks.totalBalance)
  scbBank deposit 25000
  println("Total Balance in all banks: " + allBanks.totalBalance)
  bangkokBank deposit 50000
  println("Total Balance in all banks: " + allBanks.totalBalance)

  bankLists.foreach(bank => {
   println("Bank Account " + bank.currentBalance)
  })

}
