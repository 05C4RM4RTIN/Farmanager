/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Map;
import utilerias.AccionReporte;

/**
 *
 * @author 05C4R
 */
public class TareaGenera implements Runnable{
 AccionReporte reporte;
    public static boolean band=false;   
    String ubicacionreporte;
    String ubicacionGuardado;
    Map parametros;

    public TareaGenera(String ubicacionreporte, String ubicacionGuardado, Map parametros) {
        this.ubicacionreporte = ubicacionreporte;
        this.ubicacionGuardado = ubicacionGuardado;
        this.parametros = parametros;
        reporte=new AccionReporte();
    }

    
    

    @Override
    public void run() {
        band=false;
        reporte.generarPDF(ubicacionreporte, ubicacionGuardado, parametros);
        band=true;
    }

}