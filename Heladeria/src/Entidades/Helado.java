/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import dao.HeladoDao;
import java.util.ArrayList;

/**
 *
 * @author alumno
 */
public class Helado {

    private int id;
    private String sabor;
    private String ruta;
    private int cantidad;

    public Helado() {
    }

    public Helado(int id, String sabor) {
        this.id = id;
        this.sabor = sabor;
    }

    public String getRuta() {
        return ruta;
    }

    public void setRuta(String ruta) {
        this.ruta = ruta;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    
    @Override
    public String toString(){
        
        return "ID: "+this.id+"\nNombre: "+this.sabor+"\nCantidad: "+this.cantidad;
    }

    public static ArrayList<Helado> ListarHelados() {

        HeladoDao helado = new HeladoDao();

        return helado.listarHelados();
    }

    public static void guardarUnHelado(Helado helado) {
        HeladoDao h = new HeladoDao();
        h.guardarHelado(helado);
    }
    
    public static void modificarHelado(Helado helado){
        HeladoDao h = new HeladoDao();
        h.modificarHelado(helado);
    }
    
    public static void eliminarHelado(Helado helado){
        HeladoDao h = new HeladoDao();
        h.eliminarHelado(helado.getId());
    }
    
    public static Helado buscarHelado(Helado helado){
        HeladoDao h = new HeladoDao();
 
        return h.buscarHelado(helado);
    }
}
