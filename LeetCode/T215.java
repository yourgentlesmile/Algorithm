/**
 * todo
 *
 * @version V1.0
 * @Author XiongCheng
 * @Date 2020/5/19 17:34.
 */
public class T215 {
    public int findKthLargest(int[] nums, int k) {
        int[] heap = new int[k];
        System.arraycopy(nums, 0, heap, 0, heap.length);
        build(heap);
        for (int i = k; i < nums.length; i++) {
            if(heap[0] < nums[i]) {
                heap[0] = nums[i];
            }
            heapify(heap, 0);
        }
        return heap[0];
    }
    public void heapify(int[] heap, int pos) {
        if(pos >= heap.length) return;
        int left = pos * 2 + 1;
        int right = pos * 2 + 2;
        int min = pos;
        if(left < heap.length && heap[left] < heap[pos]) {
            min = left;
        }
        if(right < heap.length && heap[right] < heap[min]) {
            min = right;
        }
        if(min != pos) {
            int tmp = heap[pos];
            heap[pos] = heap[min];
            heap[min] = tmp;
            heapify(heap, min);
        }
    }
    public void build(int[] heap) {
        for (int i = (heap.length - 1) / 2; i >= 0; i--) {
            heapify(heap, i);
        }
    }
}
