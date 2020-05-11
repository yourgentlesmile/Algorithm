package offer;

public class FindMinInRotate {
    /**
     * 此处还能用二分的方式实现
     */
    public int minArray(int[] numbers) {
        if(numbers == null && numbers.length == 0) return -1;
        for(int i = 1; i < numbers.length;i++) {
            if(numbers[i - 1] > numbers[i]) return numbers[i];
        }
        return numbers[0];
    }
}
