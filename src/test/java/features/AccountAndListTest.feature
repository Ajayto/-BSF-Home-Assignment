Feature: Verify Acount and list feature

  @Assignment
  Scenario Outline: Verify that you cannot see Your Orders and Your Addresses pages if you are notlogged in. but you can see Your Lists intro screen
    Given I am on landing page
    When Select menu as "<menu_yourOrder>" from account and list
    Then Verify login page is displayed
    When I navigate back
    And Select menu as "<menu_yourAddress>" from account and list
    Then Verify login page is displayed
    When I navigate back
    And Select menu as "<menu_yourList>" from account and list
    Then Verify list page is displayed with text "<listText>"

    Examples: 
      | menu_yourOrder | menu_yourAddress | menu_yourList | listText|
      | Your Orders    | Your Addresses   | Your Lists    | Lists\nfor all your shopping needs\nSign In|
