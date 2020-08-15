/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package TDAS;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Bryan
 */
public class Util {
    
    public static String leerTexto(String archivo){
        String line = null;
        try(BufferedReader bffr = new BufferedReader(new FileReader("/src"+archivo))) {
            String linea;
            while ((linea = bffr.readLine()) != null) {
                line= line + linea;
            }    
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Util.class.getName()).log(Level.SEVERE, null, ex);
        }    
        return line;
    }
    public static HashMap<String,Integer> calcularFrecuencias(String texto){
        HashMap<String,Integer> mapa = new HashMap<String,Integer>();
        String[] caracteres = texto.split("");
        for(int i=0;i<caracteres.length;i++){
            if(mapa.containsKey(caracteres[i])){
                mapa.put(caracteres[i],mapa.get(caracteres[i])+1);
            }else{
                mapa.put(caracteres[i],1);
            }  
        }
        return mapa;
    }
    public static String binarioHexadecimal(String binario){
        //habria que ver que se utiliza si una lista o algo mas
        
        
        
        return "";
    }
    
    public String hexadecimalBinario(String hexadecimal){
        
        return "";
    }
    
    
    
    
}
