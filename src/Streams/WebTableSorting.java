package Streams;

import java.util.List;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class WebTableSorting {

	public static void main(String[] args) {
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
//		compareList(driver);
		getItemPrice(driver);
		
		driver.quit();
	}

	private static void getItemPrice(WebDriver driver) {
		// Scan the web element text to get Rice

		// Step 1: Capture the web elements into List
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));

		//Get the price of Rice
		//Custom method using Streams
		List<String> price = list.stream().filter(s -> s.getText().contains("Rice")).map(s -> getPrice(s))
				.collect(Collectors.toList());
		price.forEach(a->System.out.println(a));

	}

	//Custom method-wil be called using Streams
	public static String getPrice(WebElement s) {
		String price = s.findElement(By.xpath("following-sibling::td[1]")).getText();
		
		return price;

	}

	public static void compareList(WebDriver driver) {
		// Step 1: Click on column-to get the list sorted

		driver.findElement(By.xpath("//tr/th[1]")).click();

		// Step 2: Capture the web elements into List
		List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));

		// Step 3: Capture text of all web elements into new(Original) list.
		List<String> originalList = list.stream().map(s -> s.getText()).collect(Collectors.toList());

		// Step 4: Sort on the original list of Step 3
		List<String> sortedList = originalList.stream().sorted().collect(Collectors.toList());

		// Compare original list Vs sorted list
		// Can use assertions in both ways to compare the list against another list.
		// Assert.assertEquals(sortedList, originalList);
		Assert.assertTrue(originalList.contains(sortedList));
	}

}
