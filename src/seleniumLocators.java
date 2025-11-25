import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class seleniumLocators {

	public static void main(String[] args) throws InterruptedException {
		// Locators - Id,name,Class name, tag name,Link text, CSS selector, Xpath,
		// partial Link text
		String email = "sss@gmail.com";
//		System.setProperty("webdriver.edge.driver", "C:/Users/swarn/Documents/msedgedriver.exe");
//		WebDriver driver = new EdgeDriver();
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");
		
//		driver.findElement(By.id("inputUsername")).sendKeys("Swarna");//By Id("value")
		
		driver.findElement(By.cssSelector("input[placeholder=\"Username\"]")).sendKeys("Swarna");// By cssSelector(tagname[attribute='value'])
		
//		driver.findElement(By.name("inputPassword")).sendKeys(email);//By name("value")
		
		driver.findElement(By.xpath("//input[@type=\"password\"]")).sendKeys(email);// By xpath(tagname[@attribute='value'])
		
		driver.findElement(By.className("signInBtn")).click();// By className("value")
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector(".error")).getText());// By cssSelector("<tagname-optional><.classname>")
		
		driver.findElement(By.linkText("Forgot your password?")).click();// By linkText("value")
		
		driver.findElement(By.xpath("//input[@type=\"text\"][1]")).sendKeys("Latha");// By xpath(tagname[@attribute='value']) with index
		
		driver.findElement(By.cssSelector("input[type=\"text\"]:nth-child(3)")).sendKeys("dfd@ds.com");// By cssSelector(tagname[attribute='value']) with index
		
		driver.findElement(By.cssSelector("input[placeholder=\"Email\"]")).clear();// By cssSelector(tagname[attribute='value'])
		
		driver.findElement(By.xpath("//form/input[2]")).sendKeys(email);// By xpath parent to child traverse
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9889889989");// By xpath parent to child traverse
		
		
//		driver.findElement(By.xpath("//button[@class=\"reset-pwd-btn\"]")).click();//By xpath using class name
//		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();//By cssSelector using class name
	    driver.findElement(By.xpath("//div[@class=\"forgot-pwd-btn-conainer\"]/button[2]")).click(); //By xpath parent to child traverse with parent class name
		
		Thread.sleep(2000);
		System.out.println(driver.findElement(By.cssSelector("form p")).getText());// By cssSelector parent to child traverse
		System.out.println(driver.findElement(By.tagName("p")).getText());//By tagName
		
		Assert.assertEquals(driver.findElement(By.cssSelector("form p")).getText(),"Please use temporary password 'rahulshettyacademy' to Login.");// By cssSelector parent to child traverse
		
		driver.findElement(By.xpath("//button[text()=\"Go to Login\"]")).click();// By xpath using button text(); same not available in css;

		Thread.sleep(2000);
		
		driver.findElement(By.cssSelector("#inputUsername")).sendKeys("Swarnalatha");//By cssSelector using #id
		
		driver.findElement(By.cssSelector("input[type*='pass']")).sendKeys("rahulshettyacademy");//By cssSelector using regularExpression(*);
		
		driver.findElement(By.id("chkboxTwo")).click();
		
		driver.findElement(By.xpath("//button[contains(@type,\"submit\")]")).click();
		Thread.sleep(2000);
		
		driver.quit();
	}

}
