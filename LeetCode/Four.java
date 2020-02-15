/**
 * 给定两个大小为 m 和 n 的有序数组 nums1 和 nums2。
 *
 * 请你找出这两个有序数组的中位数，并且要求算法的时间复杂度为 O(log(m + n))。
 *
 * 你可以假设 nums1 和 nums2 不会同时为空。
 *
 * 示例 1:
 *
 * nums1 = [1, 3]
 * nums2 = [2]
 *
 * 则中位数是 2.0
 * 示例 2:
 *
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 *
 * 则中位数是 (2 + 3)/2 = 2.5
 */
public class Four {
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int len = nums1.length + nums2.length;
        int num = 0;
        int prev = -1,cur = -1;
        int a = 0,b = 0;
        for (int i = 0; i <= len / 2;i++) {
            prev = cur;
            if(b < nums2.length && (a >= nums1.length || nums1[a] >= nums2[b])) {
                cur = nums2[b];
                b++;
            }else {
                cur = nums1[a];
                a++;
            }
        }
        if((len & 1) == 0) {
            return (prev + cur) / 2.0;
        }else {
            return cur;
        }
    }
    public static void main(String[] args) {
        findMedianSortedArrays(new int[]{},new int[]{1});
    }
}
