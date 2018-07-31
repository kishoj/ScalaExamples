package patterns.functional.eventpattern

class Channel(handlers: Seq[EventHandler]) extends Subscriber {

  override def notify(event: Event): Unit = {
    handlers.foreach(_.on(event))
  }
}
