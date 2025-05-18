
package Interfaz;


import java.awt.BorderLayout;

public class Informacion extends javax.swing.JPanel {
 
    public Informacion() {
       initComponents();
       infoListado b1 = new infoListado();
       b1.setSize(500, 580);
       b1.setLocation(0, 0);
       infoVisual.removeAll();
       infoVisual.add(b1,BorderLayout.CENTER);
       infoVisual.revalidate();
       infoVisual.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        btnListado = new javax.swing.JButton();
        btnIngresar = new javax.swing.JButton();
        infoVisual = new javax.swing.JPanel();

        setBackground(new java.awt.Color(255, 255, 255));
        setPreferredSize(new java.awt.Dimension(580, 574));
        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel1.setBackground(javax.swing.UIManager.getDefaults().getColor("DesktopIcon.background"));
        jPanel1.setPreferredSize(new java.awt.Dimension(550, 570));

        btnListado.setText("Listado");
        btnListado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnListadoActionPerformed(evt);
            }
        });

        btnIngresar.setText("Ingresar información");
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        infoVisual.setBackground(new java.awt.Color(255, 255, 255));
        infoVisual.setPreferredSize(new java.awt.Dimension(505, 486));

        javax.swing.GroupLayout infoVisualLayout = new javax.swing.GroupLayout(infoVisual);
        infoVisual.setLayout(infoVisualLayout);
        infoVisualLayout.setHorizontalGroup(
            infoVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 505, Short.MAX_VALUE)
        );
        infoVisualLayout.setVerticalGroup(
            infoVisualLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 470, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(infoVisual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnListado, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnIngresar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(infoVisual, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnListado)
                    .addComponent(btnIngresar))
                .addGap(24, 24, 24))
        );

        add(jPanel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 570, 550));
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
   
       infoIngresar b22 = new infoIngresar();
       b22.setSize(500, 585);
       b22.setLocation(0, 0);
       infoVisual.removeAll();
       infoVisual.add(b22,BorderLayout.CENTER);
       infoVisual.revalidate();
       infoVisual.repaint();
    }//GEN-LAST:event_btnIngresarActionPerformed

    private void btnListadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnListadoActionPerformed
       infoListado b3 = new infoListado();
       b3.setSize(550, 575);
       b3.setLocation(0, 0);
       infoVisual.removeAll();
       infoVisual.add(b3,BorderLayout.CENTER);
       infoVisual.revalidate();
       infoVisual.repaint();
    }//GEN-LAST:event_btnListadoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnListado;
    private javax.swing.JPanel infoVisual;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
