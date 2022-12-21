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


  @Invent_CheckTotals  @smoketest
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


  @InventarioHardware   @smoketest
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
      | Env       |Descriptiion                              |submenu                 |itemSubmenu        |itemPage                       |check1                             |check2     |
      | smc       |Smart Center Inventário Hardware          |Inventário              |Hardware           |                               |Hardware                           |Almaden com você!|


  @Inventariodadoscustomizados  @smoketest
  Scenario Outline: Smart Center health check Inventário dados customizados
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
      | Env       |Descriptiion                                                     |submenu                 |itemSubmenu        |itemPage                       |check1                             |check2     |
      | smc       |Smart Center health check Inventário dados customizados         |Inventário              |Dados customizados |                               |Inventário Customizado             |Almaden com você!|

  @healthcheckhealthInventarioSoftware  @smoketest
  Scenario Outline: Smart Center health check Inventário Software
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
      | Env       |Descriptiion                                     |submenu                 |itemSubmenu        |itemPage                       |check1                             |check2     |
      | smc       |Smart Center health check Inventário Software    |Inventário              |Software           |Lista de Softwares             |Produtos                           |Almaden com você!|
      | smc       |Smart Center health check Inventário Software    |Inventário              |Software           |Aprovação de Software          |Aprovação de Software              |Almaden com você!|
      | smc       |Smart Center health check Inventário Software    |Inventário              |Software           |Alertas Vermelhos de Softwares |Alertas Vermelhos de Softwares     |Almaden com você!|



  @healthcheckrelatorios   @smoketest
  Scenario Outline: Smart Center health check Inventário Realtorios
    Given that the user is on the home screen "<Env>"
    When Send credentials "<Env>"
    And cick Login
    And click in menu
    And Click in submenu "<submenu>"
    And Click in submenu "<submenu1>"
    And Click in item by a list "<itemSubmenu>"
    And Click in item by a list "<itemPage>"
    And Check for information "<check1>"
    Then Click in Sair
    And Check for information "<check2>"
    Examples:
      | Env       |Descriptiion                                                                  |submenu   |submenu1   |itemSubmenu                      |itemPage |check1                             |check2     |
      | smc       |Smart Center health check Inventário Relatorio Hardware                       |Inventário|Relatórios |Hardware                         |         |Relatório de Hardware              |Almaden com você!|
      | smc       |Smart Center health check Inventário Relatorio Monitor                        |Inventário|Relatórios |Monitor                          |         |Relatório de Monitores             |Almaden com você!|
      | smc       |Smart Center health check Inventário Relatorio Software                       |Inventário|Relatórios |Software                         |         |Relatório de Software              |Almaden com você!|
      | smc       |Smart Center health check Inventário Relatorio Software Metering              |Inventário|Relatórios |Software Metering                |         |Software Metering                  |Almaden com você!|
      | smc       |Smart Center health check Inventário Relatorio Pastas Compartilhadas          |Inventário|Relatórios |Pastas Compartilhadas            |         |Selecionar Departamento             |Almaden com você!|
      | smc       |Smart Center health check Inventário Relatorio Consolidado de Inventário      |Inventário|Relatórios |Consolidado de Inventário        |         |Selecione os Departamentos         |Almaden com você!|
      | smc       |Smart Center health check Inventário Relatorio Alterações Desktop             |Inventário|Relatórios |Alterações                       |Desktop  |Relatório de Alterações Desktop    |Almaden com você!|
      | smc       |Smart Center health check Inventário Relatorio Alterações Servidor            |Inventário|Relatórios |Alterações                       |Servidor |Relatório de Alterações Servidor   |Almaden com você!|
      | smc       |Smart Center health check Inventário Relatorio Indisponibilidade de Máquinas  |Inventário|Relatórios |Indisponibilidade de Máquinas    |         |Indisponibilidade de Máquinas      |Almaden com você!|
      | smc       |Smart Center health check Inventário Relatorio Equipamentos sem Agente        |Inventário|Relatórios |Equipamentos sem Agente (Backlog)|         |Equipamentos sem Agente (Backlog)  |Almaden com você!|


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


  @FichaMaquinaWin  @smoketest @FichaMaquina
  Scenario Outline: Smart Center Ficha da maquina
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
      | Env       |Descriptiion                                |item1                                 |
      | smc       |Smart Center Ficha dsa Maquina Windows      |WINDOWS7-64                           |



  @FichaMaquinaLinux  @smoketest @FichaMaquina
  Scenario Outline: Smart Center Ficha da maquina
    Given that the user is on the home screen "<Env>"
    When Send credentials "<Env>"
    And cick Login
    And pesquisar um item "<item1>"
    And selecionar o item "<item1>"
    And verifique os dados em tela
      |Nome do computador                 |LAB-CENTOS81                                           |
      |Departamento                       |DESENVOLVIMENTO                                        |
      |Sistema Operacional                |LINUX CENTOS 8.5                                       |
      |Versão do Sistema Operacional      |4.18.0.0                                               |
      |Fabricante                         |VMWare                                                 |
      |Tipo                               |DESKTOP                                                |
      |IP                                 |10.253.0.196 - 192.168.122.1                           |
      |Data de release da BIOS            |2014                                                   |
      |Domínio                            |(NONE)                                                 |
      |Ativo virtual                      |YES                                                    |
      |Nome do produto do sistema         |VMWARE VIRTUAL PLATFORM                                |
      |Número do serial do sistema        |VMWARE-42 0E 2F D5 90 F2 95 69-C4 DF FA 39 D2 28 ED F5 |
      |ID do Ativo                        |0050568E6B6E000004515113                               |
      |Arquitetura                        |64 BITS                                                |
      |Usuário atual                      |AUTOMATOS                                              |
      |Processador                        |INTEL XEON CPU E5649 2.53GHZ                           |
      |Geração do processador             |INTEL XEON E5649                                       |
      |Tipo do processador                |INTEL XEON                                             |
      |Frequência do processador (Clock)  |2.53 GHz                                               |
      |Núcleos físicos                    |0                                                      |
      |Núcleos lógicos                    |1                                                      |
      |Memória                            |4 GB                                                   |
      |Memória instalada (MB)             |1830 MB                                                |
      |Disco total (GB)                   |16 GB                                                  |
      |Disco utilizado (GB)               |15 GB                                                  |
      |Data de coleta                     |07/12/2022 12:04                                       |

    Examples:
      | Env       |Descriptiion                                |item1                                 |
      | smc       |Smart Center Ficha dsa Maquina Linux      |LAB-CENTOS81                           |


  @FichaMaquinaMac  @smoketest  @FichaMaquina
  Scenario Outline: Smart Center Ficha da maquina
    Given that the user is on the home screen "<Env>"
    When Send credentials "<Env>"
    And cick Login
    And pesquisar um item "<item1>"
    And selecionar o item "<item1>"
    And verifique os dados em tela
      |Nome do computador                 |MARCOSS-MACBOOK-PRO.LOCAL                              |
      |Departamento                       |MACOS                                                  |
      |Sistema Operacional                |MAC OS X UNKNOWN                                       |
      |Versão do Sistema Operacional      |10.0.0.0                                               |
      |Fabricante                         |Apple                                                  |
      |Tipo                               |NOTEBOOK                                               |
      |IP                                 |10.0.2.15                                              |
      #|Data de release da BIOS            |2014                                                   |
      #|Domínio                            |(NONE)                                                 |
      |Ativo virtual                      |NO                                                     |
      |Nome do produto do sistema         |MACBOOK PRO|
      #|Número do serial do sistema        |VMWARE-42 0E 2F D5 90 F2 95 69-C4 DF FA 39 D2 28 ED F5 |
      |ID do Ativo                        |0800270AF4C209230                                      |
      |Arquitetura                        |64 BITS                                                |
      |Usuário atual                      |MARCOS                                                 |
      |Processador                        |INTEL CORE I3-4130 CPU 3.40GHZ                         |
      |Geração do processador             |INTEL CORE I3 4130                                     |
      |Tipo do processador                |INTEL CORE I3                                          |
      |Frequência do processador (Clock)  |3.39 GHz                                               |
      #|Núcleos físicos                    |0                                                      |
      |Núcleos lógicos                    |2                                                       |
      |Memória                            |11 GB                                                   |
      |Memória instalada (MB)             |11142 MB|
      #|Disco total (GB)                   |16 GB                                                  |
      #|Disco utilizado (GB)               |15 GB                                                  |
      |Data de coleta                     |01/08/2022 17:40                                       |

    Examples:
      | Env       |Descriptiion                                |item1                                 |
      | smc       |Smart Center Ficha dsa Maquina MAC      |MARCOSS-MACBOOK-PRO.LOCAL               |



  @Geolocalizacao  @smoketest
  Scenario Outline: Smart Center health check Inventário Software
    Given that the user is on the home screen "<Env>"
    When Send credentials "<Env>"
    And cick Login
    And click in menu
    And Click in submenu "<submenu>"
    And Click in item "<itemSubmenu>"
    And click item page "<itemPage>"
    And define parimetro inicial "<perimetro>"
    And verifica no mapa de iteracoes se retornou endereco "<retmapa>"
    Then Click in Sair
    And Check for information "<check2>"
    Examples:
      | Env       |Descriptiion                                     |submenu                 |itemSubmenu        |itemPage                       |perimetro                 |retmapa                         |check2           |
      | smc       |Smart Center health check Inventário Software    |Inventário              |Geolocalização     |Definir Perímetro              |Avenida Paulista          |Dados cartográficos ©2022 Google|Almaden com você!|




