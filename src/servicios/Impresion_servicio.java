/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servicios;

import modelos.DetallePedido;
import modelos.Empleado;
import modelos.Pedido;
import util.Impresora;

/**
 *
 * @author Nico
 */
public class Impresion_servicio {

    static final String NOMBRE_EMPRESA = "EURO-CUCINE S.R.L.";
    
    public static void imprimirPedido(Pedido pedido) {
        Impresora impresora = new Impresora(null);
        Empleado empleado = pedido.getEmpleado();
        Double total = 0.0;
        Double acumulado = 0.0;

        //Cabecera
        impresora.escribir(NOMBRE_EMPRESA);
        //String fecha = new SimpleDateFormat("dd/MM/yyyy HH:mm").format(Calendar.getInstance().getTime());
        impresora.escribir("Fecha     " + pedido.getFecha());
        impresora.escribir("Ticket Nro " + pedido.getIdPedido());
        impresora.escribir(empleado.getNombreEmpleado().toUpperCase());
        impresora.escribir("Legoajo: " + empleado.getIdEmpleado().toString());
        //Items
        impresora.escribir("CNT Producto        Precio");
        impresora.escribir("* ADICIONALES       ******");
        for (DetallePedido detalle : pedido.getDetallesPedido()) {
            total += detalle.getCantidad() * detalle.getPrecio();
            String precio = String.format("%5s", detalle.getPrecio().toString());
            String cant = String.format("%3s", detalle.getCantidad().toString());
            String desc = String.format("%-16s", detalle.getProducto().getDescripcion()).substring(0, 16);
            String linea = cant + " " + desc + " " + precio;
            impresora.escribir(linea);
        }
        //Totales
        impresora.escribir("* SALDOS            ******");
        impresora.escribir("   Total Ticket:" + String.format("%10s", total.toString()));
        impresora.escribir("  Acum. del Mes:" + String.format("%10s", acumulado.toString()));
        //Pie
        impresora.escribir("");
        impresora.escribir("**************************");
        impresora.escribir("*       USO INTERNO      *");
        impresora.escribir("* Este comprobante no es *");
        impresora.escribir("* valido como factura    *");
        impresora.escribir("**************************");
        impresora.finalizar();
    }
}
