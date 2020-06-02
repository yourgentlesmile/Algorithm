import java.util.ArrayList;
import java.util.List;

/**
 * https://leetcode-cn.com/problems/kids-with-the-greatest-number-of-candies
 *
 */
public class T1431 {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        int max = 0;
        ArrayList<Boolean> res = new ArrayList<>();
        for (int candy : candies) {
            max = max < candy ? candy : max;
        }
        for (int candy : candies) {
            boolean x = (candy + extraCandies) >= max ? true : false;
            res.add(x);
        }
        return res;
    }
}
