Feature: verify cart flows

  @Assignment
  Scenario Outline: Verify that Items are added to cart correctly
    Given I am on landing page
    When I navigate to menu "<menu>"
    And I select category as "<category>"
    And I select product with index "<productIndex>"
    And Select quantity as "<quantity>"
    And Navigate to cart
    Then Verify correct item is added in cart

    Examples: 
      | menu          | productIndex | category | quantity |
      | Today's Deals |            1 |        2 |        3 |
