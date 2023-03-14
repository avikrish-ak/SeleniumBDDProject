package stepDef;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;

import cucumber.api.java.en.*;

public class Steps {

	WebDriver driver;
	
	@Given("^Open Chrome Browser$")
	public void openBrowser() throws Throwable
	{
		driver = new EdgeDriver();
	}
	
	@When("^Enter the Application URL$")
	public void application() throws Throwable
	{
		driver.get("https://demo.guru99.com/V1/index.php");
	}
	
	@Then("^Enter the UserId \"([^\"]*)\"$")
	public void enterUserId(String userId) throws Throwable
	{
		driver.findElement(By.name("uid")).sendKeys(userId);
	}
	
	@When("^Enter the Password \"([^\"]*)\"$")
	public void enterPassword(String pwd) throws Throwable
	{
		driver.findElement(By.name("password")).sendKeys(pwd);
	}
	
	@And("^Click LogIn button$")
	public void clickLogIn() throws Throwable
	{
		driver.findElement(By.name("btnLogin")).click();
	}
	
	
	@And("^Verify that User in LogIn Page$")
	public void verifyUserInLogInPage() throws Throwable
	{
		Assert.assertEquals("https://demo.guru99.com/V1/html/Managerhomepage.php", driver.getCurrentUrl());
		Assert.assertEquals("GTPL Bank Manager HomePage", driver.getTitle().trim());
	}
	
	@And("^Verify that User not in LogIn Page$")
	public void verifyUserNotInLogInPage() throws Throwable
	{
		Assert.assertEquals("User is not valid", driver.switchTo().alert().getText());
	}
	
}
