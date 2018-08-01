package patterns.functional.eventpattern.example.email.subscriber

import patterns.functional.eventpattern.example.email.events.Event

trait Subscriber {
  def notify(event: Event)
}
