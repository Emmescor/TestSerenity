Feature: Adding item to shopping cart
  In order to buy items
  As a customer
  I want to add several item to the shopping cart
  

  Scenario: Adding items to the shopping cart
    Given the user is logged in into the NinjaStore home page with the credentials "emmescoro@gmail.com" , "#Ninjastore"
    When the user looks up for the products and add them to the shopping cart
    Then the user should see the shopping cart list