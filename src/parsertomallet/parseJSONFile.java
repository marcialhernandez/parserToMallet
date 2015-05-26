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
    
    public int addDocuments(JSONArray jsonObjects, FileWriter fichero, BufferedWriter pw, int contador) throws IOException{
        
        //FileWriter fichero = null;
        //PrintWriter pw = new PrintWriter(fichero);
            
        //int contador=0; 
        String mensaje="";
        for(JSONObject object : (List<JSONObject>) jsonObjects){
            contador++;
            if (object.containsKey("util")){
                mensaje=contador+" "+object.get("tipo").toString()+" "+object.get("review/summary").toString()+" "+object.get("util").toString()+"\n"; 
            }
            
            else{
                mensaje=contador+" "+object.get("tipo").toString()+" "+" "+object.get("review/summary").toString()+" "+object.get("review/text").toString()+"\n";
            }
         //   String anterior = "";
            //System.out.println(mensaje);
            pw.write(mensaje);
            pw.flush();
            }
        return contador;
        }

};
