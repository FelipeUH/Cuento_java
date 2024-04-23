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
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author felip
 */

public class ExcelReader {
    
    private String rutaArchivo;
    
    public ExcelReader(String ruta) {
        this.rutaArchivo = ruta;
    }
    
    public List<String[]> obtenerDatos() {
        
        List<String[]> listaFiltrada = new ArrayList<>();
        
        try {
            FileInputStream inputStream = new FileInputStream(new File(rutaArchivo));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);
            
            XSSFSheet sheet = workbook.getSheetAt(1);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) continue;

                if (row.getRowNum() % 2 == 0) continue;
                
                Cell claseCell = row.getCell(2);

                String clase = claseCell.getStringCellValue();
                if (clase.equals("AUTOMOVIL")) {
                    String fila[] = new String[3];

                    fila[0] = row.getCell(1).getStringCellValue(); // Marca
                    fila[1] = row.getCell(5).getStringCellValue(); // Referencia
                    fila[2] = row.getCell(67).getStringCellValue(); // Precio
                    
                    listaFiltrada.add(fila);
                }
            }
            workbook.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaFiltrada;
    }
}
