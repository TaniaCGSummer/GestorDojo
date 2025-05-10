
package prueba;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class PruebaConexion {
    public static void main(String[] args) {
   
        // Datos de conexión
        String url = "jdbc:mysql://localhost:3306/dojo";
        String usuario = "root";
        String contraseña = ""; 

        try {
            Connection conexion = DriverManager.getConnection(url, usuario, contraseña);
            System.out.println(" Conexión exitosa a la base de datos.");
            conexion.close();
        } catch (SQLException e) {
            System.out.println(" Error al conectar a la base de datos.");
            e.printStackTrace();
        }
    }
    
   


}

