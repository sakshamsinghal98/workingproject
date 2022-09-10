import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SelIntroduction {

	public static void main(String[] args) {
		
		// Invoke Browser
		//We use chrome browser. 
		//For this we have ChromeDriver class which has different methods to automate in it. 
		//Chrome--ChromeDriver--Methods-- close, get
		//Firefox-- FirefoxDriver--Methods--close, get
		//Safari-- SafariDriver--Methods--close, get
		//Methods -- close(close browser), Get(to get the URL), 
		//For firefox we will use FirefoxDriver class and make its object and some for other browsers. 
		//We will make object of chrome driver class
		//WebDriver close get
		
		//chromedriver.exe is driver file of chrome which helps in invoking it. Its like the heart of code.
		//Firefox use another driver file callled gecodriver.
		
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		
		//webdriver.chrome.driver ---> value of path
		
		
		WebDriver driver= new ChromeDriver();
		
		//Now how to open a specific website in chrome automatically
		//Webdriver interface has a get method to open any specific website
		
		driver.get("https://rahulshettyacademy.com/#/index");
		
		//Get the title of current webpage 
		//driver.getTitle();
		
		System.out.println(driver.getTitle());
		
		//To get URL of current page driver has get me current url method
		
		System.out.println(driver.getCurrentUrl());
		
		//to close the browser we will use close and quit method
		//Close will close current window but Quit will close all the associated windows ie, all tabs
		
		driver.close();

	}

}
