package HandsonWebElements;

import java.time.Duration;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class Assignment3_Synchronization {

		public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver=new EdgeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		
		signIn(driver);
		addMobiles(driver);
		
		driver.findElement(By.cssSelector("a[class=\"nav-link btn btn-primary\"]")).click();
		driver.findElement(By.cssSelector("button[class=\"btn btn-success\"]")).click();
		checkoutMobiles(driver);
		
		Thread.sleep(2000);
		driver.quit();
	}
	
	public static void signIn(WebDriver driver) {
		String userName=driver.findElement(By.cssSelector(".text-center b:first-child")).getText();
		String pwd=driver.findElement(By.cssSelector(".text-center b:last-child")).getText();
		
		driver.findElement(By.id("username")).sendKeys(userName);
		driver.findElement(By.id("password")).sendKeys(pwd);
		driver.findElement(By.cssSelector("input[value=\"user\"]")).click();
		
		WebDriverWait w= new WebDriverWait(driver,Duration.ofSeconds(5));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.id("okayBtn")));
		driver.findElement(By.id("okayBtn")).click();
		
		WebElement dropdown= driver.findElement(By.cssSelector("select[class=\"form-control\"]"));
		Select ddList =new Select(dropdown);
		ddList.selectByValue("consult");
		
		driver.findElement(By.id("terms")).click();
		driver.findElement(By.id("signInBtn")).click();
		
	}
	
	public static void addMobiles(WebDriver driver) {
		List<WebElement> mblist=driver.findElements(By.xpath("//button[@class=\"btn btn-info\"]"));
		
		for(int i=0;i<mblist.size();i++)
		{
			mblist.get(0).click();
		}
	}

	public static void checkoutMobiles(WebDriver driver) throws InterruptedException {
		driver.findElement(By.id("country")).sendKeys("ind");
		
		Wait<WebDriver> wait1=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(2)).pollingEvery(Duration.ofMillis(200)).ignoring(NoSuchElementException.class);
		WebElement searchList=wait1.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".lds-ellipsis")));
		System.out.println("Loading success");
		Wait<WebDriver> wait2=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(10)).pollingEvery(Duration.ofSeconds(2)).ignoring(NoSuchElementException.class);
        WebElement sugg=wait2.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".suggestions")));
        System.out.println("List retrieved successfully");
		List<WebElement> suggList=sugg.findElements(By.tagName("a"));
		for(WebElement countryName : suggList) {
			if(countryName.getText().equals("India")) {
				countryName.click();
				break;
			}
		}		
	
			System.out.println(driver.findElement(By.id("checkbox2")).isSelected());
			WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
			WebElement checkbox= wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector(".checkbox.checkbox-primary")));
			checkbox.click();
//			checkbox.sendKeys(Keys.ENTER);
            System.out.println(driver.findElement(By.id("checkbox2")).isSelected() + "Checkbox is now selected.");
			driver.findElement(By.xpath("//input[@value=\"Purchase\"]")).click();
			String succMsg=driver.findElement(By.cssSelector(".alert.alert-success.alert-dismissible")).getText();
				
		    Assert.assertTrue(succMsg.contains("Success"),"Ordered Location confirmed");
		    System.out.println("End");
			
	}
	
}
