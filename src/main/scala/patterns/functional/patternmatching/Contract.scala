package patterns.functional.patternmatching

class Contract {
  private var id: String = ""
  private var status: String = ContractStatus.DRAFT
  private var contractNumber: String = ""
  private var user: String = ""
  private var activatedBy: String = ""
  private var closedBy: String = ""

  override def toString: String = {
    return "Contract[id='" + this.id + "' " +
                    "status='" + this.status +  "' " +
                    "contractNumber='" + this.contractNumber +  "' " +
                    "user='" + this.user +  "' " +
                    "activatedBy='" + this.activatedBy +  "' " +
                    "closedBy='" + this.closedBy +  "' " +
            "' ]"
  }

  def create(id: String, user: String) = {
    this.id = id
    this.user = user
  }

  def activate(id: String, contractNumber: String, activatedBy: String): Unit = {
    this.id = id
    status = ContractStatus.ACTIVATED
    this.contractNumber = contractNumber
    this.activatedBy = activatedBy
  }

  def close(id: String, closedBy: String): Unit = {
    status = ContractStatus.CLOSED
    this.closedBy = closedBy
  }
}
