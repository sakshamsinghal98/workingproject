import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class CompleteTravelWebsiteCode {

	public static void main(String[] args) throws InterruptedException {
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		// https://www.spicejet.com/
		// driver.switchTo().alert().dismiss();
		driver.manage().window().maximize();

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//div[@id='ctl00_mainContent_ddl_originStation1_CTNR'] //a[@value='DEL']"))
				.click();

		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[@id='glsctl00_mainContent_ddl_destinationStation1_CTNR'] //a[@value='MAA']"))
				.click();

		driver.findElement(By.cssSelector(".ui-state-default.ui-state-highlight")).click();

		if (driver.findElement(By.id("Div1")).getAttribute("style").contains("0.5")) {
			System.out.println("Disabled");
			Assert.assertTrue(true);
		} else {
			System.out.println("is Enbled");
			Assert.assertTrue(false);
		}

		driver.findElement(By.id("divpaxinfo")).click();
		Thread.sleep(2000);

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncAdt")).click();
		}
		Thread.sleep(6000);

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncChd")).click();
		}
		Thread.sleep(6000);

		for (int i = 1; i < 5; i++) {
			driver.findElement(By.id("hrefIncInf")).click();
		}

		driver.findElement(By.id("btnclosepaxoption"));
		System.out.println(driver.findElement(By.id("divpaxinfo")).getText());

		driver.findElement(By.cssSelector("input[id*='SeniorCitizenDiscount']")).click();

		WebElement staticDropdown = driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));

		Select dropdown = new Select(staticDropdown);

		dropdown.selectByIndex(3);

		System.out.println(dropdown.getFirstSelectedOption().getText());

		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());

		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();

		driver.quit();

	}

}
