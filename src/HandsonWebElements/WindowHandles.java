package HandsonWebElements;

import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.annotations.Test;

public class WindowHandles {

	@Test
	public void multipleWindowHandles() throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.className("blinkingText")).click();
		Set<String> allWindows=driver.getWindowHandles();
		
		Iterator<String> it= allWindows.iterator();
		//currentwindow and 1st parentId/it.next() have the same window details
		String currentwindow= driver.getWindowHandle();
		System.out.println(currentwindow);
		String parentId= it.next();
		String childId=it.next();
		System.out.println(parentId+"\n"+childId);
//		while(it.hasNext()){
//			String currentwirndow= driver.getWindowHandle();
//			System.out.println(currentwirndow);
//			driver.switchTo().window(it.next());
//			System.out.println(it.next());
//			System.out.println(driver.getWindowHandle());
//			driver.switchTo().window(it.next());
//			System.out.println(it.next());
//			System.out.println(driver.getWindowHandle());
//
//		}
			
		
		
		driver.switchTo().window(childId);
		String email= driver.findElement(By.cssSelector(".im-para.red a")).getText();
		System.out.println(email);
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);
		Thread.sleep(1000);
		driver.switchTo().newWindow(WindowType.TAB);
		driver.get("https://www.google.com");
		System.out.println(driver.getWindowHandle());
		driver.quit();
		
		
		
		
		
	}
}
