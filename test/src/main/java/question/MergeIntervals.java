package question;

import java.util.Arrays;
import java.util.Comparator;
import java.util.LinkedList;

/**
 * Given an array of intervals where intervals[i] = [starti, endi], merge all overlapping intervals, and return an array of the non-overlapping intervals that cover all the intervals in the input.
 *
 *
 *
 * Example 1:
 *
 * Input: intervals = [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlap, merge them into [1,6].
 * Example 2:
 *
 * Input: intervals = [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 */
public class MergeIntervals {

    public static void main(String[] args) throws Exception {
        int[][] intervals = {{2, 3},
                {4, 5},
                {6, 7},
                {8, 9},
                {1, 10}};
        //1,3  2,17  4,20  5,18
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        LinkedList<Integer> list = new LinkedList<>();
        list.add(intervals[0][0]);
        list.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (list.getLast() < intervals[i][0]) {
                list.add(intervals[i][0]);
                list.add(intervals[i][1]);
            } else {
                int last = list.removeLast();
                list.add(Math.max(last, intervals[i][1]));
            }
        }
        int[][] res = new int[list.size() / 2][2];

        for (int i = 0; i < res.length; i++) {
            res[i][0] = list.removeFirst();
            res[i][1] = list.removeFirst();
        }

        System.out.println(Arrays.deepToString(res));

    }
}
