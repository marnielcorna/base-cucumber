@web
Feature: An example

  Scenario: Access the application
    Given I am in the login page
    When I access the application with 'admin' credentials
    When I search for text 'Cars'
    #Then Google returns cars