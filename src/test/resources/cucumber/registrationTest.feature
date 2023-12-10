Feature: Registration user Tests

  Background:
    Given Page is loaded

  Scenario: New user registration test

    When The user closes the notification window at the bottom of the page
    And The user clicks the "Moje konto" button from the top menu
    And The user enters the correct email address and password and clicks the Register button.
    Then The user is successfully registered and redirected to the 'My account' page.

  Scenario: Attempt to register a user with a weak password

    When The user closes the notification window at the bottom of the page
    And The user clicks the "Moje konto" button from the top menu
    And The user provides a valid e-mail address and a weak password and clicks the Register button.
    Then The user is not registered because his password is too weak.





