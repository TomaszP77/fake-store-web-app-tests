Feature: Log in user tests

  Background:
    Given Page is loaded
    Given Home page step definitions are available
    Given My account page step definitions are available
    Given Logged user page step definitions are available

  Scenario: Log in test
    When The user closes the notification window at the bottom of the page
    And The user clicks the "Moje konto" button from the top menu
    And In the log in section, the user enters the correct email address and password, then clicks the log in button
    Then The user is successfully logged into the account

  Scenario: Log in the user with wrong data test
    When The user closes the notification window at the bottom of the page
    And The user clicks the "Moje konto" button from the top menu
    And In the log in section, the user enters the incorrect email address and password, then clicks the log in button
    Then Message appears: Blad: brak 1234 wsrod zarejestrowanych w witrynie uzytkownikow.




