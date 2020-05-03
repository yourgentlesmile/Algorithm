public class SelectionSort {
    public static void main(String[] args) {
        int[] m = {4,3,1,2,8,5,6,7,0};
        selectionSort(m);
    }
    public static void selectionSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < arr.length - 1; j++) {
                if(arr[min] > arr[j]) min = j;
            }
            if(min != i) {
                int tmp = arr[i];
                arr[i] = arr[min];
                arr[min] = tmp;
            }
        }
    }
}
