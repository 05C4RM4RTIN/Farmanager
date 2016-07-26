/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

import java.util.ArrayList;

/**
 *
 * @author 05C4R
 */
public class ListaProducto {

    
    public int buscarProducto(ArrayList <Producto>array,int valor)
    {
        int index=-1; 
            for (int i = 0; i < array.size(); i++) {
                if(array.get(i).getId()== valor){                    
                index=i;
                break;
                }
            }
        return index;
    }
    
    public double suma(ArrayList <Producto>array){
    double suma=0;
        for (int i = 0; i < array.size(); i++) {
            suma+=array.get(i).getSubtotal();
        }
    
    
        return suma;
    }
}
