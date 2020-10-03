Feature: Search in Google
 
  Scenario: Seek for Selenium-Jupiter documentation
    When I navigate to "https://google.com"
    And I type "Selenium-Jupiter"
    And I press Enter
    Then I should be shown results including "Selenium"