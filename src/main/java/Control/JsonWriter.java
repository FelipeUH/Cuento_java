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
    private String jsonFile;
    
    public JsonWriter(String path) {
        jsonFile = path;
    }
    
    public void insertObject(Object obj) {
        jsonStr = gson.toJson(obj);
    }
    
    public void saveJson() {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(jsonFile))){
            bw.write(jsonStr);
            bw.newLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
