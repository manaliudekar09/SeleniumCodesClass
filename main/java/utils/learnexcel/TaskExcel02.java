package utils.learnexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TaskExcel02 {

    // Read the Excel File

    public static void main(String[] args) throws IOException {

        // File open
        // Read Data


        FileInputStream inputStream;
        inputStream = new FileInputStream(new File("TD01.xlsx"));
        try {

            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            XSSFSheet sheet = workbook.getSheetAt(0);

            Iterator<Row> rowIterator = sheet.iterator();
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();

                Iterator<Cell> cellIterator = row.cellIterator();
                while (cellIterator.hasNext()) {

                    Cell cell = cellIterator.next();
                    switch (cell.getCellType()) {
                        case STRING: {
                            System.out.println(cell.getStringCellValue());
                            break;
                        }
                        case NUMERIC:
                            System.out.println(cell.getNumericCellValue());
                            break;
                    }
                }
            }


        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            inputStream.close();
        }


    }
}
