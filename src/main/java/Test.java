public class Test {
    public static void main(String[] args) {
        String[] cache = new String[30];
        System.out.println(cache[29]);
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
