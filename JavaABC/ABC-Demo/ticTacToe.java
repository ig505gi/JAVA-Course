package hello;

import java.util.Scanner;

public class ticTacToe {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		final int SIZE = 3; 
		int[][] board = new int[SIZE][SIZE];
		boolean gotResult = false;
		int numOfO = 0;
		int numOfX = 0;
		Scanner in = new Scanner(System.in);
		
		try 
		{
			for( int i=0; i<SIZE; i++ ) 
			{
				for( int j=0; j<SIZE; j++) 
				{
					board[i][j] = in.nextInt();
				}
			}
		}
		finally 
		{
			in.close();
		}
		
		for( int i=0; i<SIZE; i++ ) 
		{
			for( int j=0; j<SIZE; j++) 
			{
				if( board[i][j] == 0 ) 
				{
					numOfO++;
				}
				else 
				{
					numOfX++;
				}
			}
			if( numOfO == SIZE || numOfX == SIZE ) 
			{
				gotResult = true;
			}
			numOfO = 0;
			numOfX = 0;
		}
		
		if( !gotResult ) 
		{
			for( int i=0; i<SIZE; i++ ) 
			{
				for( int j=0; j<SIZE; j++) 
				{
					if( board[j][i] == 0 ) 
					{
						numOfO++;
					}
					else 
					{
						numOfX++;
					}
				}
				if( numOfO == SIZE || numOfX == SIZE ) 
				{
					gotResult = true;
				}
				numOfO = 0;
				numOfX = 0;
			}	
		}
		
		if( !gotResult ) 
		{
			for( int i=0; i<SIZE; i++ ) 
			{
				if( board[i][i] == 0 ) 
				{
					numOfO++;
				}
				else 
				{
					numOfX++;
				}
			}
			if( numOfO == SIZE || numOfX == SIZE ) 
			{
				gotResult = true;
			}
			numOfO = 0;
			numOfX = 0;
		}
		
		if( !gotResult ) 
		{
			for( int i=0; i<SIZE; i++ ) 
			{
				if( board[SIZE-1-i][i] == 0 ) 
				{
					numOfO++;
				}
				else 
				{
					numOfX++;
				}
			}
			if( numOfO == SIZE || numOfX == SIZE ) 
			{
				gotResult = true;
			}
			numOfO = 0;
			numOfX = 0;
		}
		
		System.out.print(gotResult);
		
	}

}
