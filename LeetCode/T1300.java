import java.util.Arrays;

/**
 * https://leetcode-cn.com/problems/sum-of-mutated-array-closest-to-target/
 *
 */
public class T1300 {
    public int findBestValue(int[] arr, int target) {
        int result = -1;
        //原数组的总和
        int sum = 0;
        //原数组的最大整数
        int maxInt = -1;
        int len = arr.length;
        //计算平均值
        float temp = (float)target/len;
        int avg = Math.round(temp);

        for(int i=0,ii=len; i<ii; i++){
            sum += arr[i];
            if(arr[i] > maxInt){
                maxInt = arr[i];
            }
        }
        if(sum - target == 0){
            result = maxInt;
        }else{
            result = getResult(arr, 0, avg, target);
        }
        return result;
    }

    public int getResult(int[] arr, int lastSum, int avg, int target){
        int sum = 0;
        for(int i=0,ii=arr.length;i<ii;i++){
            if(arr[i] < avg){
                sum += arr[i];
            }else{
                sum += avg;
            }
        }
        //当前计算的平均值
        int intValue = Math.abs(sum - target);
        //上一次计算的平均值
        int lastIntValue = Math.abs(lastSum - target);
        if(lastIntValue > intValue){
            avg++;
            avg = getResult(arr, sum, avg, target);
        }else {
            if(lastSum != 0){
                avg --;
            }
        }
        return avg;
    }
}
