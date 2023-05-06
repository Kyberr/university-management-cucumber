Feature: The Staff flow
  A user should be able to create/read/update all courses
  A user should be able to assign/deassign teacher to a course
  A user should be able to assign/deassign groups to a course

  Background: A user loged in with staff role
    Given a user enters staff credentials on the login page
    When the user clicks the SignIn button on the login page
    Then the user goes to the home page
    
  Scenario: A user should be able to assign groups to a course

  

  Scenario: A user with staff authorities should be able to assign teacher to a course
    Given a user sees the courses list page
    When the user clicks a present course name link
    Then the user goes to a course page
    * the user clicks the assign teacher button
    * the user select a teacher to a course
    * the user clicks the save changes button
    * the user sees the selected teacher on the course page
    
  Scenario: A user with staff authorities should be able to deassign teacher to a course
    Given a user sees the courses list page
    When the user clicks a present course name link
    Then the user goes to a course page
    * the user clicks the deassign teacher button
    * the user clicks the deassign confirm button
    * the couse page has no the deassigned teacher

  Scenario: A user with staff authorities should be able to create a course
    Given a user sees the courses list page
    When the user clicks the create button
    Then the user enters a course name on the create course panel
    * the user enters a course desctiption on the create course panel
    * the user clicks the save changes button on the create course panel
    * the created course is present on the courses list page

  Scenario: A user with staff authorities should be able to receive a course
    Given a user sees the courses list page
    When the user clicks a present course name link
    Then the user goes to a course page

  Scenario: A user with staff authorities should be able to update a course
    Given a user sees the courses list page
    When the user clicks the created course name link
    Then the user goes to a course page
    * the user enters a new course name into the input field
    * the user enters new course description into the input field
    * the user clicks the save changes button on the course page
    * the user sees updated couse data on the course page
