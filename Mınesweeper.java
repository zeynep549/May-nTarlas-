import java.util.*;
 public class Mınesweeper
 {
 	public static void main(String[] args)
 	{
 	
 	Scanner sc = new Scanner(System.in);
 	System.out.println(": :WELCOME: :");
 	System.out.print("Please enter the s i z e s of the board (m x n ) : ");
 	String s1 = sc.nextLine();
 	int end1 = s1.indexOf('x') -1;
 	int start = s1.indexOf('x') + 2;
 	int row = Integer.parseInt(s1.substring(0,end1));

 	int col = Integer.parseInt(s1.substring(start,s1.length()));
 	
 	
 	char[][] board = new char[row][col];
 	char[][] arr = new char [row][col];
 	for(int i = 0;i< board.length;i++)
 	{
 		for(int j = 0;j<board[0].length;j++)
 		{
 		board[i][j] = 'o';
 		
 		}
 		
 		} 
 	
 	randomMine(arr,row,col,board);
 	
 	}
 	public static void printBoard(char board[][])
 	{
 	for(int i = 0;i< board.length;i++)
 	{
 		for(int j = 0;j<board[0].length;j++)
 		{
 		System.out.print (board[i][j]);
 		System.out.print(" ");
 		}
 		System.out.println(" " );
 		}
 		} 
 	public static void randomMine(char arr[][],int row,int col,char [][] board) {
 	for(int i = 0;i< arr.length;i++)
 	{
 		for(int j = 0;j<arr[0].length;j++)
 		{
 		arr[i][j] = 'o';
 		
 		}
 		
 		} 
 	Scanner sc = new Scanner(System.in);
 	System.out.print("Please s e l e c t the d i f f i c u l t y ( E , M, H) : ");
 	String dif = sc.next();
 	printBoard(board);
 	int limit = 0;
 	if(dif .equals("E"))
 	limit = (row*col)*15/100;
 	else if(dif .equals( "M"))
 	limit = (row*col)/4;
 	else if(dif .equals( "H"))
 	limit = (row*col)*2/5;
 	int count = 0;	
 	while(count < limit)
 	{
 	Random rndm = new Random();
 	int row1 = rndm.nextInt(row);
 	int col1 = rndm.nextInt(col);
 	
 	if(arr[row1][col1] == 'o')
 	{
 	arr[row1][col1] = 'x';
 	count++;
 	}
 	}
 	
 		move(arr,board,row,col,limit); 
 	}
 	
 	public static void move(char[][]arr,char[][]board,int row, int col,int limit){
 	boolean game = true;
 	boolean  [][]  opened  = new boolean[board.length][board[0].length];
 	for(int i = 0;i<opened.length; i++)
 	{
 	for(int j = 0;j<opened[0].length;j++)
 	{
 	opened[i][j] = false;
 	}
 	}
         boolean[][]flagged = new boolean [row][col];
 	 for(int i = 0;i<flagged.length; i++)
 	{
 	for(int j = 0;j<flagged[0].length;j++)
 	{
 	flagged[i][j] = false;
 	}
 	}
 	 
 	while(game)
 	{
 	Scanner sc = new Scanner(System.in);
 	 System.out.print("Please make a move: ");
 	 String move = sc.nextLine();
 	 int a = 0;
 	 int b = 0;
 	 int row1 = 0;
 	 int col1 = 0;
 	
 	 
 	 
 	 if(!(move.contains("F")) && !(move.contains("U")) )
 	 {
 	   a = Integer.parseInt(Character.toString(move.charAt(0)));
 	   b = Integer.parseInt(move.substring(move.lastIndexOf(' ') + 1,move.length()));

 	   row1 = row-a;
 	   col1 = b-1;
 	if(opened[row1][col1])
 	System.out.println("Cell is already open");
 	else if(flagged[row1][col1])
 	System.out.println("Flagged cells cannot be opened");
 	else if(!opened[row1][col1] && !flagged[row1][col1])
 	mineCount(opened,arr,board,row1,col1);	
 	if(arr[row1][col1] == 'x' && board[row1][col1]!= 'F')
 	game = false;
 	else
 	{
 	game = true;
 	winGame(board,limit);
 	}
 	}
 	else if(move.charAt(move.length()-1) == 'F')
 	{
 	int end = move.indexOf(',')-1;
 	a = Integer.parseInt(move.substring(0,end));
 	int start = move.indexOf(',') + 1;
 	int end1 = move.lastIndexOf(' ');
 	b = Integer.parseInt(move.substring(start+1,end1));
 	row1 = row-a;
 	col1 = b-1;
 	 if(flagged[row1][col1])
 	System.out.println("The cell is already flagged.");
 	else if(opened[row1][col1] )
 	System.out.println("Open cells cannot be flagged.");
 	 else 
 	{
 	board[row1][col1] = 'F';
 	flagged[row1][col1] = true;
 	}
 	
 	
 	
 	
 	
 	
 	}
 	else if(move.charAt(move.length()-1) == 'U')
 	{
 	int end = move.indexOf(',')-1;
 	a = Integer.parseInt(move.substring(0,end));
 	int start = move.indexOf(',') + 1;
 	int end1 = move.lastIndexOf(' ');
 	b = Integer.parseInt(move.substring(start+1,end1));
 	row1 = row-a;
 	col1 = b-1;
 	if(flagged[row1][col1] )
 	{
 	board[row1][col1] = 'o';
 	flagged[row1][col1] = false;
 	}
 	else 
 	System.out.println("Only flagged cells can be unflagged");
 	
 	}
 	else
 	System.out.println("error,invalid move");
 	
 	
 	
 	
 	
 	if(winGame(board,limit))
 	{
 	System.out.println("congratulations,you won.");
 	break;
 	}
 	
 	
 	
 	if(game == true )
 	printBoard(board);
 	else if(arr[row1][col1] == 'x' && board[row1][col1] != 'F')
 	{
 	System.out.println("you lost , better luck next time.");
 	for(int i = 0;i<arr.length;i++)
 	{
 	for(int j = 0;j<arr[0].length;j++)
 	{
 	if(arr[i][j] == 'x')
 	board[i][j] = 'x';
 	}
 	}
 	printBoard(board);
 	}
 	
 	}
 	}
 	public static void  mineCount(boolean[][]opened,char[][]arr,char[][]board,int row1,int col1)
 	{
 	int freeCells = 0;
 	int mineCount= 0;
 	if(opened[row1][col1])
 	{
 	
 	return;
 	}
 	opened[row1][col1] = true;
 	if(arr[row1][col1] == 'x')
 	return;
 	for (int i = Math.max(row1-1, 0); i <= Math.min(row1+1, arr.length-1); i++) {
           for (int j = Math.max(col1-1, 0); j <= Math.min(col1+1, arr[0].length-1); j++) {
            if (arr[i][j] == 'x') {
             mineCount++;
           }
           }
           }
        if(mineCount != 0)
        {
 	board[row1][col1] = (char)('0'+ mineCount);
 	}
 	
 	if(mineCount == 0)
 	{
 	board[row1][col1] = '-';
 	for(int i = row1-1;i<=row1+1;i++)
 	{
 	
 	for(int j = col1-1;j<= col1+1;j++)
 	{
 	if(i<0 && j>=0 && j< board[0].length)
 	mineCount(opened,arr,board,i+1,j);
 	 if(i<0 && j<0)
 	mineCount(opened,arr,board,i+1,j+1);
 	 if(i>=0 && j<0 && i < board.length)
 	mineCount(opened,arr,board,i,j+1);
 	 if(i>=0 && j>=0 && i<board.length && j< board[0].length)
 	mineCount(opened,arr,board,i,j);
 	 if(i>=board.length && j<board[0].length && j>= 0)
 	mineCount(opened,arr,board,i-1,j);
 	 if(i<board.length && j<board[0].length && i>=0 && j>= 0 )
 	mineCount(opened,arr,board,i,j);
 	if(i<board.length && j>=board[0].length && i>=0)
 	mineCount(opened,arr,board,i,j-1);
 	if(i>=board.length && j>=board[0].length)
 	mineCount(opened,arr,board,i-1,j-1);
 	
 	
 	
 	}
 	}
 	}
 	
 	
 	}
 	public static boolean winGame(char[][] board , int limit )
 	{
 	int count = 0;
 	for(int i = 0;i<board.length;i++)
 	{
 	for(int j = 0;j<board[0].length;j++)
 	{
 	if(board[i][j] != 'o' && board[i][j] != 'F')
 	count++;
 	}
 	}
 	if(count == (board.length)*(board[0].length) - limit)
 	return true;
 	else
 	return false;
 	
 	}
 	
 	
 	}
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
 	
