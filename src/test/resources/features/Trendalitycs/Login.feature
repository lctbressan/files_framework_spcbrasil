#Language : En
#encoding: utf-8
Feature: Login

  @IntegrationTest
  @loginAPP
  Scenario Outline: TS:["<TS>"] - [Log in successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    When send credencials
    And confirm action
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                         | Message                |HomePage|
      | 001 |    0001  | Log in successfully                 | Trend Discovery        |https://app.trendalytics.co/signin        |

  @loginTP3
  Scenario Outline: TS:["<TS>"] - [Log in successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    When send credencials
   # And confirm action
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                         | Message                |HomePage|
      | 001 |    0001  | Log in successfully                 | Trend Discovery        |https://tp3app.trendalytics.co/signin      |


  @loginFailAPP
  Scenario Outline: TS:["<TS>"] - [Log in successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    When send wrong credencials
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                         |  Message                                             |HomePage|
      | 001 |    0002  | Log in Unsuccessfully               |  Wrong Username/Email and password combination.      |https://app.trendalytics.co/signin         |


  @loginFailTP3
  Scenario Outline: TS:["<TS>"] - [Log in successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    When send wrong credencials
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                         |  Message                                             |HomePage|
      | 001 |    0002  | Log in Unsuccessfully               |  Wrong Username/Email and password combination.      |https://tp3app.trendalytics.co/signin         |