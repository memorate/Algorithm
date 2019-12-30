import java.math.BigDecimal;

public class ReverseInteger {
    public static void main(String[] args) throws Exception {
        System.out.println(mySolution(901000));
        System.out.println(LeetCodeSolution(901000));
    }


    public static int mySolution(int x) {
        if (x == 0) {
            return 0;
        }
        String tackle = "";
        boolean minus = false;
        if (x < 0) {
            tackle = String.valueOf(x).split("-")[1];
            minus = true;
        } else {
            tackle = String.valueOf(x);
        }
        char[] chars = String.valueOf(tackle).toCharArray();
        int size = chars.length;
        StringBuilder stringBuilder = new StringBuilder();
        boolean flag = true;
        for (int i = size - 1; i >= 0; i--) {
            if (flag && chars[i] == '0') {
                continue;
            }
            flag = false;
            stringBuilder.append(chars[i]);
        }
        String reversed = "";
        if (minus) {
            reversed = "-" + stringBuilder.toString();
        } else {
            reversed = stringBuilder.toString();
        }
        BigDecimal result = new BigDecimal(reversed);
        if (result.compareTo(new BigDecimal(String.valueOf(Integer.MIN_VALUE))) < 0 ||
                result.compareTo(new BigDecimal(String.valueOf(Integer.MAX_VALUE))) > 0) {
            return 0;
        } else {
            return result.intValue();
        }
    }

    public static int LeetCodeSolution(int x){
        int rev = 0;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > Integer.MAX_VALUE/10 || (rev == Integer.MAX_VALUE / 10 && pop > 7)) return 0;
            if (rev < Integer.MIN_VALUE/10 || (rev == Integer.MIN_VALUE / 10 && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
