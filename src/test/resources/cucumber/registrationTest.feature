Feature: Registration user Tests

  Background:
    Given Page is loaded

  Scenario: New user registration test

    When The user closes the notification window at the bottom of the page
    And The user clicks the "Moje konto" button from the top menu
    And The user enters the correct email address and password and clicks the Register button
    Then The user is successfully registered and redirected to the 'Moje konto' page

  Scenario: Attempt to register a user with a weak password

    When The user closes the notification window at the bottom of the page
    And The user clicks the "Moje konto" button from the top menu
    And The user provides a valid e-mail address and a weak password and clicks the Register button
    Then Message appears: Bardzo slabe - Prosze wpisac mocniejsze haslo.

  Scenario: Attempt to register a user with an incorrect email address

    When The user closes the notification window at the bottom of the page
    And The user clicks the "Moje konto" button from the top menu
    And The user provides an incorrect e-mail address and password and clicks the Register button
    Then Message appears: Blad: Podaj poprawny adres e-mail.







