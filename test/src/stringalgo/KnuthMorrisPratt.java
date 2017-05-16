package stringalgo;

public class KnuthMorrisPratt {

	public void stringMatch(String text, String pattern){
		boolean match=false;
		long start=System.nanoTime();
		int prefix[] =calculatePrefixTable(pattern);
		int n=text.length();
		int m=pattern.length();
		int i=0;
		int j=0;
		while(i<n){
			if(text.charAt(i)==pattern.charAt(j)){
				if(j==m-1){
					match=true;
					break;
					}
				else{
				i++;
				j++;
				}
			}
			else if(j<=0){
				i=i+1;
			}
			else{
				j=prefix[j-1];
			}			
		}
		if(match)
			System.out.println("Match Found");
		else
			System.out.println("KMP Match not found");
		
		long end=System.nanoTime();
		System.out.println(end-start);
	}
	public int[] calculatePrefixTable(String P){
		int i=1;
		int j=0;
		int m = P.length();
		int[] F = new int[m];
		F[0]=0;
		while(i<m){
			if(P.charAt(i)==P.charAt(j)){
				F[i]=j+1;
				i++;
				j++;
			}
			else if(j>0){
				j=F[j-1];
			}
			else{
				F[i]=0;
				i++;
			}
		}
		return F;
	}
}
