package hackerrank;

import java.util.*;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Hackerrank {
	
	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		String name = s.nextLine(); // Reading input from STDIN
		// Writing output to STDOUT

		String[] input = name.split(" ");
		int n = Integer.parseInt(input[0]);
		int m = Integer.parseInt(input[1]);
		int[][] arr = new int[n][m];
		Map<Integer,String> map = new HashMap();
		for (int i = 0; i < n; i++) {
			String row = s.nextLine();
			String[] rowArr = row.split(" ");
			for (int j = 0; j < m; j++) {
				map.put(Integer.parseInt(rowArr[j]),i+" "+j);
			}
		}
		int qLine = Integer.parseInt(s.nextLine());
		List<Integer> list = new ArrayList();
			for(int i = 0; i < qLine; i ++){
				list.add(Integer.parseInt(s.nextLine().trim()));
			}
		boolean found = false;
		String value=null;
		for(int k = 0 ; k < list.size(); k ++){	
				if((value = map.get(list.get(k)))!=null)
					System.out.println(value);
				else
					System.out.println("-1"+" "+"-1");
						
		}
		
	}
	

}
