Feature:  Check Information on Correio´s site

  @CheckCorreios
  Scenario Outline: Check Information cep on Correio´s site with success
    Given that the user is on the home screen "<HomePage>"
    And click in buscar cep
    And fill Buscar no site "<CEP>"
    And cick Buscar
    And check for information "<info1>"
    And check for information "<info2>"
    And check for information "<info3>"
    And check for information "<CEP>"
  Examples:
      | Env      |Description                       |HomePage                                                     |CEP          | info1                                   |info2              |info3         |
      | STAGING  |Find for information on Correios |https://buscacepinter.correios.com.br/app/endereco/index.php  |01418-000     |Alameda Santos - até 484 - lado par    |Cerqueira César	    |São Paulo/SP	|
      | STAGING  |Find for information on Correios |https://buscacepinter.correios.com.br/app/endereco/index.php  |11441-400     |Rua Doutor Júlio Prestes de Albuquerque|Enseada      	    |Guarujá/SP		|





