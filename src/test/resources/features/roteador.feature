Feature: Home

  @Roteador
  Scenario Outline: TS:["<TS>"] - [reboot Router ]  - "<Scenario>" - "<Description>"
    Given that the user is on the home screen "<HomePage>"
    #And abre a conexao nao particular
    And ir para "<tag0>" e "<tag1>"
    #And Click Login
    And Send login "<login>" and "<Password>"
    And Reinicia o roteador
    Examples:
        | TS  | Scenario | Description    |login   | Password         |HomePage                                      |tag0             |   tag1      |
      | 001 |    0001  |Reboot router     |admin   | 4a1fdbd9         |http://192.168.15.1/cgi-bin/sophia_index.cgi  |Management       |Resets    |
