import java.util.Scanner;
import java.util.Stack;

public class NQueens {

	int row;
	int board[][]; 
	int column;
	int queenLocationX = 0;
	int queenLocationY = 0;
	int tempx;
	int tempy;
	int lastqueenLocationX;
	int lastqueenLocationY;
	Stack<String> queens = new Stack<String>();
	public NQueens(int row, int column){
		int board[][] = new int[row][column]; //creates the board
		this.row = row;
		this.column = column;
		for(int i = 0; i<row; i++) {      //sets all values in board to 0;
			for(int j = 0; j<column; j++) {
				board[i][j] = 0;                                                  
			}
		}
		solve(board, 0, 0);
	}

	public static void main(String[] args) { //main method 
		Scanner input = new Scanner(System.in);
		System.out.println("How many queens would you like to solve for?");
		int n = input.nextInt();
		if (n<4)  {
			System.out.println("No possible soultions");
		}
		if (n>=4)  {
			System.out.println("Solution found!");
			NQueens test = new NQueens(n, n);
		}
	}

	public void displayBoard(int[][] board) {
		for(int i = 0; i<row; i++) {
			for(int j = 0; j<column; j++) {
				System.out.print(board[i][j]+"\t");
			}
			System.out.println("\n");
		}
	}

	public boolean isConflictingHorizontally(int x, int y) { //checks to see if there is a conflict horizontally
		Stack<String> temp = new Stack<String>();
		temp.addAll(queens);
		while (!temp.empty()) {
			this.tempx = getX(temp);
			this.tempy = getY(temp);

			if ( tempx == x ) {
				return true;
			}
			else 
				temp.pop();
		}
		return false;
	}
	public boolean isConflictingVertically(int x, int y) { //checks to see if there is a conflict vertically and diagonally 
		Stack<String> temp = new Stack<String>();
		temp.addAll(queens);  
		while (!temp.empty()) {
			this.tempx = getX(temp);
			this.tempy = getY(temp);

			if (tempy == y)
				return true; 
			if (Math.abs(x-tempx) == Math.abs(y-tempy)) {
				return true;
			}
			else
				temp.pop(); 
		}
		return false; 
	}
	public void solve(int[][] board,int queenLocationX, int queenLocationY ){ //finds possible locations and puts them into queen stacks
		int i; 
		int j; 
		for(i = queenLocationX; i<row; i++) {
			for(j = queenLocationY; j<column; j++) {
				if (i!=0 && j==0 && isConflictingVertically(i-1,j) && !isConflictingHorizontally(i-1,j) && queens.isEmpty()==false) {
					j=3;
					i--;
					int lastqueenLocationX1 = getX(queens);
					int lastqueenLocationY1 = getY(queens);
					lastqueenLocationX = lastqueenLocationX1;
					lastqueenLocationY = lastqueenLocationY1;
					queens.pop();
					i = lastqueenLocationX;
					j = lastqueenLocationY+1;
				}

				if(!(isConflictingHorizontally(i,j)) && (!(isConflictingVertically(i, j)))){
					queens.push(String.valueOf(i)+" "+String.valueOf(j));
				}

				else if(isConflictingVertically(i,j) && !isConflictingHorizontally(i,j) && j==column-1 && i!=0 && queens.isEmpty()==false) {
					int lastqueenLocationX1 = getX(queens);
					int lastqueenLocationY1 = getY(queens);
					lastqueenLocationX = lastqueenLocationX1;
					lastqueenLocationY = lastqueenLocationY1;
					queens.pop();
					i = lastqueenLocationX;
					j = lastqueenLocationY;
				}
				else continue; 
			}
		}
		placeInBoard(queens, board);
	}

	public void placeInBoard(Stack<String> queens, int[][] board) { //places the queens stack in the board
		while(!queens.isEmpty()) {
			board[getX(queens)][getY(queens)] = 1;
			queens.pop();
		}

		displayBoard(board);
	}

	public int getX(Stack<String> queens) {  //gets x value of the queens stack
		int lastXLocation = 0;
		for (int k = 0; k<queens.peek().length();k++) {
			if(queens.peek().substring(k,k+1).equals(" ")) {
				String lastXLocationS = queens.peek().substring(0,k);
				int lastXLocation1 = Integer.parseInt(lastXLocationS);
				lastXLocation = lastXLocation1;
				break;
			}
		}
		return lastXLocation;
	}
	public int getY(Stack<String> queens) { //gets y value of the queens stack
		int lastYLocation = 0;
		for (int k = 0; k<queens.peek().length();k++) {
			if(queens.peek().substring(k,k+1).equals(" ")) {
				String lastYLocationS = queens.peek().substring(k+1,queens.peek().length());
				int lastYLocation1 = Integer.parseInt(lastYLocationS);
				lastYLocation = lastYLocation1;
				break;
			}
		}
		return lastYLocation; 
	}
} 
