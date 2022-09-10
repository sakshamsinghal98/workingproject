import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class Assignment4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.rahulshettyacademy.com/AutomationPractice/");
		driver.manage().window().maximize();

		// Select the checkbox
		driver.findElement(By.id("checkBoxOption3")).click();

		// Grab text of the checkbox
		String selected_option = driver.findElement(By.xpath("//label[@for='honda']")).getText();
		System.out.println(selected_option);

		// Select the dropdown menu
		WebElement dropdown = driver.findElement(By.id("dropdown-class-example"));
		Select select = new Select(dropdown);
		select.selectByVisibleText(selected_option);
		System.out.println(select.getFirstSelectedOption().getText());

		// Alert checkbox
		driver.findElement(By.id("name")).sendKeys(selected_option);
		driver.findElement(By.id("alertbtn")).click();
		String alerttext = driver.switchTo().alert().getText().split(",")[0].split(" ")[1];
		System.out.println(alerttext);
		driver.switchTo().alert().accept();

	}

}
