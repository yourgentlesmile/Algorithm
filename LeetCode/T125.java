/**
 * https://leetcode-cn.com/problems/valid-palindrome/
 * 逐个比较，无效字符跳过
 *
 * 二分查找优质题解
 * https://leetcode-cn.com/problems/find-first-and-last-position-of-element-in-sorted-array/solution/er-fen-cha-zhao-suan-fa-xi-jie-xiang-jie-by-labula/
 */
public class T125 {
    public boolean isPalindrome(String s) {
        int l = 0;
        int r = s.length() - 1;
        char[] chars = s.toLowerCase().toCharArray();
        while (l < r) {
            while(l < r && !((chars[l] >= 'a' && chars[l] <= 'z') || (chars[l] >= '0' && chars[l] <= '9'))) l++;
            while(l < r && !((chars[r] >= 'a' && chars[r] <= 'z') || (chars[r] >= '0' && chars[r] <= '9'))) r--;
            if(l > r) return true;
            if(chars[l] != chars[r]) return false;
            l++;
            r--;
        }
        return true;
    }
}
