/**
 * https://leetcode-cn.com/problems/robot-return-to-origin/
 */
public class T657 {
    public boolean judgeCircle(String moves) {
        int[] res = new int[4];
        for(int i = 0;i < moves.length(); i++) {
            switch (moves.charAt(i)) {
                case 'U': {
                    res[0]++;
                    break;
                }
                case 'D': {
                    res[1]++;
                    break;
                }
                case 'L': {
                    res[2]++;
                    break;
                }
                case 'R': {
                    res[3]++;
                    break;
                }
            }
        }
        return res[0] == res[1] && res[2] == res[3];
    }
}
