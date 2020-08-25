import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/letter-combinations-of-a-phone-number/
 *
 * 可以直接套用递归枚举子序列的模板
 * 模板详情看T491
 */
public class T17 {
    String[] key = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    char[] cache;
    List<String> res = new ArrayList<>();
    public List<String> letterCombinations(String digits) {
        if(digits == null || digits.length() == 0) return new ArrayList<>();
        cache = new char[digits.length()];
        traceBack(digits.toCharArray(), 0);
        return res;
    }
    public void traceBack(char[] p, int index) {
        if(index >= cache.length) {
            res.add(new String(cache));
            return;
        }
        String value = key[p[index] - '0'];
        for(int i = 0; i < value.length();i++) {
            cache[index] = value.charAt(i);
            traceBack(p, index + 1);
        }
    }
}
