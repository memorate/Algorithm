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
        int i = '1' + '1';
        int j = '0' + '0';
        int k = '0' + '1';
        int l = '1' + '1';
        System.out.println(i);
        System.out.println(j);
        System.out.println(k);
        System.out.println(l);
    }

    public static String MySolution(String a, String b) {
        int size = a.length() >= b.length() ? a.length() : b.length();
        char[] result = new char[size + 1];
        char[] carry = new char[3];
        carry[0] = '0';
        int index = 0;
        for (; index < size; index++) {
            carry[1] = a.charAt(index);
            carry[2] = b.charAt(index);
            int counter = 0;
            for (char item : carry) {
                if (item == '1') counter++;
            }
            switch (counter) {
                case 0:
                    break;
                case 1:
                    break;
                case 2:
                    break;
            }
        }
        return "";
    }

    public static String LeetCodeSolution(String a, String b) {

        return "";
    }
}
