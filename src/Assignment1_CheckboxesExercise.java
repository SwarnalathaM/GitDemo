import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class Assignment1_CheckboxesExercise {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));

		// Check the first Checkbox and verify if it is successfully checked
		System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		Thread.sleep(1000);
		System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		Assert.assertTrue(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());

		// Uncheck it again to verify if it is successfully Unchecked
		driver.findElement(By.cssSelector("#checkBoxOption1")).click();
		System.out.println(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());
		Assert.assertFalse(driver.findElement(By.cssSelector("#checkBoxOption1")).isSelected());

		// To get the Count of number of check boxes present in the page
		System.out.println("Checkboxes count:" + driver.findElements(By.xpath("//input[@type=\"checkbox\"]")).size());

		driver.quit();

	}

}
