import java.util.Arrays;

public class Test {
    public static void main(String[] args) {
        int[] array = {4, 3, 2, 2};
        for (int i = 0; i < array.length; i++) {
            array[i] += 1;
        }
        System.out.println(Arrays.toString(array));
    }

    public static int test() {
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (i < 5) return i;
            index++;
        }
        return index;
    }
}
