/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import java.io.*;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.util.*;

/**
 *
 * @author felip
 */

public class ExcelReader {
    
    private final String filePath;
    
    public ExcelReader(String path) {
        this.filePath = path;
    }
    
    public List<String[]> processExcelFile() {
        List<String[]> filteredList = new ArrayList<>();
        
        try (FileInputStream inputStream = new FileInputStream(new File(filePath));
            BufferedInputStream bufferedInputStream = new BufferedInputStream(inputStream);
            XSSFWorkbook workbook = new XSSFWorkbook(bufferedInputStream)) {
            
            XSSFSheet sheet = workbook.getSheetAt(1);
            Iterator<Row> rowIterator = sheet.iterator();

            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                if (row.getRowNum() == 0 || row.getRowNum() % 2 == 0 || row.getRowNum() % 3 == 0) continue;
                
                Cell cellClass = row.getCell(2);
                String vehicleClass = cellClass.getStringCellValue();
                
                if ("AUTOMOVIL".equals(vehicleClass)) {
                    String[] filteredRow = new String[3];

                    filteredRow[0] = row.getCell(1).getStringCellValue(); // Brand
                    filteredRow[1] = row.getCell(5).getStringCellValue(); // Reference
                    filteredRow[2] = row.getCell(67).getStringCellValue(); // Price
                    
                    filteredList.add(filteredRow);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return filteredList;
    }
}
