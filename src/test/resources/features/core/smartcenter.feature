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


  @healthcheck  @smoketest
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
  Scenario Outline: Smart Center Ficha da maquina Gerencia Alteracoes
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


  @FichaMaquina  @smoketest
  Scenario Outline: Smart Center Ficha da maquina Gerencia Alteracoes
    Given that the user is on the home screen "<Env>"
    When Send credentials "<Env>"
    And cick Login
    And pesquisar um item "<item1>"
    And selecionar o item "<item1>"
    And verifique os dados em tela
          |Nome do computador                 |WINDOWS7-64                                            |
          |Departamento                       |ALMADEN - ASA3.39.3                                    |
          |Sistema Operacional                |WINDOWS 7 PROFESSIONAL                                 |
          |Versão do Sistema Operacional      |6.1.7601                                               |
          |Fabricante                         |VMWare                                                 |
          |Tipo                               |SERVIDOR                                               |
          |IP                                 |10.253.0.187                                           |
          |Data de release da BIOS            |2014                                                   |
          |Domínio                            |AUTOMATOS.CORP                                         |
          |Ativo virtual                      |YES                                                    |
          |Nome do produto do sistema         |VMware Virtual Platform                                |
          |Número do serial do sistema        |VMWARE-42 0E 18 37 58 E9 A5 E4-76 D3 9B 31 AF 01 B5 DB |
          |ID do Ativo                        |0050568E01A61AC3C56B113C                               |
          |Processador                        |INTEL XEON CPU E5649 2.53GHZ                           |
          |Geração do processador             |INTEL XEON E5649                                       |
          |Tipo do processador                |INTEL XEON                                             |
          |Frequência do processador (Clock)  |2.53 GHz                                               |
          |Núcleos físicos                    |4                                                      |
          |Quantidade de processadores        |2                                                      |
          |Quantidade de processadores ativos |2                                                      |
          |Memória                            |4 GB                                                   |
          |Disco total (GB)                   |100.00 GB                                              |
          |Disco utilizado (GB)               |46.79 GB                                               |
          |Data de coleta                     |06/10/2022 17:23                                       |

    Examples:
      | Env       |Descriptiion                                |item1                 |
      | smc       |Smart Center Ficha dsa Maquina              |WINDOWS7-64           |