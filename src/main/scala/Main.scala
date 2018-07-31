object Main {

  sealed trait Calculation {
    def add(value: Int): Calculation =
      this match {
        case Success(v) => Success(v + value)
        case Failure(msg) => Failure(msg)
      }
  }
  final case class Success(value: Int) extends Calculation
  final case class Failure(msg: String) extends Calculation

  /*sealed trait Result[A] {
    def fold[B] (s: A => B, f: B) : B =
      this match {

      }
ve
  final case class Success[A] (value: A) extends Result[A]
  final case class Failure[A] () extends Result[A]*/

  def main(args: Array[String]): Unit = {
    println("Hello World")

  }
}