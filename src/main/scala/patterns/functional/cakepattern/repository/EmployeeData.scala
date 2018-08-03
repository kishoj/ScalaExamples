package patterns.functional.cakepattern.repository

import java.time.LocalDate
import java.util.UUID

import patterns.functional.cakepattern.Employee

object EmployeeData {
  val employeeId1 = UUID.fromString("7d5464be-96d0-11e8-9eb6-529269fb1459")
  val employee1 = Employee(employeeId1, "Ram", "Kasula", "536", LocalDate.of(2006, 5, 10))

  val employeeId2 = UUID.fromString("7d546734-96d0-11e8-9eb6-529269fb1459")
  val employee2 = Employee(employeeId2, "Prasanna", "Bajracharya", "524", LocalDate.of(2006, 5, 10))

  val employeeId3 = UUID.fromString("7d54687e-96d0-11e8-9eb6-529269fb1459")
  val employee3 = Employee(employeeId3, "Kishoj", "Bajracharya", "515", LocalDate.of(2006, 5, 10))

  val employeeId4 = UUID.fromString("01a3f434-96d4-11e8-9eb6-529269fb1459")
  val employee4 = Employee(employeeId4, "Suraj", "Maharjan", "539", LocalDate.of(2006, 5, 10))

  val employeeDbStore =  Map[UUID, Employee](
    EmployeeData.employeeId1 -> EmployeeData.employee1,
    EmployeeData.employeeId2 -> EmployeeData.employee2,
    EmployeeData.employeeId3 -> EmployeeData.employee3,
    EmployeeData.employeeId4 -> EmployeeData.employee4
  )
}