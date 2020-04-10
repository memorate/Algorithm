/**
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * <p>
 * 输入: "()"
 * 输出: true
 * 示例 2:
 * <p>
 * 输入: "()[]{}"
 * 输出: true
 * 示例 3:
 * <p>
 * 输入: "(]"
 * 输出: false
 * 示例 4:
 * <p>
 * 输入: "([)]"
 * 输出: false
 * 示例 5:
 * <p>
 * 输入: "{[]}"
 * 输出: true
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/valid-parentheses
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ValidParentheses {
    public static void main(String[] args) {
        String aa = "()";
        String bb = "()[]{}";
        String cc = "(]";
        String dd = "([)]";
        String ee = "{[]}";
        String ff = "{{)}";
        System.out.println(MySolution1(aa));
        System.out.println(MySolution1(bb));
        System.out.println(MySolution1(cc));
        System.out.println(MySolution1(dd));
        System.out.println(MySolution1(ee));
        System.out.println(MySolution1(ff));
    }

    public static boolean MySolution1(String s) {
        if (s.isEmpty()) return true;
        //奇数一定不能闭合
        if (s.length() % 2 != 0) return false;
        char[] chars = s.toCharArray();
        boolean result = false;
        for (int i = 0, j = chars.length - 1; i < chars.length / 2; i++, j--) {
            int sum = chars[i] + chars[j];
            if (sum != 248 && sum != 184 && sum != 81) {
                result = false;
                break;
            }
            result = true;
        }
        for (int i = 0; i < chars.length; i = i + 2) {
            int sum = chars[i] + chars[i + 1];
            if (sum != 248 && sum != 184 && sum != 81) {
                result = false;
                break;
            }
            result = true;
        }
        return result;
    }

    public static boolean MySolution2() {

        return false;
    }

    public static boolean LeetCodeSolution() {

        return false;
    }
}
