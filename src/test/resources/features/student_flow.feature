Feature: Student flow
  A user should be able list all courses and have only the read access
   
  Background: A user authorized as student
    Given a user entered student credentials on the login page
    When the user clicks the SignIn button on the login page
    Then the user goes to the home page
  
  Scenario: A user with student authorities has access to the courses list page
    When the user clicks the courses button
    * the user goes to the courses list page
  
  Scenario: A user with sutdent authorities tries to create a course
    When the user clicks the courses button
    Then the user goes to the courses list page
    * the user clicks the create button
    * the user enters a course name on the create course panel
    * the user enters a course desctiption on the create course panel
    * the user clicks the save changes button on the create course panel
    * the user request to create a course is denied

