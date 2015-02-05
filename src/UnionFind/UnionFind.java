package UnionFind;


public class UnionFind {
	
	private int[] numbers;
	private int[] id;
	private int[] sz;
	
	public UnionFind(int n) {
		fillArrays(n);
	}
	
	private void fillArrays(int n) {
		numbers = new int[n];
		id = new int[n];
		sz = new int[n];
		for (int i = 0; i < numbers.length; i++) {
			numbers[i] = i;
			id[i] = i;
			sz[i] = 1;
		}
	}
	
	private void printArray(int[] array) {
	
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println();
	}
	
	
	
	private void union(int first, int second) {
		System.out.print(first + " <- " + second + "    ");
	
		if ( sz[root(first)] < sz[root(second)] ) {
			
			id[first] = root(second);
			
			sz[second] += sz[first];
			sz[first] = 0;
				
		} else {
			
			id[second] = root(first);
			
			sz[first] += sz[second];
			sz[second] = 0;
			
		}

	}
	
	private void printSz(int first, int second) {
		System.out.println( "    sz[" + first + "]: " + sz[first] + "    sz[" + second + "]: " + sz[second]);
	}
	
	private boolean find(int a, int b) {
		return (root(a) == root(b));
	}
	
	private int root(int x) {				
		while (x != id[x]) x = id[x];
		return x;
	}
	
	public static void main(String[] args) {
		UnionFind example = new UnionFind(10);
		
		
		
		example.union(3,4);
		example.printArray(example.id);
		//example.printSz(3, 4);
		
		example.union(4,9);
		example.printArray(example.id);
		//example.printSz(4, 9);
		
		example.union(8,0);
		example.printArray(example.id);
		//example.printSz(8, 0);
		
		example.union(2,3);
		example.printArray(example.id);
		//example.printSz(2, 3);
		
		example.union(5,6);
		example.printArray(example.id);
		//example.printSz(5, 6);
		
			
		example.union(5,9);
		example.printArray(example.id);
		//example.printSz(5, 9);
		
		example.union(7,3);
		example.printArray(example.id);
		//example.printSz(7, 3);
		
		example.union(4,8);
		example.printArray(example.id);
		//example.printSz(4, 8);
		
		example.union(6,1);
		example.printArray(example.id);
		//example.printSz(6, 1);
		
		System.out.println(example.find(3,9));
		System.out.println(example.root(3));
		System.out.println(example.root(9));
		
	}
	 
}

