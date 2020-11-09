import javafx.util.Pair;

import java.util.PriorityQueue;

/**
 * https://leetcode-cn.com/problems/k-closest-points-to-origin/
 *
 * 快速排序到第K个时终止
 */
public class T973 {
    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Pair<Integer,Integer>> queue = new PriorityQueue<>((x, y) -> {
            return x.getKey() * x.getKey() + x.getValue() * x.getValue() - y.getKey() * y.getKey() - y.getValue() * y.getValue() > 0 ? -1 : 1;
        });
        for(int i = 0; i < points.length; i++) {
            queue.offer(new Pair(points[i][0], points[i][1]));
            if(i >= K) queue.poll();
        }
        int[][] res = new int[K][2];
        int index = 0;
        while(!queue.isEmpty()) {
            Pair<Integer, Integer> s = queue.poll();
            res[index][0] = s.getKey();
            res[index][1] = s.getValue();
            index++;
        }
        return res;
    }
}
