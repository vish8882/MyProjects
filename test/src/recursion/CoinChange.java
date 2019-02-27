package recursion;

import java.util.ArrayList;
import java.util.List;

public class CoinChange {
	int requiredSum = 4;
	public static void main(String[] args) {
		int[] arr = {1,2,3};
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
}
