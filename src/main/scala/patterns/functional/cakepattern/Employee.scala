package patterns.functional.cakepattern

import java.time.LocalDate
import java.util.UUID

case class Employee(var id: UUID, var firstName: String, var lastName: String, var employeeId: String, var joiningDate: LocalDate)