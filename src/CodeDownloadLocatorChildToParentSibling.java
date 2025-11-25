
import org.openqa.selenium.By;

import org.openqa.selenium.WebDriver;

//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class CodeDownloadLocatorChildToParentSibling {

	public static void main(String[] args) {

		// TODO Auto-generated method stub

//	System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");

		WebDriver driver = new EdgeDriver();
		
		WindowActivities(driver);

		// Sibling - Child to parent traverse

		// header/div/button[1]/following-sibling::button[1]

		driver.get("https://rahulshettyacademy.com/AutomationPractice/");

		System.out
				.println(driver.findElement(By.xpath("//header/div/button[1]/following-sibling::button[1]")).getText());

		System.out.println(driver.findElement(By.xpath("//header/div/button[1]/parent::div/button[2]")).getText());
		
		driver.quit();

	}

	public static void WindowActivities(WebDriver driver) {

//		System.setProperty("webdriver.chrome.driver", "/Users/rahulshetty/Documents/chromedriver");
//
//		WebDriver driver = new EdgeDriver();

		driver.manage().window().maximize();

		driver.get("http://google.com");

		driver.navigate().to("https://rahulshettyacademy.com");

		driver.navigate().back();

		driver.navigate().forward();
	}

}