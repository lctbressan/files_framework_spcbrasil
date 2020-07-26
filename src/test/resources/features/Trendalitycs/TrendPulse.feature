#Language : En
#encoding: utf-8

@RegressionTest
@ReportTest
Feature: TrendPulse

  #=====================================================================================================================
  #CHECK AVERAGE THIS YEAR / LAST YEAR
  #=====================================================================================================================

  @AverageTyLyAPP
  Scenario Outline: TS:["<TS>"] - [Check Average TY/LY and Perc  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    And confirm action
    When click module TrendPulse
    And select Trend Discovery
    And select Default Main Filter
    And switch to table view
    And select month "<month>"
    When Search Table "<Trend>"
    Then check Avg Weekly Searches "<Avg>"
    And check TY/LY Growth "<Perc>"
    Examples:
      | TS  | Scenario | Description                      |month    |Trend                            |Avg          |Perc     |HomePage|
      | 001 |    0001  | Trend Discovery - Average  1 M   |1m       |gaiter                           |63.176       |10%      |https://app.trendalytics.co/signin|
      | 001 |    0002  | Trend Discovery - Average  3 M   |3m       |gaiter                           |59.359       |9%       |https://app.trendalytics.co/signin|
      | 001 |    0003  | Trend Discovery - Average  6 M   |6m       |gaiter                           |34.769       |4%       |https://app.trendalytics.co/signin|
      | 001 |    0004  | Trend Discovery - Average  1 M   |1m       |loungewear                       |421.007      |3%       |https://app.trendalytics.co/signin|
      | 001 |    0005  | Trend Discovery - Average  3 M   |3m       |loungewear                       |638.147      |5%       |https://app.trendalytics.co/signin|
      | 001 |    0006  | Trend Discovery - Average  6 M   |6m       |loungewear                       |510.199      |3,5%     |https://app.trendalytics.co/signin|
      | 001 |    0007  | Trend Discovery - Average  1 M   |1m       |mens graphic sweatshirt          |564          |1,57%    |https://app.trendalytics.co/signin|
      | 001 |    0008  | Trend Discovery - Average  3 M   |3m       |mens graphic sweatshirt          |773          |3,69%    |https://app.trendalytics.co/signin|
      | 001 |    0009  | Trend Discovery - Average  6 M   |6m       |mens graphic sweatshirt          |729          |1,68%    |https://app.trendalytics.co/signin|
      | 001 |    0010  | Trend Discovery - Average  1 M   |1m       |tie dye sweatpants               |22.353       |22,67%   |https://app.trendalytics.co/signin|
      | 001 |    0011  | Trend Discovery - Average  3 M   |3m       |tie dye sweatpants               |44.192       |42,94%   |https://app.trendalytics.co/signin|
      | 001 |    0012  | Trend Discovery - Average  6 M   |6m       |tie dye sweatpants               |29.326       |37,34%   |https://app.trendalytics.co/signin|
      | 001 |    0010  | Trend Discovery - Average  1 M   |1m       |MENS STAINLESS STEEL NECKLACES   |1.342        |         |https://app.trendalytics.co/signin|
      | 001 |    0011  | Trend Discovery - Average  3 M   |3m       |MENS STAINLESS STEEL NECKLACES   |1.163        |8,20%    |https://app.trendalytics.co/signin|
      | 001 |    0012  | Trend Discovery - Average  6 M   |6m       |MENS STAINLESS STEEL NECKLACES   |1.394        |3,93%    |https://app.trendalytics.co/signin|
      | 001 |    0013  | Trend Discovery - Average  1 M   |1m       |BLEACHED TEE                     |557.75       |3,22%    |https://app.trendalytics.co/signin|
      | 001 |    0014  | Trend Discovery - Average  3 M   |3m       |BLEACHED TEE                     |415.61       |2,48%    |https://app.trendalytics.co/signin|
      | 001 |    0015  | Trend Discovery - Average  6 M   |6m       |BLEACHED TEE                     |314.80       |2,68%    |https://app.trendalytics.co/signin|


#TP3
  @AverageTyLyATP3
  Scenario Outline: TS:["<TS>"] - [Check Average TY/LY  ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And send credencials
    #And confirm action
    When click module TrendPulse
    And select Trend Discovery
    And select Default Main Filter
    And switch to table view
    And select month "<month>"
    When Search Table "<Trend>"
    Then check Avg Weekly Searches "<Avg>"
    And check TY/LY Growth "<Perc>"
    Examples:
      | TS  | Scenario | Description                      |month    |Trend                            |Avg          |Perc     |HomePage|
      | 001 |    0001  | Trend Discovery - Average  1 M   |1m       |gaiter                           |63.176       |10%      |https://tp3app.trendalytics.co/signin|
      | 001 |    0002  | Trend Discovery - Average  3 M   |3m       |gaiter                           |59.359       |9%       |https://tp3app.trendalytics.co/signin|
      | 001 |    0003  | Trend Discovery - Average  6 M   |6m       |gaiter                           |34.769       |4%       |https://tp3app.trendalytics.co/signin|
      | 001 |    0004  | Trend Discovery - Average  1 M   |1m       |loungewear                       |421.007      |3%       |https://tp3app.trendalytics.co/signin|
      | 001 |    0005  | Trend Discovery - Average  3 M   |3m       |loungewear                       |638.147      |5%       |https://tp3app.trendalytics.co/signin|
      | 001 |    0006  | Trend Discovery - Average  6 M   |6m       |loungewear                       |510.199      |3,5%     |https://tp3app.trendalytics.co/signin|
      | 001 |    0007  | Trend Discovery - Average  1 M   |1m       |mens graphic sweatshirt          |564          |1,57%    |https://tp3app.trendalytics.co/signin|
      | 001 |    0008  | Trend Discovery - Average  3 M   |3m       |mens graphic sweatshirt          |773          |3,69%    |https://tp3app.trendalytics.co/signin|
      | 001 |    0009  | Trend Discovery - Average  6 M   |6m       |mens graphic sweatshirt          |729          |1,68%    |https://tp3app.trendalytics.co/signin|
      | 001 |    0010  | Trend Discovery - Average  1 M   |1m       |tie dye sweatpants               |22.353       |22,67%   |https://tp3app.trendalytics.co/signin|
      | 001 |    0011  | Trend Discovery - Average  3 M   |3m       |tie dye sweatpants               |44.192       |42,94%   |https://tp3app.trendalytics.co/signin|
      | 001 |    0012  | Trend Discovery - Average  6 M   |6m       |tie dye sweatpants               |29.326       |37,34%   |https://tp3app.trendalytics.co/signin|
      | 001 |    0010  | Trend Discovery - Average  1 M   |1m       |MENS STAINLESS STEEL NECKLACES   |1.342        |         |https://tp3app.trendalytics.co/signin|
      | 001 |    0011  | Trend Discovery - Average  3 M   |3m       |MENS STAINLESS STEEL NECKLACES   |1.163        |8,20%    |https://tp3app.trendalytics.co/signin|
      | 001 |    0012  | Trend Discovery - Average  6 M   |6m       |MENS STAINLESS STEEL NECKLACES   |1.394        |3,93%    |https://tp3app.trendalytics.co/signin|
      | 001 |    0013  | Trend Discovery - Average  1 M   |1m       |BLEACHED TEE                     |557.75       |3,22%    |https://tp3app.trendalytics.co/signin|
      | 001 |    0014  | Trend Discovery - Average  3 M   |3m       |BLEACHED TEE                     |415.61       |2,48%    |https://tp3app.trendalytics.co/signin|
      | 001 |    0015  | Trend Discovery - Average  6 M   |6m       |BLEACHED TEE                     |314.80       |2,68%    |https://tp3app.trendalytics.co/signin|