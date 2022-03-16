#Language : En
#encoding: utf-8

@IntegrationTest
@LoginTest
Feature: Evidences


  @GetEvidencesDellBlue
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>" "<Sit>"
    Examples:
      | TS  | Scenario | Description                      |origim|path                                                                          |Sit|
      | 001 |    0001  |Get evidence from MW DELLBLUE     |DELLBLUE|\\\\10.10.0.27\\server2\\evidencias\\MWPOS\\Pipeline\\Automation            |Copy|
      | 001 |    0001  |Get evidence from MW DELLBLUE     |DELLBLUE|\\\\10.10.0.27\\server2\\evidencias\\MWPOS\\Pipeline\\Automation            |Del |


  @GetEvidencesDellGray
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>" "<Sit>"
    Examples:
      | TS  | Scenario | Description                      |origim|path                                                                          |Sit|
      | 001 |    0001  |Get evidence from MW DELLGRAY     |DELLGRAY|\\\\10.10.0.25\\ServerRoot\bressan\\evidencias\\MWPOS\\Pipeline\\Automation |Copy|
      | 001 |    0001  |Get evidence from MW DELLGRAY     |DELLGRAY|\\\\10.10.0.25\\ServerRoot\bressan\\evidencias\\MWPOS\\Pipeline\\Automation |Del|

  @GetEvidencesLenovo
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>" "<Sit>"
    Examples:
      | TS  | Scenario | Description                    |origim|path                                                                          |Sit|
      | 001 |    0001  |Get evidence from TL lenovo     |BRT-NTB |\\\\10.10.0.8\\evidenciass\\MWPOS\\Pipeline\\Automation                     |Copy|
      | 001 |    0001  |Get evidence from TL lenovo     |BRT-NTB |\\\\10.10.0.8\\evidenciass\\MWPOS\\Pipeline\\Automation                     |Del |

  @GetEvidencesOthers
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>" "<Sit>"
    Examples:
      | TS  | Scenario | Description                      |origim|path                                                                          |Sit|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\10.10.0.3\evidenciass\MWPOS                                               |Copy|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\\\10.10.0.5\\evidencias\TRENDALYTICS                                      |Copy|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB|\\\\10.10.0.5\\evidencias\\MWPOS\\Pipeline\\Automation                       |Copy|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\evidenciasServidorC\\MWPOS\\Pipeline\\Automation             |Copy|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\evidenciasServidorC\\TRENDALYTICS                            |Copy|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\server01\\evidencias                                         |Copy|

      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\10.10.0.3\evidenciass\MWPOS                                               |Del|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\\\10.10.0.5\\evidencias\TRENDALYTICS                                      |Del|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB|\\\\10.10.0.5\\evidencias\\MWPOS\\Pipeline\\Automation                       |Del|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\evidenciasServidorC\\MWPOS\\Pipeline\\Automation             |Del|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\evidenciasServidorC\\TRENDALYTICS                            |Del|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\server01\\evidencias                                         |Del|



