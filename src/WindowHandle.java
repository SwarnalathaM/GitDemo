import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class WindowHandle {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/loginpagePractise/");
		driver.findElement(By.cssSelector(".blinkingText")).click();

		Set<String> windows = driver.getWindowHandles();//{Parent window,child window}
		Iterator<String> it = windows.iterator();
		String parentId = it.next();
		String childId = it.next();
		driver.switchTo().window(childId);
		System.out.println(driver.findElement(By.cssSelector(".im-para.red a")).getText());
		// System.out.println(driver.findElement(By.cssSelector(".im-para.red")).getText().split("at")[1].trim().split("
		// ")[0]);
		String email = driver.findElement(By.cssSelector(".im-para.red a")).getText();
		driver.switchTo().window(parentId);
		driver.findElement(By.id("username")).sendKeys(email);

	}

}
