package patterns.functional.implicits

trait StringBuilder[A, String] {
  def build(value: A): String
}
