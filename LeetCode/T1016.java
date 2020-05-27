/**
 * 转成二进制比较即可
 * 优化点：
 * 由于1 ~ N的数组中，N / 2 + 1 ~ N的数字其实都是由1 ~ N / 2 二进制右移一位得来的
 * 所以1 ~ N / 2中的二进制一定是N / 2 + 1 ~ N的二进制的子集
 * 因此，只需遍历后半段数字中的全部数字即可
 */
public class T1016 {
    public boolean queryString(String S, int N) {
        for(int i= (N >> 1) + 1;i <= N;i++) {
            if(!S.contains(Integer.toBinaryString(i)))
                return false;
        }
        return true;
    }
}
