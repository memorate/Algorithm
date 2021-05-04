package leetcode.middle;

import java.util.HashSet;
import java.util.Set;

/**
 * 3.【无重复字符的最长子串】
 *
 * 给定一个字符串，请你找出其中不含有重复字符的最长子串的长度。
 *
 * 示例1:
 *   输入: s = "abcabcbb"
 *   输出: 3
 *   解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
 *
 * 示例 2:
 *  输入: s = "bbbbb"
 *   输出: 1
 *   解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
 *
 * 示例 3:
 *  输入: s = "pwwkew"
 *   输出: 3
 *   解释: 因为无重复字符的最长子串是"wke"，所以其长度为 3。
 *        请注意，你的答案必须是 子串 的长度，"pwke"是一个子序列，不是子串。
 *
 * 示例 4:
 *   输入: s = ""
 *   输出: 0
 *
 * 提示：
 *   0 <= s.length <= 5 * 104
 *   s由英文字母、数字、符号和空格组成
 *
 * @author Anchor
 * @date 2021-04-30 16:27
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public static void main(String[] args) {
        String a = "abcabcbb";
        String b = "bbbbb";
        String c = "pwwkew";
        String d = " ";
        String e = "cc";
        String f = "cd";
        String g = "dvdf";
        LongestSubstringWithoutRepeatingCharacters app = new LongestSubstringWithoutRepeatingCharacters();
        System.out.println(app.lengthOfLongestSubstring(a));
        System.out.println(app.lengthOfLongestSubstring(b));
        System.out.println(app.lengthOfLongestSubstring(c));
        System.out.println(app.lengthOfLongestSubstring(d));
        System.out.println(app.lengthOfLongestSubstring(e));
        System.out.println(app.lengthOfLongestSubstring(f));
        System.out.println(app.lengthOfLongestSubstring(g));
        System.out.println();
        System.out.println(app.slide(a));
        System.out.println(app.slide(b));
        System.out.println(app.slide(c));
        System.out.println(app.slide(d));
        System.out.println(app.slide(e));
        System.out.println(app.slide(f));
        System.out.println(app.slide(g));
    }

    /**
     * 暴力穷举，找出所有子串，并判断这些子串是否 legal
     *
     * PS：当 s 长度为 3w+ 时，力扣执行结果为：超出时间限制
     */
    public int lengthOfLongestSubstring(String s) {
        int r = 0;
        int length = s.length();
        if (length < 2) return length;
        // 用于存储子串，set 减少对重复子串的计算
        Set<String> set = new HashSet<>();
        Set<Character> checker = new HashSet<>();
        // 双重 for 循环遍历出所有的子串
        for (int i = 0; i < length; i++) {
            for (int j = i + 1; j <= length; j++) {
                String sub = s.substring(i, j);
                // 子串不重复 && 子串长度大于当前计算过的最大值，才判断是否合法
                if (!set.contains(sub) && sub.length() > r) {
                    // 用于判断子串中是否有重复字符
                    boolean flag = true;
                    for (int k = 0; k < sub.length(); k++) {
                        char charAt = sub.charAt(k);
                        if (!checker.contains(charAt)) {
                            checker.add(charAt);
                        } else {
                            // 子串中有重复字符终止
                            flag = false;
                            break;
                        }
                    }
                    checker.clear();
                    if (flag) {
                        set.add(sub);
                        r = sub.length();
                    }
                }
            }
        }
        return r;
    }

    /**
     * 滑动窗口法
     *
     * l 代表左指针，r 代表右指针，[l, r] 代表当前无重复字符子串：
     *   由于 [l, r] 中无重复，那么继续将 r 向右移，直到右边遇到了重复字符，
     *   此时，将 l + 1 ，并且移除 set 中 l 位的字符
     *
     * 对于字符串 abcabcbb，滑动窗口如下：
     *  (ab)cabcbb
     *  (abc)abcbb
     *  a(bca)bcbb
     *  ab(cab)cbb
     *  abc(abc)bb
     *  abca(bc)bb
     *  abcab(cb)b
     *  abcabc(b)b
     *  abcabcb(b)
     */
    public int slide(String s) {
        int res = 0;
        int length = s.length();
        // length 为 0、1 时跳过
        if (length <= 1) return length;
        Set<Character> set = new HashSet<>();
        // 将第一个字符放进 set
        set.add(s.charAt(0));
        for (int l = 0, r = 1; l < length; l++) {
            // 右指针向右挪移，直到遇到重复字符
            while (r < length && !set.contains(s.charAt(r))) {
                set.add(s.charAt(r));
                r++;
            }
            // 右指针碰到了重复字符，更新最大长度，注意：此时 r 在 while 循环中向右移了一位，因此是 r - l
            res = Math.max(res, r - l);
            // 移除左指针所在的字符
            set.remove(s.charAt(l));
        }
        return res;
    }
}
