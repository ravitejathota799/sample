@tag
Feature: Calculate Trip Cost in the goibibo website Regression TestSuite

  @Regression
  Scenario: user clicks on some filters in the goibibo website
  Given user clicks on the sort by options in the goibibo website
  And user clicks on the customer ratings in the goibibo website
  And user clicks on amenities in the goibibo website
  Then capture the data after applying the sorts and filters
  
  
  
  
