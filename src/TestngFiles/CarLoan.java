package TestngFiles;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;

public class CarLoan {
	
//	@BeforeMethod
//	 public void BeforeMethod() {
//		 System.out.println("Before Method Execution\n---------------------");
//		 
//	 }
	@AfterMethod
	 public void AfterMethod() {
		 System.out.println("After Method Execution\n---------------------");
		 
	 }
//	@Test(groups= {"Smoke"})
//	 public void WebCarLoanMethod() {
//		 System.out.println("Web Car Loan Method Execution");
//		 Assert.assertTrue(false);
//		 
//	 }
//	@Test(groups= {"Regression"})
//	 public void MobileCarLoanMethod() {
//		 System.out.println("Mobile Car Loan Method Execution");
//		 
//	 }
//	@Test(groups= {"Regression"})
//	 public void ApiCarLoanMethod() {
//		 System.out.println("Api Car Loan Method Execution");
//		 
//	 }
}
