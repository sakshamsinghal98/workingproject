import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class Locators2 {

	public static void main(String[] args) throws InterruptedException {
			
			String name="rahul";
			System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
			String password=getPassword(driver);
			driver.get("https://rahulshettyacademy.com/locatorspractice/");
			driver.findElement(By.id("inputUsername")).sendKeys(name);
			driver.findElement(By.name("inputPassword")).sendKeys(password);
			driver.findElement(By.className("signInBtn")).click();
			Thread.sleep(2000);
			System.out.println(driver.findElement(By.tagName("p")).getText());
			
			//Now to validate the text we will use assertions from Testng dependency
			//First remove the Scope from Testng dependency
			//Testng will provide various assertions to validate the test case
			Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
			Assert.assertEquals(driver.findElement(By.cssSelector("div[class='login-container'] h2")).getText(), "Hello "+name+",");
			
			//Finding buttons on th basis of their texts like text of Log out buton is Log Out
			driver.findElement(By.xpath("//*[text()='Log Out']")).click();
			driver.quit();
	
	}
	
	public static String getPassword(WebDriver driver) throws InterruptedException 
	{
		driver.get("https://rahulshettyacademy.com/locatorspractice/");	
		driver.findElement(By.linkText("Forgot your password?")).click();
		Thread.sleep(2000);
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();
		String passwordText= driver.findElement(By.cssSelector("form p")).getText();
		//Please use temporary password 'rahulshettyacademy' to Login. This string will be stored in passwordText
		//Now we can split this string from " ' ".
		//0th index: Please use temporary password 
		//1st index: rahulshettyacademy' to Login.
		String[] passwordArray= passwordText.split("'");
		
		//passwordArray has 2 values:
		//0th index: Please use temporary password 
		//1st index: rahulshettyacademy' to Login.
		//Again split it by " ' " then at 0th: rahulshettyacademy  1st:  to Login.
		//we want only 0th index so syntax will be like:
		String password=passwordArray[1].split("'")[0];
		return password;

	}
	
}
