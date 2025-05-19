package dao;

import database.Conexion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AsistenciaDAO {
    private final Connection conn;

    public AsistenciaDAO() {
        conn = Conexion.getInstancia().conectar();
    }

    // Método para insertar asistencia (ya lo tienes correcto)
    public boolean insertarAsistencia(int deportistaId, Date fecha, boolean presente, String observaciones) {
        final int ID_CLASE_GENERAL = 1;
        String sql = "INSERT INTO asistencia (deportista_id, fecha, presente, observaciones, clase_id) " +
                     "VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deportistaId);
            ps.setDate(2, fecha);
            ps.setBoolean(3, presente);
            ps.setString(4, observaciones);
            ps.setInt(5, ID_CLASE_GENERAL);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }

    // Método optimizado para obtener clases con asistencia
    public List<Object[]> obtenerClasesConAsistencia() {
        List<Object[]> resultados = new ArrayList<>();
        String sql = "SELECT a.fecha, c.nombre_clase, COUNT(*) as asistentes, c.horario " +
                     "FROM asistencia a " +
                     "JOIN clase c ON a.clase_id = c.id " +
                     "WHERE a.presente = 1 " +
                     "GROUP BY a.fecha, c.nombre_clase, c.horario " +
                     "ORDER BY a.fecha DESC, c.nombre_clase";
        
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                resultados.add(new Object[]{
                    rs.getDate("fecha"),
                    rs.getString("nombre_clase"),
                    rs.getInt("asistentes"),
                    rs.getString("horario")
                });
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    // Método mejorado para obtener asistentes
    public List<Object[]> obtenerAsistentesPorClase(String nombreClase, Date fecha) {
        List<Object[]> resultados = new ArrayList<>();
        String sql = "SELECT d.nombre, d.apellido " +
                     "FROM asistencia a " +
                     "JOIN deportistas d ON a.deportista_id = d.id " +
                     "JOIN clase c ON a.clase_id = c.id " +
                     "WHERE c.nombre_clase = ? AND a.fecha = ? AND a.presente = 1 " +
                     "ORDER BY d.apellido, d.nombre";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nombreClase);
            ps.setDate(2, fecha);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    resultados.add(new Object[]{
                        rs.getString("nombre"),
                        rs.getString("apellido")
                    });
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultados;
    }

    // Método para obtener asistencia por fecha (ya existente)
    public List<String> obtenerAsistenciaPorFecha(Date fecha) {
        List<String> presentes = new ArrayList<>();
        String sql = "SELECT d.nombre, d.apellido " +
                     "FROM asistencia a " +
                     "JOIN deportistas d ON a.deportista_id = d.id " +
                     "WHERE a.fecha = ? AND a.presente = 1";

        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, fecha);
            try (ResultSet rs = ps.executeQuery()) {
                while (rs.next()) {
                    presentes.add(rs.getString("nombre") + " " + rs.getString("apellido"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return presentes;
    }

    // Método para eliminar asistencia por fecha (ya existente)
    public boolean eliminarAsistenciaPorFecha(Date fecha) {
        String sql = "DELETE FROM asistencia WHERE fecha = ?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setDate(1, fecha);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
    }
    
    // Nuevo método para obtener el total de asistencias por deportista
    public int obtenerTotalAsistencias(int deportistaId) {
        String sql = "SELECT COUNT(*) FROM asistencia WHERE deportista_id = ? AND presente = 1";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, deportistaId);
            try (ResultSet rs = ps.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return 0;
    }
}