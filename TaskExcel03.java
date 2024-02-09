package utils.learnexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TaskExcel03 {

    // Create cell at Specific Position

    public static void main(String[] args) throws IOException {


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        Row row = sheet.createRow(1);
        // Specific cell number
        Cell cell = row.createCell(1);
        // putting value at specific position
        cell.setCellValue("Pramod Dutta");

        // Finding index value of row and column of give
        // cell
        int rowIndex = cell.getRowIndex();
        int columnIndex = cell.getColumnIndex();


        FileOutputStream outputStream = new FileOutputStream(new File("TD02.xlsx"));
        workbook.write(outputStream);
        outputStream.close();


    }
}
