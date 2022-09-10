import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsBasic {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		//Give the chrome driver location and create object of Webdriver class
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		
		//Time synchronisation is done in this way for 5 seconds
		//This is applicable for every line below for 5 seconds.
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		//Open the URL that you want to navigate using Get method 
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
		//We have to enter the email id. So to locate the locate the username box and enter the username
		//To enter the username after finding locator use .sendkeys() method and rahul will be entered in the username box. 
		driver.findElement(By.id("inputUsername")).sendKeys("rahul");
		
		//Use the same method to enter the password also> Here we used name locator
		driver.findElement(By.name("inputPassword")).sendKeys("hello123");
		
		//Now we have to click the button Signin
		//For this we use Class name locator. Here are two class name ,because they are space seperated. You can use any of these.
		//Then we need to click the button
		driver.findElement(By.className("signInBtn")).click();
		
		//Now we need to capture the error came by entering wrong password
		//For this we will use css selector
		//syntax---- tagname.classname     If <input type="text"placeholder="username"] Then use Generic syntax:
		//Generic syntax: Tagname[Attribute='value']
		
		//Now since this error will come after hitting signin button so we have to wait for 2 sec for this error to come up
		//So for time synchronisation we use the method see above:
		System.out.println(driver.findElement(By.cssSelector("p.error")).getText());
		
		//After this we need to click on Forget your password
		//For this we will use linktext locator
		driver.findElement(By.linkText("Forgot your password?")).click();
		
		//Then we will go to Forget your password page. we need to enter name, email and phone no to get new password
		//For this we will use Xpath selector
		//Generic syntax: 	//Tagname[@attribute=’value’]
		driver.findElement(By.xpath("//input[@placeholder='Name']")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@gmail.com");
		driver.findElement(By.xpath("//input[@type='text'][2]")).clear();
		driver.findElement(By.cssSelector("input[placeholder='Email']")).sendKeys("john@yahoo.com");
		//if we have same attribute 3 time we can we use Xpath in this way
		//     //Tagname[@attribute='value'][1] This will refer to 1st find.  //Tagname[@attribute='value'][2] will refer
		//to 2nd find.
		
		//When you want to go to child attribute through parent attribute
		//   //parentTagname/childTagname 
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("7060080496");
		
		//Now we need to click the reset login button
		driver.findElement(By.cssSelector("button.reset-pwd-btn")).click();
		
		//Now we need to copy the password and print in console
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());
		
		driver.findElement(By.xpath("//div[@class='forgot-pwd-btn-conainer']/button[1]")).click();
		
		//Now we need to enter the username and password to login
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("rahul");
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");
		
		//Now we need to check on the checkbox
		driver.findElement(By.id("chkboxOne")).click();
		
		//Now we need to click on the button
		driver.findElement(By.xpath("//button[@class='submit signInBtn']")).click();
		
		
		

	}

}
