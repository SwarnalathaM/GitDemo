import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;

public class AjaxMouseKeyboardHandling {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.get("https://www.amazon.in/");
		Actions a = new Actions(driver);
		
		WebElement hoverList = driver.findElement(By.id("nav-link-accountList"));
		// moves to specific element
		//Right Click on the element-contextClick()
		a.moveToElement(hoverList).contextClick().build().perform();
		
		
		WebElement searchText = driver.findElement(By.id("twotabsearchtextbox"));
		//Moves to element
		//Click on the element
		//Press shift key to make the entered text in UPPER CASE
		//type the given text
		//doubleClick() the text to get it selected
		a.moveToElement(searchText).click().keyDown(Keys.SHIFT).sendKeys("Clothes").doubleClick().build().perform();
		Thread.sleep(1000);
		
		
		
		driver.quit();

	}

}
