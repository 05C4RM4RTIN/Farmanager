/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package utilerias;
//import interfaz.Registrar;
import java.awt.image.BufferedImage;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
/**
 *
 * @author Javier
 */
public class Conexion {
    Connection con=null;  
    ResultSet resultado;
    Statement sentencia;
    String user,password;
    
    
    public  Conexion(String user,String password)
    {
        this.user=user;
        this.password=password;
        sentencia=null;
    }
public Connection conectar(){
    try{
         Class.forName("com.mysql.jdbc.Driver");
         con=DriverManager.getConnection("jdbc:mysql://localhost/Puntodeventa",user,password); 
         //System.out.println("Coneccion Establecida");
         //JOptionPane.showMessageDialog(null, "Coneccion Establecida");
    }catch(ClassNotFoundException | SQLException e){
        System.out.println("Error");
         JOptionPane.showMessageDialog(null, "Error de la coneccion"+e);
    }
    
    return con;
}

public ResultSet consultar(String sql) {
        try {
            System.out.println(sql);
            sentencia = this.conectar().createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("err");
            return null;
        }        return resultado;
    }

    public Connection getCon() {
        return con;
    }
    /*
    public ResultSet consultar(String sql) {
        ResultSet resultado;
        try {
            Statement sentencia = con.createStatement();
            resultado = sentencia.executeQuery(sql);
        } catch (SQLException e) {
            System.out.println("err");
            return null;
        }        return resultado;
    }

    public Connection getCon() {
        return con;
    }
    */

        /**
         * Metodo para realizar las inserciones en la base de datos
         * @param sql instruccion sql (INSERT) que se llevara a cabo
         * @param obj valores a ingresar en las columnas respectivas de la tabla
         * @return un valor entero 
         * either (1) the row count for SQL Data 
         * Manipulation Language (DML) statements or (2) 0 for SQL 
         * statements that return nothing
         * @throws SQLException 
         */
public int agregar(String sql, Object ...obj) {
         int i=1;
        try {
             PreparedStatement statement=this.conectar().prepareStatement(sql);
             for (Object obj1 : obj) {
                 statement.setObject(i++, obj1);
                 
            }
  
            return statement.executeUpdate();     
                        
         } catch (SQLException ex) {
            System.out.println("error al insertar");
         }
        return 0;
            
    
    }
        /**
         * Metodo para agregar imagen a una base de datos
         * @param sql sentencia sql (INSERT) a la base de datos
         * @param file ruta donde se encuentra la imagen
         * @param longitud longitud en bytes de la imagen
         * @return un valor entero
         * either (1) the row count for SQL Data 
         * Manipulation Language (DML) statements or (2) 0 for SQL 
         * statements that return nothing
         * @throws SQLException 
         */
        public int agregarimagen(String sql,FileInputStream file,int longitud, Object ...obj) {
         int i=1;
             try {
             PreparedStatement statement=this.conectar().prepareStatement(sql);
             for (Object obj1 : obj) {
                 statement.setObject(i++, obj1);
                 
            }
               statement.setBlob(i++, file, longitud);
            return statement.executeUpdate();     
                        
         } catch (SQLException ex) {
            // Logger.getLogger(Registrar.class.getName()).log(Level.SEVERE, null, ex);
         }
        return 0;
    
    }
        /**
         * Metodo para optener la foto de una base de datos,
         * y poder visualizarla en la aplicacion
         * @param sql consulta a la base de datos
         * @return  ImageIcon 
         * @throws SQLException, IOException
         */
        
       public ImageIcon getFoto(String sql) {
                ImageIcon icono=null;
                InputStream is=null;
                 try {
            sentencia = this.conectar().createStatement();
            resultado = sentencia.executeQuery(sql);
            if(resultado.next()){
                is=resultado.getBinaryStream(1);
                BufferedImage bufer=ImageIO.read(is);
                icono= new ImageIcon(bufer);
            }  
        } catch (SQLException e) {
            System.out.println("err");
            
        } catch(IOException e){System.out.println("err");}      
       
          return icono;
       } 
}