Feature: Sign up, log in and log out

  @all@test_1
  Scenario Outline: Create an user to login and log
    Given I go to the "<webPage>"
    When I click on sig up button
    And I register my "<user>" and "<password>"
    Then I login with my "<user>" and "<password>"
    And I log out
    Examples:
      | webPage                    | user           | password                 |  |
      | https://www.demoblaze.com/ | test_000000999 | 8QG5M8pu+ZmijJMvEZ5zBQ== |  |

    @all@test_1
  Scenario Outline: Login with Wrong user
      Given I go to the "<webPage>"
      When I click on Login button
      And Try to connect with a wrong "<user>" and "<pass>"
      Then The system shows an alert
      Examples:
        | webPage                    | user     | pass                     |  |  |
        | https://www.demoblaze.com/ | 1qazxsw2 | fCYUaQ+aN/GBvloGDsKNCQ== |  |  |