Feature: Student flow
   A user should be able list all courses and have only the read access
  
  Scenario: A user with student authorities has access to the courses list page
    Given a user entered student credentials on the login page
    When the user clicks the SignIn button on the login page
    Then the user goes to the home page
    * the user clicks the courses button
    * the user goes to the courses list page
  
    

