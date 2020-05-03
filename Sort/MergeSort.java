public class MergeSort {
    public static void main(String[] args) {
        int[] m = {4,3,1,2,8,5,6,7,0};
        mergeSort(m);
    }
    public static void mergeSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        divide(0,arr.length - 1, arr, new int[arr.length]);
        System.out.println();
    }
    public static void divide(int left, int right, int[] arr, int[] tmp) {
        if(left >= right) return;
        int mid = (right + left) >> 1;
        divide(left, mid, arr, tmp);
        divide(mid + 1, right, arr, tmp);
        merge(left, right, mid, arr, tmp);
    }
    public static void merge(int left, int right, int mid ,int[] arr, int[] tmp) {
        int l = left;
        int resultPointer = left;
        int r = mid + 1;
        while (l <= mid && r <= right) {
            if(arr[l] > arr[r]) {
                tmp[resultPointer++] = arr[r++];
            }else {
                tmp[resultPointer++] = arr[l++];
            }
        }
        while (l <= mid) {
            tmp[resultPointer++] = arr[l++];
        }
        while (r <= right) {
            tmp[resultPointer++] = arr[r++];
        }
        for (int i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
    }
}
