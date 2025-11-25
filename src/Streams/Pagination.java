package Streams;

import java.util.List;
import java.util.stream.Collectors;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;

public class Pagination {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		WebDriver driver = new EdgeDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		List<String> price;
		driver.findElement(By.xpath("//thead/tr/th[1]")).click();

		do {
			List<WebElement> list = driver.findElements(By.xpath("//tr/td[1]"));
			// Get the price of Rice
			price = list.stream().filter(s -> s.getText().contains("Rice"))
					.map(s -> s.findElement(By.xpath("following-sibling::td[1]")).getText())
					.collect(Collectors.toList());
			price.forEach(a -> System.out.println(a));

			if (price.size() < 1) {
				driver.findElement(By.cssSelector("a[aria-label='Next']")).click();
			}
		} while (price.size() < 1);
		Thread.sleep(1000);
		driver.quit();
	}

}
