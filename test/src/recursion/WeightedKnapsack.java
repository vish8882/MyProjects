package recursion;

import java.util.*;

public class WeightedKnapsack {
	 int maxWeight = 50;
	 int maxProfit = 0;
	 List<String> weightList = new ArrayList<String>();
	public void weightedKnapsack(int[] weightArr, int[] profitArr, int index,int weight, int profit,
			List<String> list)
	{
		if (weight <= maxWeight && profit > maxProfit) {
			maxProfit = profit;
			this.weightList = new ArrayList<>(list);
		}
		if (weight > maxWeight || index == weightArr.length)
			return;
		list.add(String.valueOf(weightArr[index]));
		weightedKnapsack(weightArr, profitArr, index + 1, weight + weightArr[index], profit + profitArr[index], list);
		list.remove(String.valueOf(weightArr[index]));
		weightedKnapsack(weightArr, profitArr, index + 1, weight, profit, list);
	}

	public static void main(String[] args) {
		int[] weightArr = { 10, 20, 30 };
		int[] profitArr = { 60, 100, 120 };
		WeightedKnapsack knapsack = new WeightedKnapsack();
		knapsack.weightedKnapsack(weightArr, profitArr, 0, 0, 0, new ArrayList<String>());
		System.out.println(knapsack.maxProfit);
		for (String i : knapsack.weightList) {
			System.out.println(i);
		}
	}
}
