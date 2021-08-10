package co.edu.utp.misiontic2022.c2.view;

import java.awt.BorderLayout;
import java.sql.SQLException;
import java.util.List;

import javax.print.DocFlavor.STRING;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.AbstractTableModel;

import co.edu.utp.misiontic2022.c2.controller.ConsultasController;
import co.edu.utp.misiontic2022.c2.model.vo.ProyectosConsultaVo;

public class FrmConsulta extends JFrame {

    private ConsultasController controller;
    private JTable tabla;

    public FrmConsulta() {
        controller = new ConsultasController();

        initUI();
        setLocationRelativeTo(null);
    }

    private void initUI() {
        setTitle("Reto 5");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(800, 600);

        var tbd = new JTabbedPane();
        getContentPane().add(tbd, BorderLayout.CENTER);

        var panel = new JPanel();
        panel.setLayout(new BorderLayout());
        tbd.addTab("Consulta Proyectos por Clasificaciones", panel);

        var panelEntrada = new JPanel();
        panelEntrada.add(new JLabel("Clasificacion 1"));
        var txtClasificacion1 = new JTextField(15);
        panelEntrada.add(txtClasificacion1);
        panelEntrada.add(new JLabel("Clasificacion 2"));
        var txtClasificacion2 = new JTextField(15);
        panelEntrada.add(txtClasificacion2);
        var btnConsulta = new JButton("Consultar");
        btnConsulta.addActionListener(e -> consultarProyectosPorClasificacion(txtClasificacion1.getText().trim(),
                txtClasificacion2.getText().trim()));
        panelEntrada.add(btnConsulta);
        panel.add(panelEntrada, BorderLayout.PAGE_START);

        tabla = new JTable();
        panel.add(new JScrollPane(tabla), BorderLayout.CENTER);
    }

    private void consultarProyectosPorClasificacion(String opcion1, String opcion2) {
        try {
            var lista = controller.listadoProyectosDeClasificaciones(opcion1, opcion2);
            var tableModel = new ProyectosTableModel();
            tableModel.setData(lista);

            tabla.setModel(tableModel);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(this, ex.getMessage(), getTitle(), JOptionPane.ERROR_MESSAGE);
        }
    }

    private class ProyectosTableModel extends AbstractTableModel {
        private List<ProyectosConsultaVo> data;

        public void setData(List<ProyectosConsultaVo> data) {
            this.data = data;
        }

        @Override
        public Class<?> getColumnClass(int columnIndex) {
            switch (columnIndex) {
                case 0:
                case 1:
                case 3:
                case 4:
                    return String.class;
                case 2:
                    return Integer.class;
            }
            return super.getColumnClass(columnIndex);
        }

        @Override
        public String getColumnName(int column) {
            switch (column) {
                case 0:
                    return "Ciudad";
                case 1:
                    return "Clasificación";
                case 2:
                    return "Total";
                case 3:
                    return "Viejo";
                case 4:
                    return "Reciente";
            }
            return super.getColumnName(column);
        }

        @Override
        public int getRowCount() {
            return data.size();
        }

        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public Object getValueAt(int rowIndex, int columnIndex) {
            var project = data.get(rowIndex);
            switch (columnIndex) {
                case 0:
                    return project.getCiudad();
                case 1:
                    return project.getClasificacion();
                case 2:
                    return project.getTotal();
                case 3:
                    return project.getViejo();
                case 4:
                    return project.getReciente();
            }
            return null;
        }

    }
}
