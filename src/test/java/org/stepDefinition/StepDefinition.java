package org.stepDefinition;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class StepDefinition {
	
	   public WebDriver driver;
	
		@Given("User is in facebook login page")
		public void user_is_in_facebook_login_page() {
			
			WebDriverManager.chromedriver().setup();
			
			 driver =new ChromeDriver();
			
			driver.get("https://www.facebook.com/");
			driver.manage().window().maximize();
                          //Nataraj
		   
		}

		@When("User enter invalid username and password")
		public void user_enter_invalid_username_and_password() {
		   
			WebElement username = driver.findElement(By.id("email"));
			username.sendKeys("dinesh339@gmail.com");
		    String text = username.getText();
		    System.out.println(text);
			WebElement password = driver.findElement(By.id("pass"));
			
			password.sendKeys("dinesh1234");
		}

		@When("User click the login button")
		public void user_click_the_login_button() throws InterruptedException {
			
			WebElement login = driver.findElement(By.name("login"));
			login.click();
			
			Thread.sleep(3000);
		   
		}

		@Then("User should be in invalid credentials page")
		public void user_should_be_in_invalid_credentials_page() {
		   
        String currentUrl = driver.getCurrentUrl();
        Assert.assertTrue("CHECK THE URL", currentUrl.contains("privacy_mutation_token"));
        

}
}