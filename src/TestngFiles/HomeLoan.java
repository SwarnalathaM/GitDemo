package TestngFiles;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;

public class HomeLoan {
	
	@BeforeSuite
	public void BeforeSuiteMethod() {
		 System.out.println("Before Suite Execution\n---------------------");
		 
	 }
	@AfterSuite
	public void AfterSuiteMethod() {
		 System.out.println("After Suite Execution\n---------------------");
		 
	 }
	
	@Test(groups= {"Smoke"})
	 public void WebHomeLoanMethod() {
		 System.out.println("Web Home Loan Method Execution");
		 
	 }
	@Test(groups= {"Regression"})
	 public void MobileHomeLoanMethod() {
		 System.out.println("Mobile Home Loan Method Execution");
		 
	 }
	@Test(dependsOnMethods={"MobileHomeLoanMethod"},groups= {"Regression"})
	 public void ApiHomeLoanMethod() {
		 System.out.println("Api Home Loan Method Execution");
		 
	 }
}
