@tag
Feature: Calculate Trip Cost in the goibibo website Smoke TestSuite

  @smoke
  Scenario: selecting radio buttons like india or international in goibibo website
    Given user opens the browser with the specified url
    And The user moves their cursor over the navigation bar and clicks on the Hotels tab in goibibo website
    And The user has selected one of the radio buttons on the Goibibo website.

  @smoke
  Scenario: Entering the location by user in the goibibo website
    Given user has to enter the location in the goibibo website

  @smoke
  Scenario: user need to enter checkin and checkout date in the goibibo website
  Given user enter checkin date in the goibibo website
  And user enter checkout date in the goibibo webiste
  
  
  @smoke
  Scenario: User Enter guests and rooms in the goibibo website
  Given user clicks on the guests&rooms icon and enters the no.of adults in the goibibo website
  Then user clicks on the done button in the goibibo website
  And user clicks on search button