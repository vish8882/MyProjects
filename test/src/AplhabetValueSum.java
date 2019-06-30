/**
 * An array contains values of letters from A-Z. The values are calculated in the following format.
 * A = 1
 * B = 2 * A + A
 * C = 3 * B + B
 * D = 4 * C + C
 * .
 * .
 * Z = 26 * Y + Y
 * 
 * Given a sum find the minimum number of values that can form this sum and print the alphabet corresponding to the values.
 */
import java.math.BigInteger;

public class AplhabetValueSum {

	static String finalPattern = "";

	static String  minCoins(BigInteger coins[], String[] charArr, int m, BigInteger V, BigInteger sum, int i, String pattern) {
		if (sum.compareTo(V) > 0) 
			return null;
		if (sum.compareTo(V) ==0) {
			/*if (sum == V && (finalPattern.length() == 0 || pattern.length() < finalPattern.length()))
				finalPattern = pattern;*/
			return pattern;
		}
		if (i == m)
			return null;

		finalPattern = minimumString(minCoins(coins, charArr, m, V, coins[i].add(sum), i, pattern + charArr[i]),
			minCoins(coins, charArr, m, V, sum, i + 1, pattern));
		return finalPattern;
	}
	
	public static String minimumString(String s1, String s2) {
		if(s1==null && s2==null)
			return null;
		if(s1==null)
			return s2;
		if(s2 == null)
			return s1;
		return s1.length() < s2.length() ? s1 : s2;
	}

	// Driver program
	public static void main(String[] args) {
		BigInteger[] valueArr = new BigInteger[26];
		String[] charArr = new String[26];
		for (int i = 0; i < 26; i++) {
			int a1 = 65 + i;
			char a = (char) a1;
			charArr[i] = String.valueOf(a);
			if (i > 0){				
				valueArr[i] = valueArr[i - 1].multiply(new BigInteger(String.valueOf(i+1))).add(valueArr[i - 1]);
			}
			else
				valueArr[i] = new BigInteger("1");
		}
		int m = valueArr.length;
		BigInteger V = new BigInteger("20");
		minCoins(valueArr, charArr, m, V, new BigInteger("0"), 0, "");
		System.out.println(finalPattern);
	}

}
