package simple;

/**
 * 53.【最大子序和】
 * 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *
 * 示例:
 *  输入: [-2,1,-3,4,-1,2,1,-5,4],
 *  输出: 6
 *  解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 */
public class MaximumSubarray {
    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        System.out.println(MySolution1(nums));
        System.out.println(LeetCodeSolution(nums));
    }

    /**
     * 双重for循环暴力计算所有可能的连续子数组
     */
    public static int MySolution1(int[] nums) {
        if (nums.length == 0) return 0;
        int maximum = nums[0];   //可以处理nums.length == 1的情况
        for (int i = 0; i < nums.length; i++) {
            int sum = 0;
            for (int j = i; j < nums.length; j++) {
                sum += nums[j];
                if (sum > maximum) maximum = sum;
            }
        }
        return maximum;
    }

    /**
     * 对于数组中的每一个元素，要么是某个数组中的一员，要么是某个数组中的起点，我们选择更大的那个，便是答案。
     */
    public static int MySolution2(int[] nums) {
        int length = nums.length;
        if (length == 0) return 0;
        for (int i = 0; i < length; ++i) {

        }
        return 0;
    }

    /**
     * 动态规划   Todo:理解该算法
     */
    public static int LeetCodeSolution(int[] nums) {
        int n = nums.length, maxSum = nums[0];
        for (int i = 1; i < n; ++i) {
            if (nums[i - 1] > 0) nums[i] += nums[i - 1];
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }
}
