Feature: Teacher flow
  A user should be able list all courses and have only the read access
  
  Background: A user has the teacher authorities
    Given a user enters teacher credentials on the login page
    When the user clicks the SignIn button on the login page
    Then the user goes to the home page
      
  Scenario: A user with teacher authorities should be able to list courses
    When the user clicks the courses button
    * the user goes to the courses list page
    
  Scenario: A user with teacher authorities has no access to create a course
    Given a user sees the courses list page
    When the user clicks the create button
    Then the user enters a course name on the create course panel
    * the user enters a course desctiption on the create course panel
    * the user clicks the save changes button on the create course panel
    * the user request is denied
    
  Scenario: A user with teacher authorities has access to receive a course
    Given a user sees the courses list page
    When the user clicks an existence course name link
    Then the user goes to a course page 
  
  Scenario: A user with teacher authorities has no access to update a course
    Given a user sees the courses list page
    When the user clicks an existence course name link
    Then the user goes to a course page
    * the user enters a new course name into the input field
    * the user enters new course description into the input field
    * the user clicks the save changes button on the course page
    * the user request is denied
    
  Scenario: A user with teacher authrorities has no access to delete a course
    Given a user sees the courses list page
    When the user clicks the delete course button of a existence course
    Then the created course is not present on the courses list page   
    