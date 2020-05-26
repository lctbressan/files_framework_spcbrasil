#Language : En
#encoding: utf-8

@IntegrationTest
@ReportTest
Feature: Report


    @CreateNewReportOneBrand
    Scenario Outline: TS:["<TS>"] - [Create Assortment Comparison Report  ]  - "<Scenario>" - "<Description>"
      Given that the user is logged
      When click module Report
      And click Create a Report
      And create a Report Type "<Report>"
      And click Type "<Type>"
      And click Brand "<Brand>"
      And click Retail "<Retail>"
      And click Category "<Category>"
      And type Name "<Name>"
      Then click submit
    Examples:
        | TS  | Scenario | Description                   |Report                |Type                                     |Brand    |Retail       |Category|Name                           |
        | 001 |    0001  | Create report successfully    |ASSORTMENT COMPARISON |ONE BRAND ACROSS MULTIPLE RETAIL SITES   |LEVKOFF  |Nordstrom    |Women   | Assort Comparison Automation  |


  @CreateNewReportMultipoleRetail
  Scenario Outline: TS:["<TS>"] - [Create Multiple Retail Report  ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module Report
    And click Create a Report
    And create a Report Type "<Report>"
    And click Type "<Type>"
    And click Retail "<Retail>"
    And click Category "<Category>"
    And type Name "<Name>"
    Then click submit
    Examples:
      | TS  | Scenario | Description                    |Report                |Type                                     |Retail       |Category|Name                               |
      | 001 |    00012  | Create report successfully    |ASSORTMENT COMPARISON |MULTIPLE RETAIL SITES                    |CARBON38     |Women   |Multiple Retail Report Automation  |


  @CreateNewReportMultipleBrands
  Scenario Outline: TS:["<TS>"] - [Create Multiple Brands Report  ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module Report
    And click Create a Report
    And create a Report Type "<Report>"
    And click Type "<Type>"
    And click Retail "<Retail>"
    And click Brand "<Brand>"
    And click Category "<Category>"
    And type Name "<Name>"
    Then click submit
    Examples:
      | TS  | Scenario | Description                    |Report                |Type                                     |Retail       |Brand           |Category  |Name                               |
      | 001 |    00012  | Create report successfully    |ASSORTMENT COMPARISON |MULTIPLE BRANDS ACROSS ONE RETAIL SITE   |CARBON38     |CARBON38        |Women      |Multiple Brand Report Automation  |

  @CreateNewReportTrendSide
  Scenario Outline: TS:["<TS>"] - [Create Trend Report Side By Side  ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module Report
    And click Create a Report
    And create a Report Type "<Report>"
    And click Type "<Type>"
    And Select Trends
    And type Name "<Name>"
    Then click submit
    Examples:
      | TS  | Scenario | Description                    |Report           |Type                            |Name                                  |
      | 001 |    00012  | Create report successfully    |TREND COMPARISON |SIDE BY SIDE TREND COMPARISON   |Trend Report Side By Side Automation  |


  @CheckReportCreation
  Scenario Outline: TS:["<TS>"] - [Checj Report created successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module Report
    And click on the tab "<tab0>"
    And Fill name of report "<Name>"
    And Click out
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                | tab0          |Name                                 |Message                                                        |
      | 001 |    0001 | Check One Brand Report      |My Comparison  |Assort Comparison Automation         |LEVKOFF at Multiple Retail Sites                               |
      | 001 |    0002  | Multiple Retail Report     |My Comparison  |Multiple Retail Report Automation    |Assortment Comparison Report - Multiple Retail Sites           |
      | 001 |    0003  | Multiple Retail Report     |My Comparison  |Multiple Brand Report Automation     |Assortment Comparison Report - Multiple Brands at Carbon38     |
      | 001 |    0004  | Multiple Retail Report     |My Comparison  |Trend Report Side By Side Automation |Trend Comparison Report - Side by Side Trend Comparison        |


  @CreateEmailAlertPDF
  Scenario Outline: TS:["<TS>"] - [Create request for download pdf successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module Report
    And click on the tab "<tab0>"
    And Fill name of report "<Name>"
    And Click out
    And download a PDF Report
    And Click out
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                |tab0          |Name                                  |Message                              |
      | 001 |    0001  | Create Requester PDF       |My Comparison |Assort Comparison Automation          |LEVKOFF at Multiple Retail Sites     |
      | 001 |    0002  | Multiple Retail Report     |My Comparison  |Multiple Retail Report Automation    |Assortment Comparison Report - Multiple Retail Sites           |
      | 001 |    0003  | Multiple Retail Report     |My Comparison  |Multiple Brand Report Automation     |Assortment Comparison Report - Multiple Brands at Carbon38     |
      | 001 |    0004  | Multiple Retail Report     |My Comparison  |Trend Report Side By Side Automation |Trend Comparison Report - Side by Side Trend Comparison        |



  @CheckEmailAlert
  Scenario Outline: TS:["<TS>"] - [Check Email Alert satus  ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module Admin
    And Click on email alerts
    And search for user email "<email>"
    Then I get the status "<Status>"
    Examples:
      | TS  | Scenario | Description                  |email        |Status        |
      | 001 |    0001  | Email Alert completed        |luis.bressan |Completed     |


  @CheckSubscription
  Scenario Outline: TS:["<TS>"] - [Check Subscription status  ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module Admin
    And Click verify on subscription event
    And verify the email alert "<requester>"
    Then I get the status "<Status>"
    Examples:
      | TS  | Scenario | Description                | requester    |Status        |
      | 001 |    0002  | Log in successfully        |luis.bressan |Completed     |
