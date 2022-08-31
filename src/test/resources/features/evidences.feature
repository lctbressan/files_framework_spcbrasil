#Language : En
#encoding: utf-8

@IntegrationTest
@LoginTest
Feature: Evidences


  @GetEvidencesDellBlue @GetEvidences
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>" "<Sit>"
    Examples:
      | TS  | Scenario | Description                      |origim|path                                                                          |Sit|
      | 001 |    0001  |Get evidence from MW DELLBLUE     |DELLBLUE|\\\\10.10.0.27\\server2\\evidencias\\MWPOS\\Pipeline\\Automation            |Copy|
      #| 001 |    0001  |Get evidence from MW DELLBLUE     |DELLBLUE|\\\\10.10.0.27\\server2\\evidencias\\MWPOS\\Pipeline\\Automation            |Del |


  @GetEvidencesDellGray @GetEvidences
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>" "<Sit>"
    Examples:
      | TS  | Scenario | Description                      |origim|path                                                                          |Sit|
      | 001 |    0001  |Get evidence from MW DELLGRAY     |DELLGRAY|\\\\10.10.0.25\\ServerRoot\bressan\\evidencias\\MWPOS\\Pipeline\\Automation |Copy|
      #| 001 |    0001  |Get evidence from MW DELLGRAY     |DELLGRAY|\\\\10.10.0.25\\ServerRoot\bressan\\evidencias\\MWPOS\\Pipeline\\Automation |Del|

  @GetEvidencesLenovo @GetEvidences
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>" "<Sit>"
    Examples:
      | TS  | Scenario | Description                    |origim|path                                                                          |Sit|
      | 001 |    0001  |Get evidence from TL lenovo     |BRT-NTB |\\\\10.10.0.3\evidenciass\MWPOS\\Pipeline\Automation                     |Copy|
      #| 001 |    0001  |Get evidence from TL lenovo     |BRT-NTB |\\\\10.10.0.8\evidenciass\MWPOS\Pipeline\Automation                     |Del |

  @GetEvidencesOthers @GetEvidences
  Scenario Outline: TS:["<TS>"] - [Evidence generator]  - "<Scenario>" - "<Description>"
    Given that i copy all files from path "<path>" "<Sit>"
    Examples:
      | TS  | Scenario | Description                      |origim|path                                                                          |Sit|
      | 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\\\10.10.0.50\evidencias\MWPOS\Pipeline\Automation                                                   |Copy|
      #| 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\\\10.10.0.5\\evidencias\TRENDALYTICS                                      |Copy|
      #| 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB|\\\\10.10.0.5\\evidencias\\MWPOS\\Pipeline\\Automation                       |Copy|
      #| 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\evidenciasServidorC\\MWPOS\\Pipeline\\Automation             |Copy|
      #| 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\evidenciasServidorC\\TRENDALYTICS                            |Copy|
      #| 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\server01\\evidencias                                         |Copy|

      #| 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\10.10.0.3\evidenciass\MWPOS                                               |Del|
      #| 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB |\\\\10.10.0.5\\evidencias\TRENDALYTICS                                      |Del|
      #| 001 |    0001  |Get evidence from TL DELLGRAY     |BRT-NTB|\\\\10.10.0.5\\evidencias\\MWPOS\\Pipeline\\Automation                       |Del|
      #| 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\evidenciasServidorC\\MWPOS\\Pipeline\\Automation             |Del|
      #| 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\evidenciasServidorC\\TRENDALYTICS                            |Del|
      #| 001 |    0001  |Get evidence from TL DELLGRAY     |SRV    |\\\\10.10.0.10\\server01\\evidencias                                         |Del|





  @ConvertAllfiles
  Scenario Outline: TS:["<TS>"] - [Convert files generator]  - "<Scenario>" - "<Description>"
    Given that i convert all files from path "<path>"
    Examples:
      | TS  | Scenario | Description |path                                                   |
      | 001 |    0001  |Convert Video|\\\\10.10.0.10\\f\\evidencias\\      |




  @DeleteAllFolders50
  Scenario Outline: TS:["<TS>"] - [Convert files generator]  - "<Scenario>" - "<Description>"
    Given that i remove all folders from path "<path>"
    Examples:
      | TS  | Scenario | Description                      |origim|  path                                |
      | 001 |    0001  |Get evidence from MW DELLBLUE     |BRT-NTB |\\\\10.10.0.50\evidencias\MWPOS\Pipeline\Automation              |

  @DeleteAllFolders3
  Scenario Outline: TS:["<TS>"] - [Convert files generator]  - "<Scenario>" - "<Description>"
    Given that i remove all folders from path "<path>"
    Examples:
      | TS  | Scenario | Description                      |origim|  path                                |
      | 001 |    0001  |Get evidence from TL lenovo     |BRT-NTB |\\\\10.10.0.3\evidenciass\MWPOS\\Pipeline\Automation                     |

  @DeleteAllFolders27
  Scenario Outline: TS:["<TS>"] - [Convert files generator]  - "<Scenario>" - "<Description>"
    Given that i remove all folders from path "<path>"
    Examples:
      | TS  | Scenario | Description                      |origim|  path                                |
      | 001 |    0001  |Get evidence from MW DELLBLUE     |DELLBLUE|\\\\10.10.0.27\\server2\\evidencias\\MWPOS\\Pipeline\\Automation            |

  @DeleteAllFolders25
  Scenario Outline: TS:["<TS>"] - [Convert files generator]  - "<Scenario>" - "<Description>"
    Given that i remove all folders from path "<path>"
    Examples:
      | TS  | Scenario | Description                      |origim|  path                                |
      | 001 |    0001  |Get evidence from MW DELLGRAY     |DELLGRAY|\\\\10.10.0.25\\ServerRoot\bressan\\evidencias\\MWPOS\\Pipeline\\Automation |