/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidades.Venta;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class VentaDao {
     public void guardarHelado(Venta venta) {

        try {
            conexion con = new conexion();
            Connection conn = con.RetornarConeccion();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Venta (helado, cantidad, importe, fecha) VALUES (?,?,?,?)");
            ps.setString(1, venta.getHelado());
            ps.setInt(2, venta.getCantidad());
            ps.setDouble(3, venta.getImporte());
            ps.setString(4, venta.getFecha());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Los datos fueron cargados correctamente!");
            ps.close();
        } catch (Exception e) {
            System.out.println(e.toString());
            
        }

    }
     
     public ArrayList<Venta> listarVentas() {

        ArrayList<Venta> lista = new ArrayList<Venta>();
        Venta venta;

        try {
            conexion con = new conexion();
            Connection conn = con.RetornarConeccion();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Venta");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                venta = new Venta();
                venta.setIdVenta(Integer.parseInt(rs.getString("idVenta")));
                venta.setHelado(rs.getString("helado"));
                venta.setImporte(rs.getDouble("importe"));
                venta.setCantidad(Integer.parseInt(rs.getString("cantidad")));
                venta.setFecha(rs.getString("fecha"));
                lista.add(venta);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return lista;
    }
    
}
