Feature:  CIQ Test Suite

  @LoginCIQ @smoketest
  Scenario Outline: CIQ Center Login
    Given that the user is on the home screen "<Env>"
    And Send credentials "<Env>"
    And cick Login
    And check for information on logon "<Env>" "<info1>"
    And check for information on logon "<Env>" "<info2>"
    And check for information on logon "<Env>" "<info3>"

    Examples:
      | Env       |Descriptiion     |info1              |info2                   |info3                 |
      | ciq       |Login sucess     | EXPERIÊNCIA BOA   |EXPERIÊNCIA REGULAR     | EXPERIÊNCIA RUIM     |

  @DrillMenus @smoketest
  Scenario Outline: CIQ Center Login
    Given that the user is on the home screen "<Env>"
    And Send credentials "<Env>"
    And cick Login
    And click on ciq menu "<menu>"
    And check for information on logon "<Env>" "<info1>"
    And check for information on logon "<Env>" "<info2>"
    And check for information on logon "<Env>" "<info3>"

    Examples:
      | Env       |Descriptiion     |menu                     |info1               |info2                 |info3                 |
      | ciq       |Checking Menus   |Geral                    |EXPERIÊNCIA BOA   |EXPERIÊNCIA REGULAR     | EXPERIÊNCIA RUIM     |
      | ciq       |Checking Menus   |Dispositivos             |EXPERIÊNCIA BOA   |EXPERIÊNCIA REGULAR     | EXPERIÊNCIA RUIM     |
      | ciq       |Checking Menus   |Colaboração              |EXPERIÊNCIA BOA   |EXPERIÊNCIA REGULAR     | EXPERIÊNCIA RUIM     |
      | ciq       |Checking Menus   |Aplicativos de Negócios  |EXPERIÊNCIA BOA   |EXPERIÊNCIA REGULAR     | EXPERIÊNCIA RUIM     |
      | ciq       |Checking Menus   |Sentimento do Usuário    |EXPERIÊNCIA BOA   |EXPERIÊNCIA REGULAR     | EXPERIÊNCIA RUIM     |
      | ciq       |Checking Menus   |TI Verde                 |XPERIÊNCIA BOA    |EXPERIÊNCIA REGULAR     | EXPERIÊNCIA RUIM     |


  @PontLgTempo @smoketest
  Scenario Outline: CIQ Center Login
    Given that the user is on the home screen "<Env>"
    And Send credentials "<Env>"
    And cick Login
    And click on ciq menu "<menu>"
    And click on ciq filter "<filter>"
    And Click on Region "<Region>"
    And Click Confirmar
    And check for information on logon "filter" "<info1>"
    And check for information on logon "filter" "<info2>"
    And check for information on logon "menus" "<info3>"
    And check for information on logon "menus" "<info4>"
    And check for information on logon "menus" "<info5>"
    And check for information on logon "menus" "<info6>"
    And check for information on logon "menus" "<info7>"



    Examples:
      | Env       |Descriptiion                            |menu                     |filter                |Region        |info1                  |info2                               |info3          |info4          |info5        |info6                  |info7      |
      | ciq       |Checking Pontuacao ao Longo do Tempo    |Geral                    |Filtro Avançado       |South America |Sentimento do Usuário  |Sentimento Sobre os Dispositivos    |Nome da Máquina|Departamento   | Fabricante  |Sistema Operacional    |Avaliação  |