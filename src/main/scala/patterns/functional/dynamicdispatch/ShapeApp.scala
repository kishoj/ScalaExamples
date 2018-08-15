package patterns.functional.dynamicdispatch

// Used for extensible systems
case class Point(var x: Double, var y: Double)
abstract class Shape {
  def area: Double
}
case class Circle(center: Point, radius: Double) extends Shape {
  val PI = 3.1415
  override def area: Double = PI * radius * radius
}
case class Rectangle(ll: Point, ur: Point) extends Shape {
  override def area: Double = (ur.x - ll.x) * (ur.y - ll.y)
}

object ShapeApp {
  val PI = 3.1415

  def area(s: Shape): Double = s match {
    case Circle(_, r) => PI * r * r
    case Rectangle(ll, ur) => (ur.x - ll.x) * (ur.y - ll.y)
    //case Point(_, _) => 0
  }

  def main(args: Array[String]): Unit = {

  }
}
