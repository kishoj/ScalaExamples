package patterns.functional.cakepattern.repository

import java.util.UUID

import patterns.functional.cakepattern.Employee

trait PostgresqlRepository extends Repository[Employee, UUID]{

  val postgresqlDbStore =  EmployeeData.employeeDbStore

  override def save(employee: Employee): UUID = {
    println("Saved Employee in PostgresqlRepository: " + employee.toString)
    employee.id
  }

  override def findById(id: UUID): Option[Employee] = {
    postgresqlDbStore.get(id)
  }
}
