package com.cucumber.salesforceTestcase;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class SalesforceFunctionalityTest extends ReusableBrowserUtility{
	
	//TC1
	@Given("^Launch \"([^\"]*)\" app$")
	public void launch_app(String arg1) throws Throwable {
		if(arg1.equalsIgnoreCase("chrome")) {
			LaunchBrowser("chrome");
		}
		else if(arg1.equalsIgnoreCase("firefox"))
		{
			LaunchBrowser("firefox");
		}
		
		LaunchBrowser("chrome");
			System.out.println("Launched successfully!");
	}
	
	@When("^Enter the URL$")
	public void enter_the_URL() throws Throwable {
			URL();
			System.out.println("URL is entered.");
	}
	@Then("^Enter username, leave password textbox empty and click on log in button$")
	public void enter_username_leave_password_textbox_empty_and_click_on_log_in_button() throws Throwable {
			login("mitali.k@salesforce.com", "  ");
			System.out.println("Entered username and left password empty.");
	}

	@When("^Error message appear$")
	public void error_message_appear() throws Throwable {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//div[@id='error']")));
		WebElement logOut=driver.findElement(By.xpath("//div[@id='error']"));
		String errorText=logOut.getText();
		System.out.println("Login error message:- "+ errorText);
		
	}

	@Then("^Verify and validate success or failure$")
	public void verify_and_validate_success_or_failure() throws Throwable {
		waitForPageElementToVisible(driver.findElement(By.xpath("//div[@id='error']")));
		WebElement logOut=driver.findElement(By.xpath("//div[@id='error']"));
		String errorText=logOut.getText();
		if(errorText.equalsIgnoreCase("Please enter your password."))
		{
			System.out.println("Test case one passed successfully!");
		}
	}

	@And("^Quit the browser$")
	public void quit_the_browser() throws Throwable {
		quitBrowser();
		System.out.println("TC Browser quit successfully!");
	}

	//TC2
	
	@When("^Enter username, password and click on log in button1$")
	public void enter_username_password_and_click_on_log_in_button1() throws Throwable {
	    login("mitali.k@salesforce.com", "test@123");
	}
	
	@Then("^Verify and validate1$")
	public void verify_and_validate1() throws Throwable {
		Thread.sleep(1000);	
		homepage();
	}

	//TC3
	
	@Then("^Log in with valid credentials$")
	public void log_in_with_valid_credentials1() throws Throwable {
		login("mitali.k@salesforce.com", "test@123");
		System.out.println("Logged in successfully with valid credentials.");
	}

	@When("^Click on user menu dropdown and click on log out button$")
	public void click_on_user_menu_dropdown_and_click_on_log_out_button1() throws Throwable {
		
		userMenu("Logout");	
	}
	
	//TC4

	@Then("^Check remember me checkbox and click on log in button$")
	public void check_remember_me_checkbox_and_click_on_log_in_button() throws Throwable {
		WebElement username = driver.findElement(By.id("username"));
		
		username.sendKeys("mitali.k@salesforce.com");

		WebElement password=driver.findElement(By.id("password"));

		password.sendKeys("test@123");

		waitForPageElementToVisible(driver.findElement(By.id("rememberUn")));
		WebElement rememberMe=driver.findElement(By.id("rememberUn"));
		if(rememberMe.isDisplayed())
		{
			if(!rememberMe.isSelected())
			{
				rememberMe.click();
				System.out.println("Remember me checkbox is clicked successfully!");
			}
			else
			{
				System.out.println("Remember me checkbox is checked.");
			}
		}
		else
		{
			System.out.println("Rememeber me checkbox is displayed.");
		}
		waitForPageElementToVisible(driver.findElement(By.id("Login")));
		
		driver.findElement(By.id("Login")).click();
		
		System.out.println("Logged in with remember me functionality.");
	}

	@When("^Click on user menu and click on log out button$")
	public void click_on_user_menu_and_click_on_log_out_button() throws Throwable {
		Thread.sleep(2000);
		userMenu("Logout");	
		System.out.println("Logged out to check username is displayed or not.");
	}

	@Then("^Verify and validate the username is displayed in username textbox$")
	public void verify_and_validate_the_username_is_displayed_in_username_textbox() throws Throwable {
		
		Thread.sleep(2000);
		waitForPageElementToVisible(driver.findElement(By.xpath(".//span[text()='mitali.k@salesforce.com' and @id='idcard-identity']")));
		
		WebElement username=driver.findElement(By.xpath(".//span[text()='mitali.k@salesforce.com' and @id='idcard-identity']"));
		
		String sUsername=username.getText();
		
		System.out.println("Username is displayed:- "+sUsername);
		
		waitForPageElementToVisible(driver.findElement(By.linkText("1 Saved Username")));
		
		driver.findElement(By.linkText("1 Saved Username")).click();
		
		

		waitForPageElementToVisible(driver.findElement(By.linkText("Edit List")));
		
		driver.findElement(By.linkText("Edit List")).click();
		
		
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//img[@class='hintclearicon']")));
		
		driver.findElement(By.xpath("//img[@class='hintclearicon']")).click();
		
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//button[@class ='button primary fiftyfifty right' and @id='hint_save_edit']")));
		
		driver.findElement(By.xpath("//button[@class ='button primary fiftyfifty right' and @id='hint_save_edit']")).click();
		
		waitForPageElementToVisible(driver.findElement(By.id("rememberUn")));
		driver.findElement(By.id("rememberUn")).click();
		
	}

	//TC5
	
	@Then("^Click on forgot password link$")
	public void click_on_forgot_password_link() throws Throwable {
		
		waitForPageElementToVisible(driver.findElement(By.id("forgot_password_link")));

		WebElement fPassword=driver.findElement(By.id("forgot_password_link"));
		
		String fPass=fPassword.getText();
		
		System.out.println("Forgot password link is :- "+fPass);
		
		if(fPassword.isDisplayed())
		{
			fPassword.click();
		}

	}

	@When("^Enter username and Click on continue button$")
	public void enter_username_and_Click_on_continue_button() throws Throwable {
		
		waitForPageElementToVisible(driver.findElement(By.id("un")));

		WebElement username=driver.findElement(By.id("un"));
			
		if(username.isDisplayed())
		{
		username.sendKeys("mitali.k@salesforce.com");
		System.out.println("Username is entered");
		}
		else {
			System.out.println("Username textbox is not displayed.");
		}
		
		waitForPageElementToVisible(driver.findElement(By.id("continue")));
		
		WebElement continueButton=driver.findElement(By.id("continue"));
		if(continueButton.isDisplayed())
		{
		continueButton.click();
		System.out.println("Continue button is clicked successfully!");
		}
		else {
			System.out.println("Continue button is not displayed.");
		}
	}
	
	@Then("^Verify and validate it$")
	public void verify_and_validate_it() throws Throwable {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//h2[contains(text(),'Check Your Email')]")));
		
		WebElement checkEmail=driver.findElement(By.xpath("//h2[contains(text(),'Check Your Email')]"));

		String C_email=checkEmail.getText();
		
		System.out.println(C_email);
	}
	
	//TC6
	
	@And("^Enter invalid username, password and Click on log in button$")
	public void enter_invalid_username_password_and_Click_on_log_in_button() throws Throwable {
		login("123", "22131");
	}

	@Then("^Verify and validate error$")
	public void verify_and_validate_error() throws Throwable {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//div[@id='error']")));
		
		WebElement errorText=driver.findElement(By.xpath("//div[@id='error']"));

		String error=errorText.getText();
		
		System.out.println(error);
	}
	
	//TC7
	
	@When("^Check for user menu dropdown and click on user menu dropdown$")
	public void check_for_user_menu_dropdown_and_click_on_user_menu_dropdown() throws Throwable {
		userMenu("Logout");	
		}
	
	//TC8
	
	@When("^Select user menu drop down and click My profile option from user menu$")
	public void select_user_menu_drop_down_and_click_My_profile_option_from_user_menu() throws Throwable {
			
		userMenu("My Profile");
	}

	@And("^Click on edit profile button to edit contact information$")
	public void click_on_edit_profile_button_to_edit_contact_information() throws Throwable {
		Thread.sleep(2000);
		
		WebElement editProfile=driver.findElement(By.xpath("(//img[contains(@title,'Edit Profile')])[1]"));
		
		waitForPageElementToVisible(editProfile);
		
		editProfile.click();
		
		System.out.println("CLicked on edit profile.");

	}

	@Then("^Click on About tab and enter Lastname and click on save all button$")
	public void click_on_About_tab_and_enter_Lastname_and_click_on_save_all_button() throws Throwable {
	    
		driver.switchTo().frame("contactInfoContentId");
		
		WebElement editProfile_about=driver.findElement(By.xpath("//a[contains(text(),'About')]"));
		
		waitForPageElementToVisible(editProfile_about);
		
		editProfile_about.click();
		
		WebElement update_Lastname=driver.findElement(By.id("lastName"));
		
		waitForPageElementToVisible(update_Lastname);
		
		update_Lastname.clear();
		
		update_Lastname.sendKeys("Kapuria");
		
		WebElement saveAll=driver.findElement(By.xpath("//input[@class='zen-btn zen-primaryBtn zen-pas']"));
		
		waitForPageElementToVisible(saveAll);
		
		saveAll.click();
	}

	@When("^Click on post link$")
	public void click_on_post_link() throws Throwable {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']/span[1]")));
		
		WebElement post=driver.findElement(By.xpath("//a[@id='publisherAttachTextPost']/span[1]"));
		
		post.click();
		
		System.out.println("Clicked on post link");
	}

	@Then("^Enter the text to post in the post text area and click on share button$")
	public void enter_the_text_to_post_in_the_post_text_area_and_click_on_share_button() throws Throwable {
		
		waitForPageElementToVisible(driver.findElement(By.tagName("iframe")));
		
		WebElement frame=driver.findElement(By.tagName("iframe"));
		
		driver.switchTo().frame(frame);
		
		System.out.println("Switched to frame"+ frame);
	
		WebElement messagebox=driver.findElement(By.xpath("/html/body"));
		
		messagebox.click();
		
		System.out.println("Msg box clicked");
	
		WebElement addText_inPost=driver.findElement(By.xpath("/html/body"));
		
		System.out.println("Sending msg to post");
		
		addText_inPost.clear();
		
		addText_inPost.sendKeys("textPost1");
					
		driver.switchTo().defaultContent();
		
		System.out.println("back to default frame");

		WebElement sharePost=driver.findElement(By.id("publishersharebutton"));
	
		waitForPageElementToVisible(sharePost);
	
		sharePost.click();

	}

	@When("^Click on the  file link$")
	public void click_on_the_file_link() throws Throwable {
	   
		WebDriverWait wait = new WebDriverWait(driver, 40);
		
		//WebElement file=driver.findElement(By.xpath("//span[contains(text(),'File')]"));
		
		WebElement file = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(text(),'File')]")));
		
		waitForPageElementToVisible(file);
		
		file.click();
		
		System.out.println("The file is clicked.");
		
	}

	@Then("^Click on upload a file from computer button, Click on choose file button and select a file to be uploaded and click open button\\.$")
	public void click_on_upload_a_file_from_computer_button_Click_on_choose_file_button_and_select_a_file_to_be_uploaded_and_click_open_button() throws Throwable {
		
		WebElement uploadFile=driver.findElement(By.xpath("//a[@id='chatterUploadFileAction']"));
		
		waitForPageElementToVisible(uploadFile);
		
		uploadFile.click();
		
		WebElement chooseFile=driver.findElement(By.xpath("//input[@id='chatterFile']"));
		
		waitForPageElementToVisible(chooseFile);
				
		chooseFile.sendKeys("/Users/Mit/Downloads/Test.txt");
					
		WebElement shareFile=driver.findElement(By.id("publishersharebutton"));
		
		waitForPageElementToVisible(shareFile);
		
		shareFile.click();
	}
	
	@Then("^Log out$")
	public void log_out1() throws Throwable {
		userMenu("Logout");	
		}
	
	//TC9
	
	@When("^Select user menu drop down and click My Setting option from user menu$")
	public void Select_user_menu_drop_down_and_click_My_Setting_option_from_user_menu() throws Throwable {
	    userMenu("My Settings");
	}

	@Then("^Click on personal link$")
	public void click_on_personal_link() throws Throwable 
	{
		Thread.sleep(2000);
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//span[contains(@id,'PersonalInfo_font')]")));
		
		WebElement personal=driver.findElement(By.xpath("//span[contains(@id,'PersonalInfo_font')]"));
							
		personal.click();
		
		System.out.println("CLicked on personal link");
	}

	@And("^Select Login History link and click on Download login  history link$")
	public void select_Login_History_link_and_click_on_Download_login_history_link() throws Throwable {
		WebElement loginHistory=driver.findElement(By.xpath("//span[@id='LoginHistory_font']"));
		
		waitForPageElementToVisible(loginHistory);
					
		loginHistory.click();
				
		WebElement DownloadloginHistory=driver.findElement(By.xpath("//a[contains(text(),'Download login history for last six months, includ')]"));
		
		waitForPageElementToVisible(DownloadloginHistory);
					
		DownloadloginHistory.click();
		
		System.out.println("Clicked on download login history.");
	}

	@When("^Click on Display & Layout link$")
	public void click_on_Display_Layout_link() throws Throwable {
		WebElement display=driver.findElement(By.id("DisplayAndLayout_font"));
		
		waitForPageElementToVisible(display);
					
		display.click();
		System.out.println("CLicked on display layout");
	}

	@Then("^Select Customize My Tabs link$")
	public void select_Customize_My_Tabs_link() throws Throwable {
		
		waitForPageElementToVisible(driver.findElement(By.xpath("//span[@class='leafText' and @id='CustomizeTabs_font']")));

		WebElement customizeTab=driver.findElement(By.xpath("//span[@class='leafText' and @id='CustomizeTabs_font']"));
					
		customizeTab.click();
		System.out.println("Clicked on customize my tab");
	}

	@Then("^Select Salesforce Chatter option from custom App drop down$")
	public void select_Salesforce_Chatter_option_from_custom_App_drop_down() throws Throwable {
		WebElement customApp=driver.findElement(By.xpath("//select[@id='p4']"));
		
		waitForPageElementToVisible(customApp);
		
		Select option=new Select(customApp);
		
		option.selectByVisibleText("Salesforce Chatter");
	}

	@Then("^Select Reports tab from Available Tabs list and Click on Add button$")
	public void select_Reports_tab_from_Available_Tabs_list_and_Click_on_Add_button() throws Throwable {
		WebElement availableTab=driver.findElement(By.xpath("//select[@id='duel_select_0']"));
		
		waitForPageElementToVisible(availableTab);
		
		Select optiontab=new Select(availableTab);
		
		optiontab.selectByVisibleText("Reports");
				
		WebElement add=driver.findElement(By.xpath("//img[@class='rightArrowIcon']"));
		
		waitForPageElementToVisible(add);
		
		add.click();
	}

	@When("^Click on Email link and click on my email settings link under that$")
	public void click_on_Email_link_and_click_on_my_email_settings_link_under_that() throws Throwable {
		WebElement emailLink=driver.findElement(By.id("EmailSetup_font"));
		
		waitForPageElementToVisible(emailLink);
					
		emailLink.click();
		
		WebElement myEmail=driver.findElement(By.xpath("//span[contains(text(),'My Email Settings')]"));
		
		waitForPageElementToVisible(myEmail);
					
		myEmail.click();
	}

	@Then("^Enter EmailName and EmailAddress and Select automatic BCC radio button and click on save button$")
	public void enter_EmailName_and_EmailAddress_and_Select_automatic_BCC_radio_button_and_click_on_save_button() throws Throwable {
		
		WebElement emaiName=driver.findElement(By.xpath("//input[@id='sender_name']"));
		
		waitForPageElementToVisible(emaiName);
		
		emaiName.clear();
		
		emaiName.sendKeys("Mitali Kapuria");
		
		System.out.println("The email name is given.");
		
		WebElement emailAddress=driver.findElement(By.xpath("//input[@id='sender_email']"));
		
		waitForPageElementToVisible(emailAddress);
		
		emailAddress.clear();
		
		emailAddress.sendKeys("kapuriamitali@gmail.com");
		
		System.out.println("The email address is given.");

		WebElement bccYes=driver.findElement(By.xpath("//input[@id='auto_bcc1']"));
		
		waitForPageElementToVisible(bccYes);
						
		WebElement bccNo=driver.findElement(By.xpath("//input[@id='auto_bcc0']"));
		
		waitForPageElementToVisible(bccNo);
				
		if(bccYes.isEnabled())
		{
			bccNo.click();
		}
		else			
		{
			bccYes.click();
		}
				
		WebElement save=driver.findElement(By.xpath("//input[@class='btn primary']"));
		
		waitForPageElementToVisible(save);
		
		save.click();
		
	}

	@When("^Click on Calendar & Remainders$")
	public void click_on_Calendar_Remainders() throws Throwable {
		WebElement calenderRemainder=driver.findElement(By.id("CalendarAndReminders_font"));
		
		waitForPageElementToVisible(calenderRemainder);
					
		calenderRemainder.click();
		
		System.out.println("Clicked on calender remainder.");
	}

	@Then("^Click on Activity Remainders link and Open a test Remainder button$")
	public void click_on_Activity_Remainders_link_and_Open_a_test_Remainder_button() throws Throwable {
		WebElement activityRemainders=driver.findElement(By.xpath("//span[contains(text(),'Activity Reminders')]"));
		
		waitForPageElementToVisible(activityRemainders);
					
		activityRemainders.click();
				
		WebElement openTestRemainders=driver.findElement(By.id("testbtn"));
		
		waitForPageElementToVisible(openTestRemainders);
					
		openTestRemainders.click();
	}
	
}
