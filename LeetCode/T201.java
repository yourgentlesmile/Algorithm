/**
 * https://leetcode-cn.com/problems/bitwise-and-of-numbers-range/
 * 10101110
 * 10110110
 * 只要有一位不同，那么后面的位一定会有0出现
 * 因为 0111变成1000，每一位都有突变
 * 所以只要同步右移，直到两数相同，再将移走的bit位移回去，就是答案
 */
public class T201 {
    public int rangeBitwiseAnd(int m, int n) {
        int count = 0;
        int temp1 = m;
        int temp2 = n;
        while(temp1 != temp2){
            count++;
            temp1 = temp1 >> 1;
            temp2 = temp2 >> 1;
        }
        return temp1 << count;
    }

    /**
     * 其实题的真正目的也就是求二进制数的相同前缀。
     * Brian Kernighan 算法 ，用于清除二进制右边的1，
     * 10101110
     * 10110110
     * 例如 10110110不断的清除掉右边的1，最终会成为
     * 10100000，即第一个小于m的数，就是答案
     * 因为 10100 减一之后是10011 ，按位与之后是10000，所以，当前数按位与上当前数-1
     * 就能达到清除最右边的1的目的
     */
    public int advance(int m, int n) {
        while(m < n) {
            n = n & (n - 1);
        }
        return n;
    }
}