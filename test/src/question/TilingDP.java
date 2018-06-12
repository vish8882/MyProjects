package question;
/*
 * Given a “2 x n” board and tiles of size “2 x 1”, count the number of ways to tile the given board using the 
 * 2 x 1 tiles. A tile can either be placed horizontally i.e., as a 1 x 2 tile or vertically i.e., as 2 x 1 tile.
 */
public class TilingDP {
	public static void main(String[] args) {
		int n=4;
		int[] a = new int[n+1];
		System.out.println(adjustTile(a,n));
		System.out.println(adjustNxMTile(7,4));
	}

public static int adjustTile(int[] a,int n){
	if(n==0)
		return 1;
	if(n==1)
		return 1;
	if(a[n]!=0)
		return a[n];
	int count = adjustTile(a,n-1) + adjustTile(a,n-2);
	a[n]=count;
	return count;
}

public static int adjustNxMTile(int n,int m){
	if(n==0)
		return 1;
	if(n==1)
		return 1;
	if(n<m)
		return adjustNxMTile(n-1,m);
	
	return (adjustNxMTile(n-1,m) + adjustNxMTile(n-m,m));
}

}