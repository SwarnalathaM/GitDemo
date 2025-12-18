package HandsonWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Assignment5_Frames {

	public static void main(String[] args) {
		WebDriver driver=new EdgeDriver();
	       driver.get("https://the-internet.herokuapp.com");     
	       driver.findElement(By.cssSelector("a[href*=\"/nested_frames\"]")).click();
	       WebElement topFrame=driver.findElement(By.name("frame-top"));
	       driver.switchTo().frame("frame-top");
//	       WebElement middleFrame=driver.findElement(By.name("frame-middle"));
	       driver.switchTo().frame("frame-middle");
	      System.out.println(driver.findElement(By.id("content")).getText());
	       
	       driver.quit();
	}

}
