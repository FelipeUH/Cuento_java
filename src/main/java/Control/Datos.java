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

public class Datos {
    
    private String rutaArchivo;
    
    public Datos(String ruta) {
        this.rutaArchivo = ruta;
    }
    
    public List<String[]> obtenerDatos() {
        
        List<String[]> listaFiltrada = new ArrayList<>();
        
        try {
            // Cargando el archivo Excel
            FileInputStream inputStream = new FileInputStream(new File(rutaArchivo));
            XSSFWorkbook workbook = new XSSFWorkbook(inputStream);

            // Obteniendo la segunda hoja del archivo
            XSSFSheet sheet = workbook.getSheetAt(1);

            // Iterando sobre las filas de la hoja
            for (Row row : sheet) {
                // Ignorar la primera fila (encabezados)
                if (row.getRowNum() == 0) continue;

                if (row.getRowNum() % 2 == 0) continue;
                
                // Obtener la celda de la columna "Clase"
                Cell claseCell = row.getCell(2);

                // Verificar si la clase es diferente de "MOTOCICLETA" o "MOTOCARRO"
                String clase = claseCell.getStringCellValue();
                if (clase.equals("AUTOMOVIL")) {
                    // Obtener las celdas de las columnas requerida
                    String fila[] = new String[3];

                    fila[0] = row.getCell(1).getStringCellValue(); // Marca
                    fila[1] = row.getCell(5).getStringCellValue(); // Referencia
                    fila[2] = row.getCell(67).getStringCellValue(); // Precio
                    
                    listaFiltrada.add(fila);
                }
            }

            // Cerrar el archivo
            workbook.close();
            inputStream.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
        return listaFiltrada;
    }
}
