package patterns.functional.eventpattern.example.email.clients

import patterns.functional.eventpattern.example.email.events.Event

class WebEmailClient extends EmailClient {

  override def received(event: Event): Unit = {
    println("Received email in Web Client")
    super.received(event)
  }
}
