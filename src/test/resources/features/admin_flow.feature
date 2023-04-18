Feature: Admin flow
  The actions that can be done by a user with the admin authorities

  Background: A user has the admin authorities
    Given a user enters admin credentials on the login page
    When the user clicks the SignIn button on the login page
    Then the user goes to the home page

  Scenario: A user should be able to navigate to the admin panel
    Given the user sees the admin panel button on the home page
    When the user clicks the admin panel button on the home page
    Then the user sees the admin panel page

  Scenario Outline: A user should be able to set required role for each registered user
    Given the user sees the admin panel button on the home page
    When the user clicks the admin panel button on the home page
    Then the user sees the admin panel page
    And the user clicks the Edit button of a user that has an email
    And the user selects <role> authority
    And the user clicks the SaveChanges button
    And the user sees the <role> authority of user in the list

    Examples: 
      | role  |
      | admin |
      | staff |

  Scenario: A user should be able to authorize a user
    Given the user sees the admin panel button on the home page
    When the user clicks the admin panel button on the home page
    Then the user sees the admin panel page
    * the user clicks the authorize button of a user with id
    * the user select authority in the authorize menu 
    * the user selects active status in the authorize menu
    * the user enters a password and confirm password
    * the user click the athorize button in the authorize menu
    * the user sees updated data of the user on the admin panel
    
  Scenario: A user should be able to create a course
    Given a user sees the courses button on the home page
    When the user clicks the courses button
    Then the user goes to the courses list page
    * the user clicks the create button
    * the user enters a course name on the create course panel
    * the user enters a course desctiption on the create course panel
    * the user clicks the save changes button on the create course panel
    * the created course is present on the courses list page
  
  Scenario: A user should be able to retrieve a course
    Given a user sees the courses list page
    When the user clicks a course name link
    Then the user goes to a course page  
  
  Scenario: A user should be able to update a course
    Given a user sees the courses list page
    When the user clicks a course name link    
    Then the user goes to a course page
    * the user enters a new course name into the input field
    * the user enters new course description into the input field
    * the user clicks the save changes button on the course page
    * the user sees updated couse data on the course page 
    
  Scenario: A user should be able to delete a course
    Given a user sees the courses list page
    When the user clicks the delete course button
    Then the course is not present on the courses list page
