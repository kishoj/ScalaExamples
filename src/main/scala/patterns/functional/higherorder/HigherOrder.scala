package patterns.functional.higherorder

import java.time.LocalDateTime
import java.time.temporal.ChronoUnit

class PrePostFixDecorator(prefix: String, postfix: String) {
  def apply[E](x: E): String = prefix + x.toString() + postfix
}

object AppendPrePostFixDecorator {
  def apply[E](prefix: String, x: E, postfix: String) = {
    prefix + x.toString() + postfix
  }
}

object TimeDecorator {
  def apply[E](f: () => E): Unit = {
    val start = LocalDateTime.now
    Thread.sleep(1500)
    f();
    val end = LocalDateTime.now
    println("Execution Time (in milli-seconds) " + ChronoUnit.MILLIS.between(start, end))}
}

class Decorator[E](f: () => E) {
  def apply(): Unit = {
    val start = LocalDateTime.now
    Thread.sleep(1500)
    f()
    val end = LocalDateTime.now
    println("Execution Time (in milli-seconds) " + ChronoUnit.MILLIS.between(start, end))
  }
}

object square extends (Int => Int) {
  def apply(x: Int): Int = { x * x }
}

object Switch {
  def apply[E](option: Int, first: () => E, second: () => E, third: () => E) = option match {
    case 1 => first()
    case 2 => second()
    case 3 => third()
  }
}

object HigherOrder {

  def switch[E](option: Int, first: () => E, second: () => E, third: () => E) = option match {
    case 1 => first()
    case 2 => second()
    case 3 => third()
  }

  def apply(f: Int => String, v: Int) =  {
    f(v)
  }

  def printTest: Unit= {
    println("Hello Test")
  }

  def main(args: Array[String]): Unit = {
    val function1 = () => println("First Statement is executed!...")
    val function2 = () => println("Second Statement is executed!...")
    val function3 = () => println("Third Statement is executed!...")

    switch(1, function1, function2, function3)
    switch(2, function1, function2, function3)
    switch(3, function1, function2, function3)

    Switch(1, function1, function2, function3)
    Switch(2, function1, function2, function3)
    Switch(3, function1, function2, function3)

    println(square(2))

    // To get the execution time of any method
    new Decorator(() => printTest).apply
    TimeDecorator(() => printTest) //  TimeDecorator.apply(() => printTest)

    println(AppendPrePostFixDecorator.apply("[", "Kishoj Bajracharya", "]"))

    println(new PrePostFixDecorator("[", "]")("Kishoj Bajracharya"))
  }
}
