Feature: operationName_v1_0
#
#  Background:
#    * url <string>
#    * header parameters = <string>
#
#  Scenario: No. 1 - GET method
#    Given path <string>
#    And   params <string> #{"key1":"value1","key2":"value2",...}
#    When  method GET
#    Then  status 200
#    And   match <string><param>
#
#  Scenario: No. 2 - POST method
#    Given path <string>
#    And   request <string> #{"key1":"value1","key2":"value2",...}
#    When  method POST
#    Then  status <number>
#    And   match <string><param>
#
#  Scenario: No. 3 - UPDATE method
#    Given path <string>
#    And   request <string> #{"key1":"value1","key2":"value2",...}
#    When  method UPDATE
#    Then  status <number>
#    And   match <string><param>
#
#  Scenario: No. 4 - DELETE method
#    Given path <string>
#    And   request <string> #{"key1":"value1","key2":"value2",...}
#    When  method DELETE
#    Then  status <number>
#    And   match <string><param>

  Background:
    * url 'https://jsonplaceholder.typicode.com'

  @scenario1
  Scenario: get all users
    Given path 'users'
    When method get
    Then status 200