/**
 * https://leetcode-cn.com/problems/palindromic-substrings/
 *
 * 使用中心扩散法, 枚举中心点位逐个检查。要考虑点位在两数之间的情况
 * 时间复杂度O(n^2)
 */
public class T647 {
    public int countSubstrings(String s) {
        //使用中间向两边扩散的方法来判断
        char[] arr = s.toCharArray();
        int sum = 0;
        for(int i = 0;i < arr.length;i++) {
            int a = count(arr, i , i);
            int j = count(arr, i , i + 1);
            sum = (a + j);
        }
        return sum;
    }
    public int count(char[] arr, int start, int end) {
        int res = 0;
        while(start >= 0 && end < arr.length && arr[start] == arr[end]){
            res++;
            start--;
            end++;
        }
        return res;
    }
}
