#Language : En
#encoding: utf-8

@RegressionTest
@ReportTest
Feature: Market Pulse

  #=====================================================================================================================
  #CHECK RETAILERS BETWEEN FILTER AND REPORT
  #=====================================================================================================================

  @CheckRetail
  Scenario Outline: TS:["<TS>"] - [Check Retails  ]  - "<Scenario>" - "<Description>"
    Given that the user is logged
    When click module MarketPulse
    And select filter Category "<Category>" and IndexColumnItem "<LastItemIndex>"
    And click in Set filter
    And Click Retailes Shop Cart
    And Collect all retails
    #And click Create a Report
    #And create a Report Type "<Report>"
    #And click Type "<Type>"
    #And click Brand "<Brand>"
    #And click Retail "<Retail>"

    #And type Name "<Name>"
    #Then click submit
    Examples:
      | TS  | Scenario | Description                            |Report                | Category                         |LastItemIndex|
     # | 001 |    0001  | TREN-1084Create report successfully    |ASSORTMENT COMPARISON |Women;Clothing;Intimates;Pajamas  |4            |
      | 001 |    0001  | TREN-1084Create report successfully    |ASSORTMENT COMPARISON |Women;Clothing;Intimates;Socks    |3            |


