import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.asserts.Assertion;


public class WebDriverScope_CalendarUI {

	public static void main(String[] args) {

		String day="15";
		String month="06";
		String year="2027";
		WebDriver driver = new FirefoxDriver();
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/offers");
		driver.findElement(By.cssSelector(".react-date-picker__calendar-button__icon")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.cssSelector(".react-calendar__navigation__label__labelText")).click();
		driver.findElement(By.xpath("//button[text()='"+year+"']")).click();
		driver.findElements(By.cssSelector(".react-calendar__year-view__months__month")).get(Integer.parseInt(month)-1).click();
		driver.findElement(By.xpath("//abbr[text()='"+day+"']")).click();
		
//		System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup input[name='month']")).getDomAttribute("value"));
//		System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup input[name='day']")).getDomAttribute("value"));
//		System.out.println(driver.findElement(By.cssSelector(".react-date-picker__inputGroup input[name='year']")).getDomAttribute("value"));
		String[] date= driver.findElement(By.cssSelector(".react-date-picker__inputGroup input[name='date']")).getDomAttribute("value").split("-");
		String calendarYear= date[0];
		String calendarMonth=date[1];
		String calendarDay=date[2];
		System.out.println("The selected date is : "+calendarYear+"-"+ calendarMonth +"-"+calendarDay);
		Assert.assertEquals(calendarYear, year);
		Assert.assertEquals(calendarMonth, month);
		Assert.assertEquals(calendarDay, day);
		
		driver.quit();
		

	}

}
