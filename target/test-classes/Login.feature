Feature: Register a new customer, login and checkout few items from the given ecommerce portal

  Background: 
    Given Browser needs to be open to run the scenarios

  Scenario: Sign up as a new customer
  Given I navigate to home page "http://automationpractice.com/index.php"
  And I click on the *Sign in* button
  And I provide my *Email Address* to create an account
  When I fill all the mandatory fields with necessary data
  And I click on the *Register* button
  Then I should be redirected to "My account - My Store" page
  And I should be see *Sign out* button
  
  Scenario: Login to portal with the existing user and valid credentials.
  Given I navigate to home page "http://automationpractice.com/index.php"
  And I click on the *Sign in* button
  And I provide my *Email Address* and *Password*
  And I click on *Sign in* button
  Then "My account - My Store" page is opened
  And My *First Name* is shown at the top right of the page
  And I should be see *Sign out* button 
  And close the browser
  
