#Language : En
#encoding: utf-8

@IntegrationTest
@LoginTest
Feature: Evidences


  @GetEvidencesDellBlue
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>"
    Examples:
      | TS  | Scenario | Description                      |origim|path                                                                          |
      | 001 |    0001  |Get evidence from MW DELLBLUE     |DELLBLUE|\\\\10.10.0.27\\server2\\evidencias\\MWPOS\\Pipeline\\Automation            |


  @GetEvidencesDellGray
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>"
    Examples:
      | TS  | Scenario | Description                      |origim|path                                                                          |
      | 001 |    0001  |Get evidence from MW DELLGRAY     |DELLGRAY|\\\\10.10.0.25\\ServerRoot\bressan\\evidencias\\MWPOS\\Pipeline\\Automation |

  @GetEvidencesLenovo
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>"
    Examples:
      | TS  | Scenario | Description                      |origim|path                                                                          |
      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\10.10.0.3\evidenciass\MWPOS                                               |

  @GetEvidencesOthers
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>"
    Examples:
      | TS  | Scenario | Description                      |origim|path                                                                          |
      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\10.10.0.3\evidenciass\MWPOS                                               |
      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\\\10.10.0.5\\evidencias\TRENDALYTICS                                      |
      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB|\\\\10.10.0.5\\evidencias\\MWPOS\\Pipeline\\Automation                       |
      | 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\evidenciasServidorC\\MWPOS\\Pipeline\\Automation             |
      | 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\evidenciasServidorC\\TRENDALYTICS                            |
      | 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\server01\\evidencias                                         |



