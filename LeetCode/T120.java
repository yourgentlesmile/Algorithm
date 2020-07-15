import java.util.Collections;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/triangle/
 * 自顶向下动态规划
 */
public class T120 {
    public int minimumTotal(List<List<Integer>> triangle) {
        for(int i = 1;i < triangle.size();i++) {
            List<Integer> prev = triangle.get(i - 1);
            List<Integer> cur = triangle.get(i);
            for(int j = 0;j < cur.size();j++) {
                int t1 = (j - 1 < 0) ? Integer.MAX_VALUE : prev.get(j - 1);
                int t2 = (j >= prev.size()) ? Integer.MAX_VALUE : prev.get(j);
                int c = cur.get(j);
                cur.set(j,Math.min(t1, t2) + c);
            }
        }
        return Collections.min(triangle.get(triangle.size() - 1));
    }
}
