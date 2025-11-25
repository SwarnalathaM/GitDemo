package Streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.testng.Assert;

public class JavaStreams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		ArrayList<String> names = new ArrayList<String>();
		// only possible way to add data to ArrayList.
		names.add("Ashwati");
		names.add("Abinaya");
		names.add("arthi");
		names.add("Pragu");
		names.add("Sinduja");
		names.add("Yazhli");

		List<String> names1=Arrays.asList("Abc","Bcd","Cde","Acd");
		// Can reduce code complexity with Streams.
		// There is no life for intermediate op if there is no terminal operation
		// Terminal op will execute only if inter op(filter) returns true;
		// can create stream with stream package.No need to create & convert collections
		// to stream.
		// Initial List will not be changed even after performing multiple operations.

//		filterOp();
//		filterForEach(names);
//		streamMap(names);
//		streamConcat(names,names1);
//		streamCollect(names);
		distinctValue();

	}
	private static void distinctValue() {
		// TODO Auto-generated method stub
		
		List<Integer> numList=Arrays.asList(1,3,4,6,7,3,2,6,8);
		List<Integer> actualList= numList.stream().distinct().sorted().collect(Collectors.toList());
		//To print the sorted list with distinct value
		actualList.stream().forEach(s->System.out.println(s));
		System.out.println("The number in 3rd index is : "+actualList.get(2));
		
		
	}
	private static void streamCollect(ArrayList<String> names) {
		
		for (int i=0;i<names.size();i++) {
			System.out.println(names.get(i));
		}
		
		//to convert the List to stream to perform operations and converting back the result as new list.
		List<String> newList = names.stream().filter(s->s.startsWith("A")).map(s->s.toUpperCase()).collect(Collectors.toList());
		
		for (int i=0;i<newList.size();i++) {
			System.out.println(newList.get(i));
		}
		
	}

	public static void streamConcat(ArrayList<String> names, List<String> names1) {
		Stream<String> newStream=Stream.concat(names.stream(), names1.stream());
//		newStream.forEach(s->System.out.println(s));
//		newStream.sorted().forEach(s->System.out.println(s));
		
//		anyMatch is similar to contains() method to check the entire collection.
		boolean flag=newStream.anyMatch(s->s.equalsIgnoreCase("Abc"));
		//to fail the case, assertions can be used here.Otherwise stream will return empty/blank result without failing case
		Assert.assertTrue(flag);
		System.out.println(flag);
	}

	public static void filterOp() {
		// Get the count of names that start with letter 'A'
		Long c = Stream.of("Abi", "Veena", "Yazhli", "Banu", "Arul").filter(s -> s.startsWith("A")).count();
		System.out.println(c);

		// when intermediate op has more than one line
		// when we define returns false inside inter op, count()(terminal) function will
		// not be executed.
		List<String> d=Arrays.asList("Abi", "Veena", "Yazhli", "Banu", "Arul");
		d.stream().filter(s -> {
			s.startsWith("A");
			System.out.println(s);
			return true;// random code to show multiple lines of code inside inter op;hence returning
						// true
			// return false;//terminal function will not be executed

		}).count();
		System.out.println(d);
	}

	private static void filterForEach(ArrayList<String> names) {
		// Print names which has length greater than 6
		names.stream().filter(s -> s.length() > 6).forEach(s -> System.out.println(s));

		// Print one name which has length greater than 6
		names.stream().filter(s -> s.length() > 6).limit(1).forEach(s -> System.out.println(s));

	}

	public static void streamMap(ArrayList<String> names) {
		// Filter out names ends with 'a' from ArrayList and print it in Uppercase.
		// No need of checking ArrayList size,loop for iterating thru the Array,loop for
		// iterating thru characters of each name,
		// If condition to check the last letter of each name, Iteration to print all
		// characters in uppercase.
		
		//The below codes with & without Map returns the same results for this scenario.
		names.stream().filter(s -> s.startsWith("A")).map(s -> s.toUpperCase()).forEach(s -> System.out.println(s));
		
		names.stream().filter(t -> t.endsWith("i")).forEach(t -> System.out.println(t.toLowerCase()));
		
		names.stream().filter(s->s.startsWith("A")).sorted().map(s->s.toUpperCase()).forEach(s-> System.out.println(s));
		
	}

}
