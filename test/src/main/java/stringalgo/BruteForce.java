package stringalgo;

public class BruteForce {
	public static  boolean bruteForceMatch(String t,String p){
		int n=t.length();
		int m=p.length();
		int j=0;
		long start= System.nanoTime();
		for(int i=0;i<=n-m;i++){
			for(j=0;j<m;j++){
				if(t.charAt(i+j)!=p.charAt(j))
					break;
			}
			if(j==m){
				long end= System.nanoTime();
				System.out.println(end-start);
				return true;
			}
		}
		long end= System.nanoTime();
		System.out.println(end-start);
		return false;
	}


}
