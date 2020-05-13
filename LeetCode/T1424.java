import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * https://leetcode-cn.com/problems/diagonal-traverse-ii/
 */
public class T1424 {
    public int[] findDiagonalOrder(List<List<Integer>> nums) {
        List<Stack<Integer>> re = new ArrayList<>();
        int number = 0;
        for(int i = 0;i < nums.size();i++) {
            for(int j = 0;j < nums.get(i).size();j++) {
                while(re.size() < j + i + 2 ) re.add(new Stack<Integer>());
                Stack<Integer> slot = re.get(j + i + 1);
                slot.push(nums.get(i).get(j));
                number++;
            }
        }
        int p = 0;
        int[] ans = new int[number];
        for(int i = 0;i< re.size();i++) {
            Stack<Integer> c = re.get(i);
            while(!c.isEmpty()) {
                ans[p++] = c.pop();
            }
        }
        return ans;
    }
}
