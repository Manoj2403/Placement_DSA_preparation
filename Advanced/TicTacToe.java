import java.util.*;
public class TicTacToe {

	private char[][] board;
	private char player1 = 'X';
	private char player2 = 'O';
	private boolean gameOver;
	private int gameCount;
	
	public TicTacToe(int size) {
		board = new char[size][size];
		gameCount = size*size;
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board[0].length;col++) {
				board[row][col] = ' ';
			}
		}
	}
	public void printBoard() {
		for(int row=0;row<board.length;row++) {
			for(int col=0;col<board[0].length;col++) {
				System.out.print(board[row][col]+" | ");
			}
			System.out.println();
		}
	}
	private boolean haveWon(char[][] board,int row,int col, char player) {
		//checking row wise
//		System.err.println(gameCount);
//		if(gameCount!=0) {
		
//		-----------Normal------------------
//			for(int row=0;row<board.length;row++) {
//				if(board[row][0]==player && board[row][1]==player && board[row][2]==player) {
//					return true;
//				}
//			}
//			//checking column wise
//			for(int col=0;col<board.length;col++) {
//				if(board[0][col]==player && board[1][col]==player && board[2][col]==player) {
//					return true;
//				}
//			}
//			
//			//diagonal
//			if(board[0][0]==player && board[1][1]==player && board[2][2]==player) {
//				return true;
//			}
//			
//			//ReverseDiagonal
//			if(board[0][2]==player && board[1][1]==player && board[2][0]==player) {
//				return true;
//			}
//			return false;
		
		//Optimized Approach
		boolean winRow=true,winCol=true,winDiagonal=true,winRevDiagonal=true;
		for(int i=0;i<board.length;i++) {
			if(board[row][i]!=player)
					winRow=false;
			if(board[i][col]!=player)
					winCol=false;
			if(board[i][i]!=player)
					winDiagonal=false;
			if(board[i][board.length-1-i]!=player)
					winRevDiagonal=false;
		}
		if(winRow||winCol||winDiagonal||winRevDiagonal)
			return true;
		return false;
//		}
////		return false;
//		else {
//			return false;
//		}
	}
	public void playGame() {
		// gameCount = 9;
		Scanner sc = new Scanner(System.in);
		gameOver = false;
		char player = player1;
		while(!gameOver) {
			if(gameCount==0){
				System.out.println("Match Draw...");
				break;
			}
			--gameCount;
			printBoard();
			System.out.println("Current Player : " + player);
			int row = sc.nextInt();
			int col = sc.nextInt();
			row--;
			col--;
			if(board[row][col]==' ') {
				board[row][col]=player;
				gameOver = haveWon(board,row,col,player);
				if(gameOver) {
					System.err.println("Player " + player + " has Won the Game....");
				}
				else {
					player = (player)==player1?player2:player1;
				}
			}
			else {
				System.out.println("Invalid Move....Make another Valid Move");
			}
			
		}
		printBoard();
	}
	public static void main(String[] args) {
		TicTacToe tictactoe = new TicTacToe(3);
		tictactoe.playGame();
	}

}
