package patterns.functional.eventpattern.example.email.utils

import patterns.functional.eventpattern.example.email.domains.Email
import patterns.functional.eventpattern.example.email.events.EmailReceivedEvent

object EmailUtils {
  val TO: String = "kishoj@gmail.com"

  def formatToEmail(event: EmailReceivedEvent): Email = {
    Email(event.id, event.sender, TO, event.title, event.body)
  }
}
