/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package parsertomallet;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import static java.lang.System.out;
import java.util.List;
import java.util.Vector;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

/**
 *
 * @author Marcial
 */
public class ParserToMallet {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        String directorioRaiz="src/bd";
        
        File dir = new File(directorioRaiz);
        File[] directoryListing = dir.listFiles();
        //banderaCrear indica si hay que crear o no un nuevo indice invertido
        //En caso que si, es true, en caso que no, es false
        if (directoryListing != null) {
            
            parseJSONFile entradaBD;
            JSONArray documentos;
            FileWriter fichero = new FileWriter("entradaMallet.txt");
            BufferedWriter pw = new BufferedWriter(fichero);
            
            for (File child : directoryListing) {
                
                //Para cada documento
                entradaBD = new parseJSONFile();
                documentos = new JSONArray(); 
                //Se usa esta forma para ignorar un documento dentro de la carpeta bd
                if (child.getName().equals(".DS_Store")){
                continue;}
                documentos = entradaBD.obtieneDocumentos("/bd/"+child.getName());
                entradaBD.addDocuments(documentos,fichero,pw);
            }
            fichero.close();
    
        }
    }
}
