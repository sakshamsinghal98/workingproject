import java.util.Iterator;
import java.util.Set;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleParentChildWindowsImp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
		driver.findElement(By.cssSelector(".cart-header-navlink.blinkingText")).click();
		
		//This 5 line code is used to switch windows in browser
		Set<String> windows=driver.getWindowHandles();   //windows={Parentsid,childid}
		Iterator<String> it=windows.iterator();
		String parentid=it.next();
		String childid= it.next();
		driver.switchTo().window(childid);
		
		String text=driver.findElement(By.cssSelector(".im-para.red")).getText();
		System.out.println(text);
		String email=text.split("at")[1].trim().split(" ")[0];
		driver.switchTo().window(parentid);
		

		
		
		
		
	}

}
