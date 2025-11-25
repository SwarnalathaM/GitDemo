package Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;

public class FilteringWebTable {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");

		// check the searchList against elements in actual List
		checkFilteredItems(driver);
		driver.quit();

//		// Search with searchText
//		driver.findElement(By.id("search-field")).sendKeys("Ch");
//		// items based on search text filter
//		List<WebElement> items = driver.findElements(By.xpath("//tr/td[1]"));
//
//		// check the filteredItems all contains searchText & filter it again
//		List<WebElement> filteredList = items.stream().filter(s -> s.getText().contains("Ch"))
//				.collect(Collectors.toList());
//
//		// compare initialList & filteredList
//		Assert.assertEquals(items, filteredList);

	}

	public static void checkFilteredItems(WebDriver driver) throws InterruptedException {

		int searchListSize;
		int filteredListSize = 0;
		int currentSize;
		int actualSize = 0;
//		List<String> filteredList;

		List<WebElement> actualItems;
		int totalPages = Integer.parseInt(driver.findElement(By.cssSelector("li:nth-child(6)")).getText());
		
		int i = 0;
		do {
			actualItems = driver.findElements(By.xpath("//tr/td[1]"));
			actualSize = actualSize + actualItems.size();
			List<WebElement> getList = actualItems.stream().filter(s -> s.getText().toUpperCase().contains("P")).collect(Collectors.toList());
			currentSize = getList.size();
			filteredListSize = filteredListSize + currentSize;
			i++;
			if(currentSize !=0)
			{
				getList.forEach(s->System.out.println("Filtered List Items : "+s.getText()));
			}
			if (i < totalPages) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}

		} while (i < totalPages);
		
		driver.findElement(By.xpath("//a[@aria-label='First']")).click();
		Thread.sleep(1000);

		
		driver.findElement(By.id("search-field")).sendKeys("P");
		List<WebElement> searchItems = driver.findElements(By.xpath("//tr/td[1]"));
		searchListSize = searchItems.size();
		System.out.println("Search List size : " + searchListSize + " & Filtered List size : " + filteredListSize);
		searchItems.forEach(s->System.out.println("Search List Items : "+s.getText()));
		Assert.assertEquals(searchListSize, filteredListSize);

	}

}
