package simple;

import java.util.HashMap;
import java.util.Map;

/**
 * 38.【外观数列】
 *
 * 「外观数列」是一个整数序列，从数字 1 开始，序列中的每一项都是对前一项的描述。前五项如下：
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 * 1  被读作    "one 1"    ("一个一") , 即  11。
 * 11 被读作  "two 1s"  ("两个一"）, 即  21。
 * 21 被读作  "one 2",   "one 1"  （"一个二"  ,    "一个一")  , 即  1211。
 *
 * 给定一个正整数 n（1 ≤  n  ≤ 30），输出外观数列的第 n 项。
 * 注意：整数序列中的每一项将表示为一个字符串。
 *
 * 示例  1:
 *  输入: 1
 *  输出: "1"
 *  解释：这是一个基本样例。
 *
 * 示例 2:
 *  输入: 4
 *  输出: "1211"
 *  解释：当 n = 3 时，序列是 "21"，其中我们有 "2" 和 "1" 两组，"2" 可以读作 "12"，也就是出现频次 = 1 而 值 = 2；类似 "1" 可以读作 "11"。所以答案是 "12" 和 "11" 组合在一起，也就是 "1211"。
 */
public class CountAndSay {
    public static void main(String[] args) {
        System.out.println(MySolution(30));
        System.out.println(MySolution2(30));
    }

    /**
     * 递归 + 双指针
     * 核心思想是：用candidate表示每次要描述的数字，用counter表示候选人出现了几次。正向循环挨个检测。
     */
    public static String MySolution(int n) {
        if (n < 1 || n > 30) return "";
        if (n == 1) return "1";
        char[] array = MySolution(n - 1).toCharArray();    //递归，要求得CountAndSay(29)，必须知道CountAndSay(28)的值
        int counter = 0, candidate = array[0] - '0';   //候选人初始化为数组中第一个num
        StringBuilder result = new StringBuilder();
        for (int j = 0; j < array.length + 1; j++) {
            //将数组最后一个元素的检查结果写入result
            if (j == array.length) {
                return result.append(counter).append(candidate).toString();
            }
            //char '1'、'2'、'3'.. 转为 int 1、2、3..
            int num = array[j] - '0';   //当前number
            if (candidate == num) {    //相同，计数器+1
                counter++;
            } else {        //不相同，计数器重置为1，更换候选人为当前num（因为当前num与候选人不同且已检测过了，所以计数器重置为1）
                result.append(counter).append(candidate);
                candidate = num;
                counter = 1;
            }
        }
        return result.toString();
    }

    /**
     * 自下而上解决问题，但是感觉和递归没啥区别，因为没有重复计算的部分
     * 耗时反而更长（不知道为啥）
     */
    public static String MySolution2(int n) {
        if (n < 1 || n > 30) return "";
        Map<Integer, String> map = new HashMap();
        map.put(1, "1");
        if (n == 1) return map.get(1);
        for (int i = 2; i <= n; i++) {
            char[] array = map.get(i - 1).toCharArray();
            int counter = 0, candidate = array[0] - '0';
            StringBuilder result = new StringBuilder();
            for (int j = 0; j <= array.length; j++) {
                if (j == array.length) {
                    map.clear();
                    map.put(i, result.append(counter).append(candidate).toString());
                    break;
                }
                int num = array[j] - '0';
                if (candidate == num) {
                    counter++;
                } else {
                    result.append(counter).append(candidate);
                    candidate = num;
                    counter = 1;
                }
            }
        }
        return map.get(n);
    }
}
