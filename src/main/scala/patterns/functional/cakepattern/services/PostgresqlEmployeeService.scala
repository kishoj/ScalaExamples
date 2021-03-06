package patterns.functional.cakepattern.services

import patterns.functional.cakepattern.repository.PostgresqlRepository

object PostgresqlEmployeeService extends EmployeeService with PostgresqlRepository
