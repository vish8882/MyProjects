package question;

public class TrappingRainWater {
	static int arr[] = new int[] { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };

	// Method for maximum amount of water
	static int findWater(int n) {
		int left[] = new int[n];
		int right[] = new int[n];

		int water = 0;

		// Fill left array
		left[0] = arr[0];
		for (int i = 1; i < n; i++)
			left[i] = Math.max(left[i - 1], arr[i]);

		// Fill right array
		right[n - 1] = arr[n - 1];
		for (int i = n - 2; i >= 0; i--)
			right[i] = Math.max(right[i + 1], arr[i]);
		
		for (int i = 0; i < n; i++)
			water += Math.min(left[i], right[i]) - arr[i];

		return water;
	}

	// Driver method to test the above function
	public static void main(String[] args) {

		System.out.println("Maximum water that can be accumulated is " + findWater(arr.length));
	}
}
