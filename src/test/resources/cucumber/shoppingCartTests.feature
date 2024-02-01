Feature:Shopping cart test

  Background:

    Given Page is loaded
    Given Home page step definitions are available
    Given My account page step definitions are available
    Given Logged user page step definitions are available
    Given Shop page step definitions are available
    Given Windsurfing category page step definitions are available
    Given Cart page step definitions are available
    Given Climbing page step definitions are available

  Scenario: Add to cart test

    When The user closes the notification window at the bottom of the page
    And The user clicks the "Moje konto" button from the top menu
    And In the log in section, the user enters the correct email address and password, then clicks the log in button
    And The user clicks the "Sklep" button from the top menu
    And The user will select categories "Windsurfing"
    And The user adds an offer Egipt El Gouna to the cart
    And The user moves the cursor to the quick view of the basket
    And The user presses the Zobacz koszyk button in the basket quick view window
    Then The user notices that the product has been successfully added to the cart

  Scenario: Store cart update test

    When The user closes the notification window at the bottom of the page
    And The user clicks the "Sklep" button from the top menu
    And The user will select categories "Wspinaczka"
    And The user adds the Gran Koscielcow product to the cart
    And The user goes to the cart
    And The user sets the number of products in the basket "4"
    And The user updates the cart
    Then The User then notices that the cart has been successfully updated

  Scenario: Delete product from cart test

    When The user closes the notification window at the bottom of the page
    And The user will select an offer "Windsurfing w Lanzarote (Costa Teguise)"
    And The user will go to the shopping cart view
    And The user removes the item from the cart
    Then The user then notices that the product has been successfully removed from the cart











