/**
 * 【最长公共前缀】
 *
 * 编写一个函数来查找字符串数组中的最长公共前缀。
 * 如果不存在公共前缀，返回空字符串 ""。
 *
 * 示例 1:
 * 输入: ["flower","flow","flight"]
 * 输出: "fl"
 *
 * 示例 2:
 * 输入: ["dog","racecar","car"]
 * 输出: ""
 * 解释: 输入不存在公共前缀。
 *
 * 说明:
 * 所有输入只包含小写字母 a-z 。
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/longest-common-prefix
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class LongestCommonPrefix {
    public static void main(String[] args) {
        String[] input = {"flower","flow","flight"};

        System.out.println("result is :" + MySolution(input));
        System.out.println("result is :" + LeetSolution(input));
    }

    /**
     * input[i].startsWith()
     * 用input[0]去检测数组中所有的元素，每次input[0]的index +1，直到input[i].startsWith()为false
     */
    private static String MySolution(String[] input) {
        if (input == null || input.length == 0) {
            return "";
        }
        String firstS = input[0];
        String result = "";
        boolean flag = true;
        for (int i = 0; i < firstS.length(); i++) {
            String candidate = firstS.substring(i, i + 1);
            int j = 1;
            for (; j < input.length; j++) {
                if (!input[j].startsWith(result + candidate)) {
                    flag = false;
                    break;
                }
            }
            if (!flag) {
                break;
            }
            result += candidate;
        }
        return result;
    }

    /**
     * input[i].indexOf(prefix) != 0
     * 每次检查prefix是否是LCP后踢出最后一个字符，直到prefix为空
     */
    private static String LeetSolution(String[] input) {
        if (input.length == 0) return "";
        String prefix = input[0];
        for (int i = 1; i < input.length; i++)
            while (input[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        return prefix;
    }
}
