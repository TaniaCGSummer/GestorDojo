package dao;
import database.Conexion;
import entidades.articulo;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class articuloDAO {
      
    private Connection conn;
    
    public articuloDAO() {
        conn = Conexion.getInstancia().conectar();
    } 
    
    public List<articulo> obtenerTodos() {
        List<articulo> lista = new ArrayList<>();
        String sql = "SELECT * FROM articulo";
        try (PreparedStatement ps = conn.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            while (rs.next()) {
                articulo a = new articulo(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("categoria"),
                    rs.getDouble("precio")                 
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error al obtener todos los artículos: " + e.getMessage());
            e.printStackTrace();
        }
        return lista;
    }
    
    public boolean insertar(articulo a) {
        String sql = "INSERT INTO articulo (nombre, descripcion, categoria, precio) VALUES (?, ?, ?, ?)";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            
            // Manejar valores NULL para descripcion
            if (a.getDescripcion() == null) {
                ps.setNull(2, Types.VARCHAR);
            } else {
                ps.setString(2, a.getDescripcion());
            }
            
            // Manejar valores NULL para categoria
            if (a.getCategoria() == null) {
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(3, a.getCategoria());
            }
            
            ps.setDouble(4, a.getPrecio());
            
            // Imprimir para depuración
            System.out.println("Insertando artículo:");
            System.out.println("Nombre: " + a.getNombre());
            System.out.println("Descripción: " + a.getDescripcion());
            System.out.println("Categoría: " + a.getCategoria());
            System.out.println("Precio: " + a.getPrecio());
            
            int filasAfectadas = ps.executeUpdate();
            System.out.println("Filas afectadas: " + filasAfectadas);
            return filasAfectadas > 0;
        } catch (SQLException e) {
            System.out.println("Error SQL al insertar artículo: " + e.getMessage());
            System.out.println("SQL State: " + e.getSQLState());
            System.out.println("Error Code: " + e.getErrorCode());
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            System.out.println("Error general al insertar artículo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean actualizar(articulo a) {
        String sql = "UPDATE articulo SET nombre=?, descripcion=?, categoria=?, precio=? WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, a.getNombre());
            
            // Manejar valores NULL para descripcion
            if (a.getDescripcion() == null) {
                ps.setNull(2, Types.VARCHAR);
            } else {
                ps.setString(2, a.getDescripcion());
            }
            
            // Manejar valores NULL para categoria
            if (a.getCategoria() == null) {
                ps.setNull(3, Types.VARCHAR);
            } else {
                ps.setString(3, a.getCategoria());
            }
            
            ps.setDouble(4, a.getPrecio());
            ps.setInt(5, a.getId());
            
            // Imprimir para depuración
            System.out.println("Actualizando artículo ID: " + a.getId());
            
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error SQL al actualizar artículo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    public boolean eliminar(int id) {
        String sql = "DELETE FROM articulo WHERE id=?";
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setInt(1, id);
            return ps.executeUpdate() > 0;
        } catch (SQLException e) {
            System.out.println("Error SQL al eliminar artículo: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
    
    // Métodos adicionales útiles para artículos
    public List<articulo> buscarPorNombre(String nombre) {
        List<articulo> lista = new ArrayList<>();
        String sql = "SELECT * FROM articulo WHERE nombre LIKE ?";
        
        try (PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, "%" + nombre + "%");
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) {
                articulo a = new articulo(
                    rs.getInt("id"),
                    rs.getString("nombre"),
                    rs.getString("descripcion"),
                    rs.getString("categoria"),
                    rs.getDouble("precio")                   
                );
                lista.add(a);
            }
        } catch (SQLException e) {
            System.out.println("Error al buscar por nombre: " + e.getMessage());
            e.printStackTrace();
        }
        
        return lista;
    }
    
    // Este método solo debe usarse si realmente existe un campo 'stock' en la tabla
    public boolean actualizarStock(int id, int cantidad) {
        // Verificar primero si existe la columna 'stock' en la tabla
        try {
            DatabaseMetaData meta = conn.getMetaData();
            ResultSet rs = meta.getColumns(null, null, "articulos", "stock");
            
            if (!rs.next()) {
                System.out.println("Error: La columna 'stock' no existe en la tabla 'articulos'");
                return false;
            }
            
            String sql = "UPDATE articulo SET stock = stock + ? WHERE id = ?";
            try (PreparedStatement ps = conn.prepareStatement(sql)) {
                ps.setInt(1, cantidad);
                ps.setInt(2, id);
                return ps.executeUpdate() > 0;
            }
        } catch (SQLException e) {
            System.out.println("Error al actualizar stock: " + e.getMessage());
            e.printStackTrace();
            return false;
        }
    }
}