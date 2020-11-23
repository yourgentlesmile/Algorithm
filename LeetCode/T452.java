import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/minimum-number-of-arrows-to-burst-balloons/
 *
 */
public class T452 {

    public int findMinArrowShots(int[][] points) {
        if(points.length == 0) {
            return 0;
        }
        Arrays.sort(points, (x, y) -> x[1] > y[1] ? 1 : -1);
        int pos = points[0][1];
        int ans = 1;
        for (int[] point : points) {
            if(point[0] > pos) {
                pos = point[1];
                ans++;
            }
        }
        return ans;
    }

}
