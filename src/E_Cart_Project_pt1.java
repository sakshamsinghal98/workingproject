import java.time.Duration;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class E_Cart_Project_pt1 {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		// Implicit wait example
		//driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		WebDriverWait wait = new WebDriverWait(driver, 10);


		E_Cart_Project_pt1 ecart = new E_Cart_Project_pt1();

		String[] itemNeed = { "Cucumber", "Brocolli", "Brinjal", "Potato" };

		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");

		Thread.sleep(2000);
		ecart.addItems(driver, itemNeed);
		driver.findElement(By.cssSelector("img[alt='Cart']")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input[class='promoCode']")));
		driver.findElement(By.cssSelector("input[class='promoCode']")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button[class='promoBtn']")).click();

		// Use explicit wait to target specific element
		// To implement this we use WebDriver wait class
		// We will make an object of this class and use its methods
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("promoInfo")));

		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
	}

	public void addItems(WebDriver driver, String[] itemNeed) throws InterruptedException {
		List<WebElement> products = driver.findElements(By.className("product-name"));

		int count = 0;

		for (int i = 0; i < products.size(); i++) {

			String name = products.get(i).getText();
			String product = name.split(" ")[0];

			List<String> itemsNeededList = Arrays.asList(itemNeed);

			if (itemsNeededList.contains(product)) {
				driver.findElements(By.xpath("//div[@class='product-action']/button")).get(i).click();
				 Thread.sleep(6000);
				count++;

			}
			if (count == itemsNeededList.size()) {
				break;
			}
		}
	}
}
