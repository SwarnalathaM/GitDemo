import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class E2EFlightBooking {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub

		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();//to Maximize browser window
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));//Implicit wait to get the elements/text to be returned.
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
		driver.findElement(By.id("autosuggest")).sendKeys("Ind");//Select Country as India from Auto suggestion

		// Select generic Locator to extract the elements and store it in List.
		// Iterate thru the List to get text and check if it matches with the expected
		// real value and click on it.
		List<WebElement> options = driver.findElements(By.cssSelector("li[class=\"ui-menu-item\"] a"));
		for (WebElement option : options) {

			if (option.getText().equalsIgnoreCase("India")) {
				Thread.sleep(1000);
				option.click();
				break;
			}

		}
		//Round trip selection
		driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
		Thread.sleep(1000);
		
		//From selection
		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value=\"MAA\"]")).click();
		Thread.sleep(1000);
		
		//To Selection
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value=\"BLR\"]")).click();
		Thread.sleep(1000);
		
		//Depart date selection
		driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
	
		driver.findElement(By.cssSelector(".ui-datepicker-current-day")).click();
		Thread.sleep(1000);
		
		//Is the Return date field enabled or not 
		if(driver.findElement(By.cssSelector("#Div1")).getDomAttribute("style").contains("1")) {
			System.out.println("Its enabled");
			Assert.assertTrue(true);
		}
		else
		{
			System.out.println("Its disabled");
			Assert.assertTrue(false);
			
		}
		
		driver.findElement(By.cssSelector("input[id*=\"chk_friendsandfamily\"]")).click();
        Thread.sleep(1000);
		
      //Passengers Selection
		driver.findElement(By.id("divpaxinfo")).click();
		for (int i = 1; i < 5; i++) {
				driver.findElement(By.id("hrefIncAdt")).click();
				Thread.sleep(1000);
			}
		Thread.sleep(1000);
		driver.findElement(By.id("btnclosepaxoption")).click();

		//Currency Selection
		WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
		staticDropdown.click();		
		Select dropdown=new Select(staticDropdown);
		dropdown.selectByValue("USD");
		Thread.sleep(1000);
		System.out.println(dropdown.getFirstSelectedOption().getText());
		//Search Flight
		driver.findElement(By.id("ctl00_mainContent_btn_FindFlights")).click();
		Thread.sleep(2000);
		
		driver.quit();
				
		
	}

}
