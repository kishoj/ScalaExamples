package patterns.functional.cakepattern

import java.util.UUID

import patterns.functional.cakepattern.repository.{CassandraRepository, EmployeeData, EmployeeRepository, PostgresqlRepository}
import patterns.functional.cakepattern.services.{CassandraEmployeeService, EmployeeService, PostgresqlEmployeeService}

object EmployeeApp {

  def main(args: Array[String]): Unit = {
    println ("Testing Cake Pattern in Scala")
    val employeeService = new EmployeeService with EmployeeRepository
    val employeeId1: UUID = employeeService.addEmployee(EmployeeData.employee1)
    println ("EmployeeId1 Received: " + employeeId1)

    val employeeServiceWithPostgres = new EmployeeService with PostgresqlRepository
    val employeeId2: UUID = employeeServiceWithPostgres.addEmployee(EmployeeData.employee2)
    println ("EmployeeId2 Received: " + employeeId2)

    val employeeServiceWithCassandra = new EmployeeService with CassandraRepository
    val employeeId3: UUID = employeeServiceWithCassandra.addEmployee(EmployeeData.employee3)
    println ("EmployeeId3 Received: " + employeeId3)

    // From objects
    val maybeEmployee4: Option[Employee] = PostgresqlEmployeeService.getEmployeeById(EmployeeData.employeeId4)
    if (!maybeEmployee4.isEmpty) {
      println("Employee(4): " + maybeEmployee4.get)
    }

    val maybeEmployee2: Option[Employee] = CassandraEmployeeService.getEmployeeById(EmployeeData.employeeId2)
    if (!maybeEmployee2.isEmpty) {
      println("Employee(2): " + maybeEmployee2.get)
    }
  }
}
