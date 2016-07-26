/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package interfaz;

import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import utilerias.AccionReporte;
import static utilerias.AccionReporte.band;
import utilerias.Conexion;

/**
 *
 * @author 05C4R
 */
public class TareaVisualiza implements Runnable {
    AccionReporte reporte;
    public static boolean band=false;   
    String ubicacionreporte;
    String titulo;
    Map parametros;
    Conexion con;

    public TareaVisualiza(String ubicacionreporte, String titulo, Map parametros) {
        this.ubicacionreporte = ubicacionreporte;
        this.titulo = titulo;
        this.parametros = parametros;
        //reporte=new AccionReporte();
        
        con=new Conexion("root","05C4R");
        con.conectar();
    }

    

    
    
    @Override
    public void run() {
        band = false;
        //reporte.visualizarPDF(ubicacionreporte, titulo, parametros);
        JasperReport reporte;
        try {

            //dialogo.setVisible(true);
            band = false;
            reporte = (JasperReport) JRLoader.loadObjectFromFile(ubicacionreporte);

            JasperPrint jp = JasperFillManager.fillReport(reporte, parametros, con.getCon());

            JasperViewer jv = new JasperViewer(jp);
            jv.setTitle(titulo);
            band = true;
            // dialogo.setVisible(false);
            jv.setVisible(true);

            // jp.
        } catch (JRException ex) {
            System.out.println("errrrrrrrrrrrrr");
        }
        

    }
}
