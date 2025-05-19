package Interfaz;

import Interfaz.AgregarArticulo;
import java.awt.BorderLayout;

public class ventas extends javax.swing.JPanel {

    public ventas() {
        initComponents();
        AgregarArticulo b = new AgregarArticulo();
        b.setSize(580, 550);
        b.setLocation(0, 0);
        VentasPanel.removeAll();
        VentasPanel.add(b, BorderLayout.CENTER);
        VentasPanel.revalidate();
        VentasPanel.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        VentasPanel = new javax.swing.JPanel();
        btnAgregarImplemento = new javax.swing.JButton();
        btnInventario = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(580, 550));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("Button.focusedBorderColor"));

        VentasPanel.setPreferredSize(new java.awt.Dimension(550, 470));

        javax.swing.GroupLayout VentasPanelLayout = new javax.swing.GroupLayout(VentasPanel);
        VentasPanel.setLayout(VentasPanelLayout);
        VentasPanelLayout.setHorizontalGroup(
            VentasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 534, Short.MAX_VALUE)
        );
        VentasPanelLayout.setVerticalGroup(
            VentasPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        btnAgregarImplemento.setText("Agregar implemento ");
        btnAgregarImplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgregarImplementoActionPerformed(evt);
            }
        });

        btnInventario.setText("Lista de implementos");
        btnInventario.setActionCommand("Inventario");
        btnInventario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInventarioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(VentasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 534, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnAgregarImplemento, javax.swing.GroupLayout.PREFERRED_SIZE, 256, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(32, 32, 32)
                        .addComponent(btnInventario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(28, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(VentasPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnAgregarImplemento)
                    .addComponent(btnInventario))
                .addGap(25, 25, 25))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 580, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgregarImplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgregarImplementoActionPerformed
    AgregarArticulo b = new AgregarArticulo();
        b.setSize(580, 550);
        b.setLocation(0, 0);
        VentasPanel.removeAll();
        VentasPanel.add(b, BorderLayout.CENTER);
        VentasPanel.revalidate();
        VentasPanel.repaint();
    }//GEN-LAST:event_btnAgregarImplementoActionPerformed

    private void btnInventarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInventarioActionPerformed
       
    }//GEN-LAST:event_btnInventarioActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel VentasPanel;
    private javax.swing.JButton btnAgregarImplemento;
    private javax.swing.JButton btnInventario;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
