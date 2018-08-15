package patterns.functional.implicits.comparators

trait Comparable [A <: Comparable[A]] {
  this: A => def compareTo(that: A)(implicit comparator: Comparator[A]): Int = comparator.compare(this, that)
}
