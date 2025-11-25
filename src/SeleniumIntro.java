import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;

public class SeleniumIntro {

	public static void main(String[] args) {
		// Invoking Browser
		//Chrome Browser
//		WebDriver driver = new ChromeDriver();
//		driver.get("https://www.udemy.com/");
//		driver.close();
//		
//		//Firefox Browser
//		WebDriver driver1 = new FirefoxDriver();
//		driver1.get("https://www.udemy.com/");
//		driver1.close();
		
		//Edge Browser
		// "msedgedriver.exe" - middleman proxy between selenium and browser.This should be provided by Edge team to overcome browser restriction.
		//Selenium invoke "msedgedriver.exe", Third party file which will internally do some logic and invoke browser.
		// we are relying on this driver(3rd party file) to launch edge browser.
		//step to invoke edge driver 
		//Here Selenium manager will be disabled as the driver path is defined locally.
		//Pros:Faster Execution - It will be lil fast as its directly hitting the driver link
		System.setProperty("webdriver.edge.driver", "C:/Users/swarn/Documents/msedgedriver.exe");
		
		
		//If we dont use setProperty() to define driver, selenium Manager will take care of it.
		//It has to connect to the web & download and it has to run.It will take some time.
		WebDriver driver2 = new EdgeDriver();
		driver2.get("https://www.udemy.com/");
		System.out.println(driver2.getCurrentUrl());
		System.out.println(driver2.getTitle());
		driver2.close();
		
	}

}
