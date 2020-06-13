/**
 * https://leetcode-cn.com/problems/climbing-stairs/
 * 就是斐波那契数列
 */
public class T70 {
    public int climbStairs(int n) {
        if(n == 1) return 1;
        int left = 1;
        int mid = 1;
        for(int i = 1; i < n;i++){
            int temp = left + mid;
            left = mid;
            mid = temp;
        }
        return mid;
    }
}
