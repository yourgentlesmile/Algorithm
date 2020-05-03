public class QuickSort {
    public static void main(String[] args) {
        int[] m = {4,3,1,2,8};
        quickSort(m);
    }
    public static void quickSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        sort(0, arr.length - 1, arr);
        System.out.println();
    }
    public static void sort(int left, int right, int[] arr) {
        if(left >= right) return;
        int pivot = arr[left];
        int s = left;
        int e = right;
        while (s < e) {
            while (s < e && arr[e] > pivot) e--;
            if(arr[e] < pivot)
                arr[s++] = arr[e];
            while (s < e && arr[s] < pivot) s++;
            if(s < e){
                arr[e--] = arr[s];
            }
        }
        arr[s] = pivot;
        sort(left, s, arr);
        sort(s + 1, right, arr);
    }
}
