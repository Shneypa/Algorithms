package StacksAndQueues;

import java.util.Scanner;

public class StackOfStringsTestClient {

	// reads String input from standard input.

	// adds (pushes) that string into the stack
	
	// if input is "-"  then pops an item
	
	
	

	public static void main(String[] args) {
		
		StackOfStrings stack1 = new StackOfStrings();
		
		
		
		while(!StdIn.isEmpty()) {
			
			String item = StdIn.readString();
			
			
			if(item.equals("-")) {
				
				Std.out.print(stack1.pop());
				
			} else stack1.push(item);
				
		}
	}
	
}

	

