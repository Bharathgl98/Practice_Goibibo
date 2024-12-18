Feature: Train Booking

Background:
		Given I want to use the browser Firefox
		When I login to CosmicComix
		
		Examples:
		| Browser | URL |
		| chrome	| https://www.goibibo.com/ |
		| firefox | https://www.goibibo.com/ |
	@trainpage
	Scenario: User searches for trains between two stations     

		Given the user is on the Goibibo train booking homepage     
		When the user enters <From Name> in the From field     
		And the user enters <To Name> in the To field     
		And the user selects travel <Date> and <Month Year> and clicks on the Search Trains button    
		Then the user should see a list of available trains from <From Name> to <To Name>  
		And the user should see the travel date <Date> and <Month Year>
		And the user should see a Book Now button for each train option
		
	Examples: 

	| From Name | To Name 	| Date 		| Month Year	 |
	| Bangalore | Tumkur  	| 	28		| November 2024|
	#| Tumkur 		| Bangalore | 	1			| November 2024| Month   |


##Feature: Train Booking

	##Scenario: User searches for trains between two stations

##		Given the user is on the Goibibo train booking homepage     
##	When the user enters <From Name> in the "From" field     
##		And the user enters <To Name> in the "To" field     
##	And the user selects <Date> as the travel date     
##		And the user clicks on the "Search Trains" button     
##		Then the user should see a list of available trains from New Delhi to Mumbai     
##		And the user should see the travel date as "2024-10-20"     
##		And the user should see a "Book Now" button for each train option 

##Examples: 

##| From Name | To Name | Date |
##| Bangalore | Tumkur  | 1-10-2024|
