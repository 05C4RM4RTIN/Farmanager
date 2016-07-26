package utilerias;



import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 05C4R
 */
public class AccionReporte{

    public static boolean band=false; 
    Conexion con;
 //Cargando dialogo;
    public AccionReporte() {
        con=new Conexion("root","05C4R");
        con.conectar();
       // dialogo=new Cargando(parent,modal);
    }
    
    public  void generarPDF(String ubicacionreporte,String ubicacionGuardado,Map parametros){
        JasperReport jasperReport;
        JasperPrint jasperPrint;                
        try
        {
            
           // dialogo.setVisible(true);
          //se carga el reporte
            band=false;
         // URL  in=this.getClass().getResource( "report1.jasper" );
          jasperReport=(JasperReport)JRLoader.loadObjectFromFile(ubicacionreporte);
          //se procesa el archivo jasper
          jasperPrint = JasperFillManager.fillReport(jasperReport,parametros,con.getCon());
          //se crea el archivo PDF
          JasperExportManager.exportReportToPdfFile( jasperPrint, ubicacionGuardado);
          band=true;
            //dialogo.setVisible(false);
        }
        catch (JRException ex)
        {
          System.err.println( "Error iReport: " + ex.getMessage() );
        }
  }
    public  void visualizarPDF(String ubicacionreporte,String title,Map parametros){
    
    JasperReport reporte;
    try {
        
        //dialogo.setVisible(true);
        band=false;
       reporte=(JasperReport)JRLoader.loadObjectFromFile(ubicacionreporte);
       
        JasperPrint jp=JasperFillManager.fillReport(reporte, parametros,con.getCon());
         
        JasperViewer jv=new JasperViewer(jp);
        jv.setTitle(title);
        band=true;
          // dialogo.setVisible(false);
        jv.setVisible(true);
        
       // jp.
    } catch (JRException ex) {
        System.out.println("errrrrrrrrrrrrr");
    }
    }


}
