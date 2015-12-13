import java.util.Scanner;

public class KnightMoveCounter {
	static int counter=1;
	static boolean canStep(int [][] arr,int row,int col){
		return row>=0 &&
				row<arr.length&&
				col>=0 &&
				col <arr[0].length &&
				arr[row][col]==0;
	}
	static void markVisited(int [][] arr,int row,int col,int counter){
		arr[row][col]=counter;
	}
	static boolean moveTheKnight(int [][] arr,int row,int col){
		markVisited(arr,row,col,counter);
		counter=counter+1;
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
	static void create(int [][] arr){
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr[0].length;col++){
				arr[row][col]=0;
			}
		}
	}
	static void print(int [][] arr){
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr[0].length;col++){
				if(arr[row][col]<10){
					System.out.print("0"+arr[row][col]+" ");
				}
				else{
					System.out.print(arr[row][col]+" ");
				}
			}
			System.out.println();
		}
	}
	public static void main(String[] args) {
		Scanner in=new Scanner(System.in);
		int row=in.nextInt(),col=in.nextInt();
		int[][] arr=new int [row][col];
		int x=in.nextInt(),y=in.nextInt();
		create(arr);
		moveTheKnight(arr,x,y);
		print(arr);
		in.close();
	}

}
