package HandsonWebElements;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class WebpageLinks {
	public static void main(String[] args) {

		WebDriver driver=new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		System.out.println(driver.findElements(By.tagName("a")).size());
		WebElement footer= driver.findElement(By.id("gf-BIG"));
		System.out.println(footer.findElements(By.tagName("a")).size());
		WebElement footerCol1=driver.findElement(By.xpath("//table/tbody/tr/td[1]/ul"));
		List<WebElement> col1Links=footerCol1.findElements(By.tagName("a"));
		int colSize= col1Links.size();
		System.out.println(colSize);
		for(int i=0;i<colSize;i++) {
			footerCol1.findElements(By.tagName("a")).get(i).sendKeys(Keys.CONTROL,Keys.ENTER);
		}
		Set<String> openedLinks = driver.getWindowHandles();
		
//		Iterator it= openedLinks.iterator();
		
		for( String links : openedLinks)
		{
			System.out.println(driver.switchTo().window(links).getTitle());
		}
		
		
		
		
		driver.quit();
	}
}
