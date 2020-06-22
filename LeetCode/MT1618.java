/**
 * https://leetcode-cn.com/problems/pattern-matching-lcci/
 * 待补充
 */
public class MT1618 {
    public boolean patternMatching(String pattern, String value) {
        // 计算模式串中 a,b 的数量
        int countA = 0, countB = 0;
        for (char ch : pattern.toCharArray()) {
            if (ch == 'a') {
                ++countA;
            } else {
                ++countB;
            }
        }
        //如果 b 的数量大于 a 的数量，交换 a 和 b
        if (countA < countB) {
            int temp = countA;
            countA = countB;
            countB = temp;
            char[] array = pattern.toCharArray();
            for (int i = 0; i < array.length; i++) {
                array[i] = array[i] == 'a' ? 'b' : 'a';
            }
            pattern = new String(array);
        }
        //如果主串是空字符串，并且模式串只有一种子模式或模式串也是空字符串，则匹配成功，返回 true 。
        //否则失败，返回 false
        if (value.length() == 0) {
            return countB == 0;
        }
        //如果模式串是空字符串，并且主串非空，则匹配失败
        if (pattern.length() == 0) {
            return false;
        }
        for (int lenA = 0; countA * lenA <= value.length(); ++lenA) {
            //主串减去 countA 个长度为 lenA 的 a 子模式匹配值后剩余字符数量。
            //剩余部分是需要和 b 模式进行匹配，由于从模式串已知 b 子模式的数量，
            //从而可以计算出b的匹配值长度（必须是非负整数）
            int rest = value.length() - countA * lenA;
            // b 子模式匹配值长度为是非负整数时继续计算，否则匹配失败
            if ((countB == 0 && rest == 0) || (countB != 0 && rest % countB == 0)) {
                //获取 b 子模式匹配值长度
                int lenB = (countB == 0 ? 0 : rest / countB);
                //每次分割起始位置
                int pos = 0;
                //记录当前子串是否匹配成功
                boolean correct = true;
                String valueA = "", valueB = "";
                //根据a 子模式和b 子模式匹配值长度和 a,b 在模式串里出现的先后顺序去分割主串。
                // 同时获得 a 子模式的匹配值和 b 子模式的匹配值
                for (char ch : pattern.toCharArray()) {
                    if (ch == 'a') {
                        String sub = value.substring(pos, pos + lenA);
                        if (valueA.length() == 0) {
                            //a 子模式的匹配值
                            valueA = sub;
                        } else if (!valueA.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += lenA;
                    } else {
                        String sub = value.substring(pos, pos + lenB);
                        if (valueB.length() == 0) {
                            //b 子模式的匹配值
                            valueB = sub;
                        } else if (!valueB.equals(sub)) {
                            correct = false;
                            break;
                        }
                        pos += lenB;
                    }
                }
                //如果主串和模式串完全匹配，同时 a 子模式的匹配值和 b 子模式的匹配值不相同，则匹配成功
                if (correct && !valueA.equals(valueB)) {
                    return true;
                }
            }
        }
        return false;
    }
}
