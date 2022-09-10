import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class NewFashionEcartProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("http://automationpractice.com/index.php");

		accountCreation(driver);

	}

	public static void accountCreation(WebDriver driver) {
		driver.manage().window().maximize();
		String email = "abc@gmail.com";
		String first_name = "Rahul";
		String last_name = "Shetty";
		String password = "password";
		driver.findElement(By.className("login")).click();
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();
		@SuppressWarnings("deprecation")
		WebDriverWait wait = new WebDriverWait(driver, 60);
		wait.until(ExpectedConditions
				.visibilityOfElementLocated(By.xpath("//div[@class='alert alert-danger']//parent::li")));
		String expected = "An account using this email address has already been registered. Please enter a valid password or request a new one.";
		Assert.assertEquals(driver.findElement(By.xpath("//div[@class='alert alert-danger']//parent::li")).getText(),
				expected);
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger']//parent::li")).getText());
		driver.findElement(By.id("email_create")).clear();
		email = "bisadbhf@biudf.com";
		driver.findElement(By.id("email_create")).sendKeys(email);
		driver.findElement(By.id("SubmitCreate")).click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("id_gender1")));
		driver.findElement(By.id("id_gender1")).click();
		Assert.assertTrue(driver.findElement(By.id("id_gender1")).isSelected());
		driver.findElement(By.id("customer_firstname")).sendKeys(first_name);
		driver.findElement(By.id("customer_lastname")).sendKeys(last_name);
		driver.findElement(By.id("passwd")).sendKeys(password);

		WebElement days = driver.findElement(By.id("days"));
		WebElement months = driver.findElement(By.id("days"));
		WebElement year = driver.findElement(By.id("days"));
		Select select_day = new Select(days);
		select_day.selectByValue("12");
		Select select_month = new Select(months);
		select_month.selectByValue("September ");
		Select select_year = new Select(year);
		select_year.selectByValue("1998 ");

	}

}
