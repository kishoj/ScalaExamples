package patterns.functional.implicits

class IntOperator(val value: Int) {
  def square: Int = value * value
  def double: Int = 2 * value
}
