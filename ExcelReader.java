package utils.learnexcel;

import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.ss.util.CellReference;
import org.apache.poi.xssf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;


public class ExcelReader {

    public  String path;
    public  FileInputStream fis = null;
    public  FileOutputStream fileOut =null;
    private XSSFWorkbook workbook = null;
    private XSSFSheet sheet = null;
    private XSSFRow row   =null;
    private XSSFCell cell = null;

    public ExcelReader(String path) {
        this.path=path;
        try {
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            //sheet = workbook.getSheetAt(0);
        } catch (Throwable e) {
            e.printStackTrace();
        }

    }


    // returns the row count in a sheet
    public int getRowCount(String sheetName){
        int index = workbook.getSheetIndex(sheetName);
        if(index==-1)
            return 0;
        else{
            sheet = workbook.getSheetAt(index);
            int number=sheet.getLastRowNum()+1;
            return number;
        }

    }


    // returns the data from a cell
    public String getCellData(String sheetName,String colName,int rowNum){
        try{
            if(rowNum <=0)
                return "";

            int index = workbook.getSheetIndex(sheetName);
            int col_Num=-1;
            if(index==-1)
                return "";

            sheet = workbook.getSheetAt(index);
            row=sheet.getRow(0);
            for(int i=0;i<row.getLastCellNum();i++){
                //System.out.println(row.getCell(i).getStringCellValue().trim());
                if(row.getCell(i).getStringCellValue().trim().equals(colName.trim()))
                    col_Num=i;
            }
            if(col_Num==-1)
                return "";

            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum-1);
            if(row==null)
                return "";
            cell = row.getCell(col_Num);

            if(cell==null)
                return "";

            if(cell.getCellType()==CellType.STRING)
                return cell.getStringCellValue();
            else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA ){

                String cellText  = String.valueOf(cell.getNumericCellValue());
                if (DateUtil.isCellDateFormatted(cell)) {

                    double d = cell.getNumericCellValue();

                    Calendar cal =Calendar.getInstance();
                    cal.setTime(DateUtil.getJavaDate(d));
                    cellText =
                            (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.DAY_OF_MONTH) + "/" +
                            cal.get(Calendar.MONTH)+1 + "/" +
                            cellText;

                }
                return cellText;
            }else if(cell.getCellType()==CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());

        }
        catch(Exception e){

            e.printStackTrace();
            return "row "+rowNum+" or column "+colName +" does not exist in xls";
        }
    }

    // returns the data from a cell
    public String getCellData(String sheetName,int colNum,int rowNum){
        try{
            if(rowNum <=0)
                return "";

            int index = workbook.getSheetIndex(sheetName);

            if(index==-1)
                throw new Exception(sheetName + " sheet not available in excel file");


            sheet = workbook.getSheetAt(index);
            row = sheet.getRow(rowNum-1);
            if(row==null)
                return "";
            cell = row.getCell(colNum);
            if(cell==null)
                return "";

            if(cell.getCellType()==CellType.STRING)
                return cell.getStringCellValue();
            else if(cell.getCellType()==CellType.NUMERIC || cell.getCellType()==CellType.FORMULA ){

                String cellText  = String.valueOf(cell.getNumericCellValue());
                if (DateUtil.isCellDateFormatted(cell)) {
                    // format in form of M/D/YY
                    double d = cell.getNumericCellValue();

                    Calendar cal =Calendar.getInstance();
                    cal.setTime(DateUtil.getJavaDate(d));
                    cellText =
                            (String.valueOf(cal.get(Calendar.YEAR))).substring(2);
                    cellText = cal.get(Calendar.MONTH)+1 + "/" +
                            cal.get(Calendar.DAY_OF_MONTH) + "/" +
                            cellText;
                }

                return cellText;
            }else if(cell.getCellType()==CellType.BLANK)
                return "";
            else
                return String.valueOf(cell.getBooleanCellValue());
        }
        catch(Exception e){

            e.printStackTrace();
            return "row "+rowNum+" or column "+colNum +" does not exist  in xls";
        }
    }


    // returns true if data is set successfully else false
    public boolean setCellData(String sheetName,String colName,int rowNum, String data){
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if(rowNum<=0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum=-1;
            if(index==-1)
                return false;


            sheet = workbook.getSheetAt(index);


            row=sheet.getRow(0);
            for(int i=0;i<row.getLastCellNum();i++){
                //System.out.println(row.getCell(i).getStringCellValue().trim());
                if(row.getCell(i).getStringCellValue().trim().equals(colName))
                    colNum=i;
            }
            if(colNum==-1)
                return false;

            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum-1);
            if (row == null)
                row = sheet.createRow(rowNum-1);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);


            cell.setCellValue(data);

            fileOut = new FileOutputStream(path);

            workbook.write(fileOut);

            fileOut.close();

        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // returns true if data is set successfully else false
    public boolean setCellData(String sheetName,String colName,int rowNum, String data,String url){

        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if(rowNum<=0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            int colNum=-1;
            if(index==-1)
                return false;


            sheet = workbook.getSheetAt(index);

            row=sheet.getRow(0);
            for(int i=0;i<row.getLastCellNum();i++){

                if(row.getCell(i).getStringCellValue().trim().equalsIgnoreCase(colName))
                    colNum=i;
            }

            if(colNum==-1)
                return false;
            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum-1);
            if (row == null)
                row = sheet.createRow(rowNum-1);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);

            cell.setCellValue(data);
            XSSFCreationHelper createHelper = workbook.getCreationHelper();

            //cell style for hyperlinks

            CellStyle hlink_style = workbook.createCellStyle();
            XSSFFont hlink_font = workbook.createFont();
            hlink_font.setUnderline(XSSFFont.U_SINGLE);
            hlink_font.setColor(IndexedColors.BLUE.getIndex());
            hlink_style.setFont(hlink_font);
            //hlink_style.setWrapText(true);

            XSSFHyperlink link = createHelper.createHyperlink(HyperlinkType.FILE);
            link.setAddress(url);
            cell.setHyperlink(link);
            cell.setCellStyle(hlink_style);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);

            fileOut.close();

        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }



    // returns true if sheet is created successfully else false
    public boolean addSheet(String  sheetname){

        FileOutputStream fileOut;
        try {
            workbook.createSheet(sheetname);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    // returns true if sheet is removed successfully else false if sheet does not exist
    public boolean removeSheet(String sheetName){
        int index = workbook.getSheetIndex(sheetName);
        if(index==-1)
            return false;

        FileOutputStream fileOut;
        try {
            workbook.removeSheetAt(index);
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    // returns true if column is created successfully
    public boolean addColumn(String sheetName,String colName){


        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            int index = workbook.getSheetIndex(sheetName);
            if(index==-1)
                return false;

            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT.getIndex());
            style.setFillPattern(FillPatternType.SOLID_FOREGROUND);

            sheet=workbook.getSheetAt(index);

            row = sheet.getRow(0);
            if (row == null)
                row = sheet.createRow(0);


            if(row.getLastCellNum() == -1)
                cell = row.createCell(0);
            else
                cell = row.createCell(row.getLastCellNum());

            cell.setCellValue(colName);
            cell.setCellStyle(style);

            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();

        }catch(Exception e){
            e.printStackTrace();
            return false;
        }

        return true;


    }


    // removes a column and all the contents
    public boolean removeColumn(String sheetName, int colNum) {
        try{
            if(!isSheetExist(sheetName))
                return false;
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            sheet=workbook.getSheet(sheetName);
            XSSFCellStyle style = workbook.createCellStyle();
            style.setFillForegroundColor(HSSFColor.HSSFColorPredefined.GREY_40_PERCENT.getIndex());
            XSSFCreationHelper createHelper = workbook.getCreationHelper();
            style.setFillPattern(FillPatternType.NO_FILL);



            for(int i =0;i<getRowCount(sheetName);i++){
                row=sheet.getRow(i);
                if(row!=null){
                    cell=row.getCell(colNum);
                    if(cell!=null){
                        cell.setCellStyle(style);
                        row.removeCell(cell);
                    }
                }
            }
            fileOut = new FileOutputStream(path);
            workbook.write(fileOut);
            fileOut.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;

    }


    // find whether sheets exists
    public boolean isSheetExist(String sheetName){
        int index = workbook.getSheetIndex(sheetName);
        if(index==-1){
            index=workbook.getSheetIndex(sheetName.toUpperCase());
            if(index==-1)
                return false;
            else
                return true;
        }
        else
            return true;
    }


    // returns number of columns in a sheet
    public int getColumnCount(String sheetName,Integer... rowOtherThanZero){
        // check if sheet exists
        if(!isSheetExist(sheetName))
            return -1;

        sheet = workbook.getSheet(sheetName);
        if(rowOtherThanZero.length==0)
            row = sheet.getRow(0);
        else
            row = sheet.getRow(rowOtherThanZero[0]);

        if(row==null)
            return -1;

        return row.getLastCellNum();



    }


    //String sheetName, String testCaseName,String keyword ,String URL,String message
    public boolean addHyperLink(String sheetName,String screenShotColName,String testCaseName,int index,String url,String message){


        url=url.replace('\\', '/');
        if(!isSheetExist(sheetName))
            return false;

        sheet = workbook.getSheet(sheetName);

        for(int i=2;i<=getRowCount(sheetName);i++){
            if(getCellData(sheetName, 0, i).equalsIgnoreCase(testCaseName)){

                setCellData(sheetName, screenShotColName, i+index, message,url);
                break;
            }
        }


        return true;
    }
    public int getCellRowNum(String sheetName,String colName,String cellValue){

        for(int i=2;i<=getRowCount(sheetName);i++){
            if(getCellData(sheetName,colName , i).equalsIgnoreCase(cellValue)){
                return i;
            }
        }
        return -1;

    }


    public void closeWorkbook()
    {
        try {
            workbook.close();
            if(fis != null)
                fis.close();
            if(fileOut!=null)
                fileOut.close();
        }catch(Throwable t)
        {

        }
    }

    public String[][] getAllDataFromSheet(String sheetName)
    {
        int rowCount = getRowCount(sheetName);
        int colCount = getColumnCount(sheetName);
        String[][] obj = new String[rowCount][];

        for(int i=0;i<rowCount;i++)
        {
            obj[i] = new  String[colCount];
            for(int j=0;j<colCount;j++)
            {
                obj[i][j] = getCellData(sheetName, j, i+1);
            }
        }
        return obj;
    }

    public String[][] getAllDataFromSheetWithoutEmptyRows(String sheetName) {
        int rowCount = getRowCount(sheetName);
        int colCount = getColumnCount(sheetName);
        String[][] obj = getAllDataFromSheet(sheetName);
        List<String[]> finalList = new ArrayList<>();

        for (int i = 0; i < rowCount; i++) {
            boolean dataFound = false;
            for (int j = 0; j < colCount; j++) {
                if (obj[i][j].equals("") == false) {
                    dataFound = true;
                    break;
                }
            }
            if (dataFound) {
                String[] rowData = obj[i];
                finalList.add(rowData);
            }
        }
        return finalList.stream().toArray(String[][]::new);
    }

    public List<String> getColHeader(String sheetName, int rowNum){
        List<String> Data = new ArrayList<String>();
        int colCount = getColumnCount(sheetName,rowNum);
        for(int i =0;i<colCount;i++) {
            if(getCellData(sheetName, i, rowNum)!=null)
                Data.add(getCellData(sheetName, i, rowNum));
        }
        return Data;

    }

    public List<String> getCompleteColumnData(String sheetNameToGet, int columnToGet, boolean removeFirstColumn) {
        List<String> xlData = null;
        try {
            sheet = getSheetIdBySheetName(sheetNameToGet);

            xlData = new ArrayList<>();
            for (int i = 0; i < sheet.getLastRowNum() + 1; i++) {
                if (removeFirstColumn || i > 0) {
                    Row row = sheet.getRow(i);
                    Cell cell = row.getCell(columnToGet);
                    xlData.add(cell.getStringCellValue());
                }
            }
        } catch (Throwable e) {
            e.printStackTrace();
        }

        return xlData;
    }

    public Map<String,Integer> collectDataFromSheetForParticularColumn(String sheetNameToGet,String column){
        Map<String,Integer> excelDataInMap= new HashMap<>();
        try{
            sheet = getSheetIdBySheetName(sheetNameToGet);
            int rowCount = getRowCount(sheetNameToGet);
            int colCount = getColumnCount(sheetNameToGet);
            Row headerRow = sheet.getRow(0);
            for (int j=1;j<rowCount;j++){
                for(int i=0;i<colCount;i++){
                    //System.out.println(i+headerRow.getCell(i).getStringCellValue());
                    if(headerRow.getCell(i).getStringCellValue().equalsIgnoreCase(column)){
                        if (excelDataInMap.containsKey(sheet.getRow(j).getCell(i).getStringCellValue().replaceAll("[^a-zA-Z0-9]", " ").toLowerCase())) {
                            excelDataInMap.put(sheet.getRow(j).getCell(i).getStringCellValue().replaceAll("[^a-zA-Z0-9]", " ").toLowerCase(), excelDataInMap.get(sheet.getRow(j).getCell(i).getStringCellValue().replaceAll("[^a-zA-Z0-9]", " ").toLowerCase())+1);
                        } else {
                            excelDataInMap.put(sheet.getRow(j).getCell(i).getStringCellValue().replaceAll("[^a-zA-Z0-9]", " ").toLowerCase(), 1);
                        }
                        break;
                    }
                }}

        }catch(Throwable e){

        }
        return excelDataInMap;
    }
    public List<List<String>> getDataFromSheet(String sheetNameToGet){
        List<List<String>> excelDataInMap= new LinkedList<>();
        try{
            sheet = getSheetIdBySheetName(sheetNameToGet);
            int rowCount = getRowCount(sheetNameToGet);
            for (int j=2;j<rowCount;j++){
                List<String> rowsData=new LinkedList<>();
                rowsData.add(sheet.getRow(j).getCell(1).getStringCellValue());
                rowsData.add(sheet.getRow(j).getCell(3).getStringCellValue());
                rowsData.add(sheet.getRow(j).getCell(4).getStringCellValue());
                excelDataInMap.add(rowsData);
            }

        }catch(Throwable e){

        }
        return excelDataInMap;
    }

    public Map<String,List<String>> collectAllDataFromSheet(String sheetNameToGet,int headerRowNumber){
        Map<String,List<String>> excelDataInMap= new HashMap<>();
        try {
            sheet = getSheetIdBySheetName(sheetNameToGet);
            int rowCount = getRowCount(sheetNameToGet);
            int colCount = getColumnCount(sheetNameToGet);
            for (int i = 0; i < colCount; i++) {
                String mapKey ="";
                List<String> mapValues= new ArrayList<>();
                for (int j = headerRowNumber; j < rowCount; j++) {
                    Row row = sheet.getRow(j);
                    Cell cell = row.getCell(i);
                    if (j==headerRowNumber){
                        mapKey = cell.getStringCellValue();
                    }else{
                        mapValues.add(cell.getStringCellValue());
                    }
                }
                excelDataInMap.put(mapKey,mapValues);
            }
        }catch (Throwable e){

        }
        return excelDataInMap;
    }

    private XSSFSheet getSheetIdBySheetName(String sheetNameToGet) throws NullPointerException{
        Iterator<Sheet> sheetIterator = workbook.sheetIterator();
        int indexForSheet = 0;

        while (sheetIterator.hasNext()) {
            Sheet sheet = sheetIterator.next();
            if (sheet.getSheetName().equalsIgnoreCase(sheetNameToGet))
                break;
            else
                indexForSheet++;
        }
        sheet = workbook.getSheetAt(indexForSheet);
        return sheet;
    }

    public List<List<String>> getDataFromExcelSheet(int sheetAt) {

        List<List<String>> mainList = null;
        try{
            Sheet firstSheet = workbook.getSheetAt(sheetAt);
            Iterator<Row> iterator = firstSheet.iterator();
            mainList = new ArrayList<>();
            while (iterator.hasNext()) {
                Row nextRow = iterator.next();
                List<String> list = new ArrayList<>();
                for (Cell currentCell : nextRow) {
                    if (currentCell.getCellType() == CellType.STRING) {
                        list.add(currentCell.getStringCellValue());
                    } else if (currentCell.getCellType() == CellType.NUMERIC) {
                        list.add(String.valueOf(Math.round(currentCell.getNumericCellValue())));
                    }
                }
                mainList.add(list);
            }
            mainList.remove(0);

        } catch (Throwable e) {
            e.printStackTrace();
        }
        return mainList;
    }

    //to return a calculated cell value which contains formula
    public String getFormulatedCellData(String sheetName,int rowNum,int colNum ) throws IOException {
        String cellData = null;
        try {
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            sheet = getSheetIdBySheetName(sheetName);
            Row row = sheet.getRow(rowNum);
            Cell cell = row.getCell(colNum);
            CellValue cellValue = evaluator.evaluate(cell);
            cellData= cellValue.formatAsString();
            return cellData;
        }catch(Throwable e)
        {
            e.printStackTrace();
        }
        return cellData;
    }

    //to copy an excel to destination
    public void copyExcel(String destinationPath) {
        try {
            fileOut = new FileOutputStream(destinationPath);
            workbook.write(fileOut);
            closeWorkbook();
        } catch (Throwable e) {

            e.printStackTrace();
        }
    }

    //to delete an excel to destination ,return true if file is deleted
    public boolean deleteExcel() {
        boolean isFileDeleted = false;
        try {
            File fileToBeDeleted = new File(path);
            isFileDeleted=fileToBeDeleted.delete();
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return isFileDeleted;
    }

    //to get the CellName based on the text given
    public CellReference getCellReference(String sheetName,String data) {
        try {
            DataFormatter objDefaultFormat = new DataFormatter();
            int index = workbook.getSheetIndex(sheetName);
            sheet = workbook.getSheetAt(index);
            CellReference cellRef = null;
            for (Row row : sheet) {
                for (Cell cell : row) {
                    cellRef = new CellReference(row.getRowNum(), cell.getColumnIndex());
                    String text = objDefaultFormat.formatCellValue(cell);

                    if (data.equals(text)) {
                        return cellRef;
                    }
                }
            }}catch(Throwable e){
            e.printStackTrace();
        }
        return null;
    }

    //to set cell data based on row and column number
    public boolean setCellData(String sheetName,int rowNum,int colNum,String data) throws IOException {
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);

            if(rowNum<=0)
                return false;

            int index = workbook.getSheetIndex(sheetName);
            if(index==-1)
                return false;


            sheet = workbook.getSheetAt(index);

            sheet.autoSizeColumn(colNum);
            row = sheet.getRow(rowNum-1);
            if (row == null)
                row = sheet.createRow(rowNum-1);

            cell = row.getCell(colNum);
            if (cell == null)
                cell = row.createCell(colNum);


            cell.setCellValue(data);

            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();

            fileOut = new FileOutputStream(path);

            workbook.write(fileOut);

            fileOut.close();
        }
        catch(Exception e){
            e.printStackTrace();
            return false;
        }
        return true;
    }

    //to evalaute all the formula in workbook
    public void evaluateAllFormulae() {
        try{
            fis = new FileInputStream(path);
            workbook = new XSSFWorkbook(fis);
            workbook.getCreationHelper().createFormulaEvaluator().evaluateAll();
        }
        catch(Exception e){
            e.printStackTrace();
        }
    }

}


