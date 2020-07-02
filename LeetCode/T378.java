import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/kth-smallest-element-in-a-sorted-matrix
 *
 *
 * 可以最多取 k < r * c < (r + 2) * c 数进行排序，在数据大，k小的情况下，可以
 * 少排序一点数据
 */
public class T378 {
    public int kthSmallest(int[][] matrix, int k) {
        int rows = matrix.length, columns = matrix[0].length;
        int[] sorted = new int[rows * columns];
        int index = 0;
        for (int[] row : matrix) {
            for (int num : row) {
                sorted[index++] = num;
            }
        }
        Arrays.sort(sorted);
        return sorted[k - 1];
    }
}
