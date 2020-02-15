import com.sun.jmx.remote.internal.ArrayQueue;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;

/**
 * 给定一个字符串，请你找出其中不含有重复字符的 最长子串 的长度。
 *
 * 示例 1:
 *
 * 输入: "abcabcbb"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 * 示例 2:
 *
 * 输入: "bbbbb"
 * 输出: 1
 * 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 * 示例 3:
 *
 * 输入: "pwwkew"
 * 输出: 3
 * 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
 *      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
 */
public class Three {
    public static int lengthOfLongestSubstring(String s) {
        if(s == null || s.length() == 0) return 0;
        int result = 0;
        Map<Character,Integer> map = new HashMap<>();
        for(int i = 0, j = 0;i < s.length();i++) {
            if(map.containsKey(s.charAt(i))) {
                j = Math.max(map.get(s.charAt(i)),j);
            }
            result = Math.max((i - j + 1),result);
            map.put(s.charAt(i),i + 1);
        }
        return result;
    }
    public static int lowerOne(String s) {
        if(s == null || s.length() == 0) return 0;
        Queue<Character> queue = new LinkedList<>();
        Map<Character,Integer> map = new HashMap<>();
        int longest = 0;
        char[] value = s.toCharArray();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if(!map.containsKey(value[i])) {
                map.put(value[i],i);
                queue.add(value[i]);
            }else {
                longest = queue.size() > longest ? queue.size() : longest;
                char p = '-';
                while (p != value[i]) {
                    p = queue.poll();
                    map.remove(p);
                }
                queue.add(value[i]);
                map.put(value[i],i);
            }
        }
        longest = queue.size() > longest ? queue.size() : longest;
        return longest;
    }
    public static void main(String[] args) {
        System.out.println(lengthOfLongestSubstring("abcabc"));
    }
}
