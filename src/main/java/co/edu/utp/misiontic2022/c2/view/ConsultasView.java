package co.edu.utp.misiontic2022.c2.view;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectosConsultaVo;

public class ConsultasView {
    private ConsultasController consultasController;

    public ConsultasView() {
        consultasController = new ConsultasController();
    }

    private String repitaCaracter(Character caracter, Integer veces) {
        var respuesta = "";
        for (int i = 0; i < veces; i++) {
            respuesta += caracter;
        }
        return respuesta;
    }

    public void imprimirProyectosCasasCampestreYCondominios() {
        try {
            System.out.println(
                    repitaCaracter('=', 12) + " LISTADO DE PROYECTOS POR CLASIFICACIONES " + repitaCaracter('=', 13));
            System.out.println(String.format("%-20s %-15s %-5s %-10s %-10s", "CIUDAD", "CLASIFICACION", "TOTAL",
                    "VIEJO", "RECIENTE"));
            System.out.println(repitaCaracter('-', 67));
            var lista = consultasController.listadoProyectosDeClasificaciones("Casa Campestre", "Condominio");
            for (ProyectosConsultaVo proyecto : lista) {
                System.out.printf("%-20s %-15s %5d %10s %10s %n", proyecto.getCiudad(), proyecto.getClasificacion(),
                        proyecto.getTotal(), proyecto.getViejo(), proyecto.getReciente());
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
            e.printStackTrace();
        }
    }

}
