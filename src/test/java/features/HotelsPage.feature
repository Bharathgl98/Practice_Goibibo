Feature: Hotel Search

Background:
#Given setup the entries in database
#When launch the browser from config variables
#And hit the home page URL of hotel site

Scenario:  Hotel search within India
Given user is on the Goibibo hotel search page
When user click on India
And user enter the location "Majestic"
And user select the check-in date as "10" "November 2024" and check-out date as "15" "November 2024"

And user select the number of Guests as "5" Child as "1" and childAge as "2" and Rooms "1"
And user click on the search button
Then user should see a list of hotels in "Majestic"

#Scenario: User searches for hotels in Bangalore
#Given user is on the Goibibo hotel search page for Bangalore
#And user enters "Bangalore" in the location input field
#Then the user should see a list of available hotels in Bangalore
#And user should see the check-in and check-out dates displayed correctly
#And user should see the number of guests displayed correctly
#And user should see sort by options
#Then based on sorted option  user can select hotels in Bangalore




