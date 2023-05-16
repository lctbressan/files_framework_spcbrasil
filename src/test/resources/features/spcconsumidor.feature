Feature: SPC Consumidor

  Background:
    And open SPC Consumidor "ANDROID"
    When access the consumidor app
    And send a cpf and password "125.243.478-26" ""

  @ConsumidorLogin @RegressivoConsumidor
  Scenario Outline: TS:["<TS>"] - [SPC Brasil consumidor Login logout]  - "<Scenario>" - "<Description>"
    And click in sair da Consulta
    Examples:
      | TS      | Scenario      | Description                                     |
      | 001     | 001           | SPC Brasil consumidor Login logout - sucesso    |

  @ConsumidorConsultaTercCpf @RegressivoConsumidor
  Scenario Outline: TS:["<TS>"] - [SPC Brasil consumidor consulta Terc CPF invalido]  - "<Scenario>" - "<Description>"
    And click in consulta de terceiros
    And click Consultar CPF
    And inform a cpf number "<type>"
    And check for message "<Message>"
    And close session
    #And click in termo de compromisso
    Examples:
      | TS      | Scenario      | Description                              |type|Message                                                     |
      | 001     | 001           | Consumidor Consulta Terc CPF invalido    |i   |CPF inválido para contratação. Corrija o CPF se necessário. |


  @ConsumidorConsultaTercCnpj @RegressivoConsumidor
  Scenario Outline: TS:["<TS>"] - [SPC Brasil consumidor consulta Terc CPF invalido]  - "<Scenario>" - "<Description>"
    And click in consulta de terceiros
    And click Consultar CNPJ
    And inform a cnpj number "<type>"
    And check for message "<Message>"
    And close session
    #And click in termo de compromisso
    Examples:
      | TS      | Scenario      | Description                               |type|Message                                                     |
      | 001     | 001           | Consumidor Consulta Terc CNPJ invalido    |i   |CNPJ inválido para contratação. Corrija o CNPJ se necessário. |


  @ConsumidorComprarAssinatura @RegressivoConsumidor
  Scenario Outline: TS:["<TS>"] - [SPC Brasil consumidor Comprar Assinatura PF  - "<Scenario>" - "<Description>"
    And click in consulta de terceiros
    And click Consultar CPF
    And inform a cpf number "<type>"
    And click in termo de compromisso
    And click contratar agora
    And fill confirme seus dados
    Examples:
      | TS      | Scenario      | Description                       |type |
      | 001     | 001           | Consumidor Consulta CPF valido    |v    |

  @ConsumidorCadastro
  Scenario Outline: TS:["<TS>"] - [SPC Brasil consumidor Cadastro]  - "<Scenario>" - "<Description>"
    And click in faca seu cadastro
    And send a name "<Name>"
    And inform a cpf number "<type>"
    And send Data de nascimento
    And send email
    And send Celular
    And send Password
    And agree terms
    And Confirm by email
    Examples:
      | TS      | Scenario      | Description           |Name            |type|
      | 001     | 001           | Consumidor Cadastro   |Luis Bressan    |   n|



