package basis;

/**
 * 二分法
 *
 * 从升序数组 [2, 5, 17, 23, 23, 23, 58, 66, 73, 80]     中查找 23，length = 11
 * 从升序数组 [1, 3, 12, 23, 23, 23, 35, 42, 57, 62, 94] 中查找 23，length = 10
 *
 * 三种查找方式：
 *   1.普通二分查找，返回中间符合条件的值
 *   2.左边界二分查找，返回最左符合条件的值
 *   3.右边界二分查找，返回最右符合条件的值
 *
 * 1.计算 mid = (left + right) / 2 时如何防止溢出?
 *   mid = left + (right - left) / 2;
 *
 * 2.初始化时 right = length 还是 right = length - 1?
 *   二者不同点在于：
 *      1）while 循环的终止条件是 left <= right 还是 left < right
 *      2）缩小边界时 left 和 right 的取值不同
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array1 = {2, 5, 17, 23, 23, 23, 58, 66, 73, 80};
        int[] array2 = {1, 3, 12, 23, 23, 23, 35, 42, 57, 62, 94};
        test(array1, 0, 5, 23, 66, 100);
        System.out.println("============================");
        System.out.println("============================");
        test(array2, 0, 12, 23, 62, 100);
    }

    private static void test(int[] array, int target1, int target2, int target3, int target4, int target5) {
        System.out.println(binarySearch(array, target1));
        System.out.println(binarySearch(array, target2));
        System.out.println(binarySearch(array, target3));
        System.out.println(binarySearch(array, target4));
        System.out.println(binarySearch(array, target5));
        System.out.println("-----------------------------");
        System.out.println(leftBinarySearch(array, target1));
        System.out.println(leftBinarySearch(array, target2));
        System.out.println(leftBinarySearch(array, target3));
        System.out.println(leftBinarySearch(array, target4));
        System.out.println(leftBinarySearch(array, target5));
        System.out.println("-----------------------------");
        System.out.println(rightBinarySearch(array, target1));
        System.out.println(rightBinarySearch(array, target2));
        System.out.println(rightBinarySearch(array, target3));
        System.out.println(rightBinarySearch(array, target4));
        System.out.println(rightBinarySearch(array, target5));
    }

    private static int binarySearch(int[] array, int target) {
        int left = 0, right = array.length - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (target == array[mid]) {
                return mid;
            } else if (target < array[mid]) {
                right = mid - 1;
            } else if (target > array[mid]) {
                left = mid + 1;
            }
        }
        return -1;
    }

    private static int leftBinarySearch(int[] array, int target) {
        if (array.length == 0) return -1;
        int left = 0, right = array.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (array[mid] == target) {
                right = mid;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid;
            }
        }
        return left;
    }

    private static int rightBinarySearch(int[] array, int target) {
        if (array.length == 0) return -1;
        int left = 0, right = array.length;
        while (left < right) {
            int mid = (left + right) / 2;
            if (array[mid] == target) {
                left = mid + 1;
            } else if (array[mid] < target) {
                left = mid + 1;
            } else if (array[mid] > target) {
                right = mid;
            }
        }
        return left - 1;
    }
}
