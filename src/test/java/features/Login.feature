Feature: Login to the Luma Application

  Scenario: Successful Login
    Given User is on Luma Login page "https://magento.softwaretestingboard.com"
    When the user enters their credentials
    And clicks the "Submit" button
    Then the user should be logged in