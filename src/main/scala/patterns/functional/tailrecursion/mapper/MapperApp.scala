package patterns.functional.tailrecursion.mapper

import java.util.UUID

import scala.annotation.tailrec

object MapperApp {

  def mapHotelIds(hotelIds: Seq[UUID], partnerHotelIds: Seq[String]): Seq[HotelIdMapper] = {
    @tailrec
    def helper(hotelIds: Seq[UUID], partnerHotelIds: Seq[String], mappers: Vector[HotelIdMapper]): Seq[HotelIdMapper] = {
      if (hotelIds.isEmpty) mappers
      else helper(hotelIds.tail, partnerHotelIds.tail, mappers :+ HotelIdMapper(hotelIds.head, partnerHotelIds.head))
    }
    helper(hotelIds, partnerHotelIds, Vector[HotelIdMapper]())
  }

  def main(args: Array[String]): Unit = {
    val systemHotelIds = Seq(UUID.randomUUID(), UUID.randomUUID())
    val partnerHotelIds = Seq("111111", "222222")

    mapHotelIds(systemHotelIds, partnerHotelIds).foreach(println)
  }
}
