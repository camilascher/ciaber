/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.util.JRLoader;
import net.sf.jasperreports.view.JasperViewer;
import servicios.Conexion;

/**
 *
 * @author Nico
 */
public class Reportes {

    public Reportes(String reporte, String[] param) {

        switch (reporte) {
            case "ReporteVentasProducto":
                crearReporteVentasProducto(param);
                break;
            case "ReporteVentasDia":
                crearReporteVentasDia(param);
                break;
            case "ReporteTXT":
                crearReporteTXT(param);
                break;
            default:
                break;
        }

    }

    private void crearReporteVentasProducto(String[] param) {
        URL in = this.getClass().getResource("ReporteVentasProducto.jasper");
        JasperReport reporte;
        Map parametersMap = new HashMap();
        String where_usr = "";
        if (param[2].length() > 0) {
            where_usr = " and usr.nombre = '" + param[2] + "' \n";
            parametersMap.put("turno", param[2]);
        } else {
            parametersMap.put("turno", "Todos");
        }
        parametersMap.put("fd", param[0]);
        parametersMap.put("fh", param[1]);
        parametersMap.put("query", "SELECT\n"
                + "                prod.idproducto as Codigo,\n"
                + "                prod.descripcion as Producto,\n"
                + "                sum(det.cantidad) as Cantidad,\n"
                + "                sum(det.cantidad*det.precio) as Total,\n"
                + "                usr.nombre as Turno\n"
                + "                FROM\n"
                + "			ABMPrueba.pedido ped,\n"
                + "                ABMPrueba.detalle_pedido det,\n"
                + "                ABMPrueba.producto prod,\n"
                + "                ABMPrueba.usuario usr\n"
                + "                WHERE\n"
                + "                prod.idproducto = det.idproducto\n"
                + "			and det.idpedido = ped.idpedido\n"
                + "                and usr.idusuario = ped.usuarioid_creacion\n" + where_usr
                + "                and str_to_date(ped.fecha,'%Y-%m-%d') between str_to_date('" + param[0] + "','%d/%m/%Y') and str_to_date('" + param[1] + "','%d/%m/%Y') \n"
                + "                group by Codigo,Producto;");
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\Cami\\Documents\\ABM Prueba\\src\\Inicio\\ReporteVentasProducto.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametersMap, Conexion.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearReporteVentasDia(String[] param) {
        URL in = this.getClass().getResource("ReporteVentasDia.jasper");
        JasperReport reporte;
        Map parametersMap = new HashMap();
        parametersMap.put("query", "SELECT\n"
                + "                date_format((ped.fecha),'%d/%m/%Y') as Dia,"
                + "               count(ped.idpedido) as CantTick,"
                + "                sum(ped.total) as Total\n"
                + "                FROM\n"
                + "			ABMPrueba.pedido ped\n"
                + "                 WHERE\n"
                + "                 str_to_date(ped.fecha,'%Y-%m-%d') between str_to_date('" + param[0] + "','%d/%m/%Y') and str_to_date('" + param[1] + "','%d/%m/%Y') \n"
                + "                group by Dia;");
        parametersMap.put("fd", param[0]);
        parametersMap.put("fh", param[1]);
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\Cami\\Documents\\ABM Prueba\\src\\Inicio\\ReporteVentasDia.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametersMap, Conexion.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void crearReporteTXT(String[] param) {
        URL in = this.getClass().getResource("ReporteTXT.jasper");
        JasperReport reporte;
        Map parametersMap = new HashMap();
        parametersMap.put("query", "SELECT \n"
                + "concat(lpad(ped.idpedido,8,0),\n"
                + "lpad(ped.idempleado,6,0),\n"
                + "date_format((ped.fecha),'%d%m%Y%H%i%s'),\n"
                + "lpad(cast((ped.total*100) as decimal(11,0)),10,0) \n"
                + ") res \n"
                + "from\n"
                + "ABMPrueba.pedido ped\n"
                + "where \n"
                + "str_to_date(ped.fecha,'%Y-%m-%d') between str_to_date('" + param[0] + "','%d/%m/%Y') and str_to_date('" + param[1] + "','%d/%m/%Y'); \n" 
        );
        parametersMap.put("fd", param[0]);
        parametersMap.put("fh", param[1]);
        try {
            reporte = (JasperReport) JRLoader.loadObjectFromFile("C:\\Users\\Cami\\Documents\\ABM Prueba\\src\\Inicio\\ReporteTXT.jasper");
            JasperPrint jasperPrint = JasperFillManager.fillReport(reporte, parametersMap, Conexion.getConnection());
            JasperViewer.viewReport(jasperPrint, false);
        } catch (Exception ex) {
            Logger.getLogger(Reportes.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
