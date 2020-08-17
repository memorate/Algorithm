/**
 * 58.【最后一个单词的长度】
 * 给定一个仅包含大小写字母和空格 ' ' 的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0 。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 * <p>
 * 示例:
 * 输入: "Hello World"
 * 输出: 5
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/length-of-last-word
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FiftyEight_LengthOfLastWord {
    public static void main(String[] args) {
        System.out.println(MySolution("Hello World"));
        System.out.println(MySolution("a "));
        System.out.println(MySolution("sdf gd "));
        System.out.println(MySolution(" sdf"));
        System.out.println(MySolution("dd  "));
    }

    public static int MySolution(String s) {
        if (s.length() == 0) return 0;
        int counter = 0;
        boolean flag = false;                              //用一个开关控制是否开始计数
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') flag = true;              //跳过末尾的所有空格
            if (flag && s.charAt(i) == ' ') return counter;   //碰到单词后的第一个空格，返回
            if (flag) counter++;                           //开关打开时计数
        }
        return counter;
    }
}
