import java.time.Duration;
import java.util.ArrayList;
import java.util.List;

import org.jspecify.annotations.Nullable;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class WebElementsAutomation {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.get("https://rahulshettyacademy.com/dropdownsPractise/");
		
//		staticDropdownAutomation(driver);
//		staticDropdownLooping(driver);
//		dynamicDropdownBasedOnSelection(driver);
//		dynamicDropdownBasedOnAutoSuggestion(driver);
//		checkboxValidation(driver);
//		assertionsValidation(driver);
		radioButtonCalendarValidation(driver);
		
				
		driver.quit();
	}

	public static void staticDropdownAutomation(WebDriver driver) throws InterruptedException {

				//Static dropdown with select class
				WebElement staticDropdown= driver.findElement(By.id("ctl00_mainContent_DropDownListCurrency"));
				staticDropdown.click();
				
				Select dropdown=new Select(staticDropdown);
				dropdown.selectByIndex(0);
				Thread.sleep(1000);
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByValue("USD");
				Thread.sleep(1000);
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByVisibleText("AED");
				Thread.sleep(1000);
				System.out.println(dropdown.getFirstSelectedOption().getText());
				dropdown.selectByContainsVisibleText("INR");
				System.out.println(dropdown.getFirstSelectedOption().getText());
	}

	public static void staticDropdownLooping(WebDriver driver) throws InterruptedException {
		// Static Dropdown with dynamic values by adding/removing members in flight booking.

//		System.out.println(driver.findElement(By.id("divAdult")).isDisplayed());
		driver.findElement(By.id("divpaxinfo")).click();

//		if (driver.findElement(By.id("divAdult")).isDisplayed()) {
			for (int i = 0; i < 5; i++) {
				driver.findElement(By.id("hrefIncAdt")).click();
				Thread.sleep(1000);
			}
//		}
		Thread.sleep(1000);
		driver.findElement(By.id("btnclosepaxoption")).click();
	}

	public static void dynamicDropdownBasedOnSelection(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("ctl00_mainContent_ddl_originStation1_CTXT")).click();
		driver.findElement(By.xpath("//a[@value=\"MAA\"]")).click();
		Thread.sleep(1000);

		// After selecting From Location(lik MAA for Chennai),To list will be enabled;
		// And now when searching for elements with LocationName(lik BLR for Bengaluru),
		// it exists in both From & To Lists;
		// So to filter out Locationelements in To List, used index value below.
//		//driver.findElement(By.xpath("(//a[@value=\"BLR\"])[2]")).click();
		
		//To avoid hardcoding of Index value in above step, can use Parent-Child Relationship in xpath to identify unique locator
		//when having same xpath for multiple instances, can use parent xpath to identify uniquely.
		//parent xpath<space>childxpath as like //div[@id="glsctl00_mainContent_ddl_destinationStation1_CTNR"] //a[@value="BLR"]
		driver.findElement(By.xpath("//div[@id=\"glsctl00_mainContent_ddl_destinationStation1_CTNR\"] //a[@value=\"BLR\"]")).click();
	}

	public static void dynamicDropdownBasedOnAutoSuggestion(WebDriver driver) throws InterruptedException {

		driver.findElement(By.id("autosuggest")).sendKeys("Ind");

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

	}

	public static void checkboxValidation(WebDriver driver) throws InterruptedException{
		System.out.println(driver.findElement(By.cssSelector("input[id*=\"chk_friendsandfamily\"]")).isEnabled());
		System.out.println(driver.findElement(By.cssSelector("input[id*=\"chk_friendsandfamily\"]")).isDisplayed());
		System.out.println(driver.findElement(By.cssSelector("input[id*=\"chk_friendsandfamily\"]")).isSelected());
		
		
		Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id*=\"chk_friendsandfamily\"]")).click();
        Thread.sleep(1000);
        driver.findElement(By.cssSelector("input[id*=\"chk_SeniorCitizenDiscount\"]")).click();
        
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("input[id*=\"chk_friendsandfamily\"]")).isEnabled());
        System.out.println(driver.findElement(By.cssSelector("input[id*=\"chk_friendsandfamily\"]")).isDisplayed());
        System.out.println(driver.findElement(By.cssSelector("input[id*=\"chk_friendsandfamily\"]")).isSelected());
		
		//Total checkboxes count
		int totalCheckboxes=driver.findElements(By.xpath("//input[contains(@name, \"ctl00$mainContent$chk\")]")).size();
		int checkboxCount= driver.findElements(By.xpath("//div[@id=\"discount-checkbox\"] //input[contains(@name, \"ctl00$mainContent$chk\")]")).size();
		System.out.println("Total Checkboxes on the page ="+totalCheckboxes+"\nCheckboxes available for the selection ="+ checkboxCount );
	}
	
	public static void assertionsValidation(WebDriver driver) throws InterruptedException{
		System.out.println(driver.findElement(By.cssSelector("input[id*=\"chk_SeniorCitizenDiscount\"]")).isSelected());//Returns False
		Assert.assertFalse(driver.findElement(By.cssSelector("input[id*=\"chk_SeniorCitizenDiscount\"]")).isSelected());//If False, this assertion will pass
		driver.findElement(By.cssSelector("input[id*=\"chk_SeniorCitizenDiscount\"]")).click();
        Thread.sleep(1000);
        System.out.println(driver.findElement(By.cssSelector("input[id*=\"chk_SeniorCitizenDiscount\"]")).isSelected());//Returns True
        Assert.assertTrue(driver.findElement(By.cssSelector("input[id*=\"chk_SeniorCitizenDiscount\"]")).isSelected());//If True, this assertion will pass
        
        System.out.println(driver.findElements(By.xpath("//div[@id=\"discount-checkbox\"] //input[contains(@name, \"ctl00$mainContent$chk\")]")).size());
        Assert.assertEquals(driver.findElements(By.xpath("//div[@id=\"discount-checkbox\"] //input[contains(@name, \"ctl00$mainContent$chk\")]")).size(), 5);
	}
	
	public static void radioButtonCalendarValidation(WebDriver driver) throws InterruptedException{
		
	System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).isSelected());
	
	String flag=driver.findElement(By.cssSelector("#Div1")).getDomAttribute("style");
	System.out.println(flag);
	driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).click();
	Thread.sleep(1000);
	flag=driver.findElement(By.cssSelector("#Div1")).getDomAttribute("style");
	System.out.println(driver.findElement(By.cssSelector("#ctl00_mainContent_rbtnl_Trip_1")).isSelected());
	System.out.println(flag);
	if(flag.contains("1")) {
	System.out.println("Its enabled");
	Assert.assertTrue(true);//if string contains value '1', then the script will pass
	}
	else {
		System.out.println("Its disabled");
		Assert.assertTrue(false);//if string doesnt contain value '1', then the script will fail by executing this line.
	}
	
	driver.findElement(By.cssSelector("#ctl00_mainContent_view_date1")).click();
	Thread.sleep(1000);
	driver.findElement(By.cssSelector(".ui-datepicker-current-day")).click();
	System.out.println(driver.findElement(By.cssSelector(".ui-datepicker-current-day")).getText());//Currently returning incorrect value
	
	}

}