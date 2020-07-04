import java.util.HashMap;

/**
 * https://leetcode-cn.com/problems/fraction-to-recurring-decimal
 *
 * 模拟长除法，用哈希表来存已出现的商，进而判断是否出现了循环
 */
public class T166 {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) {
            return "0";
        }
        StringBuilder sb = new StringBuilder();
        if (numerator < 0 ^ denominator < 0) {
            sb.append("-");
        }
        long dividend = Math.abs(Long.valueOf(numerator));
        long divisor = Math.abs(Long.valueOf(denominator));
        sb.append(dividend / divisor);
        long remainder = dividend % divisor;
        if (remainder == 0) {
            return sb.toString();
        }
        sb.append('.');
        HashMap<Long, Integer> remainderMap = new HashMap<>();
        while (remainder != 0) {
            if (remainderMap.containsKey(remainder)) {
                sb.insert(remainderMap.get(remainder), "(");
                sb.append(')');
                return sb.toString();
            }
            remainderMap.put(remainder, sb.length());
            remainder = remainder * 10;
            sb.append(remainder / divisor);
            remainder = remainder % divisor;
        }
        return sb.toString();
    }
}
