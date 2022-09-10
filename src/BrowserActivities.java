import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserActivities {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.google.com");
		
		//to navidate to other page from google.com we use navigate function
		
		driver.navigate().to("https://rahulshettyacademy.com");
		
		//to go back to google.com using back button
		driver.navigate().back();
		
		//to go again to rahulshettyacademy using forword button use
		driver.navigate().forward();
		
	}

}
