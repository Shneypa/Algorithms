
public class CompareToMax {

	
	static int CompareToMax(int array[]) {
		
		// Check if array is empty, and exit the method
		if (array.length == 0) {
			System.out.println("No values in the array!");
			return -1; 
		}
		
		// variables
		int currentMax = array[0];
		int checks = 0;
		int operations = 0;
		
		// check each element and find the largest
		for (int i = 1; i < array.length; i++) {
 			checks++;			
			if (array[i] > currentMax) {
				operations++;
				currentMax = array[i];
			}
		}
		
		System.out.println("COMPAREtoMAX");
		System.out.println("N = " + array.length);
		System.out.println("Checks: " + checks);
		System.out.println("Operations: " + operations);
		System.out.println("Max number in the array is " + currentMax);
		System.out.println();
		
		return currentMax;
	}
}
