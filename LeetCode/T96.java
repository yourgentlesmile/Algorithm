/**
 * https://leetcode-cn.com/problems/unique-binary-search-trees/
 *
 * 卡特兰数
 */
public class T96 {
    public int numTrees(int n) {
        long C = 1;
        for (int i = 0; i < n; ++i) {
            C = C * 2 * (2 * i + 1) / (i + 2);
        }
        return (int) C;
    }
}
