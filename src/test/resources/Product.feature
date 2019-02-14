Feature: 

	
	@BRIT-4018
	Scenario: Creating new product
		
		Scenario: Created product is displayed test
		    Given user on login page
		    When  user logs in using "n_manager@info.com" and "Wdf4ssa44"
		    Then  user should see these links on the top
		    Then  user clicks on sales link,then products link
		    Then  user should see these buttons on the top left
		    Then  user clicks on create button
		    When  user enters name of the product as "ApplesGreen" then saves it
		    Then  user should be able to see the created product on the page.
		
		
		Scenario: Creating product with blank name test
		    Given user on login page
		    When user logs in using "in_manager2@info.com" and "Wdf4ssa45"
		    Then user clicks on sales link,then products link
		    Then  user should see these buttons on the top left
		      |Create|
		      |Import|
		    Then  user clicks on create button
		    When user enters name of the product as "" then saves it
		    Then user should receive "The following fields are invalid:Name" error
		
		
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
		    When  user enters valid credentials
		    Then  user clicks on create button
		    Then  user should be able to see the created product on the page.
		
		