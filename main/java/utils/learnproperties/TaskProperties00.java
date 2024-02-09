package utils.learnproperties;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;
import java.util.ResourceBundle;

public class TaskProperties00 {
    public static void main(String[] args) throws IOException {
        FileReader reader=new FileReader("src/main/resources/db.properties");

        Properties p=new Properties();
        p.load(reader);

        System.out.println(p.getProperty("url"));
        System.out.println(p.getProperty("driver"));

    }
}
