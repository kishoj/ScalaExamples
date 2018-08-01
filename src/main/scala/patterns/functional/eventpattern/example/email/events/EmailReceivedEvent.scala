package patterns.functional.eventpattern.example.email.events

case class EmailReceivedEvent (id: String, sender: String, title: String, body:String) extends Event