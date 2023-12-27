package question;

import java.util.Arrays;
import java.util.Comparator;

/**
 * Given an array of intervals 'intervals' where intervals[i] = [starti, endi], return the minimum number of intervals you need to remove to make the rest of the intervals non-overlapping.
 * Example 1:
 * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
 * Output: 1
 * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
 * Example 2:

 * Input: intervals = [[1,2],[1,2],[1,2]]
 * Output: 2
 * Explanation: You need to remove two [1,2] to make the rest of the intervals non-overlapping.
 * Example 3:

 * Input: intervals = [[1,2],[2,3]]
 * Output: 0
 * Explanation: You don't need to remove any of the intervals since they're already non-overlapping.
 */
public class NonOverlappingInterval {

    public static void main(String[] args) {
        int[][] intervals = {{1,100},{11,22},{1,11},{2,12}};
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        int count = 0;
        int index = 1;
        int i = intervals.length - 1;
        while (i > 0) {
            if (i - index < 0) {
                break;
            }
            if (intervals[i - index][1] >= intervals[i][1]) {
                count++;
                index++;
            } else if (intervals[i - index][0] == intervals[i][0]) {
                count++;
                index++;
            } else if (intervals[i - index][1] > intervals[i][0]) {
                count++;
                index++;
            } else {
                i = i - index;
                index = 1;
            }
        }
        System.out.println(count);
    }
}
