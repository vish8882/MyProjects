package objecttest;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.StringTokenizer;
import java.math.BigInteger;
class ChefAndWay {
	public static void main(String args[])throws NumberFormatException,IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine()," ");
		StringTokenizer st2 = new StringTokenizer(br.readLine()," ");
		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int[] streets = new int[n];
		BigInteger[] nums = new BigInteger[n];
		for(int i = 0;i<n;i++){
			streets[i] = Integer.parseInt(st2.nextToken());
			nums[i] = new BigInteger(streets[i]+"");
		}
		for(int a = 1;a<n-1;a++){
			int back = Math.max(0, a-k);
			nums[a] = nums[a].multiply(nums[back]);
		}
		ArrayList<BigInteger> list = new ArrayList<BigInteger>();
		for(int b = n-2;b>=n-1-k;b--){
			list.add(nums[b].multiply(nums[n-1]));
		}
		BigInteger min = Collections.min(list);
		nums[n-1] = min;
		nums[n-1] = nums[n-1].mod(new BigInteger("1000000007"));
		bw.write(nums[n-1]+"");
		bw.flush();
	}
} 