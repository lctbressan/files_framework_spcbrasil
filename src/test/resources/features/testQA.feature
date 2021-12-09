Feature: Luis Bressan - process and check file - Test



  @ProcessFile
  Scenario Outline: TS:["<TS>"] - [Process Files in folder ]  - "<Scenario>" - "<Description>"
    Given Check folder file "<ProcessFile>" and FileControl "<FileControl>" in path "<path>" is not empty
    And   get return code for check "<RetCode>"
    And   confirm system date "<InitDate>"
    When  check "<FileControl>" is empty in path "<path>"
    Then  Process file "<ProcessFile>" and get result from "<FileControl>"
    And   The return code should be "<RetCode>"
    Examples:
      | TS  | Scenario | Description  		        |InitDate    |ProcessFile | FileControl|RetCode  | path                             |
      | 001 |    0001  | Process file invalid date  |2021-11-05  | ABC.xml    |ABC.ok      |     200 |/src/test/resources/arquivos/     |
      | 001 |    0001  | Process file invalid date  |1900-01-01  | ABC.xml    |ABC.ok      |     403 |/src/test/resources/arquivos/     |


  @ProcessFile
  Scenario Outline: TS:["<TS>"] - [Process no Files on Foledr]  - "<Scenario>" - "<Description>"
    Given Check folder file "<ProcessFile>" and FileControl "<FileControl>" in path "<path>" is not empty
    And   get return code for check "<RetCode>"
    And   confirm system date "<InitDate>"
    When  check "<FileControl>" is empty in path "<path>"
    Then  Process file "<ProcessFile>" and get result from "<FileControl>"
    And   The return code should be "<RetCode>"
    Examples:
      | TS  | Scenario | Description  		        |InitDate    |ProcessFile | FileControl|RetCode  | path                             |
      | 001 |    0003  | Process no file 	        |2021-01-01  | 	          |ABC.ok      |     500 |/src/test/resources/arquivos2/     |
      | 001 |    0003  | Process no file 	        |2021-01-01  | ABC.xml    |            |     500 |/src/test/resources/arquivos2/     |
      | 001 |    0003  | Process no system date     |            |        	  |            |     500 |/src/test/resources/arquivos2/     |