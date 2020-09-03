/**
 * 35.【搜索插入位置】
 * <p>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 你可以假设数组中无重复元素。
 * <p>
 * 示例 1:
 * 输入: [1,3,5,6], 5
 * 输出: 2
 * <p>
 * 示例  2:
 * 输入: [1,3,5,6], 2
 * 输出: 1
 * <p>
 * 示例 3:
 * 输入: [1,3,5,6], 7
 * 输出: 4
 * <p>
 * 示例 4:
 * 输入: [1,3,5,6], 0
 * 输出: 0
 * <p>
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/search-insert-position
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class SearchInsertPosition {
    public static void main(String[] args) {

        int[] nums = {1, 3, 5, 6, 8};
        System.out.println(LeetCodeSolution1(nums, 7));
    }

    public static int MySolution(int[] nums, int target) {
        if (nums.length == 0 || target <= nums[0]) return 0;
        if (target == nums[nums.length - 1]) return nums.length - 1;
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i] == target) return i;
            if (target > nums[i] && target < nums[i + 1]) {
                return i + 1;
            }
        }
        return nums.length;
    }

    /**
     * 暴力求解
     */
    public static int LeetCodeSolution1(int[] nums, int target) {
        int index = 0;
        for (int j = 0; j < nums.length; j++) {
            if (nums[j] < target) index = j + 1;  //当前元素小于target，结果一定是 j+1
            if (nums[j] >= target) return j;      //nums是有序的，第一个比target大的一定是要的结果
        }
        return index;
    }

    /**
     * 二分查找
     */
    public static int LeetCodeSolution2(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] == target) {
                return mid;
            }
            if (nums[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return left;
    }
}
