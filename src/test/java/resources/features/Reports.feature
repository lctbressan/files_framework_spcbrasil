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




  @ReportDownloadPdf
  Scenario Outline: TS:["<TS>"] - [Report download pdf successfully / fail ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module "<module>"
    And click on the tab "<tag0>" and the tab "<tag1>"
    And Click out
    And download a PDF Report
    And Click confirm
    #And get the status "<Status"
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                | module   |tag0          |tag1      |Message                    |Status         |
      | 001 |    0002  | Log in successfully        |Report    |My Comparison |2Modern   |SEO Opportunity Report     |Confirmed      |
      #| 001 |    0002  | Log in successfully        |Report    |My Comparison |2Modern   |SEO Opportunity Report     |Fail           |



