package patterns.functional.eventpattern

object EventPatternApp extends App {
  // register EventHandlers
  val e1 = new EventHandler("UpdateEventStoreHandler")
  val e2 = new EventHandler("UpdateReadModelHandler")
  val e3 = new EventHandler("UpdateEventHandler1")
  val e4 = new EventHandler("UpdateEventHandler2")

  // Event Notifier to fire event to Registered EventHandlers
  val channel = new Channel(Seq(e1, e2))
  val channel2 = new Channel(Seq(e3, e4))

  // Register Publisher
  val publisher = new EventPublisher
  // publisher subscribe to the publishing channel
  publisher.subscribe(channel)
  publisher.subscribe(channel2)
  // publisher fire Event to publish on the channel

  publisher.publishEvent(Event("123456", "Event Publishing Test", "KISHOJ BAJRACHARYA"))
}
