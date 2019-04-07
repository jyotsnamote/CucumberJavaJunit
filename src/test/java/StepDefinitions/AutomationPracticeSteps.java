package StepDefinitions;

import static org.junit.Assert.assertEquals;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import com.aventstack.extentreports.reporter.configuration.ChartLocation;
import com.aventstack.extentreports.reporter.configuration.Theme;

import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import pageElements.LoginPage;

public class AutomationPracticeSteps {
	WebDriver driver;
	Properties properties;

	@Given("^Browser needs to be open to run the scenarios$")
	public void browser_needs_to_be_open_to_run_the_scenarios() throws Throwable {

		try {
			FileInputStream Locator = new FileInputStream(".\\src/test/java/propertyFile/LoginPropeties");
			properties = new Properties();
			properties.load(Locator);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// Check if property passed as 'firefox'
		if (properties.getProperty("browser").equalsIgnoreCase("firefox")) {

			System.setProperty("webdriver.firefox.marionette", ".\\src/main/resources/geckodriver.exe");
			driver = new FirefoxDriver();
		}
		// Check if property passed as 'chrome'
		else if (properties.getProperty("browser").equalsIgnoreCase("chrome")) {

			System.setProperty("webdriver.chrome.driver", ".\\src/main/resources/chromedriver.exe");

			driver = new ChromeDriver();
		}
		// Check if property passed as 'internet explorer'
		else if (properties.getProperty("browser").equalsIgnoreCase("ie")) {

			System.setProperty("webdriver.ie.driver", ".\\src/main/resources/IEDriverServer.exe");

			driver = new InternetExplorerDriver();
		} else {
			// If no browser passed throw exception
			throw new Exception("Browser is not correct");
		}

	}

	@Given("^I navigate to home page \"([^\"]*)\"$")
	public void i_navigate_to_home_page(String URL) throws Throwable {
		driver.get(URL);
		driver.manage().window().maximize();

	}

	@Given("^I click on the \\*Sign in\\* button$")
	public void i_click_on_the_Sign_in_button() throws Throwable {
		driver.findElement(LoginPage.signIn).click();

	}

	@Given("^I provide my \\*Email Address\\* to create an account$")
	public void i_provide_my_Email_Address_to_create_an_account() throws Throwable {

		driver.findElement(LoginPage.emailAddress).sendKeys(properties.getProperty("emailAddress"));

	}

	@When("^I fill all the mandatory fields with necessary data$")
	public void i_fill_all_the_mandatory_fields_with_necessary_data() throws Throwable {

		driver.findElement(LoginPage.createAccountButton).click();

		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		driver.findElement(LoginPage.gender).click();
		driver.findElement(LoginPage.customer_firstname).sendKeys(properties.getProperty("customer_firstname"));
		driver.findElement(LoginPage.customer_lastname).sendKeys(properties.getProperty("customer_lastname"));
		driver.findElement(LoginPage.passwd).sendKeys(properties.getProperty("passwd"));
		Select days = new Select(driver.findElement(LoginPage.days));
		days.selectByValue(properties.getProperty("days"));
		Select months = new Select(driver.findElement(LoginPage.months));
		months.selectByValue(properties.getProperty("months"));
		Select years = new Select(driver.findElement(LoginPage.years));
		years.selectByValue(properties.getProperty("years"));
		driver.findElement(LoginPage.firstname).sendKeys(properties.getProperty("firstname"));
		driver.findElement(LoginPage.lastname).sendKeys(properties.getProperty("lastname"));
		driver.findElement(LoginPage.company).sendKeys(properties.getProperty("company"));
		driver.findElement(LoginPage.address1).sendKeys(properties.getProperty("address1"));
		driver.findElement(LoginPage.address2).sendKeys(properties.getProperty("address2"));
		driver.findElement(LoginPage.city).sendKeys(properties.getProperty("city"));
		driver.findElement(LoginPage.state).sendKeys(properties.getProperty("state"));
		driver.findElement(LoginPage.postcode).sendKeys(properties.getProperty("postcode"));
		driver.findElement(LoginPage.phone_mobile).sendKeys(properties.getProperty("phone_mobile"));
		driver.findElement(LoginPage.alias).sendKeys(properties.getProperty("alias"));

	}

	@When("^I click on the \\*Register\\* button$")
	public void i_click_on_the_Register_button() throws Throwable {
		driver.findElement(LoginPage.register).click();

	}

	@Then("^I should be redirected to \"([^\"]*)\" page$")
	public void i_should_be_redirected_to_page(String expectedTitle) throws Throwable {

		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		assertEquals(expectedTitle, actualTitle);
	}

	@Then("^I should be see \\*Sign out\\* button$")
	public void i_should_be_see_Sign_out_button() throws Throwable {
		driver.findElement(LoginPage.signOut).isDisplayed();

	}

	@Given("^I provide my \\*Email Address\\* and \\*Password\\*$")
	public void i_provide_my_Email_Address_and_Password() throws Throwable {
		driver.findElement(LoginPage.email).sendKeys(properties.getProperty("emailAddress"));
		driver.findElement(LoginPage.passwd).sendKeys(properties.getProperty("passwd"));

	}

	@Given("^I click on \\*Sign in\\* button$")
	public void i_click_on_Sign_in_button() throws Throwable {
		driver.findElement(LoginPage.signIn1).click();

	}

	@Then("^\"([^\"]*)\" page is opened$")
	public void page_is_opened(String expectedTitle) throws Throwable {
		String actualTitle = driver.getTitle();
		System.out.println(actualTitle);
		assertEquals(expectedTitle, actualTitle);

	}

	@Then("^My \\*First Name\\* is shown at the top right of the page$")
	public void my_First_Name_is_shown_at_the_top_right_of_the_page() throws Throwable {

		driver.findElement(LoginPage.firstnameLastname).isDisplayed();

	}

	@Given("^close the browser$")
	public void close_the_browser() throws Throwable {
		driver.quit();

	}

}
