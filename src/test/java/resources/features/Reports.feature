#Language : En
#encoding: utf-8

@IntegrationTest
@ReportTest
Feature: Report


  @Report
  Scenario Outline: TS:["<TS>"] - [Report successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module "<module>"
    And click on "<tag0>"
    And click on "<tag1>"
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                | module   |tag0          |tag1                     |Message                              |
      | 001 |    0002  | Log in successfully        |reports   |My Comparison |Assort Comparition Report|LEVKOFF at Multiple Retail Sites     |
