package utils.learnproperties;

import java.util.ResourceBundle;

public class TaskPropertiesO1 {
    public static void main(String[] args) {
        ResourceBundle rb = ResourceBundle.getBundle("db");
        System.out.println(rb.getString("url"));
        System.out.println(rb.getString("driver"));
        System.out.println(rb.getString("password"));

    }
}
