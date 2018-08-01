package patterns.functional.eventpattern.example.email.clients

import patterns.functional.eventpattern.example.email.utils.EmailUtils
import patterns.functional.eventpattern.example.email.events.{EmailReceivedEvent, Event}

trait EmailClient {

  def received(event: Event): Unit = event match {
    case emailReceived: EmailReceivedEvent => {
      println(EmailUtils.formatToEmail(emailReceived))
    }
    case _ => None
  }
}
