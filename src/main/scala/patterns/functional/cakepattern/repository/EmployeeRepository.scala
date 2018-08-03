package patterns.functional.cakepattern.repository

import java.util.UUID

import patterns.functional.cakepattern.Employee

trait EmployeeRepository extends Repository[Employee, UUID]{

  val employeeDbStore =  EmployeeData.employeeDbStore

  override def save(employee: Employee): UUID = {
    println("Saved Employee in EmployeeRepository: " + employee.toString)
    employee.id
  }

  override def findById(id: UUID): Option[Employee] = {
    employeeDbStore.get(id)
  }
}
