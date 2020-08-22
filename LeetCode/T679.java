import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/24-game/
 * DFS枚举所有可能
 *
 * 附一个暴力美学的解法
 */
public class T679 {
    public boolean judgePoint24(int[] nums) {
        List<Double> inner = new ArrayList<Double>();
        for (int k = 0; k < nums.length; k++) {
            inner.add((double)nums[k]);
        }
        return dfs(inner);
    }
    public boolean dfs(List<Double> nums) {
        if(nums.size() == 1) {
            return Math.abs(Math.abs(nums.get(0)) - 24) < 1e-6;
        }
        for(int i = 0; i < nums.size() - 1;i++) {
            for(int j = 0; j < nums.size();j++) {
                if(i == j) continue;
                List<Double> inner = new ArrayList<Double>();
                for (int k = 0; k < nums.size(); k++) {
                    if (k != i && k != j) {
                        inner.add(nums.get(k));
                    }
                }
                inner.add(nums.get(i) + nums.get(j));
                if( dfs(inner)) return true;
                inner.remove(inner.size() - 1);
                inner.add(nums.get(i) - nums.get(j));
                if(dfs(inner)) return true;
                inner.remove(inner.size() - 1);
                inner.add(nums.get(i) * nums.get(j));
                if(dfs(inner)) return true;
                inner.remove(inner.size() - 1);
                if(nums.get(j) != 0 && nums.get(i) != 0 && nums.get(j) > 1e-6) {
                    inner.add(nums.get(i) / nums.get(j));
                    if(dfs(inner)) return true;
                    inner.remove(inner.size() - 1);
                }

            }
        }
        return false;
    }

    class beautiful {
        public boolean judgePoint24(int[] nums) {
            double a = nums[0]; double b = nums[1];
            double c = nums[2]; double d = nums[3];
            return judge(a, b, c, d);
        }

        public boolean judge(double a, double b, double c, double d){
            return
            // a b
            judge(a + b, c, d) ||
            judge(a * b, c, d) ||
            judge(a - b, c, d) ||
            judge(b - a, c, d) ||
            judge(a / b, c, d) ||
            judge(b / a, c, d) ||
            // b c
            judge(c + b, a, d) ||
            judge(c * b, a, d) ||
            judge(c - b, a, d) ||
            judge(b - c, a, d) ||
            judge(c / b, a, d) ||
            judge(b / c, a, d) ||
            // c d
            judge(c + d, a, b) ||
            judge(c * d, a, b) ||
            judge(c - d, a, b) ||
            judge(d - c, a, b) ||
            judge(c / d, a, b) ||
            judge(d / c, a, b) ||
            // b d
            judge(b + d, a, c) ||
            judge(b * d, a, c) ||
            judge(b - d, a, c) ||
            judge(d - b, a, c) ||
            judge(b / d, a, c) ||
            judge(d / b, a, c) ||
            // a c
            judge(a + c, b, d) ||
            judge(a * c, b, d) ||
            judge(a - c, b, d) ||
            judge(c - a, b, d) ||
            judge(a / c, b, d) ||
            judge(c / a, b, d) ||
            // a d
            judge(a + d, b, c) ||
            judge(a * d, b, c) ||
            judge(a - d, b, c) ||
            judge(d - a, b, c) ||
            judge(a / d, b, c) ||
            judge(d / a, b, c) ;

        }
        public boolean judge(double a, double b, double c){// 24 , 3 , 8
            return
            // a b
            judge(a + b, c) ||
            judge(a * b, c) ||
            judge(a - b, c) ||
            judge(b - a, c) ||
            judge(a / b, c) ||
            judge(b / a, c) ||
            // b c
            judge(c + b, a) ||
            judge(c * b, a) ||
            judge(c - b, a) ||
            judge(b - c, a) ||
            judge(c / b, a) ||
            judge(b / c, a) ||
            // a c
            judge(c + a, b) ||
            judge(c * a, b) ||
            judge(c - a, b) ||
            judge(a - c, b) ||
            judge(c / a, b) ||
            judge(a / c, b);
        }

        public boolean judge(double a, double b){
            return
            //注意精度
            Math.abs(a + b - 24) < 0.001 ||
            Math.abs(a - b - 24) < 0.001 ||
            Math.abs(b - a - 24) < 0.001 ||
            Math.abs(a * b - 24) < 0.001 ||
            Math.abs(a / b - 24) < 0.001 ||
            Math.abs(b / a - 24) < 0.001;
        }
    }
}
