package question;

import java.util.*;

public class OverLappingRectangles {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int numberOfSlots = Integer.parseInt(in.nextLine().trim());
		int arrayI = Integer.parseInt(in.nextLine().trim());
		int arrayJ = Integer.parseInt(in.nextLine().trim());
		List<List<Integer>> rectangle = new ArrayList<>();
		for (int i = 0; i < arrayI; i++) {
			String coordinates = in.nextLine().trim();
			String[] coordArray = coordinates.split(" ");
			List<Integer> list = new ArrayList<>();
			for (int j = 0; j < arrayJ; j++) {
				list.add(Integer.parseInt(coordArray[j]));
			}
			rectangle.add(list);
		}
		in.close();
		//int[][] array = new int[1000][1000];
		List<int[][]> list = findArrayLength(rectangle);
		int overLappedAreaPositive = areaOfOverLapping(rectangle, list.get(0), true);
		System.out.println(overLappedAreaPositive);
	}
	
	public static List<int[][]> findArrayLength(List<List<Integer>> rectangles){
		int firstNegativeLength = 0;
		int secondNegativeLength = 0;
		int firstLength=0;
		int secondLength=0;
		for(List<Integer> rectangle : rectangles){
			int x2 = rectangle.get(2);
			int y2 = rectangle.get(3);
			if(x2 < firstNegativeLength)
				firstNegativeLength = x2;
			if(y2 < secondNegativeLength)
				secondNegativeLength = y2;
			if(x2 > firstLength)
				firstLength = x2;
			if(y2 > secondLength)
				secondLength = y2;
		}
		List<int[][]> list = new ArrayList<>();
		list.add(new int[firstLength+1][secondLength+1]);
		list.add(new int[0-firstNegativeLength+1][0-secondNegativeLength+1]);
		return list;
	}

	public static int areaOfOverLapping(List<List<Integer>> rectangles,
			int[][] arrayOfPlane , boolean isPositive) {
		int area = 0;
		int k = arrayOfPlane.length;
		for (int i = 0; i < k; i++) {
			int[] arr = arrayOfPlane[k-1];
			for (int j = 0; j < arr.length; j++) {
				arrayOfPlane[i][j] = 0;
				int temp = 0;
				for (List<Integer> rectangle : rectangles) {
					boolean isPartOfRectangle;
					if (isPositive)
						isPartOfRectangle = checkPointLiesInsideSlot(rectangle,
								i, j);
					else
						isPartOfRectangle = checkPointLiesInsideSlotNegative(rectangle,
								0 - i, 0 - j);
					if (isPartOfRectangle) {
						arrayOfPlane[i][j]++;
						if (arrayOfPlane[i][j] == 1)
							temp = rectangle.get(4);
						if (arrayOfPlane[i][j] > 1) {
							area = area + rectangle.get(4) + temp;
							temp = 0;
						}
					}
				}
			}
		}
		return area;
	}

	public static boolean checkPointLiesInsideSlot(List<Integer> rectangle,
			double x, double y) {
		int x1 = rectangle.get(0);
		int y1 = rectangle.get(1);
		int x2 = rectangle.get(2);
		int y2 = rectangle.get(3);
		if (x == x1 || x == x2)
			if (y >= y1 && y <= y2)
				return true;
		if (y == y1 || y== y2)
			if (x >= x1 && x <= x2)
				return true;
		if (x > x1)
			if (y > y1)
				if (x < x2)
					if (y < y2)
						return true;
		
		return false;
	}
	public static boolean checkPointLiesInsideSlotNegative(List<Integer> rectangle,
			double x, double y) {
		int x1 = rectangle.get(0);
		int y1 = rectangle.get(1);
		int x2 = rectangle.get(2);
		int y2 = rectangle.get(3);
		if (x == x1 || x == x2)
			if (y <= y1 && y >= y2)
				return true;
		if (y == y1 || y== y2)
			if (x <= x1 && x >= x2)
				return true;
		if (x < x1)
			if (y < y1)
				if (x > x2)
					if (y > y2)
						return true;
		
		return false;
	}

}
