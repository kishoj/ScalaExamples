package patterns.functional.functors

object FunctorApp {

  trait Functor[F[_]] {
    def map[A, B](fa: F[A])(f: A => B): F[B]
  }

  def incrementBy1(list: List[Int])(implicit func: Functor[List]): List[Int] =
    func.map(list)(_ + 1)


  def main(args: Array[String]): Unit = {
    val expectedList = List(1, 2, 3)
    val outputList = Functor[List].map(expectedList)(x => x)
  }
}
