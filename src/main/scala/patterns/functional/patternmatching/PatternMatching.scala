package patterns.functional.patternmatching

import java.util.UUID

abstract class Event {
  val id: String
}

case class ContractCreated(id: String, user: String) extends Event
case class ContractActivated(id: String, activatedBy: String) extends Event
case class ContractClosed(id: String, closedBy: String) extends Event

object PatternMatching {
  var contract: Contract = new Contract

  def recordEventHistory(event: Event): Unit = {
    event match {
      case ContractCreated(_, _) => {
        println("Contract is created " + event.toString)
        contract.create(event.id, "Kishoj Bajracharya")
        println(contract.toString)
      }
      case ContractActivated(_, _) => {
        println("Contract is activated " + event.toString)
        contract.activate(event.id, "Kishoj Bajracharya","STAFF123")
        println(contract.toString)
      }
      case ContractClosed(_, _) => {
        println("Contract is Closed " + event.toString)
        contract.close(event.id, "STAFF456");
        println(contract.toString)
      }
      case _ => println("Unknown Event " + event.toString)
    }
  }

  def main(args: Array[String]): Unit = {
    val contractId = UUID.randomUUID().toString

    val contractCreatedEvent = ContractCreated(contractId, "Kishoj Bajracharya")
    val contractActivatedEvent = ContractActivated(contractId, "STAFF123")
    val contractClosedEvent = ContractClosed(contractId, "STAFF456")

    Seq(contractCreatedEvent, contractActivatedEvent, contractClosedEvent)
      .foreach(recordEventHistory)
  }
}
