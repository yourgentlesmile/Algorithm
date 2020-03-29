public class T12 {
    public static String intToRoman(int num) {
        int[] number = new int[]     {1000,900,500,400, 100,90,  50, 40,  10, 9, 5, 4, 1};
        String[] roman = new String[]{"M","CM","D","CD","C","XC","L","XL","X","IX","V","IV","I"};
        int i = 0;
        String res = "";
        while(num > 0) {
            int div = num / number[i];
            if(div != 0) {
                for(int j = 0;j < div;j++) {
                    res += (roman[i] + "");
                }
            }
            num = num - number[i] * div;
            i++;
        }
        return res;
    }

    public static void main(String[] args) {
        System.out.println(intToRoman(4));
    }
}
