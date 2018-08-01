package patterns.functional.eventpattern.example.email.subscriber

import patterns.functional.eventpattern.example.email.clients.EmailClient
import patterns.functional.eventpattern.example.email.events.Event

class EmailNotifier(handlers: Seq[EmailClient]) extends Subscriber {

  override def notify(event: Event): Unit = {
    handlers.foreach(_.received(event))
  }
}
