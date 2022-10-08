package recursion;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
	int requiredSum = 6249;
	public static void main(String[] args) {
		int coins[] = {186,419,83,408};
		int amount = 6249;
		int[] arr ={186,419,83,408};
		CoinChange coinChange = new CoinChange();
		coinChange.coinChange(arr, 0, 0, new ArrayList<String>(), false);
	}

	public void coinChange(int[] array, int index, int sum, List<String> list, boolean include){
		if(index == array.length)
			return;
		if(sum > requiredSum)
			return;
		if(include)
			list.add(String.valueOf(array[index]));
		if(sum==requiredSum) {
			list.forEach(value -> System.out.print(value+" "));
			System.out.println();
			return;
		}
		coinChange(array, index, sum+array[index], list, true);
		list.remove(String.valueOf(array[index]));
		coinChange(array, index+1, sum, list, false);
	}


	public int coinChangeDP(int[] coins, int amount) {
		int am[][] = new int[coins.length][amount + 1];
		for (int i = 0; i < coins.length; i++) {
			am[i][0] = 0;
		}
		for (int i = 0; i < coins.length; i++) {
			for (int j = 1; j < amount + 1; j++) {
				// if amount is less than the current coin value
				if (coins[i] > j) {
					if (i - 1 >= 0) {
						am[i][j] = am[i - 1][j];
					} else {
						am[i][j] = 0;
					}
				} else if (coins[i] == j) {
					//if the amount is equal to the current coin value
					am[i][j] = 1;
				} else {
					// find minimum of (i, j-coin), (i-1, j-coin), (i-1, j)
					// also ignore 0s from the minimum
					int min1 = am[i][j - coins[i]] > 0 ? am[i][j - coins[i]] + 1 : Integer.MAX_VALUE;
					int min2 = min1;
					if (i - 1 >= 0) {
						min2 = am[i - 1][j - coins[i]] > 0 ? am[i - 1][j - coins[i]] + 1 : min1;
						int min3 = am[i - 1][j] > 0 ? am[i - 1][j] : min1;
						min2 = Math.min(min2, min3);
					}

					am[i][j] = Math.min(min1, min2) != Integer.MAX_VALUE ?
							Math.min(min1, min2) : 0;
				}
			}
		}
		return am[coins.length - 1][amount];
	}
}
