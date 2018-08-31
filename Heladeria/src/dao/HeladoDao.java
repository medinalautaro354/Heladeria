/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import Entidades.Helado;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author alumno
 */
public class HeladoDao {

    public void guardarHelado(Helado helado) {

        try {
            conexion con = new conexion();
            Connection conn = con.RetornarConeccion();

            PreparedStatement ps = conn.prepareStatement("INSERT INTO Helado (sabor, ruta, cantidad) VALUES (?,?,?)");
            ps.setString(1, helado.getSabor());
            ps.setString(2, helado.getRuta());
            ps.setInt(3, helado.getCantidad());
            ps.executeUpdate();

            JOptionPane.showMessageDialog(null, "Los datos fueron cargados correctamente!");
            ps.close();
        } catch (Exception e) {
            System.out.println(e.toString());

        }

    }

    public void guardarHeladoImagen(Helado helado) {
        try {
            conexion con = new conexion();
            Connection conn = con.RetornarConeccion();

            String insert = "INSERT INTO Helado (sabor, ruta) VALUES (?,?)";
            PreparedStatement ps = null;
            FileInputStream fi = null;

            try {
                File file = new File(helado.getRuta());
                fi = new FileInputStream(file);

                ps = conn.prepareStatement(insert);
                ps.setString(1, helado.getSabor());
                ps.setBinaryStream(2, fi);

                ps.executeUpdate();
            } catch (Exception e) {
                System.out.println("Error al guardar");
            }
        } catch (Exception e) {
        }
    }

    public Helado buscarHelado(Helado helado) {
        try {
            conexion con = new conexion();
            Connection conn = con.RetornarConeccion();

            PreparedStatement ps = conn.prepareStatement("SELECT idHelado, sabor, ruta, cantidad FROM helado WHERE sabor = ?");
            ps.setString(1, helado.getSabor());
            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                helado = new Helado();
                helado.setId(Integer.parseInt(rs.getString("idHelado")));
                helado.setSabor(rs.getString("sabor"));
                helado.setRuta(rs.getString("ruta"));
                helado.setCantidad(rs.getInt("cantidad"));
            }

        } catch (Exception e) {
        }

        return helado;
    }

    public ArrayList<Helado> listarHelados() {

        ArrayList<Helado> lista = new ArrayList<Helado>();
        Helado helado;

        try {
            conexion con = new conexion();
            Connection conn = con.RetornarConeccion();

            PreparedStatement ps = conn.prepareStatement("SELECT * FROM Helado");
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                helado = new Helado();
                helado.setId(Integer.parseInt(rs.getString("idHelado")));
                helado.setSabor(rs.getString("sabor"));
                helado.setRuta(rs.getString("ruta"));
                helado.setCantidad(rs.getInt("cantidad"));

                lista.add(helado);
            }

        } catch (Exception e) {
            System.out.println(e.toString());
        }

        return lista;
    }

    public void modificarHelado(Helado helado) {
        try {
            conexion con = new conexion();
            Connection conn = con.RetornarConeccion();

            PreparedStatement ps = conn.prepareStatement("UPDATE Helado SET sabor = ?, cantidad=? WHERE idHelado = ? ");
            ps.setString(1, helado.getSabor());
            ps.setInt(2, helado.getCantidad());
            ps.setInt(3, helado.getId());

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al modificar");
        }
    }

    public void eliminarHelado(int idHelado) {
        try {
            conexion con = new conexion();
            Connection conn = con.RetornarConeccion();

            PreparedStatement ps = conn.prepareStatement("DELETE FROM helado WHERE idHelado = ? ");
            ps.setInt(1, idHelado);

            ps.executeUpdate();

        } catch (Exception e) {
            System.out.println("Error al eliminar");
        }

    }
}
