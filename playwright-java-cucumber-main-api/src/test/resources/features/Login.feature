Feature: Login Page feature

  @smoke @login
  Scenario: Verify User is able to login to Hudl with correct credentials
    Given user navigates to "url"
    When user clicks Login button
    And user clicks on Hudl icon in main page
    Then verify that user is navigated to main page for log in
    And user enters "username" username
    And user enters "password" password
    And user clicks Continue button
    And verify that user is logged in and navigated to user Profile page
    And user clicks Logout button

  @smoke @login @invalidUsername @errorText
  Scenario: Verify User is not able to login to Hudl with invalid username
    Given user navigates to "url"
    When user clicks Login button
    And user clicks on Hudl icon in main page
    Then verify that user is navigated to main page for log in
    And user enters "invalidUsername" username
    And user enters "password" password
    And user clicks Continue button
    Then verify the error text for invalid credentials

  @smoke @login @invalidPassword @errorText
  Scenario: Verify User is not able to login to Hudl with invalid password
    Given user navigates to "url"
    When user clicks Login button
    And user clicks on Hudl icon in main page
    Then verify that user is navigated to main page for log in
    And user enters "username" username
    And user enters "invalidPassword" password
    And user clicks Continue button
    Then verify the error text for invalid credentials

  @smoke @login @blankPassword @errorText
  Scenario: Verify User is not able to login to Hudl with blank username
    Given user navigates to "url"
    When user clicks Login button
    And user clicks on Hudl icon in main page
    Then verify that user is navigated to main page for log in
    And user enters "blankUsername" username
    And user enters "password" password
    And user clicks Continue button
    Then verify the blank error text for credentials

  @smoke @login @blankPassword @errorText
  Scenario: Verify User is not able to login to Hudl with blank password
    Given user navigates to "url"
    When user clicks Login button
    And user clicks on Hudl icon in main page
    Then verify that user is navigated to main page for log in
    And user enters "username" username
    And user enters "blankPassword" password
    And user clicks Continue button
    Then verify the blank error text for credentials

  @smoke @login @blankEmailAndPassword @errorText
  Scenario: Verify User is not able to login to Hudl with blank email and password
    Given user navigates to "url"
    When user clicks Login button
    And user clicks on Hudl icon in main page
    Then verify that user is navigated to main page for log in
    And user enters "blankUsername" username
    And user enters "blankPassword" password
    And user clicks Continue button
    Then verify the blank error text for credentials