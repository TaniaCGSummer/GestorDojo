
package Interfaz;

import dao.AsistenciaDAO;
import java.sql.Date;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class AsistenciaListado extends javax.swing.JPanel {
    
    private final AsistenciaDAO asistenciaDAO;
    
    public AsistenciaListado() {
        initComponents();
        this.asistenciaDAO = new AsistenciaDAO();
        configurarTablas();
        cargarTablaClases();
        btnDetalles.addActionListener(e -> cargarTablaAsistentes());
    }

    private void configurarTablas() {
        // Configurar tabla de clases
        DefaultTableModel modelClases = new DefaultTableModel(
            new Object[]{"Fecha", "Nombre de clase", "Cantidad de Asistentes", "Horario"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
            @Override
            public Class<?> getColumnClass(int column) {
                switch (column) {
                    case 0: return Date.class;
                    case 2: return Integer.class;
                    default: return String.class;
                }
            }
        };
        tablaClases.setModel(modelClases);
        
        // Configurar tabla de asistentes
        DefaultTableModel modelAsistentes = new DefaultTableModel(
            new Object[]{"Nombre", "Apellido"}, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        tablaAsistenciaAClases.setModel(modelAsistentes);
    }
    
    private void cargarTablaClases() {
        DefaultTableModel model = (DefaultTableModel) tablaClases.getModel();
        model.setRowCount(0); // Limpiar tabla
        
        List<Object[]> clases = asistenciaDAO.obtenerClasesConAsistencia();
        
        for (Object[] clase : clases) {
            model.addRow(clase);
        }
        
        if (model.getRowCount() > 0) {
            tablaClases.setRowSelectionInterval(0, 0);
        }
    }
    
    private void cargarTablaAsistentes() {
        int filaSeleccionada = tablaClases.getSelectedRow();
        if (filaSeleccionada == -1) {
            JOptionPane.showMessageDialog(this, 
                "Seleccione una clase primero", 
                "Advertencia", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        DefaultTableModel model = (DefaultTableModel) tablaAsistenciaAClases.getModel();
        model.setRowCount(0); // Limpiar tabla
        
        Date fecha = (Date) tablaClases.getValueAt(filaSeleccionada, 0);
        String nombreClase = (String) tablaClases.getValueAt(filaSeleccionada, 1);
        
        List<Object[]> asistentes = asistenciaDAO.obtenerAsistentesPorClase(nombreClase, fecha);
        
        for (Object[] asistente : asistentes) {
            model.addRow(asistente);
        }
    }
   
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaClases = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        tablaAsistenciaAClases = new javax.swing.JTable();
        btnDetalles = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(550, 470));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        tablaClases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Fecha", "Nombre de clase", "Cantidad de Asistentes", "Horario"
            }
        ));
        jScrollPane1.setViewportView(tablaClases);

        tablaAsistenciaAClases.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null},
                {null, null},
                {null, null},
                {null, null}
            },
            new String [] {
                "Nombre", "Apellido"
            }
        ));
        jScrollPane2.setViewportView(tablaAsistenciaAClases);

        btnDetalles.setText("Ver detalles");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 506, Short.MAX_VALUE)
                        .addComponent(jScrollPane2))
                    .addComponent(btnDetalles, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
                .addComponent(btnDetalles)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(19, 19, 19))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 550, 470));
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDetalles;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tablaAsistenciaAClases;
    private javax.swing.JTable tablaClases;
    // End of variables declaration//GEN-END:variables
}
