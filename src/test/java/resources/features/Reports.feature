#Language : En
#encoding: utf-8

@IntegrationTest
@ReportTest
Feature: Report


  @login
  Scenario Outline: TS:["<TS>"] - [Report successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module "<module>"
    And click to create a report
    #And confirm action
    #Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                | module   |Message        |
      | 001 |    0002  | Log in successfully        |reports   |               |
