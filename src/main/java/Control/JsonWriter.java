/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Control;

import com.google.gson.*;
import java.io.*;

/**
 *
 * @author felip
 */
public class JsonWriter {
    private final Gson gson = new Gson();
    private String jsonStr;
    private String fileJson;
    
    public JsonWriter(String file) {
        fileJson = file;
    }
    
    public void insertarObj(Object obj) {
        jsonStr = gson.toJson(obj);
    }
    
    public void guardarJson() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(fileJson))) {
            bw.write(jsonStr);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
