package patterns.functional.eventpattern.example.email.clients

import patterns.functional.eventpattern.example.email.events.Event

class PhoneEmailClient extends EmailClient {

  override def received(event: Event): Unit = {
    println("Received email in Phone Client")
    super.received(event)
  }
}
