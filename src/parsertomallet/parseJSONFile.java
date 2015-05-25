/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package parsertomallet;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.List;
import org.json.simple.*;

/**
 *
 * @author Marcial
 */
public class parseJSONFile{

    public parseJSONFile(){
    };

    JSONArray obtieneDocumentos(String jsonFilePath){
        System.out.println("obteniendo Datos de "+ jsonFilePath);
        InputStream jsonFile =  getClass().getResourceAsStream(jsonFilePath);
        Reader readerJson = new InputStreamReader(jsonFile);
        //Parse the json file using simple-json library
        System.out.println("Parseando Jsons de "+jsonFilePath);
        Object fileObjects= JSONValue.parse(readerJson);
        JSONArray arrayObjects=(JSONArray)fileObjects;
        System.out.println("Parseo completado de "+jsonFilePath);
        return arrayObjects;
    };
    
    public void addDocuments(JSONArray jsonObjects, FileWriter fichero, BufferedWriter pw) throws IOException{
        
        //FileWriter fichero = null;
        //PrintWriter pw = new PrintWriter(fichero);
            
        int contador=0; 
        String mensaje="";
        for(JSONObject object : (List<JSONObject>) jsonObjects){
            contador++;
         //   String anterior = "";
            mensaje=contador+" "+object.get("tipo").toString()+" "+object.get("util").toString(); 
            System.out.println(mensaje);
            pw.write(mensaje);
            pw.flush();
            }
        }

};
