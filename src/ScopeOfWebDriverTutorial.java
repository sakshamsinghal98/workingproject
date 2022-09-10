import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ScopeOfWebDriverTutorial {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Get the links count on the entire page
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();
		System.out.println(driver.findElements(By.tagName("a")).size());

		// Finding no of links on footer by creating a mini driver
		// This mini driver will work only in footer section and not in the entire page
		// for this we just have to locate the element and store it into one element
		// Now this element will work as a new mini webdriver which will work only in
		// footer section of the page
		WebElement footerdriver = driver.findElement(By.id("gf-BIG"));
		System.out.println(footerdriver.findElements(By.tagName("a")).size());

		// Now find links on the first column of the footer
		WebElement column_driver = driver.findElement(By.xpath("//div/table/tbody/tr/td[1]/ul"));
		System.out.println(column_driver.findElements(By.tagName("a")).size());

		// Check if the links are working by clicking on it.
		String click_button = Keys.chord(Keys.CONTROL, Keys.ENTER);
		for (int i = 1; i < column_driver.findElements(By.tagName("a")).size(); i++) {

			column_driver.findElements(By.tagName("a")).get(i).sendKeys(click_button);
			Thread.sleep(15000L);
		}
		Set<String> windows = driver.getWindowHandles();
		Iterator<String> it = windows.iterator();

		while (it.hasNext()) {
			driver.switchTo().window(it.next());

			System.out.println(driver.getTitle());
		}
		driver.close();
	}

}
