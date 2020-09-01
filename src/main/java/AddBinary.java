/**
 * 67.【二进制求和】
 * <p>
 * 给你两个二进制字符串，返回它们的和（用二进制表示）。
 * 输入为 非空 字符串且只包含数字 1 和 0。
 * <p>
 * 示例 1:
 * 输入: a = "11", b = "1"
 * 输出: "100"
 * <p>
 * 示例 2:
 * 输入: a = "1010", b = "1011"
 * 输出: "10101"
 * <p>
 * 提示：
 * 1）每个字符串仅由字符 '0' 或 '1' 组成。
 * 2）1 <= a.length, b.length <= 10^4
 * 3）字符串如果不是 "0" ，就都不含前导零。
 */
public class AddBinary {

    public static void main(String[] args) {

    }

    public static String MySolution(String a, String b) {
        if (a.length() < b.length()){
            String temp = a;
            a = b;
            b = temp;
        }
        int big = Math.max(a.length(), b.length());
        int small = Math.min(a.length(), b.length());
        char[] result = new char[big + 1];
        char[] carry = new char[]{'0', '0', '0'};
        int index = big - 1;
        for (; index >= 0; index--) {
            if (index == small - 1) {
                break;
            } else {
                carry[0] = a.charAt(index);
                carry[1] = b.charAt(index);
                int counter = 0;
                for (char item : carry) {
                    if (item == '1') counter++;
                }
                switch (counter) {
                    case 0:
                        result[index + 1] = '0';
                        carry[2] = '0';
                        break;
                    case 1:
                        result[index + 1] = '1';
                        carry[2] = '0';
                        break;
                    case 2:
                        result[index + 1] = '0';
                        carry[2] = '1';
                        break;
                    case 3:
                        result[index + 1] = '1';
                        carry[2] = '1';
                        break;
                }
            }
        }
        return "";
    }

    public static String LeetCodeSolution(String a, String b) {

        return "";
    }
}
