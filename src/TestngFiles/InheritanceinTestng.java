package TestngFiles;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class InheritanceinTestng extends CarLoan {
	
	@BeforeMethod
	 public void BeforeMethod() {
		 System.out.println("Before Method Execution\n---------------------");
		 
	 }

	@Test
	public void ChildclassMethod()
	{
		System.out.println("Child Class Method Execution");
	}
}
