import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment7 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		driver.findElement(By.id("autocomplete")).sendKeys("ja");
		Thread.sleep(5000);
		List<WebElement> country = driver.findElements(By.cssSelector(".ui-menu-item-wrapper"));
		for (WebElement option : country) {
			if (option.getText().equalsIgnoreCase("japan")) {
				option.click();
				System.out.println(option.getText());
				break;
			}
		}
	}

}
