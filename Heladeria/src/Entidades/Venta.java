/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import dao.VentaDao;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Venta {

    private int idVenta;
    private String helado;
    private int cantidad;
    private double importe;
    private String fecha;

    public Venta(int idVenta, String helado, int cantidad, double importe, String fecha) {
        this.idVenta = idVenta;
        this.helado = helado;
        this.cantidad = cantidad;
        this.importe = importe;
        this.fecha = fecha;
    }

    public Venta() {
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public String getHelado() {
        return helado;
    }

    public void setHelado(String helado) {
        this.helado = helado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getImporte() {
        return importe;
    }

    public void setImporte(double importe) {
        this.importe = importe;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }
    
    public static void guardarVenta(Venta venta){
        VentaDao v = new VentaDao();
        v.guardarHelado(venta);
    }
    
    public static ArrayList<Venta> listarVentas(){
        VentaDao venta= new VentaDao();
        return venta.listarVentas();
    }

}
