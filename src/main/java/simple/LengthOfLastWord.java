package simple;

/**
 * @author Anchor
 *
 * 58.【最后一个单词的长度】
 * 给定一个仅包含大小写字母和空格  ' '  的字符串 s，返回其最后一个单词的长度。如果字符串从左向右滚动显示，那么最后一个单词就是最后出现的单词。
 * 如果不存在最后一个单词，请返回 0  。
 * 说明：一个单词是指仅由字母组成、不包含任何空格字符的 最大子字符串。
 *
 * 示例:
 *  输入: "Hello World"
 *  输出: 5
 */
public class LengthOfLastWord {
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
        // 用一个开关控制是否开始计数
        boolean flag = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            // 跳过末尾的所有空格
            if (s.charAt(i) != ' ') flag = true;
            // 碰到单词后的第一个空格，返回
            if (flag && s.charAt(i) == ' ') return counter;
            // 开关打开时计数
            if (flag) counter++;
        }
        return counter;
    }
}
