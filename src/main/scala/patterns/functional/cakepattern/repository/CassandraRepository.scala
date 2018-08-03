package patterns.functional.cakepattern.repository

import java.util.UUID

import patterns.functional.cakepattern.Employee

trait CassandraRepository extends Repository[Employee, UUID]{

  val cassandraDbStore =  EmployeeData.employeeDbStore

  override def save(employee: Employee): UUID = {
    println("Saved Employee in CassandraRepository: " + employee.toString)
    employee.id
  }

  override def findById(id: UUID): Option[Employee] = {
    cassandraDbStore.get(id)
  }
}
