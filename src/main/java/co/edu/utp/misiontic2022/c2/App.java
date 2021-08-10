package co.edu.utp.misiontic2022.c2;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectosConsultaVo;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        try {
            var controller = new ConsultasController();
            var lista = controller.listadoProyectosDeClasificaciones("Casa Campestre", "Condominio");
            for (ProyectosConsultaVo consulta : lista) {
                System.out.println(consulta);
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e);
            e.printStackTrace();
        }
    }
}
