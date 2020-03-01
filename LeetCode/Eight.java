/**
 * 请你来实现一个 atoi 函数，使其能将字符串转换成整数。
 *
 * 首先，该函数会根据需要丢弃无用的开头空格字符，直到寻找到第一个非空格的字符为止。
 *
 * 当我们寻找到的第一个非空字符为正或者负号时，则将该符号与之后面尽可能多的连续数字组合起来，作为该整数的正负号；假如第一个非空字符是数字，则直接将其与之后连续的数字字符组合起来，形成整数。
 *
 * 该字符串除了有效的整数部分之后也可能会存在多余的字符，这些字符可以被忽略，它们对于函数不应该造成影响。
 *
 * 注意：假如该字符串中的第一个非空格字符不是一个有效整数字符、字符串为空或字符串仅包含空白字符时，则你的函数不需要进行转换。
 *
 * 在任何情况下，若函数不能进行有效的转换时，请返回 0。
 *
 * 说明：
 *
 * 假设我们的环境只能存储 32 位大小的有符号整数，那么其数值范围为 [−2^31,  2^31 − 1]。如果数值超过这个范围，请返回  INT_MAX (2^31 − 1) 或 INT_MIN (−2^31) 。
 */
public class Eight {
    /**
     * 思路同answer差不多
     * @param str
     * @return
     */
    public static int myAtoi(String str) {
        char[] chars = str.toCharArray();
        int start = -1;
        boolean continueSign = true;
        long ans = 0;
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == ' '){
                continue;
            }else if(chars[i] == '+') {
                if(!continueSign) return 0;
                continueSign = false;
                continue;
            }
            if(chars[i] == '-') {
                if(!continueSign) return (int)ans;
            }
            if(!continueSign || (chars[Math.min(i + 1,chars.length)] < '0' || chars[Math.min(i + 1,chars.length)] > '9' )) return (int)ans;
            if(chars[i] == '-') {
                start = i;
                break;
            } else if (chars[i] >= '0' && chars[i] <= '9') {
                start = i;
                break;
            }else break;
        }
        if(start == -1) return 0;
        boolean positive = chars[start] != '-';
        start += positive ? 0 : 1;
        while (start < chars.length && chars[start] >= '0' && chars[start] <= '9') {
            ans *= 10;
            ans += (chars[start] - '0');
            start++;
        }
        if(ans < 0) return positive ?  Integer.MAX_VALUE : Integer.MIN_VALUE;
        ans *= positive ? 1 : -1;
        if(positive && ans > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(!positive && ans < Integer.MIN_VALUE) return Integer.MIN_VALUE;
        return (int)ans;
    }
    public static int answer(String str) {
        int len = str.length();

        // 去除前导空格
        int index = 0;
        while (index < len) {
            if (str.charAt(index) != ' ') {
                break;
            }
            index++;
        }

        if (index == len) {
            return 0;
        }

        // 第 1 个字符如果是符号，判断合法性，并记录正负
        int sign = 1;
        char firstChar = str.charAt(index);
        if (firstChar == '+') {
            index++;
            sign = 1;
        } else if (firstChar == '-') {
            index++;
            sign = -1;
        }

        // 不能使用 long 类型，这是题目说的
        int res = 0;
        while (index < len) {
            char currChar = str.charAt(index);
            // 判断合法性
            if (currChar > '9' || currChar < '0') {
                break;
            }

            // 题目中说：环境只能存储 32 位大小的有符号整数，因此，需要提前判断乘以 10 以后是否越界
            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            // 每一步都把符号位乘进去
            res = res * 10 + sign * (currChar - '0');
            index++;
        }

        return res;

    }

    public static void main(String[] args) {
        System.out.println(myAtoi("3.14"));
    }
}
