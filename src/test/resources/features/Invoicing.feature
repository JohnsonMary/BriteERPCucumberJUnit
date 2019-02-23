#@wip
Feature: Orders to Invoice page details


#  @BRIT-4270

  Background:
    Given user on the login page
    When  user logs in using these "in_manager2@info.com" and "Wdf4ssa45"
    Then user clicks on a sales link, then Orders to Invoice link
    When user clicks on Order Number checkbox header

  Scenario:  Checking Order Number checkbox header
    Then user should be able to see print and action tabs

  Scenario:  Action tab test
    Then user clicks on action tab
    And user should be able to see the following dropdown list
      | Export                     |
      | Delete                     |
      | Invoice Order              |
      | Send a Cart Recovery Email |
    Then user clicks export dropdown list
    And user should be able to see the following text
      | Export Data |


  Scenario:  Print tab test
    Then user clicks on print tab
    And user should be able to see the following dropdown menu
      | Quotation / Order |
