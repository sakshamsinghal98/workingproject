import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class UpdatedDropdown {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		
		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);
		
		//Click as much number of times you want on no of adults button
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		Thread.sleep(6000);
		//Click as much times you want on child buttonss
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncChd")).click();
		}
		Thread.sleep(6000);
		//click as much number of times on infant button
		for(int i=1;i<5;i++)
		{
			driver.findElement(By.id("hrefIncInf")).click();
		}
		
		//After this click on done button and print the text on console
		driver.findElement(By.id("btnclosepaxoption"));
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());
		


	}

}