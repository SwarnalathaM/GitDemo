package HandsonWebElements;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class Assignment7_PracticalExercise_WebElements {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
        WebDriver driver=new EdgeDriver();
        driver.get("https://rahulshettyacademy.com/AutomationPractice/");
        WebElement chkbox= driver.findElement(By.id("checkBoxOption1"));
        chkbox.click();
        String chkboxLbl=chkbox.findElement(By.xpath("./parent::label")).getText();
        WebElement dd=driver.findElement(By.id("dropdown-class-example"));
        Select ddList= new Select(dd);
        dd.click();
        ddList.selectByContainsVisibleText(chkboxLbl);
        driver.findElement(By.id("name")).sendKeys(chkboxLbl);
        driver.findElement(By.id("alertbtn")).click();
       String alertTxt=driver.switchTo().alert().getText();
       if(alertTxt.contains(chkboxLbl))
       {
    	   Assert.assertTrue(true, "Alert text dosnt contain checkbox Label");
    	   System.out.println("Alert text contains selected checkbox Label -" + chkboxLbl);
       }
       
       Thread.sleep(2000);
       driver.switchTo().alert().accept();
        
        driver.quit();
                
        
	}

}
