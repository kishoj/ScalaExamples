package patterns.collections

import scala.annotation.tailrec

object Sum {

  def method1(list: List[Int]): Int = list match {
    case Nil => 0
    case x :: tail => x + method1(tail)
  }

  def method2(list: List[Int]): Int = {
    @tailrec
    def sum(list: List[Int], result: Int = 0): Int = list match {
      case Nil => result
      case x :: tail => sum(tail, result + x)
    }
    sum(list, 0)
  }

  def method3(list: List[Int]): Int = {
    if (list.isEmpty) 0 else list.head + method3(list.tail)
  }

  def method4(list: List[Int]): Int = {
    list.reduce((a, b) => a + b)
    //list.reduce(_ + _)
    //list.sum
  }

  def method5(list: List[Int]): Int = {
    list.reduceLeft(_ + _)
  }

  def main(args: Array[String]): Unit = {
    val numbers = List(0, 1, 2, 3, 4, 5, 6, 7, 8, 9)

    println("Sum using method1: " + Sum.method1(numbers))
    println("Sum using method2: " + Sum.method2(numbers))
    println("Sum using method3: " + Sum.method3(numbers))
    println("Sum using method4: " + Sum.method4(numbers))
    println("Sum using method5: " + Sum.method5(numbers))
  }

}