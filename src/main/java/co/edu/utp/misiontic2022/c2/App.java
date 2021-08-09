package co.edu.utp.misiontic2022.c2;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.model.dao.ProyectosConsultaDao;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectosConsultaVo;
import co.edu.utp.misiontic2022.c2.util.JDBCUtilities;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            var dao = new ProyectosConsultaDao();
            var lista = dao.listarProyectosPorClasificaciones("Casa Campestre", "Condominio");
            for (ProyectosConsultaVo consulta : lista) {
                System.out.println(consulta);
            }
            System.out.println("Conexion realizada exitosamente");
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
