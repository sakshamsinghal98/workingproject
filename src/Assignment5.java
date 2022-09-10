import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment5 {

	public static void main(String[] args) {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		List<WebElement> list_row = driver.findElements(By.xpath("//div/div/fieldset/table/tbody/tr"));
		System.out.println(list_row.size());

		List<WebElement> list_column = driver.findElements(By.xpath("//div/div/fieldset/table/tbody/tr/th"));
		System.out.println(list_column.size());

		List<WebElement> list = driver.findElements(By.xpath("//div/div/fieldset/table/tbody/tr[3]"));
		for (WebElement option : list) {
			System.out.println(option.getText());
		}

	}

}
