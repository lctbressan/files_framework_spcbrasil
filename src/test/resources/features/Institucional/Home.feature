#Language : En
#encoding: utf-8

@IntegrationTest
@LoginTest
Feature: Home


  @Links
  Scenario Outline: TS:["<TS>"] - [Test Institutional links ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And accept cookies
    When click on menu "<Menu>" link
    Then I get the message Home "<Message>"
    Examples:
      | TS  | Scenario | Description                   |Menu               | Message                                    |HomePage|
      | 001 |    0001  |Test Link Product              |Product            | The closest thing to a crystal ball        |https://trendalytics.co/|
     # | 001 |    0001  |Test Link Thought Leadership   |THOUGHT LEADERSHIP | Medium                                     ||
      | 001 |    0001  | Test Press Link               |Press              | Press                                     |https://trendalytics.co/ |

  @About
  Scenario Outline: TS:["<TS>"] - [Test Institutional links ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    When click on menu "<Menu>" link
    And click on menu "<SubMenu>" link
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                   |Menu    |SubMenu           | Message                    |HomePage|
      | 001 |    0001  |Test Link Product              |ABOUT   |LEADERSHIP        |Your personal data scientist|https://trendalytics.co/|
      | 001 |    0001  |Test Link Product              |ABOUT   |LEADERSHIP        |The leadership team         |https://trendalytics.co/|
      | 001 |    0001  |Test Link Product              |ABOUT   |CAREERS           |Join the team               |https://trendalytics.co/|

