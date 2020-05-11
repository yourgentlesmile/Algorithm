package offer;


public class Fibonacci {
    int[] book = new int[100];
    public int fib(int n) {
        /**
         * 青蛙跳台阶就是初始条件 n == 0 时 值 == 1
         */
        if(n == 0) return 0;
        if(n == 1) return 1;
        int left = -1;
        int right = -1;
        if(book[n - 1] != 0) left = book[n - 1];
        else {
            left = fib(n - 1);
            book[n - 1] = left;
        }
        if(book[n - 2] != 0) right = book[n - 2];
        else {
            right = fib(n - 2);
            book[n - 2] = right;
        }
        return (left + right) % 1000000007;
    }
}
