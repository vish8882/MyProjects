package datastructures.tree;

import java.util.Scanner;

public class SegmentTree {

	public static void main(String[] args) {
		int[] arr = {-1,0,3,6};
		SegmentTree segmentTree = new SegmentTree();
		int[] segmentArr = new int[7];
		segmentTree.buildSegmentTree(arr, segmentArr, 0, 0, arr.length-1);
		Scanner in = new Scanner(System.in);
		String cont = null;
		do {
			System.out.println("Enter input range in start,end format: ");
			String input = in.nextLine();
			String inputArr[] = input.split(",");
			int lQuery = Integer.parseInt(inputArr[0]);
			int hQuery = Integer.parseInt(inputArr[1]);
			System.out.println(segmentTree.findMinimumInRange(segmentArr, 0, 0, arr.length - 1, lQuery, hQuery));
			System.out.print("Do you want to enter range: ");
			cont = in.nextLine();
		} while(cont.equals("y"));
	}
	
	public void buildSegmentTree(int[] arr, int[] segmentArr, int pos, int start, int end) {
		if(start == end){
			segmentArr[pos] = arr[start];
			return;
		}
		int mid = (end+start)/2;
		buildSegmentTree(arr, segmentArr, 2*pos+1, start, mid);
		buildSegmentTree(arr, segmentArr, 2*pos+2, mid+1, end);
		segmentArr[pos] = Math.min(segmentArr[2*pos+1], segmentArr[2*pos+2]);
	}
	
	public int findMinimumInRange(int[] segmentArr, int pos, int start, int end, int lQuery, int hQuery) {
		if(start >= lQuery && end <= hQuery)
			return segmentArr[pos];
		else if (end < lQuery || start > hQuery) {
			return Integer.MAX_VALUE;
		}
		else{
		int mid = (end+start)/2;
		return Math.min(findMinimumInRange(segmentArr, 2*pos+1, start, mid, lQuery, hQuery),
				 findMinimumInRange(segmentArr, 2*pos+2, mid+1, end, lQuery, hQuery));
		}
		
	}

}
