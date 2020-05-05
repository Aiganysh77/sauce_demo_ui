@apidemo
Feature: Make GET, POST, PUT, DELETE calls


  Scenario: Validating CRUD operations
    Given User validates get method with the "/posts/1"
    And User validates post method with "/posts"
    And User validates put method with "/posts/1"
    Then User validates delete method with "/posts/1"



