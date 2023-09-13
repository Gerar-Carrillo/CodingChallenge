Feature: placing an order

  @all@test_3
  Scenario Outline: Place an order and validate pop up

    Given I go to the "<webPage>"
    When I click on Login button
    And I login with my "<user>" and "<pass>"
    Then I click on "<category>"
    Given I select a product to buy
    When I add it to the cart
    And Add other product to the cart of "<category2>"
    And Remove an item from the cart
    Then I place the order with a "<name>","<country>","<city>","<creditCard>","<month>" and "<year>"
    And The system show the "<creditCard>" and "<name>"
    Examples:
      | webPage                    | user           | pass                     | category | name | country      | city      | creditCard | month      | year | category2 |
      | https://www.demoblaze.com/ | test_000000999 | 8QG5M8pu+ZmijJMvEZ5zBQ== | Phones   | test | country_test | city_test | 40984098   | month_test | 2020 | Phones    |
