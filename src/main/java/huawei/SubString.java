package huawei;

import java.util.Scanner;

/**
 * 【字符串分割】
 *
 * 题目描述
 *  •连续输入字符串，请按长度为8拆分每个字符串后输出到新的字符串数组；
 *  •长度不是8整数倍的字符串请在后面补数字0，空字符串不处理。
 *
 * 输入描述:
 *  连续输入字符串(输入多次,每个字符串长度小于100)
 *
 * 输出描述:
 *  输出到长度为8的新字符串数组
 *
 * 示例1
 *
 *  输入  abc
 *       123456789
 *
 *  输出  abc00000
 *       12345678
 *       90000000
 *
 * @author Anchor
 * @date 2021-04-09 18:04
 */
public class SubString {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (sc.hasNext()) {
            String str = sc.nextLine();
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            int size = str.length();
            int addZero = 8 - size % 8;
            while ((addZero > 0) && (addZero < 8)) {
                sb.append("0");
                addZero--;
            }
            String str1 = sb.toString();
            while (str1.length() > 0) {
                System.out.println(str1.substring(0, 8));
                str1 = str1.substring(8);
            }
        }
    }
}
