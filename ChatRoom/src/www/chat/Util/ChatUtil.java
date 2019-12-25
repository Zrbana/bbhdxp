package www.chat.Util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;

public class ChatUtil {
    public ChatUtil() {
    }

    public static void loadPro(Properties pro, File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException var5) {
                var5.printStackTrace();
            }
        }

        try {
            pro.load(new FileInputStream(file));
        } catch (FileNotFoundException var3) {
            var3.printStackTrace();
        } catch (IOException var4) {
            var4.printStackTrace();
        }

    }

    public static String getTimer() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdf.format(new Date());
    }
}

