import java.util.*;

/**
 * https://leetcode-cn.com/problems/course-schedule
 *
 * 拓扑排序
 * BFS依次输出入度为0的点，当从入度为0的点结束遍历时
 * 有点未被输出则表示无法完成拓扑排序
 *
 * 因为出现了环，则环内的点的入度都不会为0，所以无法被选取作为BFS的起点
 *
 */
public class T207 {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<ArrayList<Integer>> adjacency = new ArrayList<>((int)(numCourses * 1.5));
        int[] a = new int[numCourses];
        int outputCount = 0;
        for(int i = 0; i < numCourses; i++) {
            adjacency.add(new ArrayList<>());
        }
        for(int i = 0; i < prerequisites.length; i++) {
            a[prerequisites[i][1]]++;
            ArrayList<Integer> next = adjacency.get(prerequisites[i][0]);
            next.add(prerequisites[i][1]);
        }
        Queue<Integer> head = new LinkedList<>();
        for(int i = 0;i < numCourses;i++) {
            if(a[i] == 0) head.add(i);
        }
        while(!head.isEmpty()) {
            int cur = head.poll();
            outputCount++;
            ArrayList<Integer> next = adjacency.get(cur);
            for (Integer c : next) {
                a[c]--;
                if(a[c] == 0) head.add(c);
            }
        }
        return outputCount == numCourses;
    }
}
