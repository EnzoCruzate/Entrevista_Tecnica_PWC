package Service;

import java.sql.DriverManager;
import java.sql.*;

public class dbConnection {
    private static final String URL = "jdbc:mysql://localhost:3306/dblibrary$";
    private static final String user= "root";
    private static final String  password = "12345";


    public static Connection getdbConnection() throws SQLException {
        return DriverManager.getConnection(URL, user, password);
    }


    public static void closedb(Connection connection) throws SQLException{
        connection.close();
    }

    public static void closedb(Statement sentence) throws SQLException{
        sentence.close();
    }

    public static void closedb(PreparedStatement sentence) throws SQLException{
        sentence.close();
    }

    public static void closedb(ResultSet result) throws SQLException{
        result.close();
    }

}
