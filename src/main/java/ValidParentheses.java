import java.util.HashMap;
import java.util.Stack;

/**
 * 【有效的括号】
 *
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串，判断字符串是否有效。
 * <p>
 * 有效字符串需满足：
 * <p>
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 注意空字符串可被认为是有效字符串。
 * <p>
 * 示例 1:
 * 输入: "()"
 * 输出: true
 * <p>
 * 示例 2:
 * 输入: "()[]{}"
 * 输出: true
 * <p>
 * 示例 3:
 * 输入: "(]"
 * 输出: false
 * <p>
 * 示例 4:
 * 输入: "([)]"
 * 输出: false
 * <p>
 * 示例 5:
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
        String gg = "(([]){})";
        System.out.println(MySolution2(aa));
        System.out.println(MySolution2(bb));
        System.out.println(MySolution2(cc));
        System.out.println(MySolution2(dd));
        System.out.println(MySolution2(ee));
        System.out.println(MySolution2(ff));
        System.out.println(MySolution2(gg));
    }

    /**
     * 此解法失败
     * 大致思路：
     * 第一次循环判断首位对称的两个char能否闭合，like this：{[]}
     * 第二次循环判断每两个相邻的char能否闭合，like this：()[]{}
     * 失败原因：
     * 组合闭合无法判断，like this：(([]){})
     * <p>
     * 其实一开始思路就错了，应该使用栈，栈很轻松就可以解决
     */
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
        if (result) return true;
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

    /**
     * 使用栈来顺序检查，从s[0]开始入栈，如果s[n-1]和s[n]相匹配，出栈，最后检测栈是否为空
     */
    public static boolean MySolution2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            if (stack.empty()) {
                stack.push(s.charAt(i));
                continue;
            }
            int sum = stack.peek() + s.charAt(i);
            if (sum != 248 && sum != 184 && sum != 81) {
                stack.push(s.charAt(i));
            } else {
                stack.pop();
            }
        }
        return stack.empty();
    }

    public static boolean LeetCodeSolution(String s) {
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            //右括号检查是否能闭合，左括号直接入栈
            if (mappings.containsKey(c)) {
                char topElement = stack.empty() ? '#' : stack.pop();
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }
}
