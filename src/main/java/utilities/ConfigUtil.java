package utilities;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigUtil {
    private static FileInputStream fileInputStream;
    private static final String CONFIG_PROPERTIES_FILE_PATH = "src/main/resources/config.properties";
    private static Properties pro;

 public static String getProperty (String Key){
     try {
         fileInputStream = new FileInputStream(CONFIG_PROPERTIES_FILE_PATH);
         pro = new Properties();
         pro.load(fileInputStream);
     } catch (Exception e) {
         e.printStackTrace();
     }
     return pro.getProperty(Key);
 }
}
