Feature: Train Booking   

	Scenario: User searches for trains between two stations     

		Given the user is on the Goibibo train booking homepage     
		When the user enters "New Delhi" in the "From" field     
		And the user enters "Mumbai" in the "To" field     
		And the user selects "2024-10-20" as the travel date     
		And the user clicks on the "Search Trains" button     
		Then the user should see a list of available trains from New Delhi to Mumbai     
		And the user should see the travel date as "2024-10-20"     
		And the user should see a "Book Now" button for each train option 


Feature: Train Booking

	Scenario: User searches for trains between two stations

		Given the user is on the Goibibo train booking homepage     
		When the user enters <From Name> in the "From" field     
		And the user enters <To Name> in the "To" field     
		And the user selects <Date> as the travel date     
		And the user clicks on the "Search Trains" button     
		Then the user should see a list of available trains from New Delhi to Mumbai     
		And the user should see the travel date as "2024-10-20"     
		And the user should see a "Book Now" button for each train option 

Examples: 

| From Name | To Name | Date |
| Bangalore | Tumkur  | 1-10-2024|
