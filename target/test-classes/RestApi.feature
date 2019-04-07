Feature: Employees Details API Testing

  Scenario: POST Request - Add new Employee Details Dynamically from feature file
    Given POST request with valid input
      | name   | Jyotsnamote |
      | salary |     4587942 |
      | age    |          35 |
    And the system requests POST "http://dummy.restapiexample.com/api/v1/create"
    Then the status code is 200
    And response Of POST request includes the following and ID generated is notnull and numeric value
      | name        | salary  | age |
      | Jyotsnamote | 4587942 |  35 |

  Scenario: GET Request - Get the employee details of added employee in Scenario 2
    Given the system requests GET "http://dummy.restapiexample.com/api/v1/employee"
    Then the status code is 200
    And response includes the following
      | employee_name | employee_salary | employee_age | profile_image |
      | Jyotsnamote   |         4587942 |           35 |               |

  Scenario: PUT Request - Update salary of added employee in Scenario 2
    Given Update salary of the employee to following
      | salary | 998887 |
    And the system requests PUT "http://dummy.restapiexample.com/api/v1/update"
    Then the status code is 200

  Scenario: DELETE Request - DELETE  added employee in Scenario 2
    Given the system requests DELETE "http://dummy.restapiexample.com/api/v1/delete"
    Then the status code is 200
    And response Of DELETE request includes the following
      | text | successfully! deleted Records |

  Scenario: Validate the response
    Given the system requests GET "http://dummy.restapiexample.com/api/v1/employee" for validation of schema
    Then the status code is 200
    And validating response
      | employee_name | employee_salary | employee_age |
