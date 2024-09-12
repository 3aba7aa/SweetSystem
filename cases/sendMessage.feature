@tag2
Feature: Send a message to another user
  As a user
  I want to send a message to another user
  So that I can communicate with them

  Scenario: Successfully send a message to an existing user
    Given a user with ID 3 exists and a receiver with name "abd" exists and the receiver is an owner or supplier
    When the user sends a message "Hello!" to receiver with name "abd"
    Then the message "Hello!" should be added to the user's sent messages and the message should be received by the receiver and successful operation message is shown

  Scenario: Fail to send a message to a non-existent receiver
    Given a user with ID 4 exists and a receiver with name "yahya" does not exist
    When the user send a message "Hello!" to receiver with name "yahya"
    Then receiver does not exist message is shown