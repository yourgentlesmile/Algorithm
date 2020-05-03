public class InsertionSort {
    public static void main(String[] args) {
        int[] m = {4,3,1,2,8,5,6,7,0};
        insertionSort(m);
    }
    public static void insertionSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        int preIndex;
        int value;
        for (int i = 1; i < arr.length; i++) {
            preIndex = i - 1;
            value = arr[i];
            while(preIndex >= 0 && arr[preIndex] > value) {
                arr[preIndex + 1] = arr[preIndex];
                preIndex--;
            }
            arr[preIndex + 1] = value;
        }
    }
}
