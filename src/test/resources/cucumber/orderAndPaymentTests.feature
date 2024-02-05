Feature: Order and payment tests

  Background:

    Given Page is loaded
    Given Home page step definitions are available
    Given My account page step definitions are available
    Given Logged user page step definitions are available
    Given Cart page step definitions are available
    Given Order page step definitions are available

  Scenario: Checkout test

    When The user closes the notification window at the bottom of the page
    And The user will select an offer "Fuerteventura - Sotavento"
    And The user will select an offer "Kurs żeglarski na Mazurach"
    And The user will go to the shopping cart view
    And The user will use the go to payment button
    And The user will provide data in the payment form
    And The user will enter the correct payment card details: card "4242 4242 4242 4242 4240" date "06/24" cvc "123"
    And The user will use the buy and pay button
    Then The user notices that the order has been placed correctly

  Scenario: Checkout test using a card with an incorrect expiration date

    When The user closes the notification window at the bottom of the page
    And The user will select an offer "Kurs żeglarski na Mazurach"
    And The user will go to the shopping cart view
    And The user will use the go to payment button
    And The user will provide data in the payment form
    And The user will enter the correct payment card details: card "4242 4242 4242 4242 4240" date "06/19" cvc "123"
    And The user will use the buy and pay button
    Then The user notices that the order has not been placed because the card has expired





