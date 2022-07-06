#Language : En
#encoding: utf-8

  @IntegrationTest
  @LoginTest
  Feature: Home


  @Links
  Scenario Outline: TS:["<TS>"] - [Test get appointment ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    And Click Login
    And Enter "<Email>" and "<Password>"
    And Select Project Trendalitycs
    And Click StopStart
    Examples:
      | TS  | Scenario | Description                   |Email                     | Password         |HomePage            |
      | 001 |    0001  |Test Link Product              |luis.bressan@joyjet.com   | brt125243        |https://clockify.me/|


