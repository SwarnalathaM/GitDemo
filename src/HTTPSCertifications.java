import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class HTTPSCertifications {

	public static void main(String[] args) {
		//Internally setting up the browser behavior to accept the certificates and proceed to the actual website.
		EdgeOptions object=new EdgeOptions();
		object.setAcceptInsecureCerts(true);
		//intimating the browser behavior to new browser
		//Driver will get the knowledge of how it has to invoke the browser
		WebDriver driver=new EdgeDriver(object);
		
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		//Deleting specific cookie by passing cookie name as argument
//		driver.manage().deleteCookieNamed("sessionKey");
		
		driver.get("https://expired.badssl.com/");
		System.out.println(driver.getTitle());

	}

}
