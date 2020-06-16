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
}