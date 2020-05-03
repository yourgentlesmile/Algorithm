public class BubbleSort {
    public static void main(String[] args) {
        int[] m = {4,3,1,2,8,5,6,7,0};
        bubbleSort(m);
    }
    public static void bubbleSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if(arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;
                }
            }
        }
    }
}
