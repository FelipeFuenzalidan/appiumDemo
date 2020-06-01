@Complete
Feature: Login Test

  Login Test for prepaid and postpaid users

  @Login
  Scenario Outline: Login test with wrong password for the prepaid and postpaid user
    Given I login the <username> and <password>
    Then I verify that the user login successful
    And I logout in the Directv app

    Examples:
      | username          | password |
      | posact1@gmail.com | posact1  |
      | preact2@gmail.com | preact   |


  @WhatsApp
  Scenario: Whatshap Test
    Given I login the posact1@gmail.com and posact1
    Then I verify that the user login successful
    When I press the Ayuda menu
    And I press the Whatsapp button
    Then I verify that it is on WhatsApp
    And I switch to the Directv app
    And I logout in the Directv app


  @ios
  Scenario: Test IOS
    When I type posact1@gmail.com in the field username
    Then I verify that the username is posact1@gmail.com