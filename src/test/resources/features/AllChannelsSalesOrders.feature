
  Feature: All Channels Sales Orders Page


    Background:
      Given user on the login page
      When  user logs in using these "in_manager2@info.com" and "Wdf4ssa45"
      When sales manager clicks on a sales link, then All Channels Sales Orders link


    Scenario:  Sales manager applied filter to the search results.
      When sales manager selects "Total" as filter criteria
      And sales manager selects "less than" as a second filter criteria
      And sales manager types "20000" as a filter value
      And sales manager hits the apply button
      Then search results should be displayed based on the applied filter


    Scenario:  Sales Manager saved search results to Favorites Menu
      Given filter applied on the search page
      When sales manager hits favorites menu and save the the current search result as a "sale1"
      Then search result should be saved to the favorites menu

    Scenario:  Sales manager saved current search results as "default search result"

    Scenario:  Sales manager saved search results to Dashboard and be able to access it under the Dashboard Menu

    Scenario:  Sales manager grouped the search results.

    Scenario:  Sales manager applied saved search from Favorites and can delete them.

    Scenario:  Sales manager shared the search results with all users

    Scenario:  Sales manager applied and delete the shared search results with all users

    Scenario:  Sales manager deleted the search results from dashboard.

    Scenario:  Sales manager added columns to the search results


