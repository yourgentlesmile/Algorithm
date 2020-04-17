import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/ji-qi-ren-de-yun-dong-fan-wei-lcof/
 */
public class T1531 {
    static class Point {
        public int x;
        public int y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static int calc(int x,int y) {
        int sum = 0;
        while(x != 0) {
            sum += x % 10;
            x = x / 10;
        }
        while(y != 0) {
            sum += y % 10;
            y = y / 10;
        }
        return sum;
    }
    public static int movingCount(int m, int n, int k) {
        int[][] map = new int[m][n];
        map[0][0] = 1;
        Stack<Point> stack = new Stack<>();
        stack.push(new Point(0, 0));
        int count = 1;
        while(!stack.isEmpty()) {
            Point cur = stack.pop();
            if(cur.x + 1 < m && map[cur.x + 1][cur.y] == 0 && calc(cur.x + 1,cur.y) <= k) {
                stack.push(new Point(cur.x + 1, cur.y));
                map[cur.x + 1][cur.y] = 1;
                count += 1;
            }
            if(cur.y + 1 < n && map[cur.x][cur.y + 1] == 0 && calc(cur.x, cur.y + 1) <= k) {
                stack.push(new Point(cur.x, cur.y + 1));
                map[cur.x][cur.y + 1] = 1;
                count += 1;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(movingCount(2, 3, 1));
    }
}
