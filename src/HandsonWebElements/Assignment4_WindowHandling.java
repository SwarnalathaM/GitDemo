package HandsonWebElements;

import java.util.Collections;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;


public class Assignment4_WindowHandling {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
       WebDriver driver=new EdgeDriver();
       driver.get("https://the-internet.herokuapp.com");     
       driver.findElement(By.linkText("Multiple Windows")).click();
       
       driver.findElement(By.linkText("Click Here")).click();     
     
       Set<String> windows= driver.getWindowHandles();
       Iterator<String> it=windows.iterator();
       
       String parentWindow= it.next();
       String childTab1=it.next();
       driver.switchTo().window(childTab1);
       System.out.println(driver.findElement(By.cssSelector("div[class=\"example\"] h3")).getText());
       driver.switchTo().window(parentWindow);
       System.out.println(driver.findElement(By.cssSelector("div[class=\"example\"] h3")).getText());
       
       driver.quit();
	}

}
