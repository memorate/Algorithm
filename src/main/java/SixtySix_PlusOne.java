import java.util.Arrays;

/**
 * 66.【加一】
 * 给定一个由整数组成的非空数组所表示的非负整数，在该数的基础上加一。
 * 最高位数字存放在数组的首位， 数组中每个元素只存储单个数字。
 * 你可以假设除了整数 0 之外，这个整数不会以零开头。
 * <p>
 * 示例 1:
 * 输入: [1,2,3]
 * 输出: [1,2,4]
 * 解释: 输入数组表示数字 123。
 * <p>
 * 示例 2:
 * 输入: [4,3,2,1]
 * 输出: [4,3,2,2]
 * 解释: 输入数组表示数字 4321。
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/plus-one
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SixtySix_PlusOne {
    public static void main(String[] args) {
        int[] array = {9, 9, 9};
        System.out.println(Arrays.toString(MySolution(array)));
        System.out.println(Arrays.toString(LeetCodeSolution(array)));
    }

    public static int[] MySolution(int[] digits) {
        if (digits.length == 0) return digits;
        int index = digits.length - 1;
        boolean flag = digits[index] == 9;      //用于控制是否需要向更高位进1
        for (int i = index; i >= 0; i--) {
            if (flag && i == 0 && digits[0] == 9) {   //如果最高位为9且需要加一，将数组长度加一
                //如果最高位需要扩展一位，那么digits中每个元素都是9，例：99、999、9999。因此长度加一，将最高位置为1
                digits = new int[index + 2];
                digits[0] = 1;
                return digits;
            }
            if (digits[i] == 9) {
                flag = true;
                digits[i] = 0;
            } else {
                digits[i] += 1;
                return digits;
            }
        }
        return digits;
    }

    public static int[] LeetCodeSolution(int[] digits) {
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) return digits;
        }
        //如果最高位需要扩展一位，那么数组中每个元素都是9，例：99、999、9999
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
