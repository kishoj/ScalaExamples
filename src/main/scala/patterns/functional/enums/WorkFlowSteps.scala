package patterns.functional.enums

class WorkFlowSteps {

  def steps[E](option: Int, placeOrderStep: () => E, confirmOrderStep: () => E, processOrderStep: () => E, completeOrderStep: () => E, cancelOrderStep: () => E) = option match {
    case 1 => placeOrderStep()
    case 2 => confirmOrderStep()
    case 3 => processOrderStep()
    case 4 => completeOrderStep()
    case 5 => cancelOrderStep()
  }

  def recursiveSteps[E](option: Int, placeOrderStep: () => E, confirmOrderStep: () => E, processOrderStep: () => E, completeOrderStep: () => E, cancelOrderStep: () => E): Unit = option match {
    case 1 => if (placeOrderStep() == 2) {
      Thread.sleep(1500)
      recursiveSteps(2, placeOrderStep, confirmOrderStep, processOrderStep, completeOrderStep, cancelOrderStep)
    } else None
    case 2 => if (confirmOrderStep() == 3) {
      Thread.sleep(1500)
      recursiveSteps (3, placeOrderStep, confirmOrderStep, processOrderStep, completeOrderStep, cancelOrderStep)
    } else None
    case 3 => if (processOrderStep() == 4) {
      Thread.sleep(1500)
      recursiveSteps (4, placeOrderStep, confirmOrderStep, processOrderStep, completeOrderStep, cancelOrderStep)
    } else None
    case 4 => if (completeOrderStep() == 5) {
      Thread.sleep(1500)
      recursiveSteps (5, placeOrderStep, confirmOrderStep, processOrderStep, completeOrderStep, cancelOrderStep)
    } else None
    case 5 => if (cancelOrderStep() == 6) {
      Thread.sleep(1500)
    } else None
    case 0 => None
  }
}
