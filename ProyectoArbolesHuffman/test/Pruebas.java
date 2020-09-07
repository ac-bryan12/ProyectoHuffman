
import TDAS.Util;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Bryan
 */
public class Pruebas {
    public static void main(String[] args){
        String g =Util.binarioHexadecimal("0010 0100 1001 0010 0111 0110 1101 1011 0110 1101 1000 0000 0000 0000 0101 1011 0110 1101 1011 0110 0100 1001 0010 0100 1111 1111 1111 1111 1111 1111 0101 0101 0101 0101 0101 01 ");
        System.out.println(g);
        System.out.println("");
        System.out.println(Util.hexadecimalBinario(g));
    }
    public static HashMap<String, String> mapa = new HashMap<>();
    public static HashMap<String, String> leerMapa(String nombreArchivo) {
        try (BufferedReader bff = new BufferedReader(new FileReader("src/" + nombreArchivo + ".txt"))) {            
            String linea;
            while ((linea = bff.readLine()) != null) {                
                String[] array = linea.split("\\,");
                mapa.put(array[0], array[1]);   
            }

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(Pruebas.class.getName()).log(Level.SEVERE, null, ex);
        }
        return mapa;
    }
    
}
