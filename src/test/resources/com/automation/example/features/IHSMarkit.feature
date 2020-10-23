@web @register

Feature: IHSMarkit PCM

  Background: User Has already navigated to the site under test

  Scenario: User Test 1 Hello World
    When the user selects run
    Then then "Hello World" is displayed in the output console


  Scenario Outline: User Test 2 name: "<name>" and condition: "<validation>"

    Given the user enters the "<name>"
    Then then the appropriate actions and validations ("<validation>)"
    Examples:
      | name  | validation              |
      | Apple | First Validation ABCDE  |
      | bpple | First Validation ABCDE  |
      | cpple | First Validation ABCDE  |
      | dpple | First Validation ABCDE  |
      | Epple | First Validation ABCDE  |
      | fpple | Second Validation GHIJK |
      | Gpple | Second Validation GHIJK |
      | Hpple | Second Validation GHIJK |
      | Ipple | Second Validation GHIJK |
      | jpple | Second Validation GHIJK |
      | Kpple | Second Validation GHIJK |
      | Lpple | Third Validation LMNOP  |
      | mpple | Third Validation LMNOP  |
      | npple | Third Validation LMNOP  |
      | Opple | Third Validation LMNOP  |
      | Pxxle | Third Validation LMNOP  |
      | Qpple | Fourth Validation QRSTU |
      | Rpple | Fourth Validation QRSTU |
      | Spple | Fourth Validation QRSTU |
      | Tpple | Fourth Validation QRSTU |
      | upple | Fourth Validation QRSTU |
      | Vpple | Fifth Validation VWXYZ  |
      | Wpple | Fifth Validation VWXYZ  |
      | Xpple | Fifth Validation VWXYZ  |
      | Ypple | Fifth Validation VWXYZ  |
      | Zpple | Fifth Validation VWXYZ  |






