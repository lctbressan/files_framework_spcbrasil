Feature: Braziltest New Era Desktop Test



  @Desktop
  Scenario Outline: TS:["<TS>"] - [Desktop test ]  - "<Scenario>" - "<Description>"
    Given open a client server system "<css>"

    Examples:
      | TS  | Scenario | Description  		        |css                            |
      | 001 |    0001  | Process file invalid date  |C:\Windows\System32\calc.exe   |


