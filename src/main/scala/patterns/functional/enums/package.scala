package patterns.functional

package object enums {
  sealed trait OrderStatus
  case object CREATED extends OrderStatus
  case object CONFIRMED extends OrderStatus
  case object PROCESSED extends OrderStatus
  case object COMPLETED extends OrderStatus
  case object CANCELLED extends OrderStatus
}
