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
      Given that the user is on the home screen "<Environment>"
      And send credencials
      And confirm action "<confirm>"
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
        | TS  | Scenario | Description                   |Report                |Type                                     |Name                           |confirm|Environment    |
        | 001 |    0001  | Create report successfully    |ASSORTMENT COMPARISON |ONE BRAND ACROSS MULTIPLE RETAIL SITES   | Assort Comparison Automation  |yes    |app            |


  @CreateNewReportMultipoleRetail
  Scenario Outline: TS:["<TS>"] - [Create Multiple Retail Report  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<Environment>"
    And send credencials
    And confirm action "<confirm>"
    When click module Report
    And click Create a Report
    And create a Report Type "<Report>"
    And click Type "<Type>"
    And click Retail
    And click Category
    And type Name "<Name>"
    Then click submit
    Examples:
      | TS  | Scenario | Description                    |Report                |Type                   |Name                              |confirm  |Environment|
      | 002 |    00012  | Create report successfully    |ASSORTMENT COMPARISON |MULTIPLE RETAIL SITES  |Multiple Retail Report Automation |yes      |app        |


  @CreateNewReportMultipleBrands
  Scenario Outline: TS:["<TS>"] - [Create Multiple Brands Report  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<Environment>"
    And send credencials
    And confirm action "<confirm>"
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
      | TS  | Scenario | Description                    |Report                |Type                                     |Name                               |confirm|Environment|
      | 003 |    00012  | Create report successfully    |ASSORTMENT COMPARISON |MULTIPLE BRANDS ACROSS ONE RETAIL SITE   |Multiple Brand Report Automation   |yes     |app|

  @CreateNewReportTrendSide
  Scenario Outline: TS:["<TS>"] - [Create Trend Report Side By Side  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<Environment>"
    And send credencials
    And confirm action "<confirm>"
    When click module Report
    And click Create a Report
    And create a Report Type "<Report>"
    And click Type "<Type>"
    And Select Trends
    And type Name "<Name>"
    Then click submit
    Examples:
      | TS  | Scenario | Description                    |Report           |Type                            |Name                                  |confirm  |Environment|
      | 001 |    00012  | Create report successfully    |TREND COMPARISON |SIDE BY SIDE TREND COMPARISON   |Trend Report Side By Side Automation  |yes      |app        |



  #=====================================================================================================================
  #CHECK CREATE REPORT AND NOW DOWNLOAD EXCEL CURRENT
  #=====================================================================================================================

  @DownloadExcelHistory
  Scenario Outline: TS:["<TS>"] - [Check Report previously created And Download Excel  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<Environment>"
    And send credencials
    And confirm action "<confirm>"
    When click module Report
    And click My Comparison
    And Fill name of report "<Name>" "<placeholder>"
    And Click out
    Then I get the message "<Report>"
    And Click out
    And Download Excel Current "<Name>"
        Examples:
      | TS  | Scenario | Description                                  | Name                                |Report                                                 |placeholder|confirm|Environment|
      | 004 |    0001  | Check One Brand Report and download Excel    |Assort Comparison Automation         |Assortment Comparison Report                           |Search     |yes    |app        |
      | 004 |    0002  | Multiple Retail Report and download Excel    |Multiple Retail Report Automation    |Assortment Comparison Report                           |Search     |yes    |app        |
      | 004 |    0003  | Multiple Brand Report and download Excel     |Multiple Brand Report Automation     |Assortment Comparison Report                           |Search     |yes    |app        |
      | 004 |    0004  | Trend Report Side By Side and download Excel |Trend Report Side By Side Automation |Trend Comparison Report - Side by Side Trend Comparison|Search     |yes    |app        |



  #=====================================================================================================================
  #DOWNLOAD EXCEL history
  #=====================================================================================================================
  @DownloadExcelHistory2
  Scenario Outline: TS:["<TS>"] - [Download Excel History]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<Environment>"
    And send credencials
    And confirm action "<confirm>"
    When click module Report
    And click My Comparison
    And Fill name of report "<Name>" "<placeholder>"
    And Click out
    Then I get the message "<Report>"
    And Click out
    And Download Excel History
    And click Save
    Examples:
    Examples:
      | TS  | Scenario | Description                                          | Name                                |Report                                                 |placeholder|confirm|Environment|
      | 004 |    0001  | Check One Brand Report and download Excel History    |Assort Comparison Automation         |Assortment Comparison Report                           |Search     |yes    |app        |
      | 004 |    0002  | Multiple Retail Report and download Excel History    |Multiple Retail Report Automation    |Assortment Comparison Report                           |Search     |yes    |app        |
      | 004 |    0003  | Multiple Brand Report and download Excel History     |Multiple Brand Report Automation     |Assortment Comparison Report                           |Search     |yes    |app        |
      | 004 |    0004  | Trend Report Side By Side and download Excel History |Trend Report Side By Side Automation |Trend Comparison Report - Side by Side Trend Comparison|Search     |yes    |app        |




 #=====================================================================================================================
  # PDF
  #=====================================================================================================================
  @DownloadPDF
  Scenario Outline: TS:["<TS>"] - [Download PDF Report  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<Environment>"
    And send credencials
    And confirm action "<confirm>"
    When click module Report
    And click My Comparison
    And Fill name of report "<Name>" "<placeholder>"
    And Click out
    And download a PDF Report
    And Click out
    Then I get the message "<Message>"
    Examples:
      | TS  | Scenario | Description                 |Name                                 |placeholder     |Message                                                   |confirm |Environment |
      | 006 |    0001  | Create Requester PDF        |Assort Comparison Automation         |Search          |Assortment Comparison Report                              |yes     |app         |
      | 006 |    0002  | Multiple Retail Report      |Multiple Retail Report Automation    |Search          |Assortment Comparison Report - Multiple Retail Sites      |yes     |app         |
      | 006 |    0003  | Multiple Retail Report      |Multiple Brand Report Automation     |Search          |Assortment Comparison Report                              |yes     |app         |
      | 006 |    0004  | Multiple Retail Report      |Trend Report Side By Side Automation |Search          |Trend Comparison Report                                   |yes     |app         |


#=====================================================================================================================
  #CHECK ADMIN AREA EMAIL ALERT NOT TROLLED OUT TO PRODUCTION
  #=====================================================================================================================

  @TrendPulseExcelDownload
  Scenario Outline: TS:["<TS>"] - [Download TrendPulse Excel]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    And confirm action "<confirm>"
    When click module TrendPulse
    And select Trend Discovery
    And Click out
    And Download to Excel
    And Fill name of report "<Name>" "<placeholder>"
    And click on confirm
    #And select Default Main Filter
    #And switch to table view
    #And select month "<month>"
    #When Search Table "<Trend>"
    #Then check Avg Weekly Searches "<Avg>"
    #And check TY/LY Growth "<Perc>"
    Examples:
      | TS  | Scenario | Description                   |Name                                  |placeholder          |confirm  |HomePage|
      | 007 |    0001  | Trend Pulse Excel Download    |TrendPulse Excel Download Automation  |File Name (optional) |yes       |app|
  #=====================================================================================================================
  #CHECK ADMIN AREA EMAIL ALERT NOT TROLLED OUT TO PRODUCTION
  #=====================================================================================================================

  #@CheckAdminAreaEmailAlert
  #Scenario Outline: TS:["<TS>"] - [Check Email Alert   ]  - "<Scenario>" - "<Description>"
  #  Given that the user is on the home screen "<Environment>"
  #  And send credencials
  #  And confirm action "<confirm>"
  #  When click module Admin
  #  Then Click on email alerts
  #  And search for user email "<email>"
  #  And search for Report "<Report>"
  #  And search for Type "<Type>"
  #  And I get the status "<Status>"
  #  And check creation date

  #  Examples:
  #    | TS  | Scenario | Description                  |email        |Status        |Type    |Report                        |confirm |Environment|
  #    | 001 |    0001  | Email Alert completed        |luis.bressan |Completed     |excel   |Assortment Comparison Report  |yes |app|
  #    | 001 |    0001  | Email Alert completed        |luis.bressan |Completed     |pdf   |Report                          |yes |app|


# @CheckSubscription
# Scenario Outline: TS:["<TS>"] - [Check Subscription status  ]  - "<Scenario>" - "<Description>"
# Given that the user is on the home screen "<HomePage>"
# And send credencials
# And confirm action "<yes>"
# When click module Admin
# And Click verify on subscription event
# And verify the email alert "<requester>"
# Then I get the status "<Status>"
# Examples:
# | TS  | Scenario | Description               | requester    |Status       |HomePage|
# | 001 |    0002  | Check Subscription        |luis.bressan |Completed     |app|

