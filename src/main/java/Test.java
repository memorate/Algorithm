public class Test {
    public static void main(String[] args) {
        int test = test();
        System.out.println(test);
    }

    public static int test(){
        int index = 0;
        for (int i = 0; i < 10; i++) {
            if (i<5)return i;
            index++;
        }
        return index;
    }
}
