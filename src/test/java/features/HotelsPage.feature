Feature: Hotel Search

Background:
#Given setup the entries in database
#When launch the browser from config variables
#And hit the home page URL of hotel site

Scenario:  Hotel search within India
Given user is on the Goibibo hotel search page
When user click on India
And user enter the location " Bangalore"
And user select the check-in date "2024-09-30"
And user select the check-out date "2024-10-02"
And user select the number of Guests and Rooms
And user click on the search button
Then user should see a list of hotels in " Bangalore"

#Scenario: User searches for hotels in Bangalore
#Given user is on the Goibibo hotel search page for Bangalore
#And user enters "Bangalore" in the location input field
#Then the user should see a list of available hotels in Bangalore
#And user should see the check-in and check-out dates displayed correctly
#And user should see the number of guests displayed correctly
#And user should see sort by options
#Then based on sorted option  user can select hotels in Bangalore




Feature: Flight Booking

  Scenario: Search for flights
    Given I am on the Goibibo flight search page
    When I enter "New Delhi" as the departure city
    And I enter "Mumbai" as the arrival city
    And I select the departure date as "2024-10-15"
    And I click on the "Search Flights" button
    Then I should see a list of available flights from "New Delhi" to "Mumbai"

  Scenario: Search for round trip flights
    Given I am on the Goibibo flight search page
    When I enter "New Delhi" as the departure city
    And I enter "Mumbai" as the arrival city
    And I select the departure date as "2024-10-15"
    And I select the return date as "2024-10-20"
    And I click on the "Search Flights" button
    Then I should see a list of available round trip flights from "New Delhi" to "Mumbai"

  Scenario: Filter flights by price
    Given I have searched for flights from "New Delhi" to "Mumbai"
    When I apply a price filter of "2000" to "5000"
    Then I should see flights within the price range of "2000" to "5000"

  Scenario: Select a flight
    Given I have searched for flights from "New Delhi" to "Mumbai"
    When I select the first available flight
    Then I should be taken to the flight details page

  Scenario: Book a flight
    Given I have selected a flight from "New Delhi" to "Mumbai"
    When I enter passenger details with name "John Doe" and age "30"
    And I provide contact information "johndoe@example.com"
    And I click on the "Book Now" button
    Then I should see a confirmation message for the booking

  Scenario: Validate error message for invalid date
    Given I am on the Goibibo flight search page
    When I enter "New Delhi" as the departure city
    And I enter "Mumbai" as the arrival city
    And I select an invalid departure date as "2024-02-30"
    And I click on the "Search Flights" button
    Then I should see an error message indicating the date is invalid

  Scenario: Check for seat selection
    Given I have selected a flight from "New Delhi" to "Mumbai"
    When I navigate to the seat selection page
    Then I should see available seats for selection

  Scenario: Validate booking cancellation
    Given I have booked a flight from "New Delhi" to "Mumbai"
    When I navigate to the booking management page
    And I select the booking to cancel
    And I click on the "Cancel Booking" button
    Then I should see a confirmation message for the cancellation

  Scenario: Check for special offers
    Given I am on the Goibibo flight search page
    When I search for flights from "New Delhi" to "Mumbai"
    Then I should see any applicable special offers or discounts displayed

