package patterns.functional.implicits.comparators

class Age(val age: Int) extends Comparable[Age]
object Age {
  def apply(age: Int): Age = new Age(age)

  implicit val naturalAgeComparator: Comparator[Age] = new Comparator[Age] {
    def compare(t1: Age, t2: Age): Int = t1.age - t2.age
  }
}
object ComparisonApp extends App {
  import Age._
  val ageComparison1:Int = Age(1) compareTo Age(2)
  val ageComparison2:Int = Age(1) compareTo Age(1)
  println(ageComparison1)
  println(ageComparison2)
}
