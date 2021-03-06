/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelos;

/**
 *
 * @author Nico
 */
public class DetallePedido {
    private final Integer idPedido;
    private final Producto producto;
    private final Double precio;
    private final Integer cantidad;
    
    public DetallePedido(){
        this.idPedido = null;
        this.producto = null;
        this.precio=0.0;
        this.cantidad=null;
    }
    
    public DetallePedido(Integer idPedido,Producto producto, Double precio,Integer cantidad){
        this.idPedido = idPedido;
        this.producto = producto;
        this.precio = precio;
        this.cantidad = cantidad;
    }
    
    public Integer getIdPedido(){
        return idPedido;
    }
    
    public Producto getProducto(){
        return producto;
    }
    
    public Double getPrecio(){
        return precio;
    }
    
    public Integer getCantidad(){
        return cantidad;
    }
}
