import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.devtools.idealized.Javascript;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class ScrollingTable_Window {
	public static void main(String[] args) throws InterruptedException {
		WebDriver driver=new EdgeDriver();
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Scrolling with in window
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,500)");
		//Scrolling with in table
		Thread.sleep(1000);
		js.executeScript("document.querySelector('.tableFixHead').scrollTop=500");
		
		int sum=0;
		List<WebElement> amtColumn = driver.findElements(By.cssSelector(".tableFixHead td:nth-child(4)"));
		for(int i=0;i<amtColumn.size();i++) {
			sum=sum+Integer.parseInt(amtColumn.get(i).getText());
		}
		
		System.out.println(sum);
		int expectedTotalAmt = Integer.parseInt(driver.findElement(By.cssSelector(".totalAmount")).getText().split(":")[1].trim());
		Assert.assertEquals(sum, expectedTotalAmt);
		driver.quit();
		
	}
}
