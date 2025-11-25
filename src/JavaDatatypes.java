public class JavaDatatypes {

	public static void main(String[] args) {
		int a=5;
		float f=5;
		double d=5.0;
		char c='a';
		boolean b=true;
		
		System.out.println(a +"\t"+ f+"\t"+ d+"\t"+ c+"\t"+b);
		
		int[] ia= {1,2,3,4,5};
		for(int i=0;i<ia.length;i++)
		{
			System.out.println(ia[i]);
		}
		
		int[] i1=new int[3];
		i1[0]=6;
		i1[1]=7;
		i1[2]=8;
		for(int iaa : i1)
		{
			System.out.println(iaa);
		}
		
		//String defined as string literal
		String s="Happy Learning";
		String ss="Happy Learning";//Instead of allocating memory ss will internally refer to the previously
		//created object 's' as both the objects are defined with the same value 
		System.out.println(s+"\t"+ss);
		
		//String defined as string object
		String s1=new String();
		s1="Welcome to training Academy";
		String s2=new String(); // Since new is used to create an object, both s1 & s2 will have separate memory 
		//allocated to it,regardless of the value its holding.
		s2="Welcome to training Academy";
		System.out.println(s1+"\t"+s2);
		
		
		//String Array
		String[] stringArray= {"Swarna Latha Malayappan"};
				for(int i=0;i<stringArray.length;i++) //string Array "length" as keyword
		{
			System.out.println(stringArray[i]);
		}
		
				
		String[] sa = new String[3];
		sa[0]="aaa";
		sa[1]="bbb";
		sa[2]="ccc";
		for(String ssa : sa)
		{
		System.out.println(ssa);
		}
		
		String ssplit= "Swarna1 Latha1 Malayappan1";
		System.out.println(ssplit.length());//total characters-26
		String[] splitArray=ssplit.split(" ");
		//for(int i=0;i<splitArray.length;i++) //string Array "length" as keyword
		for(int i=0;i<splitArray.length;i++)//String literal "length()" as function
		{
			System.out.println(splitArray[i]);
		}
		
		String[] splitArray1=ssplit.split("Latha1");
		for(int i=0;i<splitArray1.length;i++)//String literal "length()" as function
		{
			System.out.println(splitArray1[i].trim());//will remove space before/after the string if exists
		}
		
		//String reverse
		for(int j=ssplit.length()-1;j>=0;j--)
		{
			System.out.println(ssplit.charAt(j));
		}
		
		
		
	}
	
	
}
