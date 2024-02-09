package utils.learnexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

public class TaskExcel01 {

    // Create a Excel File and Add Data

    public static void main(String[] args) throws IOException {


        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Main");

        Map<String,Object[]> data = new TreeMap<>();
        data.put("1",new Object[]{"LoginID","EMAIL","PASSWORD"});
        data.put("2",new Object[]{"1","test@gmail.com","pass123"});
        data.put("3",new Object[]{"2","test1@gmail.com","pass123"});

        Set<String> keyset = data.keySet();



        int rownum=0;
        for (String key : keyset) {
            Row r = sheet.createRow(rownum++);
            Object[] objectsA = data.get(key);
            int cellnum = 0;
            for (Object o : objectsA) {
                Cell cell = r.createCell(cellnum++);
                if (o instanceof String) {
                    cell.setCellValue((String) (o));
                } else {
                    cell.setCellValue((Integer) (o));
                }
            }
        }

        FileOutputStream outputStream = new FileOutputStream(new File("TD01.xlsx"));
        workbook.write(outputStream);
        outputStream.close();


    }
}
