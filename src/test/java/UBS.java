
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class UBS {
		

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		
		
		
			
		  // Optional, if not specified, WebDriver will search your path for chromedriver.
		  System.setProperty("webdriver.chrome.driver", "C:\\Users\\nj249r\\eclipse-workspace\\jpatil\\myproject\\src\\main\\resources\\chromedriver.exe");

		  WebDriver driver = new ChromeDriver();
		  driver.get("http://www.google.com/xhtml");
		  Thread.sleep(5000);  // Let the user actually see something!
		  WebElement searchBox = driver.findElement(By.name("q"));
		  searchBox.sendKeys("ChromeDriver");
		  searchBox.submit();
		  Thread.sleep(5000);  // Let the user actually see something!
		  driver.quit();
		  
		  
		  
		  
		  
		}
	

}
