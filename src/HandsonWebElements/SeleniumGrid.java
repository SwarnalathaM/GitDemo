package HandsonWebElements;

import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;
public class SeleniumGrid {
//	public static void main(String[] args) throws InterruptedException, MalformedURLException {
	
	@Test
	public void chromeTesting() throws MalformedURLException {
		DesiredCapabilities caps=new DesiredCapabilities();
		caps.setBrowserName("chrome");
		String path = "http://10.195.81.168:4444";
	
		WebDriver driver=new RemoteWebDriver(new URL(path), caps);
		driver.get("https://www.google.com/");
		System.out.println(driver.getTitle());
		driver.close();
	}
}
