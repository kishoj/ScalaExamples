package patterns.functional.eventpattern.example

import patterns.functional.eventpattern.example.email.clients.{PhoneEmailClient, WebEmailClient}
import patterns.functional.eventpattern.example.email.events.EmailReceivedEvent
import patterns.functional.eventpattern.example.email.publisher.EmailPublisher
import patterns.functional.eventpattern.example.email.subscriber.EmailNotifier

object MainApp extends App {
  val client1: WebEmailClient = new WebEmailClient
  val client2: PhoneEmailClient = new PhoneEmailClient

  val emailClients = Seq(client1, client2)
  val mailChannel = new EmailNotifier(emailClients)

  // Register Publisher
  val publisher = new EmailPublisher
  // publisher subscribe to the publishing channel
  publisher.subscribe(mailChannel)
  // publisher fire Event to publish on the channel
  publisher.publishEvent(EmailReceivedEvent("123456", "kishoj@gmail.com", "Event Publishing Test", "KISHOJ BAJRACHARYA"))

  publisher.unsubscribe(mailChannel)
  publisher.publishEvent(EmailReceivedEvent("123456", "kishoj@gmail.com", "Event Publishing Test", "KISHOJ BAJRACHARYA"))
}
