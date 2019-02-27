package question;

public class TextJustification {

	public static void main(String[] args) {
		String word = "Tushar Roy Likes To Code";
		String[] wordArr = word.split(" ");
		int[] letterCount = new int[wordArr.length];
		for(int i=0; i < letterCount.length; i++){
			letterCount[i] = wordArr[i].length();
		}
		int[][] spaceLeftSQ = new int[letterCount.length][letterCount.length];
		computeArray(letterCount, 10, spaceLeftSQ);
		for(int i=0; i < letterCount.length; i++ ){
			for(int j=0; j < letterCount.length; j++){
				System.out.print(spaceLeftSQ[i][j]+" ");
			}
			System.out.println();
		}
		calculateMinimumSpace(spaceLeftSQ);
	}

	public static void computeArray(int[] letterCount, int width, int[][] spaceLeftSQ){
		for(int i=0; i < letterCount.length; i++ ){
			int sum=0;
			int count=0;
			for(int j=i; j < letterCount.length; j++){
				sum=sum+letterCount[j]+count++;
				spaceLeftSQ[i][j]=(int) ((sum<=10) ? Math.pow(width-sum, 2): -1);
			}
		}
	}
	
	public static void calculateMinimumSpace(int[][] spaceLeftSQ){
		int[] minimumSpace = new int[ spaceLeftSQ.length];
		int[] justifiedIndex = new int[ spaceLeftSQ.length];
		for(int i= 0; i < minimumSpace.length ; i++){
			int minimumTillNow=100;
			for(int j = 0 ; j <= i ; j++) {
				int a =0;
				if(spaceLeftSQ[j][i] >= 0){
					if(j-1>=0)
						a = spaceLeftSQ[j][i] + minimumSpace[j-1]; 
					else
						a = spaceLeftSQ[j][i];
					
					if(a < minimumTillNow) {
						minimumTillNow = a;
						justifiedIndex[i] = j;
					}
				}
			}
			minimumSpace[i] = minimumTillNow;
		}
		System.out.println();
	}
	
}
