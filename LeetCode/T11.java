/**
 * https://leetcode-cn.com/problems/container-with-most-water/
 */
public class T11 {
    public static int maxArea(int[] height) {
        int maxArea = -1;
        int i = 0;
        int j = height.length - 1;
        while(i < j) {
            maxArea = Math.max(Math.min(height[i],height[j]) * (j - i),maxArea);
            if(height[i] < height[j]) i++;
            else j--;
        }
        return maxArea;
    }
    public static void main(String[] args) {
        System.out.println(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}));
    }
}
