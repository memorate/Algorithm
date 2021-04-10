package huawei;

import java.util.Scanner;

/**
 * 【句子逆序】
 *
 * 题目描述
 *   将一个英文语句以单词为单位逆序排放。例如“I am a boy”，逆序排放后为“boy a am I”
 *   所有单词之间用一个空格隔开，语句中除了英文字母外，不再包含其他字符
 *
 * 输入描述:
 *   输入一个英文语句，每个单词用空格隔开。保证输入只包含空格和字母。
 *
 * 输出描述:
 *   得到逆序的句子
 *
 * 示例1
 *   输入
 *   I am a boy
 *
 *   输出
 *   boy a am I
 *
 * @author Anchor
 * @date 2021-04-09 18:20
 */
public class ReverseSentence {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] s = scanner.nextLine().split(" ");
        StringBuilder builder = new StringBuilder();
        for (int i = s.length - 1; i >= 0; i --) {
            builder.append(s[i]).append(" ");
        }
        System.out.println(builder);
    }
}
