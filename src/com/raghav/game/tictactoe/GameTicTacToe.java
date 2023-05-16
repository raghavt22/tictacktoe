package com.raghav.game.tictactoe;

import java.util.Scanner;

public class GameTicTacToe {

	
	public static void printBoard(char[][] grid) {
		for(int i=0; i<grid.length; i++) {
			for(int j=0; j<grid[0].length; j++) {
				System.out.print(grid[i][j]  + " | ");
			}//end-inner for
			System.out.println();
		}//end-outer for
	}//end method

	public static void main(String[] args) {

		char[][] game = new char[3][3];
		for(int r=0; r<game.length; r++) {
			for(int c=0; c<game[0].length; c++) {
				game[r][c] = ' ';
			}//end-inner for
			System.out.println();
		}//end-outer for
		
		char player = 'X';
		boolean gameOver = false;
		try (Scanner sc = new Scanner(System.in)) {
			while(!gameOver) {
				printBoard(game);
				System.out.print("Player " + player + "enter co-ordinates :: ");
				int row = sc.nextInt();
				int col = sc.nextInt();
				if(game[row][col] == ' ') {
					game[row][col] = player;
					gameOver = gameWon(game,player);
					if(gameOver) {
						System.out.println("WWOHHHOOOOO!!!! Player :: "+ player + " Won the game....");
					}else {
						player = (player == 'X') ? 'O' : 'X';
					}
				}else {
					System.out.println("error !!!! Try again ");
				}
			}
		}
		
	}//end main method


	private static boolean gameWon(char[][] game, char player) {
		// to decide who has won
		
		//check each rows
		for(int row=0; row<game.length; row++){
			if(game[row][0] == player && game[row][1] == player && game[row][2] == player) {
				return true;
			}
		}
		
		//check each columns
		for(int col=0; col<game[0].length; col++){
			if(game[0][col] == player && game[1][col] == player && game[2][col] == player) {
				return true;
			}
		}
		
		//check diagonally
		if(game[0][0] == player && game[1][1] == player && game[2][2] == player ) {
			return true;
		}
		
		if(game[0][2] == player && game[1][1] == player && game[2][0] == player ) {
			return true;
		}
		
		return false;
	}
		
}

