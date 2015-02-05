package UnionFind;

import java.util.Random;

public class Board {

    public static final int FILL_PERCENT = 60;

    private final int size;

    private final boolean[][] table;
    private final int[][] id;
    private final int[] sz;

    public Board(int size) {
        this.table = new boolean[size][size];
        this.size = size;
        this.id = new int[size][size];
        this.sz = new int[size * size];
        fillRandom();
        fillIDs();
    }

    private void fillRandom() {
        Random random = new Random();
        int noOfTimes = size * size * FILL_PERCENT / 100;

        while (noOfTimes > 0) {
            int x = random.nextInt(size);
            int y = random.nextInt(size);

            if (isFull(x, y)) {
                open(x, y);
                noOfTimes--;
            }
        }
    }
    
    public void printBoard() {
      	System.out.println("1 is empty, 0 is blocked");
    	System.out.println();
    	
    	for (int i = 0; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if (table[i][j]) {
                    System.out.print("1  ");					// 1 = open 
                } else System.out.print("0  ");					// 0 = closed
            }	
            System.out.println();
        }
        System.out.println();
    }
    
    
    private void fillIDs() {
    		
		for (int j = 0; j < size; j++) {	 	// first row.
				if(isOpen(0,j)) {
					id[0][j] = 0;				// open cells get ID of 0   
					sz[id[0][j]] = 1;											// size of 'trees' is 1 in the start
				} else id[0][j] = j;
		}
		
    	
    	for (int i = 1; i < size; i++) {			// all other rows
			for (int j = 0; j < size; j++) {
				id[i][j] = i * size  + j;
				sz[id[i][j]] = 1;												// size of 'trees' is 1 in the start
			}
		}
    
    }

  
    
    public void printIDs() {
    	
    	System.out.println("Printing cell IDs...");
      	System.out.println();
    	
    	for (int i = 0; i < size; i++) {					
            for (int j = 0; j < size; j++) {					//
                	if (id[i][j] < 10) {						//
                		System.out.print(id[i][j] + "    ");	//	keeps proper spacing between numbers (up to 9999)
                	} else 	if (id[i][j] < 100) {				//				
                		System.out.print(id[i][j] + "   ");		//
                	} else 	if (id[i][j] < 1000) {				//			
                		System.out.print(id[i][j] + "  ");		//
                	} else 	System.out.print(id[i][j] + " ");	// 									
                }											
            System.out.println();							
        }													
        													
        System.out.println();								
    }

    public void open(int i, int j) {         // open site (row i, column j) if it is not open already
        table[i][j] = true;
    }

    public boolean isOpen(int i, int j) {     // is site (row i, column j) open?
        return table[i][j];
    }

    public boolean isFull(int i, int j) {   // is site (row i, column j) full?
        return !isOpen(i, j);
    }

    private int root(int i, int j) {		
    	
    	while (id[i][j] != i * size + j) {
    		j = id[i][j] % size;
    		i = (id[i][j]  - id[i][j] % size ) / size; 
    	}
    	// System.out.println(id[x][y]);
    	return id[i][j];
    
    }
    
    private void viewRoot(int i, int j, Board board) {
    	System.out.println("Root of (" + i  + "," + j + ") is " + board.root(i,j)+ " "); 
    }
    
    private void union(int firstX, int firstY, int secondX, int secondY) {				
    		
    		// Merge two  (i,j)   elements into one tree
    	
    					//	System.out.println("union(" + firstX + "," + firstY + ") <- (" + secondX + "," + secondY + ")");
    		
    					// System.out.println("sz1 = " + sz[root(firstX,firstY)] + " sz2 = " + sz[root(secondX,secondY)]);
    		
    		if(sz[root(secondX,secondY)] <= sz[root(firstX,firstY)] ) {	
    			System.out.println("union(" + firstX + "," + firstY + ") <- (" + secondX + "," + secondY + ")");
    			
    			id[secondX][secondY] = root(firstX,firstY);		
    			
    			sz[id[firstX][firstY]] += sz[id[secondX][secondY]];
    			sz[id[secondX][secondY]] = 0;
    			
    		} else {
    			System.out.println("union(" + secondX + "," + secondY + ") <- (" + firstX + "," + firstY + ")");
    			
    			
    			id[firstX][firstY] = root(secondX,secondY);
    			
    			sz[id[secondX][secondY]] += sz[id[firstX][firstY]] ;
    			sz[id[firstX][firstY]] = 0 ;
    		}
	
	}
    
    private void unifyBoard() {					// runs a union algorithm on a board
    	
    	System.out.println("Unifying cell IDs of open neighbors");
    	System.out.println();
    	System.out.println("First row");
    	
		for (int j = 0; j + 1 < size; j++) {			//
				if (isOpen(0,j)) {						//	for first row
					if (isOpen(0,j+1)) {				// 
							union(0,j, 0,j+1);			//  was 5 6       becomes   5 5 
						}
				}
		}
		
		System.out.println();
		System.out.println("All other rows");
		
		for (int i = 1; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if (isOpen(i,j)) {
					
					if(j+1 < size) {					// if right neighbor isn't out of bounds...
						if (isOpen(i,j+1)) {			// .. check right neighbor 
							union(i,j+1,i,j);			//  					    was		5 16       becomes 		16 16
						}
					}
					if (isOpen(i-1,j)) {				// check above neighbor				5						5	
						union(i-1,j,i,j);				// 							was     15			becomes		5	
					}
					
					
					
				}
			}
		}
		System.out.println();
    }
	
    
    public boolean percolates() {            // does the system percolate?
          
        return false;
    }

    public static void main(String[] args) {
       	int size = 3;
       	int numberOfBoards = 1;
       	
        for (int i = 0; i < numberOfBoards ; i++) {
            Board board = new Board(size);
            board.printBoard();
            board.printIDs();
         
          	// board.union(1,1,1,2);
            board.unifyBoard();
            board.printBoard();
            board.printIDs();
          
            board.viewRoot(1,0, board);
            board.viewRoot(1,1, board);
            board.viewRoot(1,2, board);
            board.viewRoot(2,0, board);
            board.viewRoot(2,1, board);
            board.viewRoot(2,2, board);
             
            
            System.out.println();
            System.out.println(board.percolates());
            System.out.println();
            System.out.println();
            
            
        }
    }

}