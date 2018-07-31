package patterns.functional.eventpattern

trait Publisher {
  private var subscribers: Set[Subscriber] = Set()

  def subscribe(subscriber: Subscriber): Unit = {
    subscribers += subscriber
  }

  def unsubscribe(subscriber: Subscriber): Unit ={
    subscribers -= subscriber
  }

  def publishEvent(event: Event): Unit = {
    subscribers.foreach { _.notify(event) }
  }
}
