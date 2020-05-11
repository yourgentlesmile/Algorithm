package offer;

public class FindRepeatNumber {
    public int findRepeatNumber(int[] nums) {
        int[] bitmap = new int[(nums.length >> 5) + 1];
        for(int i = 0; i < nums.length; i++) {
            if(bitmapExist(bitmap, nums[i]) == 0) {
                bitmapSet(bitmap, nums[i]);
            }else {
                return nums[i];
            }
        }
        return 0;
    }
    public void bitmapSet(int[] bitmap, int value) {
        int bucket = value >> 5;
        int offset = value % 32;
        bitmap[bucket] |= (1 << offset);
    }
    public int bitmapExist(int[] bitmap, int value) {
        int bucket = value >> 5;
        int offset = value % 32;
        return bitmap[bucket] & (1 << offset);
    }
}
