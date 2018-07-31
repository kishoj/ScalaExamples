package patterns.functional.eventpattern

class EventHandler(name: String) {

  def on(event: Event): Unit = {
    println("Inside EventHandler: " + name)
    println("Event handler handles the event: " + event.toString)
  }
}
