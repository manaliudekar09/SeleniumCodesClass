package com.tta.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.List;

public class WebTableP01 {
    public static void main(String[] args) throws InterruptedException {

        WebDriver dr = new FirefoxDriver();
        String URL = "https://awesomeqa.com/webtable.html";
        dr.get(URL);
        dr.manage().window().maximize();


        // //table[contains(@id,"cust")]/tbody/tr - Row - 7 ( 1 ignore -> header)
        // //table[contains(@id,"cust")]/tbody/tr[2]/td - Col - 3

        int row = dr.findElements(By.xpath("//table[contains(@id,\"cust\")]/tbody/tr")).size();
        int col = dr.findElements(By.xpath("//table[contains(@id,\"cust\")]/tbody/tr[2]/td")).size();

        System.out.println(row);
        System.out.println(col);

        //table[@id="customers"]/tbody/tr[1]/th[1]

        //table[contains(@id,"cust")]/tbody/tr[2]/td


        //table[@id="employeeListTable"]/tbody/tr[1]/td[4]

        String part1 = "//table[@id=\"customers\"]/tbody/tr[";
        String part2 = "]/td[";
        String part3 = "]";


        for (int i = 2; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                // //table[contains(@id,"cust")]/tbody/tr[2]/td
                String dynamic_xpath = part1 + i + part2 + j + part3;  //  //table[@id="customers"]/tbody/tr[2]/td[1]
                String data = dr.findElement(By.xpath(dynamic_xpath)).getText();
                System.out.println(data + "\t");
                if (data.contains("Helen Bennett")) {
                    String new_dynamic_path = dynamic_xpath + "/following-sibling::td";
                    String country_text = dr.findElement(By.xpath(new_dynamic_path)).getText();
                    System.out.println("------");
                    System.out.println("Helen Bennett is In - " + country_text);

                }
            }
        }


        dr.get("https://awesomeqa.com/webtable1.html");

        WebElement table = dr.findElement(By.xpath("//table[@summary=\"Sample Table\"]/tbody"));

        // table -> tr -> td

        List<WebElement> row_tables = table.findElements(By.tagName("tr"));

        for (WebElement rowTable : row_tables) {
            List<WebElement> col_table = rowTable.findElements(By.tagName("td"));
            for (WebElement element : col_table) {
                System.out.println(element.getText());
            }
        }


        Thread.sleep(10000);

        dr.close();


    }
}
