import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class WebDriverScope {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		//Finding total number of links available on the webpage
		System.out.println(driver.findElements(By.tagName("a")).size());
		//Finding total number of links available on the footer with attribute value of actual driver element.
		System.out.println(driver.findElements(By.cssSelector("#gf-BIG a")).size());
		
		//Limiting driver scope to Footer by using limited webElements/subset of actual driver elements.
		WebElement footerDriver=driver.findElement(By.cssSelector("#gf-BIG"));
		System.out.println(footerDriver.findElements(By.tagName("a")).size());
		
		//Limiting footerDriver scope to 1st column of the footer
		WebElement columnDriver=footerDriver.findElement(By.xpath("//table[@class='gf-t'] //td[1]"));
		System.out.println(columnDriver.findElements(By.tagName("a")).size());
		
		//Checking if all the footer links are working
		for(int i=1;i <columnDriver.findElements(By.tagName("a")).size();i++)
		{
			columnDriver.findElements(By.tagName("a")).get(i).sendKeys(Keys.chord(Keys.CONTROL,Keys.ENTER));
			
		}
		
		//Getting title of each tab opened in previous steps
		Set<String> windows=driver.getWindowHandles();
		Iterator<String> it=windows.iterator();
		while(it.hasNext()) {
			System.out.println(driver.switchTo().window(it.next()).getTitle());
		}
		
//		//Getting title of each tab opened in previous steps-same step using for loop
//		Set<String> windows=driver.getWindowHandles();
//		Iterator<String> it=windows.iterator();
//		for(int i=1;i<windows.size();i++)
//		{
//			System.out.println(driver.switchTo().window(it.next()).getTitle());
//		}
		
		
		driver.quit();
	}

}
