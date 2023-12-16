package Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbConnectionTest {


    protected static final String URL = "jdbc:mysql://localhost:3306/dblibrary-";
    protected static final String USUARIO = "root";
    protected static final String CONTRASENA = "12345";

    public static Connection conexion = null;

    public static void openConnection(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conexion = DriverManager.getConnection(URL, USUARIO, CONTRASENA);
            System.err.println("La conexion fue exitosa.");
        } catch (ClassNotFoundException e) {
            System.err.println("Error al cargar el controlador JDBC de SQL Server: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("Error al conectar con la base de datos: " + e.getMessage());
        }
    }

    public static void closeConnection() {
        if (conexion != null) {
            try {
                conexion.close();
            } catch (SQLException e) {
                System.err.println("Error al cerrar la conexión: " + e.getMessage());
            }
        }
    }



}

