package TestngFiles;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class getParameters {
	@Test
	@Parameters({"BaseURL","Learning"})
	 public void getBaseURL(String link,String moduleLink) {
		System.out.println("Inside Suite");
		 System.out.println(link);
		 System.out.println("Inside Module");
		 System.out.println(moduleLink);
		 
	 }
	@Test(dataProvider="getData")
//	@Parameters({"Login"})
	 public void getModule(String user, String pwd) {
		System.out.println("Inside Module");
//		 System.out.println(moduleLink);
		 
		 System.out.println("User : " + user);
		 System.out.println("Password : " + pwd);
		 
	 }	
	@DataProvider
	public Object[][] getData(){
		Object[][] loginInfo= new Object[3][2];
		loginInfo[0][0]="1st user";
		loginInfo[0][1]="1st pwd";
		
		loginInfo[1][0]="2nd user";
		loginInfo[1][1]="2nd pwd";
		
		loginInfo[2][0]="3rd user";
		loginInfo[2][1]="3rd pwd";
		return loginInfo;
	}

}
