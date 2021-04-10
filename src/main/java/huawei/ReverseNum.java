package huawei;

import java.util.Scanner;

/**
 *
 * 【数字颠倒】
 *
 * 题目描述
 *   输入一个整数，将这个整数以字符串的形式逆序输出
 *   程序不考虑负数的情况，若数字含有0，则逆序形式也含有0，如输入为100，则输出为001
 *
 * 输入描述:
 *   输入一个int整数
 *
 * 输出描述:
 *   将这个整数以字符串的形式逆序输出
 *
 * 示例1
 * 输入
 * 1516000
 *
 * 输出
 * 0006151
 *
 * @author Anchor
 * @date 2021-04-09 18:16
 */
public class ReverseNum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] chars = scanner.nextLine().toCharArray();
        char[] r = new char[chars.length];
        for (int i = chars.length - 1, j = 0; i >= 0; i--, j++) {
            r[j] = chars[i];
        }
        System.out.println(String.valueOf(r));
    }
}
