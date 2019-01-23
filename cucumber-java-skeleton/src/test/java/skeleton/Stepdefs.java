package skeleton;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;


public class Stepdefs 
{ static WebDriver driver;

	@Given("^login url is of the demoshop$")
	public void login_url_is_of_the_demoshop() throws Throwable 
	{
		System.setProperty("webdriver.chrome.driver", "src/test/resources/chromedriver.exe");
		driver=new ChromeDriver();
		driver.get("http://demowebshop.tricentis.com/");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
	}

	@When("^user enters (.*) as username$")
	public void user_enters_usjfkd_iasudj_com_as_username(String username) throws Throwable {
		driver.findElement(By.linkText("Log in")).click();
		driver.manage().timeouts().implicitlyWait(6000, TimeUnit.MILLISECONDS);
		driver.findElement(By.id("Email")).sendKeys(username);
		}

	@When("^user enters (.*) as password$")
	public void user_enters_ieujkffns_as_password(String password) throws Throwable {
		driver.findElement(By.id("Password")).sendKeys(password);
	}

	@When("^user clicks login$")
	public void user_clicks_login() throws Throwable {
		driver.findElement(By.cssSelector("input[value='Log in']")).click();
	}

	
	@Then("^user is invalid$")
	public void user_is_valid() throws Throwable 
	{
		Assert.assertTrue(driver.getTitle().contains("Login"));
		
		// Write code here that turns the phrase above into concrete actions
	}

}
