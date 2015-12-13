import java.util.Scanner;

public class KnightTurn {
	
	static boolean canStep(char [][] arr,int row,int col){
		return row>=0 &&
				row<arr.length&&
				col>=0 &&
				col <arr[0].length &&
				arr[row][col]==' ';
	}
	static void markVisited(char [][] arr,int row,int col){
		arr[row][col]='.';
	}
	static boolean moveTheKnight(char [][] arr,int row,int col){
		markVisited(arr,row,col);
		if(canStep(arr,row-2,col-1)&&moveTheKnight(arr,row-2,col-1)){
			return true;
		}
		if(canStep(arr,row-2,col+1)&&moveTheKnight(arr,row-2,col+1)){
			return true;
		}
		if(canStep(arr,row-1,col+2)&&moveTheKnight(arr,row-1,col+2)){
			return true;
		}
		if(canStep(arr,row+1,col+2)&&moveTheKnight(arr,row+1,col+2)){
			return true;
		}
		if(canStep(arr,row+2,col+1)&&moveTheKnight(arr,row+2,col+1)){
			return true;
		}
		if(canStep(arr,row+2,col-1)&&moveTheKnight(arr,row+2,col-1)){
			return true;
		}
		if(canStep(arr,row-1,col-2)&&moveTheKnight(arr,row-1,col-2)){
			return true;
		}
		if(canStep(arr,row+1,col-2)&&moveTheKnight(arr,row+1,col-2)){
			return true;
		}
		return false;
	}
	static void create(char [][] arr){
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr[0].length;col++){
				arr[row][col]=' ';
			}
		}
	}
	static void print(char [][] arr){
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr[0].length;col++){
				System.out.print(arr[row][col]);
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int row=in.nextInt(),col=in.nextInt();
		char[][] arr=new char [row][col];
		create(arr);
		int x,y;
		do{
			x=in.nextInt();
			y=in.nextInt();
		}while(!canStep(arr, x, y));
		
		
		moveTheKnight(arr,x,y);
		print(arr);
		in.close();
	}

}
