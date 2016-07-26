/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package utilerias;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author 05C4R
 */
public class Producto {
    private int id;
    private String nombre;
    private int cantidad;
    private double precio;
    private double subtotal;
    private int existencias; 
    private Object datos[];
   /* private ArrayList a;
    

    public ArrayList getA() {
        return a;
    }
    public int añadirProducto(int id,String Nombre,int cantidad,float precio,float subtotal,int existencias){
    
    }*/

    public Producto(ResultSet r,Integer cantidad) throws SQLException{
                       
            id=r.getInt("id_producto");
            nombre=r.getString("nombre");
            this.cantidad=cantidad;
            precio=r.getFloat("precio_unitario");
            subtotal=cantidad*r.getInt("precio_unitario");
            existencias=r.getInt("existencia");
        
    }

    public int getId() {
        return id;
    }

    public int getExistencias() {
        return existencias;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
        subtotal=this.cantidad*this.precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public double getSubtotal() {
        return subtotal;
    }

    public Object[] getDatos() {
         datos=new Object[6];
            datos[0]=id;
            datos[1]=nombre;
            datos[2]=precio;
            datos[3]=cantidad;
            datos[4]=subtotal;
            datos[5]=existencias;
        return datos;
    }
    
}
