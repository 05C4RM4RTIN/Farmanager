/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

import interfaz.Correo;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 *
 * @author 05C4R
 */
public class Archivo {
    private String Ubicacion;

    public Archivo(String Ubicacion) {
        this.Ubicacion = Ubicacion;
    }
    
    
    public void escribir(ArrayList<String> contenido) throws IOException
    {
        FileWriter fichero;
        PrintWriter pw;
        fichero = new FileWriter(Ubicacion);
        pw = new PrintWriter(fichero);
        for (int i = 0; i <contenido.size(); i++) {
            pw.println(contenido.get(i));
        }
            
        pw.close();
      
    }
    public ArrayList<String> lectura() throws IOException
    {
        int aux = 0;
        BufferedReader br;
        String arr;
        ArrayList<String> contenido = new ArrayList();
        br = new BufferedReader(new FileReader(Ubicacion));

        while ((arr = br.readLine()) != null) {
               contenido.add(arr);
            
        }
        br.close();

        return contenido;
    }
    
    public int numlineas() throws IOException
    {
        int aux=0;
        BufferedReader br;
            br= new BufferedReader(new FileReader(Ubicacion));
        
        while(br.readLine()!= null)
            { aux++;                
            }
        br.close();
        
        
        return aux;
    }
    
}
