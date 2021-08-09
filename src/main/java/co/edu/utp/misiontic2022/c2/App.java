package co.edu.utp.misiontic2022.c2;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.util.JDBCUtilities;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            var conn = JDBCUtilities.getConnection();
            System.out.println("Conexion realizada exitosamente");
            conn.close();
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
