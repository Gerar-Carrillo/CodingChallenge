Feature: placing an order

  @all@test_4
  Scenario Outline: Place an order and validate pop up

    Given I go to the "<webPage>"
    When I click on Login button
    And I login with my "<user>" and "<pass>"
    And I click on all categories
    Then The system will have all categories

    Examples:
      | webPage                    | user           | pass                     |  |  |
      | https://www.demoblaze.com/ | test_000000999 | 8QG5M8pu+ZmijJMvEZ5zBQ== |  |  |