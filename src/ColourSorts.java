import java.util.Arrays;
import java.util.Collections;

public class ColourSorts {

	public static void main(String[] args) {
		
		System.out.println("Main started");
		
		//Sorted array of 100 integers
		int[] array = new int[100];
		for (int i = 0; i < array.length; i++){
			array[i] = i + 1;
		}
		
		//Shuffle array
		Collections.shuffle(Arrays.asList(array));
		
	}

}
