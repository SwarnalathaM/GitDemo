package DownloadUpload;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class DownloadUploadFunc {
	public static void main(String[] args) throws InterruptedException, FileNotFoundException {

		WebDriver driver = new EdgeDriver();
		
		driver.get("https://rahulshettyacademy.com/upload-download-test/index.html");
		//downloading Excel
		driver.findElement(By.className("button")).click();
		
		//Uploading Excel
		WebElement upload =driver.findElement(By.cssSelector("input[type='file']"));
		upload.sendKeys("C:\\Users\\swarn\\Downloads\\download.xlsx");
		
		//Checking for the Successful message for file Upload to appear
		WebDriverWait w = new WebDriverWait(driver, Duration.ofSeconds(5));
		By alertSec=By.cssSelector("div[role='alert'] div:last-child");
		w.until(ExpectedConditions.visibilityOfElementLocated(alertSec));
		System.out.println(driver.findElement(alertSec).getText());
		Assert.assertEquals("Updated Excel Data Successfully.", driver.findElement(alertSec).getText());
//		Checking for the Successful message for file Upload to disappear
		w.until(ExpectedConditions.invisibilityOfElementLocated(alertSec));
		
//		System.out.println(driver.findElement(By.xpath("//div[@id=\"row-1\"]//div[@id=\"cell-4-undefined\"]")).getText());
		//Selecting the price with FruitName "Apple" 
		String colId=driver.findElement(By.xpath("//div[text()=\"Price\"]")).getDomAttribute("data-column-id");
		//Dynamic xpath
		String actualPrice=driver.findElement(By.xpath("//div[text()=\"Apple\"]/parent::div/parent::div/div[@id=\"cell-"+ colId +"-undefined\"]")).getText();
		System.out.println(actualPrice);
		
//		FileInputStream fis=new FileInputStream("C:\\Users\\swarn\\Downloads\\download.xlsx");
		
		
		
		driver.quit();
		

	}

}
