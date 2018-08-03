package patterns.functional.enums

trait OrderSystem {
  val EMPTY: String = ""

  var status: OrderStatus = CREATED
  var intResult: Int = 0;

  private def changeStatus(status: OrderStatus): Unit = {
    this.status = status
    println("Order status is " + status)
  }

  def placeOrder(): Int = {
    if (actionOn(CREATED)) 2 else 0
  }

  def confirmOrder(): Int = {
    if (actionOn(CONFIRMED)) 3 else 0
  }

  def processOrder(): Int = {
    if (actionOn(PROCESSED)) 4 else 0
  }

  def completeOrder(): Int = {
    if (actionOn(COMPLETED)) 0 else 0
  }

  def cancelOrder(): Int = {
    if (actionOn(CANCELLED)) 6 else 0
  }

  def actionOn(status: OrderStatus): Boolean = status match {
    case CREATED => if (!CREATED.equals(this.status)) false else {
      changeStatus(status); true }
    case CONFIRMED => if (!CREATED.equals(this.status)) false else {
      changeStatus(status); true }
    case PROCESSED => if (!CONFIRMED.equals(this.status)) false else {
      changeStatus(status); true }
    case COMPLETED => if (!PROCESSED.equals(this.status)) false else {
      changeStatus(status); true }
    case CANCELLED => if (!Vector(CREATED, CONFIRMED, PROCESSED).contains(this.status)) false else {
      changeStatus(status); true }
  }
}
