Feature: Salesforce functionality test

Scenario Outline: TC1 Login without password

Given Launch "<browser>" app
When Enter the URL
Then Enter username, leave password textbox empty and click on log in button
When Error message appear
Then Verify and validate success or failure
And Quit the browser

Scenario Outline: TC2 Login with valid credentials

Given Launch "<browser>" app
When Enter the URL
And Enter username, password and click on log in button1
Then Quit the browser

Scenario Outline: TC3 Logout option from user menu

Given Launch "<browser>" app
When Enter the URL
Then Log in with valid credentials
When Click on user menu dropdown and click on log out button
Then Quit the browser

Scenario Outline: TC4 Login with valid credentials

Given Launch "<browser>" app
When Enter the URL
Then Check remember me checkbox and click on log in button
When Click on user menu and click on log out button
Then Verify and validate the username is displayed in username textbox
And Quit the browser

Scenario Outline: TC5 Forgot password link

Given Launch "<browser>" app
When Enter the URL
Then Click on forgot password link
When Enter username and Click on continue button 
Then Verify and validate it
And Quit the browser

Scenario Outline: TC6 Login with invalid credentials

Given Launch "<browser>" app
When Enter the URL
And Enter invalid username, password and Click on log in button
Then Verify and validate error
And Quit the browser

Scenario Outline: TC7 User menu drop down 

Given Launch "<browser>" app
When Enter the URL
Then Log in with valid credentials
When Check for user menu dropdown and click on user menu dropdown
Then Quit the browser


Scenario Outline: TC8 My Profile option from user menu

Given Launch "<browser>" app
When Enter the URL
Then Log in with valid credentials
When Select user menu drop down and click My profile option from user menu
And Click on edit profile button to edit contact information
Then Click on About tab and enter Lastname and click on save all button
When Click on post link 
Then Enter the text to post in the post text area and click on share button
When Click on the  file link 
Then Click on upload a file from computer button, Click on choose file button and select a file to be uploaded and click open button.
When Log out
Then Quit the browser

Scenario Outline: TC9 My Setting option from user menu

Given Launch "<browser>" app
When Enter the URL
Then Log in with valid credentials
When Select user menu drop down and click My Setting option from user menu
Then Click on personal link 
And Select Login History link and click on Download login  history link
When Click on Display & Layout link 
Then Select Customize My Tabs link
And Select Salesforce Chatter option from custom App drop down
And Select Reports tab from Available Tabs list and Click on Add button 
When Click on Email link and click on my email settings link under that
Then Enter EmailName and EmailAddress and Select automatic BCC radio button and click on save button
When Click on Calendar & Remainders
Then Click on Activity Remainders link and Open a test Remainder button
Then Quit the browser


Examples:

  		| browser |
      | chrome  |
			|firefox	|




