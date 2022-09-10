import java.util.Arrays;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class CricbuzzWebsiteTesting {

	public static void main(String[] args) throws InterruptedException {

		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();

		String[] expected_news = { "All Stories", "Cricbuzz Plus", "Latest News", "Topics", "Spotlight", "Opinions",
				"Specials", "Stats & Analysis", "Interviews", "Live Blogs", "Harsha Bhogle" };

		driver.get("https://www.cricbuzz.com/");
		driver.manage().window().maximize();
		Actions action = new Actions(driver);
		checkLinks(action, driver, expected_news);
		newsTest(action, driver, expected_news);

		driver.close();

	}

	private static void checkLinks(Actions action, WebDriver driver, String[] expected_news)
			throws InterruptedException {
		List<WebElement> news_items = driver
				.findElements(By.xpath("//div[@id='newsDropDown']//parent::a[@class='cb-subnav-item']"));

		for (int i = 0; i < news_items.size(); i++) {
			action.moveToElement(driver.findElement(By.id("newsDropDown"))).build().perform();
			news_items.get(i).click();
			System.out.println(news_items.get(i).getText());
			Thread.sleep(10000L);
		}

	}

	public static void newsTest(Actions action, WebDriver driver, String[] expected_news) {
		action.moveToElement(driver.findElement(By.id("newsDropDown"))).build().perform();
		List<WebElement> news_options = driver.findElements(
				By.xpath("//div[@id='newsDropDown']//parent::nav[@class='cb-sub-navigation']//parent::a"));
		List<String> option_list = Arrays.asList(expected_news);
		for (int i = 0; i < news_options.size(); i++) {
			String option = news_options.get(i).getText();
			Assert.assertEquals(option, option_list.get(i));
			System.out.println(option);
		}

	}
}
