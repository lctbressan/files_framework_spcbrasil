#Language : En
#encoding: utf-8

@IntegrationTest
@LoginTest
Feature: Login


  @login
  Scenario Outline: TS:["<TS>"] - [Log in successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen
    When send credencials
    #And confirm action
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                         | Message                |
      | 001 |    0001  | Log in successfully                 | Trend Discovery        |



  @loginFail
  Scenario Outline: TS:["<TS>"] - [Log in successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen
    When send wrong credencials
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                         |  Message                                             |
      | 001 |    0002  | Log in Unsuccessfully               |  Wrong Username/Email and password combination.      |


