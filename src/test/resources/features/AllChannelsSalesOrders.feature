
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

    Scenario:  Sales manager applied saved search from Favorites and can delete them.
      Given filter applied on the search page
      When sales manager applies the "sale1" and delete it
      Then "sale1" option should no longer be on the favorites menu

    Scenario:  Sales manager shared the search results with all users
      Given filter applied on the search page
      When sales manager saves the current search results as "sale7" and check the "Share with all users" box
      Then favorites menu should have the "sale7" option

    Scenario:  Sales manager applied and delete the shared search results with all users
      Given filter applied on the search page
      When sales manager applies the shared search result and delete it from the favorites menu
      Then shared "sale2" option should no longer be on the favorites menu

    Scenario:  Sales manager saved current search results as "default search result"
      Given filter applied on the search page
      When sales manager saves the current search result as "sale9" and default results
      And logs out and logs back in to the website
      Then sales manager should see "sale9" label on the search box as a default result

    Scenario:  Sales manager saved search results to Dashboard and be able to access it under the Dashboard Menu
      Given filter applied on the search page
      When sales manager saves the current search results as "sale9" to the Dashboard
      Then sales manager should be able access "sale9" under Dashboard menu

    Scenario:  Sales manager deleted the search results from dashboard.
    When sales manager goes to the Dashboard and delete the "sale9" results
    Then Dashboard menu should no longer have the "sale9" result


    Scenario:  Sales manager added columns to the search results
      When sales manager choose "Product Quantity" under the Measure Menu
      Then search result should show the "Product Quantity" column in in the search result

    @wip
    Scenario:  Sales manager grouped the search results.
      When sales manager choose Group by menu and add "Salesperson" and hit Save Button
      Then search results should be grouped by "Salesperson" criteria
