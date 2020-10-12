package others;

/**
 * 将十六进制串解密为字符串
 *
 * 起因是：https://twitter.com/jetbrains/status/1236986174075482113
 * JetBrainsQuest解谜
 * 解谜结果为：Have you seen the source code of the JetBrains website?
 *
 * 16进制转10进制：
 *   48  转换过程   4*16^1 + 8*16^0 = 72
 */
public class HexToString {
    public static void main(String[] args) {
        String encode = "48 61 76 65 20 79 6f 75 20 73 65 65 6e 20 74 68 65 20 73 6f 75 72 63 65 20 63 6f 64 65 20 6f 66 20 74 68 65 20 4a 65 74 42 72 61 69 6e 73 20 77 65 62 73 69 74 65 3f";
        String[] hex = encode.split(" ");
        char[] dec = new char[hex.length];
        int index = 0;
        for (String s : hex) {
            int lower;
            //encode字符串中只出现了a、e、f三个字符，因此这里偷懒只写了三个
            if (s.charAt(1) == 'a') {
                lower = 10;
            }else if (s.charAt(1) == 'e') {
                lower = 14;
            }else if (s.charAt(1) == 'f') {
                lower = 15;
            }else {
                lower = Integer.parseInt(String.valueOf(s.charAt(1)));
            }
            dec[index] = (char)(Integer.parseInt(String.valueOf(s.charAt(0))) * 16 + lower);
            index++;
        }
        System.out.println(new String(dec));
    }
}
