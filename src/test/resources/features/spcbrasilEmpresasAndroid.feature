Feature: SPC Brasil Empresas ANDROID

  Background:
    And open SPC BRASIL EMPRESAS "ANDROID"
    #When logon with credentials "1594215" and "teste123456" and "22042015"
    When logon with credentials "18354482" and "Brt125243@!" and "Brt125243@!"
    Then check message "CONSULTA" "INCLUSÃO" "EXCLUSÃO"

  @SoCheque @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - Android -So Cheque]  - "<Scenario>" - "<Description>"
    And click in Consulta "<Produtos>"
    And click in Produtos Disponiveis
    And Click in type "<type>"
    And Inform all datas "<cpfcnpj>"
    And Select o produto "<produto>"
    And check results "<check>"
    Examples:
      | TS      | Scenario      | Description             |Produtos |cpfcnpj|type       |produto                        |check                                             |
      | 001     | 001           | Cheque So Cheque        |Consultas|CPF    |$ÓCHEQUE   |Status Receita Federal Online  |REGULAR;LUIS CARLOS TORREZAN BRESSAN;11/11/1972   |




  @CONFIRMEPJ @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - CONFIRME PJ]  - "<Scenario>" - "<Description>"
    And click in Consulta "<Produtos>"
    And click in Produtos Disponiveis
    And Click in type "<type>"
    And Inform all datas "<cpfcnpj>"
    And Select o produto "<produto>"
    And check results "<check>"
    Examples:
      | TS      | Scenario      | Description                             |Produtos |cpfcnpj|type           |produto                                    | check                                           |
      | 001     | 001           | CONFIRME PJ Status Receita              |Consultas|CNPJ   |CONFIRME PJ    |Status Receita Federal Online              |5 - CONFIRME PJ;ATIVA;LUIS CARLOS TORREZAN BRESSAN;Brasileira   |
      | 001     | 002           | CONFIRME PJ Quadro Social               |Consultas|CNPJ   |CONFIRME PJ    |Quadro Social e Administração Mais Completo|5 - CONFIRME PJ;ATIVA;LUIS CARLOS TORREZAN BRESSAN;Brasileira   |
      | 001     | 003           | CONFIRME PJ Indice Relacionamento       |Consultas|CNPJ   |CONFIRME PJ    |Indice Relacionamento Mercado PJ           |5 - CONFIRME PJ;ATIVA;LUIS CARLOS TORREZAN BRESSAN;Brasileira   |


  @SPCTOPFISICA @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - CONFIRME PJ]  - "<Scenario>" - "<Description>"
    And click in Consulta "<Produtos>"
    And click in Produtos Disponiveis
    And Click in type "<type>"
    And Inform all datas "<cpfcnpj>"
    And Select o produto "<produto>"
    And check results "<check>"
    Examples:
      | TS      | Scenario      | Description    |Produtos |cpfcnpj|type            |produto                         | check                                                                 |
      | 001     | 001           | SPC TOP FISICA |Consultas|CPF    |SPC TOP FISICA .|Status Receita Federal Online   |7 - SPC TOP FISICA .;REGULAR;LUIS CARLOS TORREZAN BRESSAN;11/11/1972   |



  @SPCTOPJURIDICO @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - SPC TOP JURIDICO]  - "<Scenario>" - "<Description>"
    And click in Consulta "<Produtos>"
    And click in Produtos Disponiveis
    And Click in type "<type>"
    And Inform all datas "<cpfcnpj>"
    And Select o produto "<produto>"
    And check results "<check>"
    Examples:
      | TS      | Scenario      | Description    |Produtos |cpfcnpj   |type              |produto                         | check                                                                 |
      | 001     | 001           | SPC TOP JURIDICO |Consultas|CNPJ    |SPC TOP JURIDICO .|Status Receita Federal Online   |8 - SPC TOP JURIDICO .;ATIVA;LUIS CARLOS TORREZAN BRESSAN;Brasileira   |

  @SPC @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - SPC TOP JURIDICO]  - "<Scenario>" - "<Description>"
    And click in Consulta "<Produtos>"
    And click in Produtos Disponiveis
    And Click in type "<type>"  
    And Inform all datas "<cpfcnpj>"
    And Select o produto "<produto>"
    And check results "<check>"
    Examples:
      | TS      | Scenario      | Description    |Produtos |cpfcnpj|type |produto                             | check                                         |
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Cheques Sem Fundo - CCF             |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Protesto                            |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Ação                                |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Participações em Empresas           |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Pendências Financeiras Serasa       |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|SPC Score 3 Meses                   |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Score 12 Meses                      |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Alerta de Obito                     |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Nova Renda Presumida - SPC Brasil   |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Limite de crédito sugerido          |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Status Receita Federal Online       |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Indice Relacionamento Mercado PF    |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Comprometimento de Renda Mensal PF  |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|
      | 001     | 001           | SPC            |Consultas|CPF    |SPC .|Score de Recuperação PF             |12 - SPC .;REGULAR;LUIS CARLOS TORREZAN BRESSAN|




  @MixPlus @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - Android -Consulta - SPC MIX PLUS]  - "<Scenario>" - "<Description>"
    And click in Consulta
    And click in Produtos Disponiveis
    And Click in "<frente>"
    And Inform all datas
    And Select o produto "<produto>"
    #And get all results
    #And click in mais informacoes
    #And get all results
    Examples:
      | TS      | Scenario      | Description              |frente       |produto                           |
      | 004     | 001           | Consulta SPC MIX PLUS    |SPC MIX PLUS.|Participações em Empresas         |
      | 004     | 002           | Consulta SPC MIX PLUS    |SPC MIX PLUS.|SPC Score 3 Meses                 |
      | 004     | 003           | Consulta SPC MIX PLUS    |SPC MIX PLUS.|SPC Score 12 Meses                |
      | 004     | 004           | Consulta SPC MIX PLUS    |SPC MIX PLUS.|Nova Renda Presumida - SPC Brasil |
      | 004     | 005           | Consulta SPC MIX PLUS    |SPC MIX PLUS.|Limite de crédito sugerido        |
      | 004     | 006           | Consulta SPC MIX PLUS    |SPC MIX PLUS.|Status Receita Federal Online     |
      | 004     | 007           | Consulta SPC MIX PLUS    |SPC MIX PLUS.|Indice Relacionamento Mercado PF  |
      | 004     | 008           | Consulta SPC MIX PLUS    |SPC MIX PLUS.|Comprometimento de Renda Mensal PF|
      | 004     | 009           | Consulta SPC MIX PLUS    |SPC MIX PLUS.|Score de Recuperação              |


  @SPCPlus @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - Android -Consulta - SPC PLUS]  - "<Scenario>" - "<Description>"
    And click in Consulta
    And click in Produtos Disponiveis
    And Click in "<frente>"
    And Inform all datas
    And Select o produto "<produto>"
    #And get all results
    #And click in mais informacoes
    #And get all results
    Examples:
      | TS      | Scenario      | Description           |frente     |produto                            |
      | 005     | 001           | Consulta SPC PLUS     |SPC PLUS   |Ação                               |
      | 005     | 002           | Consulta SPC PLUS     |SPC PLUS   |Participações em Empresas          |
      | 005     | 003           | Consulta SPC PLUS     |SPC PLUS   |SPC Score 3 Meses                  |
      | 005     | 004           | Consulta SPC PLUS     |SPC PLUS   |SPC Score 12 Meses                 |
      | 005     | 005           | Consulta SPC PLUS     |SPC PLUS   |Alerta de Obito                    |
      | 005     | 006           | Consulta SPC PLUS     |SPC PLUS   |Nova Renda Presumida - SPC Brasil  |
      | 005     | 007           | Consulta SPC PLUS     |SPC PLUS   |Status Receita Federal Online      |
      | 005     | 008           | Consulta SPC PLUS     |SPC PLUS   |Indice Relacionamento Mercado PF   |
      | 005     | 009           | Consulta SPC PLUS     |SPC PLUS   |Comprometimento de Renda Mensal PF |
      | 005     | 010           | Consulta SPC PLUS     |SPC PLUS   |Score de Recuperação               |




  @MixTop @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - Android -Consulta - SPC MIX TOP +]  - "<Scenario>" - "<Description>"
    And click in Consulta
    And click in Produtos Disponiveis
    And Click in "<frente>"
    And Inform all datas
    And Select o produto "<produto>"
    #And get all results
    #And click in mais informacoes
    #And get all results
    Examples:
      | TS      | Scenario      | Description             |frente         |produto                            |
      | 006     | 001           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |Protesto                           |
      | 006     | 002           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |Ação                               |
      | 006     | 003           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |Participações em Empresas          |
      | 006     | 004           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |SPC Score 3 Meses                  |
      | 006     | 005           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |SPC Score 12 Meses                 |
      | 006     | 006           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |Alerta de Obito                    |
      | 006     | 007           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |Nova Renda Presumida - SPC Brasil  |
      | 006     | 008           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |Limite de crédito sugerido         |
      | 006     | 009           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |Indice Relacionamento Mercado PF   |
      | 006     | 010           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |Comprometimento de Renda Mensal PF |
      | 006     | 011           | Consulta SPC MIX TOP +  |SPC MIX TOP +  |Score de Recuperação               |

  @MixMais @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - Android -Consulta - NOVO SPC MIX MAIS]  - "<Scenario>" - "<Description>"
    And click in Consulta
    And click in Produtos Disponiveis
    And Click in "<frente>"
    And Inform all datas
    And Select o produto "<produto>"
    #And get all results
    #And click in mais informacoes
    #And get all results
    Examples:
      | TS      | Scenario      | Description                   |frente           |produto                            |
      | 007     | 001           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Ação                               |
      | 007     | 002           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Participações em Empresas          |
      | 007     | 003           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Pendências Financeiras Serasa      |
      | 007     | 004           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|SPC Score 3 Meses                  |
      | 007     | 005           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|SPC Score 12 Meses                 |
      | 007     | 006           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Alerta de Obito                    |
      | 007     | 007           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Nova Renda Presumida - SPC Brasil  |
      | 007     | 008           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Limite de crédito sugerido         |
      | 007     | 009           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Alerta de Identidade               |
      | 007     | 010           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Status Receita Federal Online      |
      | 007     | 011           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Indice Relacionamento Mercado PF   |
      | 007     | 012           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Comprometimento de Renda Mensal PF |
      | 007     | 013           | Consulta NOVO SPC MIX MAIS    |NOVO SPC MIX MAIS|Score de Recuperação               |





  @MixMaxi @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - Android -Consulta - NOVO SPC MAXI]  - "<Scenario>" - "<Description>"
    And click in Consulta
    And click in Produtos Disponiveis
    And Click in "<frente>"
    And Inform all datas
    And Select o produto "<produto>"
    #And get all results
    #And click in mais informacoes
    #And get all results
    Examples:
      | TS      | Scenario      | Description            |frente        |produto|
      | 008     | 001           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |Ação                               |
      | 008     | 002           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |Participações em Empresas          |
      | 008     | 003           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |SPC Score 3 Meses                  |
      | 008     | 004           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |SPC Score 12 Meses                 |
      | 008     | 005           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |Alerta de Obito                    |
      | 008     | 006           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |Nova Renda Presumida - SPC Brasil  |
      | 008     | 007           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |Limite de crédito sugerido         |
      | 008     | 008           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |Alerta de Identidade               |
      | 008     | 009           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |Status Receita Federal Online      |
      | 008     | 010           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |Indice Relacionamento Mercado PF   |
      | 008     | 011           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |Comprometimento de Renda Mensal PF |
      | 008     | 012           | Consulta NOVO SPC MAXI |NOVO SPC MAXI |Score de Recuperação               |



  @RelatorioCompleto @RegressivoEmpresas2
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas - Android -Consulta - SPC RELATORIO COMPLETO]  - "<Scenario>" - "<Description>"
    And click in Consulta
    And click in Produtos Disponiveis
    And Click in "<frente>"
    And Inform all datas
    And Select o produto "<produto>"
    #And get all results
    #And click in mais informacoes
    #And get all results
    Examples:
      | TS      | Scenario      | Description                      |frente                 |produto|
      | 009     | 001           | Consulta SPC RELATORIO COMPLETO  |SPC RELATORIO COMPLETO|        |



#### others

  @Teste
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas Android - Login]  - "<Scenario>" - "<Description>"
    And open SPC BRASIL EMPRESAS "ANDROID"
    And go to "https://www.uol.com.br"
    When swipe down
    Examples:
      | TS      | Scenario      | Description               |
      | 001     | 001           | Login SPC Brasil Empresas |


  @LoginAndroid @RegressivoEmpresas
  Scenario Outline: TS:["<TS>"] - [SPC Brasil Empresas Android - Login]  - "<Scenario>" - "<Description>"
    And open SPC BRASIL EMPRESAS "ANDROID"
    When logon with credentials "<Operador>" and "<Pass>" and "<PassPrase>"
    Then check message "<Message>" "<Message1>" "<Message2>"
    And click exit
    Examples:
      | TS      | Scenario      | Description            |Operador  |Pass        |PassPrase|Message    |Message1|Message2|
      | 001     | 001           | Login SPC Brasil Empresas |1594215   |teste123456 |22042015 |CONSULTA   |INCLUSÃO|EXCLUSÃO|
