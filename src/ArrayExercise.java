
public class ArrayExercise {
	public static void main(String[] args){   
	    int[] numbers= {1,2,3,4,5};
	    int arraySize=numbers.length;
	    
	    System.out.println("The first element of the numbers array is : "+numbers[0]);
	    System.out.println("The last element of the numbers array is : "+numbers[arraySize-1]);
	    
	    System.out.println("Reverse of numbers array elements : ");
	    for(int i=arraySize-1;i>=0;i--)
	        System.out.println(numbers[i]);
	    System.out.println("Total number of elements in numbers array is:"+arraySize);
	}
}
