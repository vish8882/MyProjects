package question;

public class PermutationModP {
	
	public static void main(String[] args) {
		int n=50;
		int r=40;
		int ncr=1;
		int j=1;
		boolean no=true;
		for(int i=1 ; i <=n ; i++){
			ncr=ncr*(i/j);
			if(r!=j && no)
				j++;
			else{
				j=1;
				no=false;
			}
		}
		System.out.println(ncr);
	}

}
