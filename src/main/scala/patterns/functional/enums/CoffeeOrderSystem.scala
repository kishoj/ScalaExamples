package patterns.functional.enums

object CoffeeOrderSystem extends WorkFlowSteps with OrderSystem with App {

  println("Processing Coffee Order using Recursive way ...")
  lazy val placeOrderMessage = placeOrder()
  lazy val confirmOrderMessage = confirmOrder()
  lazy val processOrderMessage = processOrder()
  lazy val completeOrderMessage = completeOrder()
  lazy val cancelOrderMessage = cancelOrder()

  // Using recursive way
  recursiveSteps(1,
    () => placeOrderMessage,
    () => confirmOrderMessage,
    () => processOrderMessage,
    () => completeOrderMessage,
    () => cancelOrderMessage)

  // Rolling back the status
  this.status = CREATED

  println("Processing Coffee Order using normal way ...")
  lazy val placeOrderMessage2 = placeOrder()
  lazy val confirmOrderMessage2 = confirmOrder()
  lazy val processOrderMessage2 = processOrder()
  lazy val completeOrderMessage2 = completeOrder()
  lazy val cancelOrderMessage2 = cancelOrder()

  def processStep(step: Int) = {
    steps(step,
      () => placeOrderMessage2,
      () => confirmOrderMessage2,
      () => processOrderMessage2,
      () => completeOrderMessage2,
      () => cancelOrderMessage2)
  }

  Seq(1, 2, 3, 4).foreach(step => {
    processStep(step)
    Thread.sleep(1500)
  })
}
