import java.io.FileOutputStream;
import java.io.InputStream;
import java.net.URI;
import java.net.URL;
import java.net.URLConnection;

public class Text {
    public static void main(String[] args) throws Exception {
        String dir = "C:\\Users\\ancho\\Desktop\\avatar\\%s.jpg";

        URL url1 = new URL("https://mapdownload5.midea.com/file/v5/app/download/561378/public/muc/photo/2976173169366016?1550849549440");
        URLConnection uc = url1.openConnection();
        InputStream inputStream = uc.getInputStream();

        FileOutputStream out = new FileOutputStream(String.format(dir, "mawen"));
        int j = 0;
        while ((j = inputStream.read()) != -1) {
            out.write(j);
        }
        inputStream.close();
    }
}
