package leetcode.simple;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Anchor
 *
 * 1.【两数之和】
 *
 * 给定一个整数数组 nums  和一个目标值 target，请你在该数组中找出和为目标值的那  两个  整数，并返回他们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。
 *
 * 示例:
 *  给定 nums = [2, 7, 11, 15], target = 9
 *  因为 nums[0] + nums[1] = 2 + 7 = 9
 *  所以返回 [0, 1]
 *
 * int 范围 -2147483648——2147483647
 */
public class TwoSum {
    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
        System.out.println(Arrays.toString(improvement(new int[]{2, 7, 11, 15}, 9)));
    }

    public static int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                boolean judge = nums[i] + nums[j] == target;
                if (judge) {
                    return new int[]{i, j};
                }
            }
        }
        throw new IllegalArgumentException("数组中不存在符合target的两个item");
    }

    /**
     * 缓存法
     */
    public static int[] improvement(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int i = 0; i < nums.length; i++) {
            int x = target - nums[i];
            if (map.containsKey(x)) {
                return new int[]{map.get(x), i};
            }
            map.put(nums[i], i);
        }
        throw new IllegalArgumentException("数组中不存在符合target的两个item");
    }
}
