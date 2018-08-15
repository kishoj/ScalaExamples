package patterns.functional.implicits.comparators

trait Comparator[A] {
  def compare(one: A, other: A): Int
}