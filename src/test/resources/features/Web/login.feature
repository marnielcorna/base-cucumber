@web
Feature: An example

  Scenario: Add a Perfume that costs less than 30 Euros.
    Given I am in the login page
    When I access the application with 'admin' credentials
    When I search for text 'Perfume'
    #When The perfume costs less than 30 euros.
    #Then Google returns cars