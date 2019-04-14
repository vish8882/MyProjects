/*
 * You have 2 candies red and blue and you need to arrange these candies in an order so that two similar candies can only
 * come K times together
 */

package question;

public class CandyArrangement {
	public static void main(String[] args) {
		String candy = "RRB";
		int r=2;
		int b=1;
		int k =1;
		candyArrangement(new char[candy.length()], 0, r, b, k, 0, 0,0,0);
	}
	
	public static void candyArrangement(char[] candy, int pos, int rCount, int bCount, int k, int r, int b, int rk,
			int bk) {
		if (pos == candy.length) {
			for (int i = 0; i < candy.length; i++) {
				System.out.print(candy[i]);
			}
			System.out.println();
			candy = new char[candy.length];
		}

		if (rk < k && r < rCount) {
			candy[pos] = 'R';
			candyArrangement(candy, pos + 1, rCount, bCount, k, r + 1, b, rk + 1, 0);
		}
		if (bk < k && b < bCount) {
			candy[pos] = 'B';
			candyArrangement(candy, pos + 1, rCount, bCount, k, r, b + 1, 0, bk + 1);
		}
	}
	

}
