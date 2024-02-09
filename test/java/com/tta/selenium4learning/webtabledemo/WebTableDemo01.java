package com.tta.selenium4learning.webtabledemo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class WebTableDemo01 {
    public static void main(String[] args) {
        WebDriver driver = new FirefoxDriver();
        String URL = "https://awesomeqa.com/webtable.html";
        driver.get(URL);
        driver.manage().window().maximize();

        /*
        * //table[@id="customers"] -
        * //table[contains(@id,"cust")]
        * Row - //table[@id="customers"]/tbody/tr
        * //table[@id="customers"]/tbody/tr[2]
        *
        * */

        // Number of Rows and Column in table
        // Divide the path

        int row = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr")).size();
        int col = driver.findElements(By.xpath("//table[@id=\"customers\"]/tbody/tr[2]/td")).size();

        System.out.println(row);
        System.out.println(col);

        String first_part = "//table[@id=\"customers\"]/tbody/tr[";
        String second_part = "]/td[";
        String third_part = "]";



        for (int i = 2; i <= row; i++) { // //table[@id="customers"]/tbody/tr[1]/th[1] - First is Header
            for (int j = 1; j <= col ; j++) {
                String dynamic_xpath = first_part+i+second_part+j+third_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.print(data +" ");

            }
        }


        // Who is in Google -
        // //table[@id="customers"]/tbody/tr[2]/td[1]/following-sibling::td[1]
        // Google In Which Country -
        // //table[@id="customers"]/tbody/tr[2]/td[1]/following::td[2]




        // Find Helen Bennett In Which Country
        for (int i = 2; i <= row; i++) { // //table[@id="customers"]/tbody/tr[1]/th[1] - First is Header
            for (int j = 1; j <= col ; j++) {
                String dynamic_xpath = first_part+i+second_part+j+third_part;
                String data = driver.findElement(By.xpath(dynamic_xpath)).getText();
                if(data.contains("Helen Bennett")){
                    String country_path = dynamic_xpath+"/following-sibling::td";
                    String country_text = driver.findElement(By.xpath(country_path)).getText();
                    System.out.println("------");
                    System.out.println("Helen Bennett is In - " + country_text);
                }

            }
        }

        System.out.println(" ||||||||||||||||||||||| \n");

        driver.get("https://awesomeqa.com/webtable1.html");

        // For Dyamic Col use the tagName
        // Get Table
        WebElement table = driver.findElement(By.xpath("//table[@summary='Sample Table']/tbody"));
        List<WebElement> rows_table = table.findElements(By.tagName("tr"));
        for (int i = 0;i < rows_table.size(); i++) {
            List<WebElement> columns_table = rows_table.get(i).findElements(By.tagName("td"));
            for (WebElement element : columns_table) {
                System.out.println(element.getText());
            }

        }



    }
}
