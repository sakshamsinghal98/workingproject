import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
//Testng is one of the testing framework

public class BasicsofAssertions_Testng {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//First the checkbox is not selected. Therefore, the method becomes:
		//Assert.assertFalse(false); since is check box is not selected so false. Hence the false(false) , and test will pass.
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).click();
		//System.out.println(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		
		//First the checkbox is selected. Therefore, the method becomes:
		//Assert.asserttrue(true); since is check box is selected so true. Hence the true(true) , and test will pass
		Assert.assertTrue(driver.findElement(By.cssSelector("input[id*='friendsandfamily']")).isSelected());
		//System.out.println(driver.findElements(By.cssSelector("input[type='checkbox']")).size());
		
		Assert.assertEquals(driver.findElements(By.cssSelector("input[type='checkbox']")).size(), 6);

	}

}
