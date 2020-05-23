#Language : En
#encoding: utf-8

@IntegrationTest
@ReportTest
Feature: Report


  @ReportBasic
  Scenario Outline: TS:["<TS>"] - [Report successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module "<module>"
    And click on the tab "<tag0>" and the tab "<tag1>"
    And Click out
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                | module   |tag0          |tag1      |Message                    |
      | 001 |    0002  | Log in successfully        |Report    |My Comparison |2Modern   |SEO Opportunity Report     |




  @CreateRequestEmailAlertSucessPDF
  Scenario Outline: TS:["<TS>"] - [Create request for download pdf successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module "<module>"
    And click on the tab "<tag0>" and the tab "<tag1>"
    And Click out
    And download a PDF Report
    And Click out
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                | module   |tag0          |tag1      |Message                    |
      | 001 |    0002  | Create Requester PDF       |Report    |My Comparison |2Modern   |SEO Opportunity Report     |


  @CheckEmailAlertPDF
  Scenario Outline: TS:["<TS>"] - [Check email alert status  ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module "<module>"
    And Click verify on subscription event
    And verify the email alert "<requester>"
    Then I get the status "<Status>"
    Examples:
      | TS  | Scenario | Description                | module  |requester    |Status        |
      | 001 |    0002  | Log in successfully        |Admin    |luis.bressan |Completed     |


    @CreateNewReport
    Scenario Outline: TS:["<TS>"] - [Create ASSORTMENT COMPARISION Report  ]  - "<Scenario>" - "<Description>"
      Given that the user is logged
      When click module "<module>"
      And click Create a Report
      And create a Report Type "<Report>"
      And click Type "<Type>"
      And click Brand "<Brand>"
      And click Retail "<Retail>"
    And click Category "<Category>"
    Examples:
        | TS  | Scenario | Description           | module    |Report                |Type      |Brand    |Retail       |Category|
        | 001 |    0002  | Log in successfully   |Report     |ASSORTMENT COMPARISON |ONE BRAND |LEVKOFF  |Nordstron    |Women   |
        #| 001 |    0002  | Log in successfully   |Report     |TREND COMPARISON      |ONE BRAND |LEVKOFF  |Nordstron    |Women   |
        #| 001 |    0002  | Log in successfully   |Report     |SEO OPPORTUNITIES     |ONE BRAND |LEVKOFF  |Nordstron    |Women   |
        #| 001 |    0002  | Log in successfully   |Report     |ATTRIBUTE COMPARISON  |ONE BRAND |LEVKOFF  |Nordstron    |Women   |
