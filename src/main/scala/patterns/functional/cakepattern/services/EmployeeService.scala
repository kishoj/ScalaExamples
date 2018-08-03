package patterns.functional.cakepattern.services

import java.util.UUID

import patterns.functional.cakepattern.Employee
import patterns.functional.cakepattern.repository.Repository

trait EmployeeService {

  // Adding dependencies using cake pattern
  this: Repository[Employee, UUID] =>


  def addEmployee(employee: Employee): UUID = {
    save(employee)
  }

  def getEmployeeById(id: UUID): Option[Employee] = {
    findById(id)
  }

}