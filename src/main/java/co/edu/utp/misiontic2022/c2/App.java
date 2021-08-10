package co.edu.utp.misiontic2022.c2;

import java.sql.SQLException;

import co.edu.utp.misiontic2022.c2.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectosConsultaVo;
import co.edu.utp.misiontic2022.c2.view.ConsultasView;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        var view = new ConsultasView();
        view.imprimirProyectosCasasCampestreYCondominios();
    }
}
