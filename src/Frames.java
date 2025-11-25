import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class Frames {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new EdgeDriver();
		driver.get("https://jqueryui.com/droppable/");
		
		System.out.println(driver.findElements(By.tagName("iframe")).size());
		
		//if iFrame size is '1',then using frame(0) also can cast driver object. 
		driver.switchTo().frame(0);
		
		// Casting driver object to Frame using class value of iFrame element.
//		driver.switchTo().frame(driver.findElement(By.cssSelector(".demo-frame")));
				
		
		//Finding element within iFrame
		WebElement source = driver.findElement(By.id("draggable"));
		WebElement target = driver.findElement(By.id("droppable"));
		
		// Drag and Drop elements within Frames using Actions class
		Actions a = new Actions(driver);
		a.dragAndDropBy(source, 100, 100).build().perform();
		a.dragAndDrop(source, target).build().perform();
		Thread.sleep(1000);
		//driver to come back from frames to the default content
		driver.switchTo().defaultContent();
		driver.quit();
	}

}
