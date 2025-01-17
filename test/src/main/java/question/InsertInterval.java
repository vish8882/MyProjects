package question;

import java.util.*;

/**
 * You are given an array of non-overlapping intervals intervals where intervals[i] = [starti, endi] represent the start and the end of the ith interval and intervals is sorted in ascending order by starti. You are also given an interval newInterval = [start, end] that represents the start and end of another interval.
 * Insert newInterval into intervals such that intervals is still sorted in ascending order by starti and intervals still does not have any overlapping intervals (merge overlapping intervals if necessary).

 * Return intervals after the insertion.

 * Example 1:

 * Input: intervals = [[1,3],[6,9]], newInterval = [2,5]
 * Output: [[1,5],[6,9]]
 * Example 2:

 * Input: intervals = [[1,2],[3,5],[6,7],[8,10],[12,16]], newInterval = [4,8]
 * Output: [[1,2],[3,10],[12,16]]
 * Explanation: Because the new interval [4,8] overlaps with [3,5],[6,7],[8,10].
 */
public class InsertInterval {

    public static void main(String[] args) {

        //int [][] intervals = {{1,2},{4,5},{6,7},{9,10},{12,16}};
        int [][] intervals = {{1,5}};
        int[] newInterval = {1,7};
        int[][] output = insert(intervals, newInterval);
        System.out.println(Arrays.deepToString(output));
    }


    public static int[][] insert(int[][] intervals, int[] newInterval) {
        List<Integer> list = new ArrayList<>();
        list.add(newInterval[0]);
        list.add(newInterval[1]);
        boolean isFirst = true;
        for (int[] interval : intervals) {
            list.add(interval[0]);
            list.add(interval[1]);
        }
        Collections.sort(list);
        LinkedList<Integer> arr = new LinkedList<>();
        boolean add = true;
        for(int i =0; i< list.size(); i++) {
            if(isFirst && list.get(i) == newInterval[0]) {
                if(i % 2 == 1) {
                    add = false;
                } else {
                    arr.add(list.get(i));
                    add = false;
                }
                isFirst = false;
            } else if (list.get(i) == newInterval[1]) {
                if((i+1) < list.size() && Objects.equals(list.get(i), list.get(i+1))) {
                    i++;
                    if(i %2 == 0) {
                        add = true;
                        continue;
                    } else {
                        add = true;
                    }
                } else if(i %2 == 0) {
                    add = true;
                    continue;
                } else {
                    add = true;
                }
            }
            if(add && (list.get(i) <= newInterval[0] || list.get(i) >= newInterval[1])) {
                arr.add(list.get(i));
            }
        }

        int count = 0;
        int [][] output = new int[arr.size() / 2][2];
        if(arr.size() % 2 != 0) {
            return output;
        }
        while(!arr.isEmpty()) {
            int [] a = new int[2];
            output[count][0] = arr.removeFirst();
            output[count][1] = arr.removeFirst();
            count ++;
        }
        return output;
    }
}
