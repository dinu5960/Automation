Feature: To Validate login fuctionality in facebook application

Scenario: To validate login using invalid username and password

Given User is in facebook login page

When User enter invalid username and password

And User click the login button

Then User should be in invalid credentials page


