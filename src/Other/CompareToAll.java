
public class CompareToAll {

	static int CompareToAll(int array[]) {
		
		// check if array is empty
		if (array.length == 0 ) {
			System.out.println("No values in the array! ");
			return -1;
		}
		
		// variables
		boolean isMax;
		int checks = 0;
		int operations = 0;
		int i = 0;
		
		// cycle through array and check to all other elements
	
		for (i = array.length -1 ; i > 0; i--) {
			isMax = true;
			for (int j = 0; j < array.length; j++) {
				checks++;
				if (array[j] > array[i]) { 
						isMax = false; // array[i] isn't largest
						operations++;
						break;
				}
			}
		if (isMax) break;
		}
		System.out.println("COMPAREtoALL");
		System.out.println("N = " + array.length);
		System.out.println("Checks: " + checks);
		System.out.println("Operations: " + operations);
		System.out.println("Max number in the array is " + array[i]);
		System.out.println();
				
		return array[i];
		
	}
}
