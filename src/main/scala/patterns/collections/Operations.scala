package patterns.collections

object Operations {

  // Count the number of each alphabet from my name
  val my_name = "KISHOJ BAJRACHARYA"
                    .toList
                    .filter(_.isLetter)
                    .groupBy(x => x)
                    .map(x => x._1 -> x._2.size)

  // Tuple example
  val internal_hotel_ids = List("Grand Swiss Hotel", "Asia Hotel", "Novotel Hotel")
  val partners_hotel_ids = List(12345, 67890, 11111)

  val mapper = (internal_hotel_ids, partners_hotel_ids)
                      .zipped map ((internal, partners) => (internal, partners))
  val zipped = internal_hotel_ids zip partners_hotel_ids

  def main(args: Array[String]): Unit = {
    println(my_name)
    println(mapper)
    println(zipped)
    println(zipped.toMap)
  }

}
