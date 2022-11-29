Feature:  CIQ Test Suite

  @CIQ @smoketest
  Scenario Outline: CIQ Center Login
    Given that the user is on the home screen "<HomePage>"
    And Send credentials "<Env>"
    #And fill email "<Email>"
    #And fill password "<Env>" "<Passwd>"
    #And click captcha
    And cick Login
    And check for information on logon "<Env>" "<info1>"
    And check for information on logon "<Env>" "<info2>"
    And check for information on logon "<Env>" "<info3>"

    Examples:
      | Env       |Descriptiion   |info1              |info2                   |info3                 |
      | ciq     |Login sucess     | EXPERIÊNCIA BOA   |EXPERIÊNCIA REGULAR     | EXPERIÊNCIA RUIM     |



