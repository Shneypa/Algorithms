
public class Bubblesort {

	public static void bubblesort(int[] array) {
		// we have 5 elements in array.
		// we take first element and compare to second
		// if its greater, we swap them
		// compare to third, swap
		// compare to last int[array.length]
		
		// then we again take first element and compare with each except the last
		
		int temp = 0;
		int checks = 0;
		int operations = 0;
		
		// BUBBLESORT
		for (int k = 0; k < array.length - 1; k++) {
			
			for (int i = 0; i < array.length -1 ; i ++) {
				checks++;
				if (array[i] > array[i+1]) {
					temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp; 
						operations++;
				}
			}
		}
		
		System.out.println();
		System.out.println("BUBBLESORT");
		
		// PRINTING ARRAY
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
		System.out.println("N = " + array.length);
		System.out.println("Checks: " + checks);
		System.out.println("Operations: " + operations);
		System.out.println();
	}
}
