package utilities;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.IOException;

public class ExcelHelper {
    static XSSFWorkbook workbook;
    static XSSFSheet sheet;

    public static void setupExcel(){

        try {
            workbook = new XSSFWorkbook("src/test/java/data/Azola Dyantyi Luma Excel File.xlsx");
            sheet = workbook.getSheet("Luma Test Data");

            workbook.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static String getCellData(int rowNum, int cellNum){
        setupExcel();
        String cellData = sheet.getRow(rowNum).getCell(cellNum).getStringCellValue();
        return cellData;
    }

    public static int getCellInt(int rowNum, int cellNum){
        setupExcel();
        int cellData = (int) sheet.getRow(rowNum).getCell(cellNum).getNumericCellValue();
        return cellData;
    }

}
