package offer;

/**
 * https://leetcode-cn.com/problems/ba-shu-zi-fan-yi-cheng-zi-fu-chuan-lcof
 * 动态规划与滚动数组
 * 由新加入的数字可知，它有两种可能
 * 1、自己单独翻译
 * 2、与前面一个数字组合，联合翻译(组合出来的数字要大于等于10，小于等于25)
 * 所以：
 * 1、自己单独翻译，则可以看在前一个数字时他有多少种组合方式
 * 2、联合翻译时，则看前一位的前一位的数字有多少种组合方式
 * 因为当自身翻译确定时，前面的数字不管怎么组合，都不会因为自身的加入而改变组合数的
 * 例如 123：当3确定要自己翻译时，前面的组合有 1,2 或12，加入3不会改变组合数 1,2,3或12,3
 * 当确定要与前一位组合时，则不管前前一位的如何组合，组合数也是确定的，1,23
 * 所以，当前数的组合数 = 前一位的组合数 + 前二位的组合数(当前数字能与前一位进行组合时才能加)
 *
 * 由于计算新的答案只与前一位与前两位有关，所以完全可以用三个变量来进行存储压缩
 */
public class T46 {
    public int translateNum(int num) {
        String src = String.valueOf(num);
        int parent = 0;
        int prev = 0;
        int ans = 1;
        for(int i = 0;i < src.length();i++){
            parent = prev;
            prev = ans;
            ans = 0;
            ans += prev;//对应的是新增数字单独翻译f(i - 1)
            if(i == 0) continue;
            String p = src.substring(i - 1,i + 1);
            if(p.compareTo("25") <= 0 && p.compareTo("10") >= 0) { //对应的是新增数组能与之前的数字组合可翻译
                ans += parent;
            }
        }
        return ans;
    }
}
