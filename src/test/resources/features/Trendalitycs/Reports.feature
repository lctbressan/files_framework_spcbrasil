#Language : En
#encoding: utf-8

@RegressionTest
@ReportTest
Feature: Report

  #=====================================================================================================================
  # CREATE NEW REPORT AND EXPORT EXCEL
  #=====================================================================================================================

    @CreateNewReportOneBrand
    Scenario Outline: TS:["<TS>"] - [Create Assortment Comparison Report  ]  - "<Scenario>" - "<Description>"
      Given that the user is on the home screen "<HomePage>"
      And send credencials
      And confirm action "<yes>"
      When click module Report
      And click Create a Report
      And create a Report Type "<Report>"
      And click Type "<Type>"
      And click Brand
      And click Retail
      And click Category
      And type Name "<Name>"
      Then click submit
    Examples:
        | TS  | Scenario | Description                   |Report                |Type                                     |Name                           |HomePage                             |
        | 001 |    0001  | Create report successfully    |ASSORTMENT COMPARISON |ONE BRAND ACROSS MULTIPLE RETAIL SITES   | Assort Comparison Automation  |https://tp3app.trendalytics.co/signin|


  @CreateNewReportMultipoleRetail
  Scenario Outline: TS:["<TS>"] - [Create Multiple Retail Report  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    And confirm action "<yes>"
    When click module Report
    And click Create a Report
    And create a Report Type "<Report>"
    And click Type "<Type>"
    And click Retail
    And click Category
    And type Name "<Name>"
    Then click submit
    Examples:
      | TS  | Scenario | Description                    |Report                |Type                   |Name                               |HomePage|
      | 001 |    00012  | Create report successfully    |ASSORTMENT COMPARISON |MULTIPLE RETAIL SITES  |Multiple Retail Report Automation  |https://tp3app.trendalytics.co/signin|


  @CreateNewReportMultipleBrands
  Scenario Outline: TS:["<TS>"] - [Create Multiple Brands Report  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    And confirm action "<yes>"
    When click module Report
    And click Create a Report
    And create a Report Type "<Report>"
    And click Type "<Type>"
    And click Retail
    And click Brand
    And click Category
    And type Name "<Name>"
    Then click submit
    Examples:
      | TS  | Scenario | Description                    |Report                |Type                                     |Name                               |HomePage|
      | 001 |    00012  | Create report successfully    |ASSORTMENT COMPARISON |MULTIPLE BRANDS ACROSS ONE RETAIL SITE   |Multiple Brand Report Automation   |https://tp3app.trendalytics.co/signin|

  @CreateNewReportTrendSide
  Scenario Outline: TS:["<TS>"] - [Create Trend Report Side By Side  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    And confirm action "<yes>"
    When click module Report
    And click Create a Report
    And create a Report Type "<Report>"
    And click Type "<Type>"
    And Select Trends
    And type Name "<Name>"
    Then click submit
    Examples:
      | TS  | Scenario | Description                    |Report           |Type                            |Name                                  |HomePage|
      | 001 |    00012  | Create report successfully    |TREND COMPARISON |SIDE BY SIDE TREND COMPARISON   |Trend Report Side By Side Automation  |https://tp3app.trendalytics.co/signin|



  #=====================================================================================================================
  #CREATE EMAIL ALERT
  #=====================================================================================================================

  @CheckReportCreation
  Scenario Outline: TS:["<TS>"] - [Check Report previously created And Download Excel  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    And confirm action "<yes>"
    When click module Report
    And click on the option "<option>"
    And Fill name of report "<Name>"
    And Click out
    Then Check created Report
    And Click out
    And Download Excel Current "<Name>"
        Examples:
      | TS  | Scenario | Description                                  | option        |Name                                 |HomePage|
      | 001 |    0001  | Check One Brand Report and download Excel    |My Comparison  |Assort Comparison Automation         |https://tp3app.trendalytics.co/signin|
      | 001 |    0002  | Multiple Retail Report and download Excel    |My Comparison  |Multiple Retail Report Automation    |https://tp3app.trendalytics.co/signin|
      | 001 |    0003  | Multiple Brand Report and download Excel     |My Comparison  |Multiple Brand Report Automation     |https://tp3app.trendalytics.co/signin|
      | 001 |    0004  | Trend Report Side By Side and download Excel |My Comparison  |Trend Report Side By Side Automation |https://tp3app.trendalytics.co/signin|

  @DownloadExcelCurrent
  Scenario Outline: TS:["<TS>"] - [Download Excel History]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    And confirm action "<confirm>"
    When click module Report
    And Click out
    And Download Excel History "<Name>"
    #And click Save
    Examples:
      | TS  | Scenario | Description                                  | option        |Name                                 |HomePage                             |confirm|
      | 001 |    0001  | Check One Brand Report and download Excel    |My Comparison  |Assort Comparison Automation         |https://tp3app.trendalytics.co/signin| yes   |
      | 001 |    0002  | Multiple Retail Report and download Excel    |My Comparison  |Multiple Retail Report Automation    |https://tp3app.trendalytics.co/signin| yes   |
      | 001 |    0003  | Multiple Brand Report and download Excel     |My Comparison  |Multiple Brand Report Automation     |https://tp3app.trendalytics.co/signin| yes   |
      | 001 |    0004  | Trend Report Side By Side and download Excel |My Comparison  |Trend Report Side By Side Automation |https://tp3app.trendalytics.co/signin| yes   |

  @CreateEmailAlert
  Scenario Outline: TS:["<TS>"] - [Create email alert successfully ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    And confirm action "<yes>"
    When click module Report
    And click on the tab "<tab0>"
    And Fill name of report "<Name>"
    And Click out
    And download a PDF Report
    And Click out
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                |tab0          |Name                                  |Message                                                        |HomePage|
      | 001 |    0001  | Create Requester PDF       |My Comparison |Assort Comparison Automation          |LEVKOFF at Multiple Retail Sites                               |https://tp3app.trendalytics.co/signin|
      | 001 |    0002  | Multiple Retail Report     |My Comparison  |Multiple Retail Report Automation    |Assortment Comparison Report - Multiple Retail Sites           |https://tp3app.trendalytics.co/signin|
      | 001 |    0003  | Multiple Retail Report     |My Comparison  |Multiple Brand Report Automation     |Assortment Comparison Report - Multiple Brands at Carbon38     |https://tp3app.trendalytics.co/signin|
      | 001 |    0004  | Multiple Retail Report     |My Comparison  |Trend Report Side By Side Automation |Trend Comparison Report - Side by Side Trend Comparison        |https://tp3app.trendalytics.co/signin|



  @CheckEmailAlert
  Scenario Outline: TS:["<TS>"] - [Check Email Alert satus  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    And confirm action "<yes>"
    When click module Admin
    And Click on email alerts
    And search for user email "<email>"
    Then I get the status "<Status>"
    Examples:
      | TS  | Scenario | Description                  |email        |Status        |HomePage|
      | 001 |    0001  | Email Alert completed        |luis.bressan |Completed     |https://tp3app.trendalytics.co/signin|


  @CheckSubscription
  Scenario Outline: TS:["<TS>"] - [Check Subscription status  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    And confirm action "<yes>"
    When click module Admin
    And Click verify on subscription event
    And verify the email alert "<requester>"
    Then I get the status "<Status>"
    Examples:
      | TS  | Scenario | Description               | requester    |Status       |HomePage|
      | 001 |    0002  | Check Subscription        |luis.bressan |Completed     |https://tp3app.trendalytics.co/signin|
