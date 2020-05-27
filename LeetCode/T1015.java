/**
 * https://leetcode-cn.com/problems/smallest-integer-divisible-by-k/
 * 通过取余数来避免int溢出
 * 同时 K能被2,5整除时是一定无法达到条件的
 */
public class T1015 {
    public int smallestRepunitDivByK(int K) {
        if(K % 2 == 0 || K % 5 == 0) return -1;
        int a = 1;
        int len = 1;
        while(true) {
            if(a % K == 0) return len;
            a = (a * 10 + 1) % K;
            len++;
        }
    }
}
