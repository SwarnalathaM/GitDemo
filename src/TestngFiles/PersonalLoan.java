package TestngFiles;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class PersonalLoan {

@BeforeTest
public void BeforeTestMethod() {
	 System.out.println("Before Test Execution\n---------------------");
}
	
@BeforeClass
public void BeforeClassMethod() {
	 System.out.println("Before Class Execution\n---------------------");
}

@AfterClass
public void AfterClassMethod() {
	 System.out.println("After Class Execution\n---------------------");
}

@Test(enabled=false)
 public void WebPersonalLoanMethod() {
	 System.out.println("Web Personal Loan Method Execution");
	 
 }
@Test(timeOut=4000,groups= {"Regression"})
 public void MobilePersonalLoanMethod() {
	 System.out.println("Mobile Personal Loan Method Execution");
	 
 }
@Test(groups= {"Regression"})
 public void ApiPersonalLoanMethod() {
	 System.out.println("Api Personal Loan Method Execution");
	 
 }

@AfterTest
public void AfterTestMethod() {
	 System.out.println("After Test Execution\n---------------------");
	 
}
}
