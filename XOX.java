import java.util.*;
 public class XOX
 {
  private static boolean winGame = false;
  private static boolean flag = false;
 	public static void main (String [] args)
 	{
 	char [][] arr = new char[3][3];
 		for(int row = 0;row<3;row++)
 		{
 			for(int column = 0;column<3;column++)
 			{
 			arr[row][column] = '-' ;
 			}
 			
 		}
 		Scanner sc = new Scanner(System.in);
 		System.out.println("Hi, welcome to the XOX! Please enter the names of the players along with their guesses.");
 		setArr(arr);
 		
 		}
 		public static void setArr(char[] [] arr)
 		{
 		Scanner sc1 = new Scanner(System.in);
 		String player1 = sc1.next();
 		int num1 = sc1.nextInt();
 		String player2 = sc1.next();
 		int num2 = sc1.nextInt();
 		char firstPlayer = 'X';
 		Random rndm = new Random();
 		int num3 = rndm.nextInt(101);
 		String first = "";
 		if(Math.abs(num3-num1) < Math.abs(num3-num2))
 		{
 		System.out.println("The randomly generated number is" + num3 + ". Thus,"+ player1 + " starts! It’s"+ player1+"’s turn.");
 		first = player1;
 		}
 		else
 		{
 		System.out.println("The randomly generated number is" + num3 + ". Thus,"+ player2 + " starts! It’s"+ player2+"’s turn.");
 		first = player2;
 		}
 		printArr(arr);
 		
 		
 		
 		
 		
 	       
 	        
 		while(XOX.winGame== false)
 		{
 		
 		

 		
 		Scanner sc = new Scanner(System.in);
 		String s1 = sc.nextLine();
 		String rslt = "";
	for(int i = 0;i< s1.length();i++)
	{
	char c = s1.charAt(i);
	if(c=='t' ||c=='e' ){
	rslt = rslt+c;
	if(  i< s1.length()-1 && s1.charAt(i+1) != 't'  )
	i++;
	}

	else if(i<s1.length())
	rslt = rslt + c; }
 		int row = 0;
 		int col = 0;
 		if(s1.contains("upper"))
 		{
 		row = 0;
 		if(s1.contains("left"))
 		col = 0;
 		else if(s1.contains("middle"))
 		col = 1;
 		else if(s1.contains("right"))
 		col = 2;
 		else
 		{
 		
 		String result = "";
		for(int i = 0;i< s1.length();i++)
		{
		char c = s1.charAt(i);
		if(c=='t' ||c=='e' ){
		result = result+c;
		i++;
		}

		else if(i<s1.length())
		result = result + c;
		}
		
		
		
 		
 		if(result.contains("left"))
 		col = 0;
 		else if(result.contains("middle"))
 		col = 1;
 		else if(result.contains("right"))
 		col = 2;

		}
		}
		else 
		if(s1.contains("middle") &&  (s1.contains("uppe")))
 		{
 		row = 0;
 		col = 1;
 		} else if(!(rslt.contains("bottm")) && !(rslt.contains("bottom")) && !(rslt.contains("botttm")) && s1.contains("middle"))
 		{
 		if(s1.contains("left"))
 		{
 		row = 1;
 		col = 0;
 		}
 		else if(s1.contains("right"))
 		{
 		row = 1;
 		col = 2;
 		}
 		else if(s1.contains("middle"))
 		{
 		col = 1;
 		row = 1;
 		}
 		else
 		{
 		
 		
 		
 		
 		String result = "";
		for(int i = 0;i< s1.length();i++)
		{
		char c = s1.charAt(i);
		if(c=='t' ||c=='e' ){
		result = result+c;
		i++;
		}

		else if(i<s1.length())
		result = result + c;
		}
		
		
		
 		
 		if(result.contains("left"))
 		col = 0;
 		else if(result.contains("right"))
 		col = 2;
 		else if(result.contains("middle"))
 		col = 1;
 		

		}
		}
		else
		if(s1.contains("bottom"))
 		{
 		row = 2;
 		if(s1.contains("left"))
 		col = 0;
 		else if(s1.contains("middle"))
 		col = 1;
 		else if(s1.contains("right"))
 		col = 2;
 		else
 		{
 		
 		String result = "";
		for(int i = 0;i< s1.length();i++)
		{
		char c = s1.charAt(i);
		if(c=='t' ||c=='e' ){
		result = result+c;
		i++;
		}

		else if(i<s1.length())
		result = result + c;
		}
		
		
		
 		
 		if(result.contains("left"))
 		col = 0;
 		else if(result.contains("middle"))
 		col = 1;
 		else if(result.contains("right"))
 		col = 2;

		}
		}
		else 
		{
		String result1 = "";
		for(int i = 0; i < s1.length();i++)
		{
		char c = s1.charAt(i);
		if(c=='t' ||c=='e' ){
		result1 = result1+c;
		if(i<s1.length()-1 && s1.charAt(i+1) != 't')
		i++;
		}

		else if(i<s1.length())
		result1 = result1 + c;
		}
		if(result1.contains("bottm") || result1.contains("bottom") || result1.contains("botttm")  )
		{
		row = 2;
		if(s1.contains("left"))
 		col = 0;
 		else if(s1.contains("middle"))
 		col = 1;
 		else if(s1.contains("right"))
 		col = 2;
 		else
 		{
 		
 		String result = "";
		for(int i = 0;i< s1.length();i++)
		{
		char c = s1.charAt(i);
		if(c=='t' ||c=='e' ){
		result = result+c;
		i++;
		}

		else if(i<s1.length())
		result = result + c;
		}
		
		
		
 		
 		if(result.contains("left"))
 		col = 0;
 		else if(result.contains("middle"))
 		col = 1;
 		else if(result.contains("right"))
 		col = 2;

		}
		}
		else if (result1.contains("middle"))
		{
		row = 1;
		if(s1.contains("left"))
 		col = 0;
 		else if(s1.contains("middle"))
 		col = 1;
 		else if(s1.contains("right"))
 		col = 2;
 		else
 		{
 		
 		String result = "";
		for(int i = 0;i< s1.length();i++)
		{
		char c = s1.charAt(i);
		if(c=='t' ||c=='e' ){
		result = result+c;
		i++;
		}

		else if(i<s1.length())
		result = result + c;
		}
		
		
		
 		
 		if(result.contains("left"))
 		col = 0;
 		else if(result.contains("middle"))
 		col = 1;
 		else if(result.contains("right"))
 		col = 2;

		}
		}
		else if (result1.contains("upper"))
		{
		row = 0;
		if(s1.contains("left"))
 		col = 0;
 		else if(s1.contains("middle"))
 		col = 1;
 		else if(s1.contains("right"))
 		col = 2;
 		else
 		{
 		
 		String result = "";
		for(int i = 0;i< s1.length();i++)
		{
		char c = s1.charAt(i);
		if(c=='t' ||c=='e' ){
		result = result+c;
		i++;
		}

		else if(i<s1.length())
		result = result + c;
		}
		
		
		
 		
 		if(result.contains("left"))
 		col = 0;
 		else if(result.contains("middle"))
 		col = 1;
 		else if(result.contains("right"))
 		col = 2;

		}
		}
		}
		arr[row][col] = firstPlayer;
		IsWonGame(arr,firstPlayer);
		if(IsWonGame(arr,firstPlayer)== true && XOX.flag == false)
		{
		System.out.println("Congratulations " + first + " You won");
		break; //if method returns true exits from the loop.
		}
		else if(IsWonGame(arr,firstPlayer)== true && XOX.flag == true)
		break;
		if(first == player1)
 		{
 		System.out.println("The current state of the game is shown below. It’s "+ player2 + "'s   turn.");
 		}
 		else
 		{
 		System.out.println("The current state of the game is shown below. It’s "+ player1  + "'s   turn.");
 		}
		printArr(arr);
		if(firstPlayer == 'X')
		firstPlayer = 'O';
		else
		firstPlayer = 'X';
		if(first == player1)
		first = player2;
		else
		first = player1;
		
		
		
		
		}
		
		
		printArr(arr); // the next move after method returned true it will not enter to loop and print the last array.
		}
		public static void printArr(char[][] arr)
		{
		for(int row = 0;row<3;row++)
 		{
 			for(int column = 0;column<3;column++)
 			{
 			 System.out.print(arr[row][column]);
 			}
 			System.out.println();
 			
 		}
 		}
 		public static boolean IsWonGame(char[][]arr, char firstPlayer)
 		{
 		boolean flag = false;
 		int count = 0;
 		
 		
 		for(int row = 0;row<3;row++)
 		{
 		if(arr[row][0] == firstPlayer && arr[row][1] == firstPlayer &&  arr[row][2] == firstPlayer)
 		flag = true;
 		}
 		//checked for the same line
 		for(int col = 0;col<3;col++)
 		{
 		if(arr[0][col] ==firstPlayer &&  arr[1][col] == firstPlayer && arr[2][col] == firstPlayer)
 		flag = true;
 		}
 		//checked for the same column
 		if(arr[0][0] == firstPlayer && arr[1][1] ==firstPlayer && arr[2][2] == firstPlayer)
 		flag= true;
 		if(arr[0][2] == firstPlayer && arr[1][1] ==  firstPlayer && arr[2][0]== firstPlayer)
 		flag = true;
 		// checks for the diagonal
 		if(flag!=true)
 		{
 		for(int i = 0;i<arr.length;i++)
 		{
 		for(int k = 0;k<arr[0].length;k++)
 		{
 		if(arr[i][k] != '-')
 		count++;
 		}
 		}
 		if(count == arr.length*arr[0].length)
 		{
 		System.out.println("berabere");
 		XOX.flag = true;
 		return true;
 		}
 		}
 		else
 		{
 		
 		
		if(flag == true)
		XOX.winGame = true;
		else
		XOX.winGame = false;
 		
 		return flag;
 		}
 		return false;
 		}
 		}
