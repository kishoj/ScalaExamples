package patterns.functional.observerpattern

trait Subscriber {
  def notify(publisher: Publisher)
}
