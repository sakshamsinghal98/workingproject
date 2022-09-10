import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectStaticDropdown {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.setProperty("webdriver.chrome.driver", "F:\\Selenium notes\\Selenium Files\\chromedriver.exe");
		WebDriver driver= new ChromeDriver();
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		//How to handle dropdown that have Select tag. There is a class in selenium that we use .
		//Generally select is a static dropdown
		//The order of data, position of data, options and the number of data donot change in static or select dropdown.
		WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		
		//Isme driver.find.. ye ek address dega select ka ki select kahan hai complete page pe 
		//Then hum uss address ko ek variable staticDropdown me save krke object me pass karenge
		//Ye variable ka type hota hai WebElement.
		Select dropdown=new Select(staticDropdown);
		
		//select the option by using index of the option like select-0, ind-1, AED-2 and USD-3
		dropdown.selectByIndex(3);
		
		//Now to print that selected option we use
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//To select the option by using the visible text we use
		dropdown.selectByVisibleText("AED");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		//To select the option by using an attribute called valuse we use
		dropdown.selectByValue("INR");
		System.out.println(dropdown.getFirstSelectedOption().getText());
		
		

	}

}
