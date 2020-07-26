#Language : En
#encoding: utf-8

@IntegrationTest
@DashboardTest
Feature: DashBoard


  @DashBoard
  Scenario Outline: TS:["<TS>"] - [DashBoard successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is logged "<HomePage>"
    When click module "<module>"
    And click on the tab "<tag0>" and the tab "<tag1>"
    And Click out
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                 | module     |tag0           |tag1   |Message   |HomePage                            |
      | 001 |    0002  | Dashboard Sucessfully       |Dashboard   |Shared with me |Q1 2019|Q1 2019   |https://app.trendalytics.co/signin  |
    # | 001 |    0002  | Log in successfully        |Dashboard   |My dashboard |My DSB|MY DSB    |
