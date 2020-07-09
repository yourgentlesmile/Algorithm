import java.util.*;

/**
 * https://leetcode-cn.com/problems/re-space-lcci
 *
 * 字典树 + 动态规划
 */
public class MT1713 {
    class Trie {
        public Trie[] next;
        public boolean isEnd;

        public Trie() {
            next = new Trie[26];
            isEnd = false;
        }

        public void insert(String s) {
            Trie curPos = this;

            for (int i = s.length() - 1; i >= 0; --i) {
                int t = s.charAt(i) - 'a';
                if (curPos.next[t] == null) {
                    curPos.next[t] = new Trie();
                }
                curPos = curPos.next[t];
            }
            curPos.isEnd = true;
        }
    }
    public int respace(String[] dictionary, String sentence) {
        int n = sentence.length();

        Trie root = new Trie();
        for (String word: dictionary) {
            root.insert(word);
        }

        int[] dp = new int[n + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for (int i = 1; i <= n; ++i) {
            dp[i] = dp[i - 1] + 1;

            Trie curPos = root;
            for (int j = i; j >= 1; --j) {
                int t = sentence.charAt(j - 1) - 'a';
                if (curPos.next[t] == null) {
                    break;
                } else if (curPos.next[t].isEnd) {
                    dp[i] = Math.min(dp[i], dp[j - 1]);
                }
                if (dp[i] == 0) {
                    break;
                }
                curPos = curPos.next[t];
            }
        }
        return dp[n];
    }
    static class WrongTry {
        public static int respace(String[] dictionary, String sentence) {
            Set<String> dict = new HashSet<>(Arrays.asList(dictionary));
            int search = search(dict, sentence, new HashMap<>());
            return search;
        }
        public static int search(Set<String> dict, String sentence, Map<String, Integer> remember) {
            int minRes = Integer.MAX_VALUE;
            if(sentence == null || sentence.length() == 0) return 0;
            if(sentence.length() == 1) {
                return dict.contains(sentence) ? 0 : 1;
            }
            for(int i = 1; i <= sentence.length();i++) {
                String sub = sentence.substring(0,i);
                String remain = sentence.substring(i);
                int left = 0;
                if(!dict.contains(sub)) left = sub.length();
                int right = remember.containsKey(remain) ? remember.get(remain) : search(dict, remain, remember);
                remember.put(sentence.substring(i),right);
                minRes = Math.min(minRes, left + right);
            }
            return minRes;
        }
    }
}


