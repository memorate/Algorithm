public class Test {
    public static void main(String[] args) {
        String a = "112321354";
        char[] array = a.toCharArray();
        for (int i = 0; i < array.length; i++) {
            int num = array[i] - '0';
            System.out.println(num);
        }
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
