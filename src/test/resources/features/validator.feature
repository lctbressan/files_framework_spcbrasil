#Language : En
#encoding: utf-8

@IntegrationTest

Feature: Validator
@Validar
  Scenario Outline: TS:["<TS>"] - [Validador XML]  - "<Scenario>" - "<Description>"
    Given valida o xml conta o xsd "<patxsd>" "<xsdName>" "<folderXml>" "<Sit>"
    Examples:
      | TS  | Scenario | Description     |patxsd                       |xsdName            |folderXml                 |Sit     |
      | 001 |    0001  |Validar ACPO111  |C:\\spcbrasil\\xsd\\         |ACPO111.xsd        |C:\\spcbrasil\\Arquivos\\ |Validate|

