public class HeapSort {
    public static void main(String[] args) {
        int[] m = {4,3,1,2,8,5,6,7,0};
        heapSort(m);
    }
    public static void heapSort(int[] arr) {
        buildHeap(arr);
        for (int i = arr.length - 1; i >= 0 ; i--) {
            int tmp = arr[i];
            arr[i] = arr[0];
            arr[0] = tmp;
            heapfiy(arr, 0, i);
        }
    }
    public static void buildHeap(int[] arr) {
        for (int i = (arr.length - 1) / 2; i >= 0; i--) {
            heapfiy(arr, i, arr.length);
        }
    }
    public static void heapfiy(int[] arr, int i, int n) {
        if(i >= n) return;
        int c1 = 2 * i + 1;
        int c2 = 2 * i + 2;
        int max = i;
        if(c1 < n && arr[c1] > arr[max]) {
            max = c1;
        }
        if(c2 < n && arr[c2] > arr[max]) {
            max = c2;
        }
        if(max != i) {
            int tmp = arr[max];
            arr[max] = arr[i];
            arr[i] = tmp;
            heapfiy(arr, max, n);
        }
    }
}
