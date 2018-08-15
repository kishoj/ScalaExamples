package patterns.functional.implicits

import java.util.UUID

sealed trait UserRole

case class Anonymous() extends UserRole

case class Staff(userId: UUID, username: String) extends UserRole

case class Manager(userId: UUID, username: String) extends UserRole

sealed trait UIComponent

case class LoginComponent(message: String) extends UIComponent

case class StaffHomeComponent(userId: UUID, username: String) extends UIComponent

case class ManagerHomeComponent(userId: UUID, username: String) extends UIComponent

case class LogoutComponent(userId: UUID, username: String) extends UIComponent

trait Component[ROLE] {
  def getVisibleComponents(x: ROLE): List[UIComponent]
}

object ComponentVisibilityApp {

  implicit object AnonymousUserUIComponent extends Component[Anonymous] {
    override def getVisibleComponents(userRole: Anonymous): List[UIComponent] = {
      List(LoginComponent("Please login to the system!"))
    }
  }

  implicit object StaffUIComponent extends Component[Staff] {
    override def getVisibleComponents(userRole: Staff): List[UIComponent] = {
      List(StaffHomeComponent(userRole.userId, userRole.username), LogoutComponent(userRole.userId, userRole.username))
    }
  }

  implicit object ManagerUIComponent extends Component[Manager] {
    override def getVisibleComponents(userRole: Manager): List[UIComponent] = {
      List(ManagerHomeComponent(userRole.userId, userRole.username), LogoutComponent(userRole.userId, userRole.username))
    }
  }

  def uiComponentForTest[T](userRole: T)(implicit component: Component[T]): Unit = {
    component.getVisibleComponents(userRole).foreach(println)
  }

  def uiComponentVisibleFor[T: Component](userRole: T): Unit = {
    implicitly[Component[T]].getVisibleComponents(userRole).foreach(
      component => println(component.toString))
  }

  def main(args: Array[String]): Unit = {
    println("Implicit test")

    println("Anonymous user have visibility of following components:")
    uiComponentForTest(Anonymous())
    uiComponentVisibleFor(Anonymous())

    println("User with staff role have visibility of following components:")
    val staffId: UUID = UUID.randomUUID()
    uiComponentForTest(Staff(staffId, "Kishoj Bajracharya"))
    uiComponentVisibleFor(Staff(staffId, "Kishoj Bajracharya"))

    println("User with manager role have visibility of following components:")
    val managerId: UUID = UUID.randomUUID()
    uiComponentForTest(Manager(managerId, "Suraj Maharjan"))
    uiComponentVisibleFor(Manager(managerId, "Suraj Maharjan"))
  }
}
