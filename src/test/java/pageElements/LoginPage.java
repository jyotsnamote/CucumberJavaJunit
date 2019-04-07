package pageElements;

import org.openqa.selenium.By;

public class LoginPage {

	public static By signIn = By.linkText("Sign in");
	public static By emailAddress = By.id("email_create");
	public static By createAccountButton = By.name("SubmitCreate");
	public static By gender = By.xpath("//*[@id=\"id_gender2\"]");
	
	public static By customer_firstname = By.name("customer_firstname");
	public static By customer_lastname = By.id("customer_lastname");
	public static By passwd = By.id("passwd");
	public static By days = By.id("days");
	public static By months = By.id("months");
	public static By years = By.id("years");
	public static By firstname = By.id("firstname");
	public static By lastname = By.id("lastname");
	public static By company = By.id("company");
	public static By address1 = By.id("address1");
	public static By address2 = By.id("address2");
	public static By city = By.id("city");
	public static By state = By.id("id_state");
	public static By postcode = By.id("postcode");
	public static By phone_mobile= By.id("phone_mobile");
	public static By register = By.xpath("//*[@id=\"submitAccount\"]/span");
	public static By alias =By.id("alias");
	public static By signOut=By.linkText("Sign out");
	public static By signIn1=By.xpath("//*[@id=\"SubmitLogin\"]/span");
	public static By email = By.id("email");
	public static By firstnameLastname=By.linkText("Jyotsna Patil");
	
	

}
