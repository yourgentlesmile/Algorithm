package offer;

import java.util.LinkedList;
import java.util.Queue;

public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0 || matrix[0].length == 0 || matrix == null) return false;
        int rows = 0;
        int columns = matrix[0].length - 1;
        while (rows <= matrix.length - 1 && columns >= 0) {
            if(target == matrix[rows][columns]) return true;
            if(target < matrix[rows][columns]) columns--;
            else {
                rows++;
            }
        }
        return false;
    }
}
