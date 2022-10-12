Feature:Customer
Scenario:  Add a New Customer
  Given User Launch Chrome Browser
  When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
  And User Enters Email as "<email>" and Password as "<password>"
  And Click on Login
  Then Page Title should be "Dashboard / nopCommerce administration"
  Then User Can view the Dashboard
  When User clicks the Customer's Menu
  And Clicks on Customer's Menu Item
  And Click on Add New Button
  Then User can view Add New Customer Page
  When User enter the customer info
  And Click on save button
  Then user can view confirmation message "The new customer has been added successfully."
  When User CLik on Logout Link
  Then Page Title should be "Your store. Login"
  And Close Browser
  Examples:
    |email|password|
    |admin@yourstore.com|admin|
  Scenario: Search Customer by EmailID
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User Enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    Then User Can view the Dashboard
    When User clicks the Customer's Menu
    And Clicks on Customer's Menu Item
    And Enter the Customer Email
    When Click on the Search Button
    Then User should found Email in the Search Table
    And Close Browser
    Examples:
      |email|password|
      |admin@yourstore.com|admin|