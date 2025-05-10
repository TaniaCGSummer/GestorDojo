package dao;

import database.Conexion;
import entidades.Deportista;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DeportistaDAO {

    Connection conn;

    public DeportistaDAO() {
        conn = Conexion.getInstancia().conectar();
    } 

    public List<Deportista> obtenerTodos() {
        List<Deportista> lista = new ArrayList<>();
        String sql = "SELECT * FROM deportistas";

        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Deportista d = new Deportista(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("apellido"),
                    rs.getDate("fecha_nacimiento"),
                    rs.getString("telefono"),
                    rs.getString("email"),
                    rs.getString("direccion"),
                    rs.getDate("fecha_inscripcion"),
                    rs.getString("estado"),
                    rs.getString("contacto_emergencia")
                );

                lista.add(d);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return lista;
    }
    public boolean insertar(Deportista d) {
    String sql = "INSERT INTO deportistas (nombre, apellido, fecha_nacimiento, telefono, email, direccion, fecha_inscripcion, estado, contacto_emergencia) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
    try (PreparedStatement ps = conn.prepareStatement(sql)) {
        ps.setString(1, d.getNombre());
        ps.setString(2, d.getApellido());
        ps.setDate(3, d.getFechaNacimiento());
        ps.setString(4, d.getTelefono());
        ps.setString(5, d.getEmail());
        ps.setString(6, d.getDireccion());
        ps.setDate(7, d.getFechaInscripcion());
        ps.setString(8, d.getEstado());
        ps.setString(9, d.getContactoEmergencia());
        return ps.executeUpdate() > 0;
    } catch (SQLException e) {
        e.printStackTrace();
        return false;
    }
}

    public boolean actualizar(Deportista d) {
        String sql = "UPDATE deportistas SET nombre=?, apellido=?, fecha_nacimiento=?, telefono=?, email=?, direccion=?, fecha_inscripcion=?, estado=?, contacto_emergencia=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, d.getNombre());
            ps.setString(2, d.getApellido());
            ps.setDate(3, d.getFechaNacimiento());
            ps.setString(4, d.getTelefono());
            ps.setString(5, d.getEmail());
            ps.setString(6, d.getDireccion());
            ps.setDate(7, d.getFechaInscripcion());
            ps.setString(8, d.getEstado());
            ps.setString(9, d.getContactoEmergencia());
            ps.setInt(10, d.getId());
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    public boolean eliminar(int id) {
        String sql = "DELETE FROM deportistas WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
}
