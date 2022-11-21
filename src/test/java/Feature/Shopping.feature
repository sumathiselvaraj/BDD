Feature: Verifying and Selecting Product 

@productName
Scenario Outline: User verify product in landing page 

	Given User lands in Green Cart Home Page 
	When User search the product from "<SheetName>" and rownumber "<RowNumber>" 
	Then User exctract the actual name of the product 
	
	Examples: 
		| SheetName  | RowNumber |
		| product	 |   0       |
		| product    |   1       |
		
		
