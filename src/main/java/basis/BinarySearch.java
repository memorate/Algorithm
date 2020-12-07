package basis;

/**
 * 二分法
 *
 * 从升序数组 [1, 3, 4, 9, 12, 18, 21, 33, 42, 62, 94] 中查找 12
 *
 * https://www.cnblogs.com/kyoner/p/11080078.html
 * 1.
 */
public class BinarySearch {

    public static void main(String[] args) {
        int[] array = {1, 3, 4, 9, 12, 18, 21, 33, 42, 62, 94};
        System.out.println(binarySearch(array, 0));
        System.out.println(binarySearch(array, 9));
        System.out.println(binarySearch(array, 18));
        System.out.println(binarySearch(array, 62));
        System.out.println(binarySearch(array, 100));
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

    private static int leftBinarySearch(int[] array, int target){
        int left = 0, right = array.length;
        while (left < right){
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
}
