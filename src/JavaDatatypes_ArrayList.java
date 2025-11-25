import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class JavaDatatypes_ArrayList {
	public static void main(String[] args) {
		
		//ArrayList declaration
		//Array-static size -set initially
		//Array List - Dynamically grow by adding items into the list. And Lot of operations available like contains(),get()
		ArrayList<String> al=new ArrayList<String>();
		al.add("aaa");
		al.add("bbb");
		al.add("ccc");
		System.out.println("Entire Array List : " + al);
		System.out.println("Last element in the Array List : " + al.get(2));//get method to fetch element from 
		// the requested index
		al.remove(0);//Delete element
		System.out.println("After removing 1st element Current Array List : "+al);
		for(String a : al)
		{
			System.out.println(a);
		}
		for(int i=0;i<al.size();i++)// Size method to find the length of ArrayList
		{
			System.out.println(al.get(i));
		}
		System.out.println(al.contains("bbb"));//contains method is used to check if the value exists in 
		//the Array List without doing iteration how we do for tradition Array.
		
		String[] s= {"www","xxx","yyy"};//traditional Array
		List<String> alConversion= Arrays.asList(s);//Converting traditional array to Array List
		System.out.println(alConversion.contains("xxx"));
		
	}
}
