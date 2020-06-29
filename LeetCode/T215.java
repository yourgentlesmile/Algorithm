import java.util.PriorityQueue;

/**
 * 寻找第K大的元素，只需要维护一个大小为K的小顶堆即可
 */
public class T215 {
    public int findKthLargest(int[] nums, int k) {
        build(nums, k);
        for(int i = k;i < nums.length;i++) {
            if(nums[0] < nums[i]) {
                nums[0] = nums[i];
                heapify(nums,0,k);
            }
        }
        return nums[0];
    }

    /**
     * 使用优先队列
     *
     */
    public int secondAnswer(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>(k);
        for(int a : nums) {
            queue.add(a);
            if(queue.size() > k) queue.poll();
        }
        return queue.peek();
    }
    public void build(int[] arr, int end) {
        for(int i = (end - 1) / 2;i >= 0;i--) {
            heapify(arr,i,end);
        }
    }
    public void heapify(int[] arr, int n, int end) {
        int l = 2 * n + 1;
        int r = 2 * n + 2;
        int min = n;
        if(l < end && arr[l] < arr[min]) {
            min = l;
        }
        if(r < end && arr[r] < arr[min]) {
            min = r;
        }
        if(min != n) {
            int t = arr[min];
            arr[min] = arr[n];
            arr[n] = t;
            heapify(arr, min, end);
        }
    }
}
