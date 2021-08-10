package co.edu.utp.misiontic2022.c2.controller;

import java.sql.SQLException;
import java.util.List;

import co.edu.utp.misiontic2022.c2.model.dao.ProyectosConsultaDao;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectosConsultaVo;

public class ConsultasController {

    private ProyectosConsultaDao proyectosConsultaDao;

    public ConsultasController() {
        proyectosConsultaDao = new ProyectosConsultaDao();
    }

    public List<ProyectosConsultaVo> listadoProyectosDeClasificaciones(String opcion1, String opcion2)
            throws SQLException {
        return proyectosConsultaDao.listarProyectosPorClasificaciones(opcion1, opcion2);
    }

}
