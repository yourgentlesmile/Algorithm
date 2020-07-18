import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode-cn.com/problems/interleaving-string
 *
 * 动态规划
 */
public class T97 {
    Map<String,Boolean> map = new HashMap<>();
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() == 0 && s2.length() == 0 && (s3.length() != 0)) return false;
        if(map.containsKey(s1 + " " + s2 + "" +s3)) {
            return map.get(s1 + " " + s2 + "" +s3);
        }
        if(s1.length() == 0) {
            return s2.equals(s3);
        }else if(s2.length() == 0){
            return s1.equals(s3);
        }
        if(s1.charAt(0) == s2.charAt(0)) {
            if(s3.charAt(0) == s1.charAt(0)) {
                boolean leaf1 = isInterleave(s1.substring(1),s2,s3.substring(1));
                boolean leaf2 = isInterleave(s1,s2.substring(1),s3.substring(1));
                map.put(s1.substring(1) + " " + s2 + "" +s3.substring(1),leaf1);
                map.put(s1 + " " + s2.substring(1) + "" +s3.substring(1),leaf2);
                return leaf1 || leaf2;
            }
            return false;
        }else {
            if(s1.charAt(0) == s3.charAt(0)) {
                boolean leaf1 = isInterleave(s1.substring(1),s2,s3.substring(1));
                map.put(s1.substring(1) + " " + s2 + "" +s3.substring(1),leaf1);
                return leaf1;
            } else if(s2.charAt(0) == s3.charAt(0)) {
                boolean leaf2 = isInterleave(s1,s2.substring(1),s3.substring(1));
                map.put(s1 + " " + s2.substring(1) + "" +s3.substring(1),leaf2);
                return leaf2;
            } else {
                return false;
            }
        }
    }

    /**
     * dp做法
     * 待更新
     */

}
