
package Interfaz;
//Fecha
import dao.DeportistaDAO;
import entidades.Deportista;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import javax.swing.table.DefaultTableModel;
import dao.AsistenciaDAO;
import entidades.Deportista;
import java.awt.BorderLayout;
import java.sql.Date;
import java.time.LocalDate;


public class Asistencia extends javax.swing.JPanel {
    
    public Asistencia() {
        initComponents();
        mostrarFechaActualEnEspanol(); // Llama al método al crear el panel
        cargarDeportistas();
        btnAsistencia.addActionListener(e -> guardarAsistencia());
    }

    private void mostrarFechaActualEnEspanol() {
        // Configuración para español (puedes usar "es_MX", "es_AR", etc.)
        Locale español = new Locale("es", "ES");        
        // Obtener fecha actual
        LocalDate fechaActual = LocalDate.now();        
        // Formatear fecha: "día de mes de año" 
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("d 'de' MMMM 'de' yyyy", español);
        String fechaFormateada = fechaActual.format(formato);
        labelFecha.setText(fechaFormateada);
    }
    
    private void cargarDeportistas() {
    DefaultTableModel modelo = (DefaultTableModel) jTable1.getModel();
    modelo.setRowCount(0); // limpiar tabla

    DeportistaDAO dao = new DeportistaDAO();
    List<Deportista> lista = dao.obtenerTodos(); // Este método debes tenerlo o crearlo

    for (Deportista d : lista) {
        modelo.addRow(new Object[]{false, d.getNombre(), d.getId()});
    }
}
    
   private void guardarAsistencia() {
    AsistenciaDAO asistenciaDAO = new AsistenciaDAO();
    LocalDate fechaHoy = LocalDate.now();
    Date fechaSQL = Date.valueOf(fechaHoy);

    for (int i = 0; i < jTable1.getRowCount(); i++) {
        Boolean presente = (Boolean) jTable1.getValueAt(i, 0);
        if (presente != null && presente) {
            Integer deportistaId = (Integer) jTable1.getValueAt(i, 2);
            // Esta llamada debe usar el método modificado anteriormente
            asistenciaDAO.insertarAsistencia(deportistaId, fechaSQL, true, "");
        }
    }
    
    javax.swing.JOptionPane.showMessageDialog(this, "Asistencia registrada correctamente.");
}




    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        panelAsistencia = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        labelFecha = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        btnAsistencia = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setMinimumSize(new java.awt.Dimension(580, 500));
        setPreferredSize(new java.awt.Dimension(580, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        panelAsistencia.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.default.focusColor"));
        panelAsistencia.setPreferredSize(new java.awt.Dimension(580, 500));

        jLabel1.setText("Asistencia ");

        labelFecha.setText("actual");

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Presente", "Nombre", "ID"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Boolean.class, java.lang.Object.class, java.lang.Object.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(jTable1);

        btnAsistencia.setText("Tomar asistencia");
        btnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAsistenciaActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar ");
        btnBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBuscarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout panelAsistenciaLayout = new javax.swing.GroupLayout(panelAsistencia);
        panelAsistencia.setLayout(panelAsistenciaLayout);
        panelAsistenciaLayout.setHorizontalGroup(
            panelAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsistenciaLayout.createSequentialGroup()
                .addGap(44, 44, 44)
                .addGroup(panelAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(panelAsistenciaLayout.createSequentialGroup()
                        .addComponent(btnAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(panelAsistenciaLayout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(labelFecha, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 497, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(39, Short.MAX_VALUE))
        );
        panelAsistenciaLayout.setVerticalGroup(
            panelAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(panelAsistenciaLayout.createSequentialGroup()
                .addGap(38, 38, 38)
                .addGroup(panelAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(labelFecha))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
                .addGap(4, 4, 4)
                .addGroup(panelAsistenciaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnBuscar)
                    .addComponent(btnAsistencia))
                .addGap(25, 25, 25))
        );

        add(panelAsistencia, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 510));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAsistenciaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnAsistenciaActionPerformed

    private void btnBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBuscarActionPerformed
       AsistenciaListado p1 = new AsistenciaListado ();
       p1.setSize(580, 550);
       p1.setLocation(0, 0);
       panelAsistencia.removeAll();
       panelAsistencia.add(p1,BorderLayout.CENTER);
       panelAsistencia.revalidate();
       panelAsistencia.repaint(); // TODO add your handling code here:
    }//GEN-LAST:event_btnBuscarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAsistencia;
    private javax.swing.JButton btnBuscar;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable jTable1;
    private javax.swing.JLabel labelFecha;
    private javax.swing.JPanel panelAsistencia;
    // End of variables declaration//GEN-END:variables
}
