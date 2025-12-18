package HandsonWebElements;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Feedback_toAssignments {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	 	WebDriver driver=new ChromeDriver();		
	 	driver.get("https://the-internet.herokuapp.com/");		
	 	driver.findElement(By.linkText("Multiple Windows")).click();		
	 	driver.findElement(By.linkText("Click Here")).click();		
	 	Set<String> windows=driver.getWindowHandles();		
	 	Iterator<String> a=windows.iterator();		
	 	String parentID=a.next();		
	 	String childID=a.next();		
	 	driver.switchTo().window(childID);		
	 	System.out.println(driver.findElement(By.xpath("//h3[text()='New Window']")).getText());		
	 	driver.switchTo().window(parentID);		
	 	System.out.println(driver.findElement(By.xpath("//h3[text()='Opening a new window']")).getText());																	
	 	}
	}
