public class ShellSort {
    public static void main(String[] args) {
        int[] m = {4,3,1,2,8,5,6,7,0};
        shellSort(m);
    }
    public static void shellSort(int[] arr) {
        if(arr == null || arr.length < 2) return;
        int j;
        int value;
        for (int gap = (int)Math.floor(arr.length / 2); gap > 0 ; gap = (int)Math.floor(gap / 2)) {
            for(int i = gap; i < arr.length; i++) {
                j = i;
                value = arr[i];
                while(j - gap >= 0 && arr[j - gap] > value) {
                    arr[j] = arr[j - gap];
                    j = j - gap;
                }
                arr[j] = value;
            }
        }
    }
}
