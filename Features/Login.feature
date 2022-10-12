Feature: Login
Scenario: Successful Login With Valid Credential
  Given User Launch Chrome Browser
  When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
  And User Enters Email as "admin@yourstore.com" and Password as "admin"
  And Click on Login
  Then Page Title should be "Dashboard / nopCommerce administration"
  When User CLik on Logout Link
  Then Page Title should be "Your store. Login"
  And Close Browser
  Scenario: Login With DataDriven
    Given User Launch Chrome Browser
    When User opens URL "https://admin-demo.nopcommerce.com/login?ReturnUrl=%2Fadmin%2F"
    And User Enters Email as "<email>" and Password as "<password>"
    And Click on Login
    Then Page Title should be "Dashboard / nopCommerce administration"
    When User CLik on Logout Link
    Then Page Title should be "Your store. Login"
    And Close Browser
    Examples:
    |email|password|
    | admin@yourstore.com |admin|
    | admin@yourstore.com |admin123|