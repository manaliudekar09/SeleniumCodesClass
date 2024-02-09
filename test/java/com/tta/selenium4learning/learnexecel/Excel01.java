package com.tta.selenium4learning.learnexecel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class Excel01 {
    public static void main(String[] args) {

        // Create a File and Write the Data

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Login Data");

        // Data
        // 1 -> LoginId, UserName, password
        // 2 ->  1, automation001@vwoo.com, Wingify@1234
        // 3 ->  2,automation999@vwoo.com, Wingify@1234


        Map<String, Object[]> data = new TreeMap<>();
        data.put("1", new Object[]{"LoginId", "Username", "Password"});
        data.put("2", new Object[]{"1", "automation001@vwoo.com", "Wingify@1234"});
        data.put("3", new Object[]{"2", "automation999@vwoo.com", "Wingify@1234"});


        Set<String> keyset = data.keySet();
        int rownum = 0;
        for (String key : keyset) {
            Row r = sheet.createRow(rownum++);
            Object[] objectsArray = data.get(key);
            int cellNum = 0;
            for (Object o : objectsArray) {
                Cell cell = r.createCell(cellNum++);
                if (o instanceof String) {
                    cell.setCellValue((String) o);
                } else {
                    cell.setCellValue((Integer) o);
                }
            }
        }
        try {
            FileOutputStream outputStream = new FileOutputStream(new File("TataData.xlsx"));
            workbook.write(outputStream);
            outputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("I am not able to write into the File");
        }


    }
}
