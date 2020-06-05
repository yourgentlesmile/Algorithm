import java.util.ArrayList;
import java.util.List;

public class T54 {
    public List<Integer> spiralOrder(int[][] matrix) {
        if(matrix == null || matrix.length == 0) return new ArrayList<>();
        int total = matrix.length * matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int count = 0;
        int l = matrix[0].length;
        int w = matrix.length;
        int level = 0;
        while (count < total) {
            //LEFT
            for(int i = level;i < l && count < total;i++) {
                res.add(matrix[level][i]);
                count++;
            }
            for(int i = level + 1;i < w && count < total;i++) {
                res.add(matrix[i][l - 1]);
                count++;
            }
            for(int i = l - 2;i >= level && count < total;i--) {
                res.add(matrix[w - 1][i]);
                count++;
            }
            for(int i = w - 2;i > level && count < total;i--) {
                res.add(matrix[i][level]);
                count++;
            }
            l -= 1;
            w -= 1;
            level += 1;
        }
        return new ArrayList<>(res);
    }
}
