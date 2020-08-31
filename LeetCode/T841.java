import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * https://leetcode-cn.com/problems/keys-and-rooms
 *
 * 孤岛问题
 */
public class T841 {
    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        int[] vis = new int[rooms.size()];
        vis[0] = 1;
        int n = 0;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(0);
        while(!queue.isEmpty()) {
            int room = queue.poll();
            vis[room]++;
            n++;
            for(int i = 0; i < rooms.get(room).size();i++) {
                int key = rooms.get(room).get(i);
                if(vis[key] != 0 ) continue;
                vis[key]++;
                queue.offer(key);
            }
        }
        return n == vis.length;
    }
}
