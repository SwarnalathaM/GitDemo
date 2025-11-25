import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

public class BrokenLinks {

	public static void main(String[] args) throws IOException, URISyntaxException {
		WebDriver driver = new EdgeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get("https://rahulshettyacademy.com/AutomationPractice/");
//		findLinksRespCode(driver);
		
		List<WebElement> links = driver.findElements(By.cssSelector("li[class=\"gf-li\"] a"));
		SoftAssert a=new SoftAssert();
		
		for (WebElement link : links) {

			String hrefs = link.getDomAttribute("href");
			if(hrefs.matches("#"))
			{
				hrefs="https://rahulshettyacademy.com/AutomationPractice/"+hrefs;
			}
			
			// URL link= new URL(url);//This URL() constructor is deprecated in Java4
			//So convert string to uri to url
//			URI uri=new URI(hrefs);			
//			URL url = uri.toURL();
//			HttpURLConnection conn = (HttpURLConnection) url.openConnection();
			//Did the above conversion in single line code
			HttpURLConnection conn = (HttpURLConnection) new URI(hrefs).toURL().openConnection();
			conn.setRequestMethod("HEAD");
			conn.connect();
			int respCode = conn.getResponseCode();
			System.out.println(respCode);
			
//			//The execution will break when the issue link is found.
//			if (respCode > 400) {
//				System.out.println("The link "+link.getText()+" is broken with response code : "+respCode);
//				Assert.assertTrue(false);
//			}
			//To avoid breaking the flow and continue checking the other links, soft assertion is used below.
			//If respCode < 400 fails and got 403/404, the error text will be displayed and flow will continue with the next link in the list.
			a.assertTrue(respCode < 400, "The link "+link.getText()+" is broken with response code : "+respCode);
			
		}
		a.assertAll();//to fail the case at the end.
		driver.quit();
	}

	public static void findLinksRespCode(WebDriver driver) throws IOException {
		String href = driver.findElement(By.cssSelector("a[href*=\"brokenlink\"]")).getDomAttribute("href");

		// URL url= new URL(href);//This URL() constructor is deprecated i Java4
		URL url = URI.create(href).toURL();
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("HEAD");
		conn.connect();
		int respCode = conn.getResponseCode();
		System.out.println(respCode);
	}

}
