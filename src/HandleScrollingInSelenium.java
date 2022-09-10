import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

public class HandleScrollingInSelenium {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		// Scroll the window to the specific coordinates
		// Create object of javascriptexecutor and cast the driver into it. Since we
		// cannot directly use selenium for scrolling
		// Execute the script window.scroll to scroll to required position on the page
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,600)");

		Thread.sleep(3000);

		/*
		 * For scrolling into a specific element on the webpage First we have to select
		 * the element by using document.querySelector(Locator). This will select the
		 * specific element This is dom(document object model)use to select the specific
		 * element in javascript Then we have to scroll by using scroll top We can also
		 * scroll right,left,bottom using the same way
		 */
		js.executeScript("document.querySelector(\".tableFixHead\").scrollTop=500");

		List<WebElement> values = driver.findElements(By.xpath("//div[1]/table[1]/tbody[1]/tr/td[4]"));
		int sum = 0;
		for (int i = 0; i < values.size(); i++) {
			sum = sum + Integer.valueOf(values.get(i).getText());
		}

		System.out.println(sum);
		int actual_sum=Integer.valueOf(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		System.out.println(actual_sum);
		Assert.assertEquals(sum, actual_sum);

	}

}
