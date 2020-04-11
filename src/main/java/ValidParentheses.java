import java.util.HashMap;
import java.util.Stack;

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

    public static boolean MySolution2(String s) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < s.toCharArray().length; i++) {
            if (stack.empty()){
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

    public static boolean LeetCodeSolution() {

        return false;
    }

    public boolean isValid(String s) {
        HashMap<Character, Character> mappings = new HashMap<Character, Character>();
        mappings.put(')', '(');
        mappings.put('}', '{');
        mappings.put(']', '[');

        // Initialize a stack to be used in the algorithm.
        Stack<Character> stack = new Stack<Character>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            // If the current character is a closing bracket.
            if (mappings.containsKey(c)) {

                // Get the top element of the stack. If the stack is empty, set a dummy value of '#'
                char topElement = stack.empty() ? '#' : stack.pop();

                // If the mapping for this bracket doesn't match the stack's top element, return false.
                if (topElement != mappings.get(c)) {
                    return false;
                }
            } else {
                // If it was an opening bracket, push to the stack.
                stack.push(c);
            }
        }

        // If the stack still contains elements, then it is an invalid expression.
        return stack.isEmpty();
    }
}
