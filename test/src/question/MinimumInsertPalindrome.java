package question;

public class MinimumInsertPalindrome {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String word = "geeks";
		
		
	}
	
	public int InsertionCount(String word){
		int length = word.length();
		int[][] array = new int[length][length];
		for(int i=0; i < length; i ++){
			for(int j=0; j<length; j ++){
				if(i<=length-j-1)
					array[i][j]=array[i][j-1];
				if(word.charAt(i)!=word.charAt(length-i))
					array[i][j]=Math.min(array[i][j-1]+1,array[i-1][length-1]);
				
			}
		}
		
		return 0;
	}

}
