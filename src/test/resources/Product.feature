
@wip
Feature:Creating new product


  @BRIT-4018
  Scenario: Created product is displayed test
    Given user on login page
    When  user logs in using "in_manager2@info.com" and "Wdf4ssa45"
    Then  user clicks on sales link,then products link
    Then  user clicks on create button
    When  user enters name of the product as "Avocado" then saves it
    Then  user should be able to see the "Avocado" on the page.


  Scenario: Creating product with blank name test
    Given user on login page
    When user logs in using "in_manager2@info.com" and "Wdf4ssa45"
    Then user clicks on sales link,then products link
    Then  user should see these buttons on the top left
      | Create |
      | Import |
    Then  user clicks on create button
    When user enters name of the product as "" then saves it
    Then user should receive "The following fields are invalid:" error


  Scenario: Creating product with valid credentials
    Given user on login page
    When user logs in using "in_manager2@info.com" and "Wdf4ssa45"
    Then user clicks on sales link,then products link
    Then user clicks on create button
    When user should see these product information headers

      | Product Type       |
      | Category           |
      | Internal Reference |
      | Barcode            |
      | Sales Price        |
      | Cost               |
    When  user enters name of the product as "Feta Cheese" then saves it
    When  user enters valid credentials
    Then  user clicks on save button
    Then  user should be able to see the "Feta Cheese" on the page.
		
		
		     
