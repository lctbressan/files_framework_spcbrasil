Feature:  Smart Center

  @SmartCenter @smoketest
  Scenario Outline: Smart Center Login
    Given that the user is on the home screen "<Env>"
    And Send credentials "<Env>"
    #And fill email "<Email>"
    #And fill password "<Env>" "<Passwd>"
    #And click captcha
    And cick Login
    And check for information on logon "<Env>" "<info1>"
    #And check for information "<info2>"
    #And check for information "<info3>"

    Examples:
      | Env       |Descriptiion    |info1           |
      | smc       |Login sucess    |Olá Automatos   |


  @SmartCenterNotebook  @smoketest
  Scenario Outline: Hardware Check Smart Center Login
    Given that the user is on the home screen "<Env>"
    When Send credentials "<Env>"
    And cick Login
    And click in total de ativos
    And Click in Notebooks and get total
    And get total from the list "<item>"
    Then check both totals match

    Examples:
      | Env       |Descriptiion                 |item           |
      | smc       |Lardware Check - NoteBook    |Notebook              |