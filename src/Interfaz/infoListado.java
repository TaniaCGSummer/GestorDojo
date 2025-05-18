package Interfaz;

import dao.DeportistaDAO;
import entidades.Deportista;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class infoListado extends javax.swing.JPanel {

    DeportistaDAO dao = new DeportistaDAO();

    public infoListado() {
        initComponents();
        mostrarLista();
    }

    private void mostrarLista() {
        DefaultTableModel modelo = (DefaultTableModel) tablaListado.getModel();
        modelo.setRowCount(0);
         List<Deportista> lista = dao.obtenerTodos();
        Deportista deportista = new Deportista();
  
      for (Deportista d : lista) {
        modelo.addRow(new Object[]{
            d.getId(),
            d.getNombre(),
            d.getApellido(),
            d.getEstado() // Asegúrate que tu clase Deportista tenga este método
        });
    }
}

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        titulo = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tablaListado = new javax.swing.JTable();
        btnEliminar = new javax.swing.JButton();

        setPreferredSize(new java.awt.Dimension(520, 486));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("nb.startpage.bottombar.background"));
        jPanel1.setPreferredSize(new java.awt.Dimension(520, 100));
        jPanel1.setVerifyInputWhenFocusTarget(false);

        titulo.setText("Lista de Deportistas");

        tablaListado.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "ID", "Nombre", "Apellido", "Estado"
            }
        ));
        jScrollPane1.setViewportView(tablaListado);

        btnEliminar.setText("Eliminar");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(titulo)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 479, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(23, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(titulo)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEliminar)
                .addContainerGap(36, Short.MAX_VALUE))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 520, 490));
    }// </editor-fold>//GEN-END:initComponents

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
      int filaSeleccionada = tablaListado.getSelectedRow();
    
    // Verificar si hay una fila seleccionada
    if (filaSeleccionada == -1) {
        JOptionPane.showMessageDialog(this, 
            "Por favor seleccione un deportista para eliminar", 
            "Advertencia", 
            JOptionPane.WARNING_MESSAGE);
        return;
    }
    
    // Obtener el ID del deportista seleccionado
    DefaultTableModel modelo = (DefaultTableModel) tablaListado.getModel();
    int idDeportista = (int) modelo.getValueAt(filaSeleccionada, 0); // Columna 0 es el ID
    
    // Confirmar eliminación
    int confirmacion = JOptionPane.showConfirmDialog(
        this, 
        "¿Está seguro que desea eliminar este deportista?", 
        "Confirmar eliminación", 
        JOptionPane.YES_NO_OPTION);
    
    if (confirmacion == JOptionPane.YES_OPTION) {
        // Eliminar el deportista usando el DAO
        boolean eliminado = dao.eliminar(idDeportista);
        
        if (eliminado) {
            JOptionPane.showMessageDialog(this, 
                "Deportista eliminado correctamente", 
                "Éxito", 
                JOptionPane.INFORMATION_MESSAGE);
            mostrarLista(); // Actualizar la tabla
        } else {
            JOptionPane.showMessageDialog(this, 
                "Error al eliminar el deportista", 
                "Error", 
                JOptionPane.ERROR_MESSAGE);
        }
    }
    }//GEN-LAST:event_btnEliminarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tablaListado;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
