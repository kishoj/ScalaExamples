package patterns.functional.eventpattern

trait Subscriber {
  def notify(event: Event)
}
