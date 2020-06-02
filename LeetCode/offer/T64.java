package offer;

/**
 * https://leetcode-cn.com/problems/qiu-12n-lcof/
 * 通过 && 的短路性质来达到递归终止的目的
 */
public class T64 {
    int res = 0;
    public int sumNums(int n) {
        boolean x = n > 1 && sumNums(n - 1) > 0;
        res += n;
        return res;
    }
}
