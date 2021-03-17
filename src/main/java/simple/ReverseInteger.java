package simple;

import java.math.BigDecimal;

/**
 * @author Anchor
 *
 * 7.【整数反转】
 *
 * 给出一个 32 位的有符号整数，你需要将这个整数中每位上的数字进行反转。
 *
 * 示例  1:
 *  输入: 123
 *  输出: 321
 *
 * 示例 2:
 *  输入: -123
 *  输出: -321
 *
 * 示例 3:
 *  输入: 120
 *  输出: 21
 *
 * 注意:
 *  假设我们的环境只能存储得下 32 位的有符号整数，则其数值范围为  [−231,   231  − 1]。请根据这个假设，如果反转后整数溢出那么就返回 0。
 */
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
        int upper = Integer.MAX_VALUE / 10;
        int lower = Integer.MIN_VALUE / 10;
        while (x != 0) {
            int pop = x % 10;
            x /= 10;
            if (rev > upper || (rev == upper && pop > 7)) return 0;
            if (rev < lower || (rev == lower && pop < -8)) return 0;
            rev = rev * 10 + pop;
        }
        return rev;
    }
}
