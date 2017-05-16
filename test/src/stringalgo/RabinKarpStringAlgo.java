package stringalgo;

public class RabinKarpStringAlgo {
	
	static int prime=3;
	static long oldHash=0;
	static long hash;
	static char old;
	int length;
	public static void main(String[] args) {
		
		String string ="AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
				+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
				+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
				+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAA"
				+ "AAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAAB";
		String pattern="AAAAAAAAB";
		matching(string, pattern);
		
	}
	
	public static  void matching(String string, String pattern){
		long hash=0;
		for(int k=0; k<pattern.length() ; k++){
			hash= hash+(int)pattern.charAt(k)*(int)(Math.pow(prime, k));
		}
		boolean match=false;
		int m = string.length();
		int n = pattern.length();
		long start=System.nanoTime();
		for(int i=0; i<=m-n; i++){
			if(hash==hash(string.substring(i, i+n))){
				for(int j=0; j<n;j++){
					if(string.charAt(i+j)!=pattern.charAt(j)){
						match= false;
						continue;
					}
					else match = true;
				}
				if(match){
					System.out.println("Match found at index "+ i);
					break;
				}
			}
		}
		if(!match)
			System.out.println("No match found");
		long end=System.nanoTime();
		System.out.println(end-start);
	}
	
	public static long hash(String key){
		int leng= key.length();
		if(oldHash==0){
			for(int i=0; i<leng ; i++){
				hash= hash+(int)key.charAt(i)*(int)(Math.pow(prime, i));
			}
		}
		else{
		hash=oldHash - (int) old;
		hash=hash/prime;
		hash=hash+ key.charAt(leng-1) * (int)(Math.pow(prime, leng-1));	
		}
		oldHash=hash;
		old =key.charAt(0);
		return hash;
	}
	
}
