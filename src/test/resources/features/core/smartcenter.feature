Feature:  Smart Center

  @Login @smoketest
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


  @Inventoty  @smoketest
  Scenario Outline: Smart Center Inventoty check total
    Given that the user is on the home screen "<Env>"
    When Send credentials "<Env>"
    And cick Login
    And click in total de ativos
    And Click in "<item>" and get total
    And get total from the list "<item>"
    Then check both totals match
    Examples:
      | Env       |Descriptiion                               |item                  |
      | smc       |Inventory  - check total NoteBook          |Notebook              |
      | smc       |Inventory  - check total Desktop Virtual   |Desktop Virtual       |
      | smc       |Inventory  - check total Servidor Virtual  |Servidor Virtual      |
      #| smc       |Inventory  - Servidor                     |Servidor              |
      | smc       |Inventory  - check total Mobile            |Mobile                |


  @SmartCenterNotebook  @smoketest @healthcheck
  Scenario Outline: Smart Center health check functions
    Given that the user is on the home screen "<Env>"
    When Send credentials "<Env>"
    And cick Login
    And click in menu
    And Click in submenu "<submenu>"
    And Click in item "<itemSubmenu>"
    And click item page "<itemPage>"
    And Check for information "<check1>"
    Then Click in Sair
    And Check for information "<check2>"
    Examples:
      | Env       |Descriptiion                                |submenu                 |itemSubmenu        |itemPage                       |check1                             |check2     |
      | smc       |Smart Center health check functions         |Inventário              |Hardware           |                               |Hardware                           |Almaden com você!|
      | smc       |Smart Center health check functions         |Inventário              |Dados customizados |                               |Inventário Customizado             |Almaden com você!|
      | smc       |Smart Center health check functions         |Inventário              |Software           |Lista de Softwares             |Produtos                           |Almaden com você!|
      | smc       |Smart Center health check functions         |Inventário              |Software           |Aprovação de Software          |Aprovação de Software              |Almaden com você!|
      | smc       |Smart Center health check functions         |Inventário              |Software           |Alertas Vermelhos de Softwares |Alertas Vermelhos de Softwares     |Almaden com você!|



  @GerenciaAteracoes  @smoketest
  Scenario Outline: Smart Center Ficha de hardware Gerencia Alteracoes
    Given that the user is on the home screen "<Env>"
    When Send credentials "<Env>"
    And cick Login
    And pesquisar um item "<item1>"
    And selecionar o item "<item1>"
    #And colete todas as informacoes da ficha de hardware

  And verifique se o recurso de hardware apresenta a mensagem "<info1>" se sim falhe o teste
    Examples:
      | Env       |Descriptiion                                |item1                 |info1                                                            |
      | smc       |Smart Center GerenciaAteracoes              |WINDOWS7-64           |Infelizmente, você não tem permissão para visualizar esta página.|
