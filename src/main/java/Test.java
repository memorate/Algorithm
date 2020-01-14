import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        String aa = "MCMXCIV";
        List<String> bb = new ArrayList<String>();
        for (int i = 0; i < aa.length(); i++) {
            bb.add(aa.substring(i,i+1));
        }
        System.out.println(bb);
    }
}
