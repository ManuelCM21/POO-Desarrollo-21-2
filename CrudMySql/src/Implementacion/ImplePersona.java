package Implementacion;

import Conexion.ConexionMySql;
import Entidades.Persona;
import java.util.*;
import java.sql.*;

public class ImplePersona {

    ArrayList<Persona> lista = new ArrayList();
    Statement stm = null;
    ConexionMySql con = new ConexionMySql();
    ResultSet set;

    public void registrarPersona(Persona p) {
        try {
            String sql = "INSERT INTO persona (nombre, ap_paterno, ap_materno, sexo) values ('" + p.getNombre() + "','" + p.getAp_paterno() + "','" + p.getAp_materno() + "','" + p.getSexo() + "')";
            int i = 0;
            String msg = "";
            stm = con.conexionDB().createStatement();
            i = stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.getMessage();
        }
    }

    public ArrayList<Persona> reportePersona() {
        try {
            String sql = "SELECT * FROM persona";
            stm = con.conexionDB().createStatement();
            set = stm.executeQuery(sql);
            while (set.next()) {
                Persona ps = new Persona();
                ps.setId(set.getString(1));
                ps.setNombre(set.getString(2));
                ps.setAp_paterno(set.getString(3));
                ps.setAp_materno(set.getString(4));
                ps.setSexo(set.getString(5));
                lista.add(ps);
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return lista;
    }

    public void eliminarPersona(Persona p) {
        try {
            String sql = "delete from persona where id = '" + p.getId() + "' ";
            stm = con.conexionDB().createStatement();
            stm.executeUpdate(sql);
        } catch (SQLException ex) {
            ex.getMessage();
        }
    }
    
    public Persona reportePersonaUnitario(String id) {
        Persona ps = null;
        try {
            String sql = "SELECT * FROM persona WHERE id = '"+id+"' ";
            stm = con.conexionDB().createStatement();
            set = stm.executeQuery(sql);
            while (set.next()) {
                ps = new Persona();
                ps.setId(set.getString(1));
                ps.setNombre(set.getString(2));
                ps.setAp_paterno(set.getString(3));
                ps.setAp_materno(set.getString(4));
                ps.setSexo(set.getString(5));
            }
        } catch (SQLException e) {
            e.getMessage();
        }
        return ps;
    }
    
    public void actualizarPersona(Persona p) {
        try {
            String sql = "UPDATE persona SET nombre='"+p.getNombre()+"', ap_paterno = '"+p.getAp_paterno()+"', ap_materno = '"+p.getAp_materno()+"', sexo = '"+p.getSexo()+"' WHERE id = '"+p.getId()+"' ";
            stm = con.conexionDB().createStatement();
            stm.executeUpdate(sql);
        } catch (SQLException e) {
            e.getMessage();
        }
    }
}
