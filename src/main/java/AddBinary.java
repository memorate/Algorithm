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
        System.out.println(MySolution1("11", "1"));
        System.out.println(MySolution1("1010", "1011"));
        System.out.println(MySolution1("0", "0"));
        System.out.println(MySolution1("11111", "11111111"));
    }

    /**
     * 大致思路：
     * 用双指针i、j来定位a、b的位，从末位开始i、j、carry相加，判断相加的结果以确定是否需要进位
     * 当较小数被加完后，再对较大数的剩余位和carry进行运算
     * <p>
     * 判断是否进位的条件：
     * 将i、j所在的位转为int与carry相加，结果只会为0、1、2、3
     *
     *
     * 这版耗时最长。。。。第一版MySolution1()反而耗时较短
     *
     * Todo 有个问题是：r是用 String 还是 StringBuffer 还是 StringBuilder
     */
    static String MySolution2(String a, String b) {
        //a一定是较大数，若不是，手动将a替换为较大数
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int carry = 0;           //控制是否进位
        String r = "";           //结果
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0; i--) {        //i、j是双指针
            if (j >= 0) {      //控制较小数是否已被加完
                carry += (a.charAt(i) - '0') + (b.charAt(j) - '0');       //carry作每次运算的结果,这块是借鉴LeetCode，确实很巧妙
                r = carry % 2 + r;
                carry /= 2;        //carry作进位
                j--;
            } else {     //控制较大数加完较小数后剩余位的运算
                carry += a.charAt(i) - '0';
                r = carry % 2 + r;
                carry /= 2;
            }
        }
        return carry == 0 ? r : 1 + r;
    }

    static String MySolution1(String a, String b) {
        //a一定是较大数，若不是，手动将a替换为较大数
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int carry = 0;           //控制是否进位
        String r = "";           //结果
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0; i--) {        //i、j是双指针
            int aa = a.charAt(i) == '0' ? 0 : 1, bb;     //aa —— 较大数的当前位，bb —— 较小数的当前位（aa、bb非0即1）
            if (j >= 0) {      //控制较小数是否已被加完
                bb = b.charAt(j) == '0' ? 0 : 1;         //bb赋值动作放在这是为了防止 out of range
                switch (aa + bb + carry) {
                    case 0:
                        r = 0 + r;
                        carry = 0;
                        break;
                    case 1:
                        r = 1 + r;
                        carry = 0;
                        break;
                    case 2:
                        r = 0 + r;
                        carry = 1;
                        break;
                    case 3:
                        r = 1 + r;
                        carry = 1;
                        break;
                }
                j--;
            } else {     //控制较大数加完较小数后剩余位的运算
                switch (aa + carry) {
                    case 0:
                        r = 0 + r;
                        carry = 0;
                        break;
                    case 1:
                        r = 1 + r;
                        carry = 0;
                        break;
                    case 2:
                        r = 0 + r;
                        carry = 1;
                        break;
                }
            }
        }
        r = carry == 0 ? r : 1 + r;
        return r;
    }


    static String LeetCodeSolution(String a, String b) {
        StringBuffer ans = new StringBuffer();

        int n = Math.max(a.length(), b.length()), carry = 0;
        for (int i = 0; i < n; ++i) {
            carry += i < a.length() ? (a.charAt(a.length() - 1 - i) - '0') : 0;
            carry += i < b.length() ? (b.charAt(b.length() - 1 - i) - '0') : 0;
            ans.append((char) (carry % 2 + '0'));
            carry /= 2;
        }

        if (carry > 0) {
            ans.append('1');
        }
        ans.reverse();

        return ans.toString();
    }
}
