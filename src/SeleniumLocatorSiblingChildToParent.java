import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class SeleniumLocatorSiblingChildToParent {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver = new EdgeDriver();
		WindowActivities(driver);
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		
		
		//Selecting button next to Practice button:  Sibling traverse
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[2]")).getText());
		
		
		//Selecting button next to Home button : Child(button Home) to Parent(tag a) to Sibling(other 3 buttons) traverse
		System.out.println(driver.findElement(By.xpath("//button[text()=\"Home\"]")).getText());
		System.out.println(driver.findElement(By.xpath("//button[text()=\"Home\"]/parent::a/following-sibling::button[1]")).getText());
		System.out.println(driver.findElement(By.xpath("//button[text()=\"Home\"]/parent::a/following-sibling::button[2]")).getText());
		System.out.println(driver.findElement(By.xpath("//button[text()=\"Home\"]/parent::a/following-sibling::button[3]")).getText());
		
		
		driver.quit();

	}
	
	public static void WindowActivities(WebDriver driver) throws InterruptedException {
		driver.get("https://www.google.com/");
		driver.navigate().to("https://rahulshettyacademy.com/");
		Thread.sleep(1000);
		
		driver.navigate().back();
		Thread.sleep(1000);
		driver.navigate().forward();
//		Thread.sleep(1000);
	}

}
