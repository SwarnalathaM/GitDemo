import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class SeleniumLocatorsAdvanced {
	public static void main(String[] args) throws InterruptedException {
		
		String userName="Swarna";
		
		WebDriver driver = new EdgeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		driver.manage().window().maximize();
		driver.get("https://rahulshettyacademy.com/locatorspractice/");

		String password= getPassword(driver);
		
		driver.findElement(By.id("inputUsername")).sendKeys(userName);//By Id("value")
		driver.findElement(By.name("inputPassword")).sendKeys(password);//By name("value")
		driver.findElement(By.cssSelector("#chkboxTwo")).click();
		driver.findElement(By.className("signInBtn")).click();
		
		Thread.sleep(2000);
		
		System.out.println(driver.findElement(By.tagName("p")).getText());
		Assert.assertEquals(driver.findElement(By.tagName("p")).getText(), "You are successfully logged in.");
		String nameSent=driver.findElement(By.xpath("//div[@class=\"login-container\"]/h2")).getText().split(" ")[1].split(",")[0];
		System.out.println(nameSent);
		Assert.assertEquals(nameSent,userName);
		
		driver.findElement(By.xpath("//*[text()=\"Log Out\"]")).click();
					
		driver.quit();
		
		
	}

	public static String getPassword(WebDriver driver) throws InterruptedException {
		
		driver.findElement(By.linkText("Forgot your password?")).click();// By linkText("value")
		
		driver.findElement(By.xpath("//input[@type=\"text\"][1]")).sendKeys("Latha");// By xpath(tagname[@attribute='value']) with index
		
		driver.findElement(By.xpath("//form/input[2]")).sendKeys("sss@gmai.com");// By xpath parent to child traverse
		
		driver.findElement(By.xpath("//form/input[3]")).sendKeys("9889889989");// By xpath parent to child traverse
		
		driver.findElement(By.cssSelector(".reset-pwd-btn")).click();//By cssSelector using class name
	    		
		Thread.sleep(2000);
		
		String[] pwd=driver.findElement(By.tagName("p")).getText().split("'");
//		int length=pwd.length;
//		System.out.println(length+pwd[1]+"hi"+pwd[0]+"hi"+pwd[length-1]+"hi");//By tagName
//		
		
		driver.findElement(By.xpath("//button[text()=\"Go to Login\"]")).click();// By xpath using button text(); same not available in css;

		Thread.sleep(2000);
		return pwd[1];
		
		
		
		
	}
	
}
