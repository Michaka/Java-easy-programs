import java.util.Scanner;

public class TicTacToe {
	static void fillIt(char[][] arr){
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr[0].length;col++){
				arr[row][col]=' ';
			}
		}
	}
	static void print(char[][] arr){
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr[0].length;col++){
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
	}
	static boolean notMarked(char [][]arr,int row,int col){
		return row>=0&&
				row <arr.length &&
				col>=0 &&
				col<arr[0].length &&
				arr[row][col]==' ';
	}
	static void inPut(char[][]arr,boolean flag,int row,int col){
		if(notMarked(arr,row,col)){
			if(flag){
				arr[row][col]='O';
				
			}
			else{
				arr[row][col]='X';
				
			}
		}
	}
	static void showWinner(char symbol){
		if(symbol=='O'){
			System.out.println("player 1 with O wins");
		}
		else{
			System.out.println("player 2 with X wins");
		}
	}
	static boolean haveWinner(char [][]arr){
		for(int row = 0; row<3;row++){
			if(arr[row][0]==arr[row][1] && arr[row][0]==arr[row][2] && arr[row][0]!=' ' && arr[row][1]!=' '&& arr[row][2]!=' '){
				showWinner(arr[row][0]);
				return false;
			}
		}
		for(int col=0;col<3;col++){
			if(arr[0][col]==arr[1][col] && arr[0][col]==arr[2][col] && arr[0][col]!=' ' && arr[1][col]!=' '&& arr[2][col]!=' '){
				showWinner(arr[0][col]);
				return false;
			}
		}
		if(arr[0][0]==arr[1][1] && arr[0][0]==arr[2][2] && arr[0][0]!=' ' && arr[1][1]!=' '&& arr[2][2]!=' '){
			showWinner(arr[0][0]);
			return false;
		}if(arr[2][0]==arr[1][1] && arr[0][2]==arr[2][0] && arr[0][2]!=' ' && arr[1][1]!=' '&& arr[2][0]!=' '){
			showWinner(arr[2][0]);
			return false;
		}
		return true;
		
	}
	
	public static void main(String[] args)  {
		char [][] ticTacToe=new char[3][3];
		Scanner in=new Scanner(System.in);
		int x,y,counter=0;
		boolean flag=true;
		fillIt(ticTacToe);
		do{
			do{
				x=in.nextInt();
				y=in.nextInt();
			}while( !notMarked(ticTacToe, x, y));
			
			inPut(ticTacToe, flag, x, y);
			print(ticTacToe);
			if(flag){
				flag=false;
			}
			else{
				flag=true;
			}
			counter++;
			
		}while(counter<9 && haveWinner(ticTacToe));
		print(ticTacToe);
		in.close();
	}

}
