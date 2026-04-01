Feature: The Internet App - Login demo
  This demo is for advanced : HTML reports + Extent + Maven reports + rerun failed scenarios.
  
  
  @smoke
  Scenario: Valid login should PASS
      Given I open the Internet App login page
      When I login with username "tomsmith" and password "SuperSecretPassword!"
      Then I should see message containing "You logged into a secure area!"
      
  @rerun
      Scenario: Invalid login should FAIL (intentional for rerun demo)
      Given I open the Internet App login page
      When I login with username "tomsmith" and password "wrongPassword!"
      Then I should see message containing "Your password is invalid!"