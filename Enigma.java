import java.util.Scanner;

public class Enigma {
	
	
	
	static String fixLength(String arr){
		arr=arr.toUpperCase().trim();
		if(arr.length()%2!=0){
			arr=arr+"A";
		}
		return arr;
	}
	static int findSymbolInTable(char[][]arr,char symbol){
		for(int row=0;row<arr.length;row++){
			for(int col=0;col<arr[0].length;col++){
				if(arr[row][col]==symbol){
					return (row*10)+col;
				}
			}
		}
		return 0;
		
	}
	static boolean thereIsSymbol(char [][] arr,int row,int col){
		return row>=0 &&
				row<arr.length&&
				col>=0 &&
				col <arr[0].length ;
	}
	static String replace(char[][] arr,int firstSymbol,int secondSymbol){
		String newSymbols=new String();
		int rowOne=(firstSymbol/10),colOne=(firstSymbol%10),rowTwo=(secondSymbol/10),colTwo=(secondSymbol%10);
		if(rowOne==rowTwo){
			if(thereIsSymbol(arr, rowOne, colOne+1)){
				newSymbols=newSymbols+arr[rowOne][colOne+1];
			}
			else{
				newSymbols=newSymbols+arr[rowOne][0];
			}
			if(thereIsSymbol(arr, rowTwo, colTwo+1)){
				newSymbols=newSymbols+arr[rowTwo][colTwo+1];
			}
			else{
				newSymbols=newSymbols+arr[rowTwo][0];
			}
		}
		if(colOne==colTwo){
			if(thereIsSymbol(arr, rowOne+1, colOne)){
				newSymbols=newSymbols+arr[rowOne+1][colOne];
			}
			else{
				newSymbols=newSymbols+arr[0][colOne];
			}
			if(thereIsSymbol(arr, rowTwo+1, colTwo)){
				newSymbols=newSymbols+arr[rowTwo+1][colTwo];
			}
			else{
				newSymbols=newSymbols+arr[0][colTwo];
			}
		}if(colOne!=colTwo&& rowOne!=rowTwo){
			newSymbols=newSymbols+arr[rowOne][colTwo]+arr[rowTwo][colOne];
		}
		return newSymbols;
	}
	static String replaceDecode(char[][] arr,int firstSymbol,int secondSymbol){
		String newSymbols=new String();
		int rowOne=(firstSymbol/10),colOne=(firstSymbol%10),rowTwo=(secondSymbol/10),colTwo=(secondSymbol%10);
		if(rowOne==rowTwo){
			if(thereIsSymbol(arr, rowOne, colOne-1)){
				newSymbols=newSymbols+arr[rowOne][colOne-1];
			}
			else{
				newSymbols=newSymbols+arr[rowOne][arr[0].length];
			}
			if(thereIsSymbol(arr, rowTwo, colTwo-1)){
				newSymbols=newSymbols+arr[rowTwo][colTwo-1];
			}
			else{
				newSymbols=newSymbols+arr[rowTwo][arr[0].length];
			}
		}
		if(colOne==colTwo){
			if(thereIsSymbol(arr, rowOne-1, colOne)){
				newSymbols=newSymbols+arr[rowOne-1][colOne];
			}
			else{
				newSymbols=newSymbols+arr[arr.length][colOne];
			}
			if(thereIsSymbol(arr, rowTwo-1, colTwo)){
				newSymbols=newSymbols+arr[rowTwo-1][colTwo];
			}
			else{
				newSymbols=newSymbols+arr[arr.length][colTwo];
			}
		}if(colOne!=colTwo&& rowOne!=rowTwo){
			newSymbols=newSymbols+arr[rowOne][colTwo]+arr[rowTwo][colOne];
		}
		return newSymbols;
	}
	static String encode(char [][]arr,String words){
		String newWords=new String();
		words=fixLength(words);
		for(int index=0;index<words.length()-1;index++){
			newWords=newWords+replace(arr, 
									findSymbolInTable(arr, words.charAt(index)),
									findSymbolInTable(arr, words.charAt(index+1))
									);
			index=index+1;
		}
		return newWords;
	}
	static String decode (char [][]arr,String words){
		String newWords=new String();
		words=fixLength(words);
		for(int index=0;index<words.length()-1;index++){
			newWords=newWords+replaceDecode(arr, 
									findSymbolInTable(arr, words.charAt(index)),
									findSymbolInTable(arr, words.charAt(index+1))
									);
			index=index+1;
		}
		return newWords;
	}
	static boolean checkString(String string){
		for(int index=0;index<string.length();index++){
			if(!(string.charAt(index)>='a' && string.charAt(index)<'z') && !(string.charAt(index)>='A' && string.charAt(index)<'Z') ){
				return false;
			}
			
		}
		return true;
	}
	public static void main(String[] args) {
		char [][] codeTable={   {'L','F','B','R','N'},
								{'A','M','Y','E','P'},
								{'G','J','H','D','X'},
								{'C','T','S','U','K'},
								{'O','V','I','W','Q'}
							};
		Scanner in=new Scanner(System.in);
		
		String word1;
		do{
			word1=in.nextLine();
		}while(!checkString(word1));
		String word2=encode(codeTable,word1);
		//System.out.println(word1);
		System.out.println(encode(codeTable, word1));
		//System.out.println(word2);
		System.out.println(decode(codeTable, word2)); 
			in.close();
		

	}

}
