package patterns.functional.observerpattern

trait Publisher {
  private var subscribers: Set[Subscriber] = Set()

  def subscribe(subscriber: Subscriber): Unit = {
    subscribers += subscriber
  }

  def unsubscribe(subscriber: Subscriber): Unit ={
    subscribers -= subscriber
  }

  def publish(): Unit = {
    subscribers.foreach { _.notify(this) }
  }
}
