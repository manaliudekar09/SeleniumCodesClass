package com.tta.selenium4learning.learnexecel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

public class Excel02 {
    public static void main(String[] args) throws IOException {


        // Find the file and open it
        // Read the Row and CELLs


        FileInputStream inputStream = new FileInputStream("src/test/resources/TataData.xlsx");
        XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
        XSSFSheet sheet = workbook.getSheetAt(0);

        Iterator<Row> rowIterator = sheet.iterator();

        while(rowIterator.hasNext()){

            Row row = rowIterator.next();
            Iterator<Cell> cellIterator = row.cellIterator();
            while (cellIterator.hasNext()){
                Cell cell = cellIterator.next();
                switch (cell.getCellType()){
                    case STRING -> {
                        System.out.println(cell.getStringCellValue());
                        break;
                    }
                    case NUMERIC -> {
                        System.out.println(cell.getNumericCellValue());
                        break;
                    }
                    case BOOLEAN -> {
                        System.out.println(cell.getBooleanCellValue());
                        break;
                    }
                    case BLANK -> {
                        System.out.println("ThIS IS BLANK VALUE");
                        break;
                    }
                }

            }
        }


        inputStream.close();






    }
}
