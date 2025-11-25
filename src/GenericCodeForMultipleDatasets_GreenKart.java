import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class GenericCodeForMultipleDatasets_GreenKart {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		// Explicit wait will be applied to the specific element which will take some
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));

		driver.get("https://rahulshettyacademy.com/seleniumPractise/");
		Thread.sleep(2000);
		String[] items = { "Brocolli", "Cucumber", "Beetroot", "Tomato", "Mango" };
		addToCart(driver, items);
		driver.findElement(By.cssSelector(".cart-icon")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//button[text()='PROCEED TO CHECKOUT']")).click();

		// Applying Explicit wait to the specific element
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("input.promoCode")));
		driver.findElement(By.cssSelector("input.promoCode")).sendKeys("rahulshettyacademy");
		driver.findElement(By.cssSelector("button.promoBtn")).click();

//		w.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector("span.promoInfo"))));
		w.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("span.promoInfo")));
		System.out.println(driver.findElement(By.cssSelector("span.promoInfo")).getText());
		// Thread.sleep(1000);
		driver.quit();

	}

	public static void addToCart(WebDriver driver, String[] items) throws InterruptedException {

		List<WebElement> availableItems = driver.findElements(By.cssSelector("h4.product-name"));

		int j = 1;
		List itemsNeeded = Arrays.asList(items);

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

}
