import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Synchronization {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();

		// implicit wait which will be applied to all the steps.
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS)
		
//		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
//		String[] items = { "Brocolli", "Cucumber", "Beetroot", "Tomato", "Mango" };
//		addToCart(driver, items);
		
		//Explicit implemented in below method
//		proceedToCart(driver);
		
		driver.get("https://the-internet.herokuapp.com/dynamic_loading/1");
	    fluentWaitExample(driver);
		
		driver.quit();

	}

	public static void addToCart(WebDriver driver, String[] items) throws InterruptedException {

		// implicit wait which will be applied to all the steps.
		// driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		// driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS)
		List<WebElement> availableItems = driver.findElements(By.cssSelector("h4.product-name"));

		int j = 1;
		List<String> itemsNeeded = Arrays.asList(items);
		for (int i = 0; i < availableItems.size(); i++) {
			// Getting current item Name
			String itemName = availableItems.get(i).getText().split("-")[0].trim();
			// Check if the current Item name available in itemsNeeded list
			if (itemsNeeded.contains(itemName)) {
				// If so click on ADD TO CART
				driver.findElements(By.cssSelector(".product-action")).get(i).click();
//					Thread.sleep(1000);
				System.out.println(itemName + " is added to Cart");
				j++;

				if (j > items.length)
					break;
			}
		}
		
	}
	
	public static void proceedToCart(WebDriver driver) throws InterruptedException {
		driver.findElement(By.cssSelector(".cart-icon")).click();
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		// Explicit wait will be applied to the specific element which will take some
		// seconds to load /displayed on the page.
		// Defining Explicit wait object
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		
		// Applying Explicit wait to the specific element
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		// Thread.sleep(1000);

	}

	public static void fluentWaitExample(WebDriver driver) {
		
		//Fluent wait object definition
		Wait<WebDriver> wait=new FluentWait<WebDriver>(driver).withTimeout(Duration.ofSeconds(30)).pollingEvery(Duration.ofSeconds(3)).ignoring(NoSuchElementException.class);
		
		driver.findElement(By.cssSelector("#start button")).click();
		System.out.println(driver.findElement(By.xpath("//div[@id='loading']")).getText());
		
		//Fluent wait implementation to the specific element
		WebElement foo=wait.until(new Function<WebDriver, WebElement>(){
				
			public WebElement apply(WebDriver driver) {
				if(driver.findElement(By.xpath("//div[@id='finish']/h4")).isDisplayed()) {
					return driver.findElement(By.xpath("//div[@id='finish']/h4"));
				}
				else
					return null;
			}
			});
		System.out.println(driver.findElement(By.xpath("//div[@id='finish']/h4")).getText());
		
	}
	
}
