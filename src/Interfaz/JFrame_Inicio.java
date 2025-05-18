
package Interfaz;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JPanel;


public class JFrame_Inicio extends javax.swing.JFrame {

    // Configuración básica de la ventana
    public JFrame_Inicio() {
        
        setTitle("Gestión de Deportistas"); // titulo
        setSize(800, 600);// Tamaño
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Finaliza la ejecucion con del porgrama con cerrar la ventana
        setLocationRelativeTo(null); // Centra la ventana
       // iniciarComponentes();
       initComponents();
       
       Asistencia p5 = new Asistencia();
       p5.setSize(580, 550);
       p5.setLocation(0, 0);
       Contenido.removeAll();
       Contenido.add(p5,BorderLayout.CENTER);
       Contenido.revalidate();
       Contenido.repaint();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BtnAsistencia = new javax.swing.JButton();
        BtnDeportistas = new javax.swing.JButton();
        BtnVentas = new javax.swing.JButton();
        Contenido = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(800, 600));

        jPanel1.setBackground(java.awt.SystemColor.activeCaption);

        BtnAsistencia.setText("Asistencia");
        BtnAsistencia.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnAsistenciaActionPerformed(evt);
            }
        });

        BtnDeportistas.setText("Informacion de deportistas ");
        BtnDeportistas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnDeportistasActionPerformed(evt);
            }
        });

        BtnVentas.setText("Ventas");
        BtnVentas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BtnVentasActionPerformed(evt);
            }
        });

        Contenido.setBackground(new java.awt.Color(255, 255, 255));
        Contenido.setPreferredSize(new java.awt.Dimension(550, 574));

        javax.swing.GroupLayout ContenidoLayout = new javax.swing.GroupLayout(Contenido);
        Contenido.setLayout(ContenidoLayout);
        ContenidoLayout.setHorizontalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 571, Short.MAX_VALUE)
        );
        ContenidoLayout.setVerticalGroup(
            ContenidoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 574, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(BtnVentas, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnAsistencia, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(BtnDeportistas, javax.swing.GroupLayout.DEFAULT_SIZE, 192, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Contenido, javax.swing.GroupLayout.DEFAULT_SIZE, 571, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(121, 121, 121)
                .addComponent(BtnAsistencia, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnDeportistas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(BtnVentas, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(Contenido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(14, 14, 14))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void BtnAsistenciaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnAsistenciaActionPerformed
        Asistencia p1 = new Asistencia();
       p1.setSize(580, 550);
       p1.setLocation(0, 0);
       Contenido.removeAll();
       Contenido.add(p1,BorderLayout.CENTER);
       Contenido.revalidate();
       Contenido.repaint();
    }//GEN-LAST:event_BtnAsistenciaActionPerformed

    private void BtnDeportistasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnDeportistasActionPerformed
       Informacion p2 = new Informacion();
       p2.setSize(580, 550);
       p2.setLocation(0, 0);
       Contenido.removeAll();
       Contenido.add(p2,BorderLayout.CENTER);
       Contenido.revalidate();
       Contenido.repaint();
    }//GEN-LAST:event_BtnDeportistasActionPerformed

    private void BtnVentasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BtnVentasActionPerformed
       ventas p3 = new ventas ();
       p3.setSize(580, 550);
       p3.setLocation(0, 0);
       Contenido.removeAll();
       Contenido.add(p3,BorderLayout.CENTER);
       Contenido.revalidate();
       Contenido.repaint(); 
    }//GEN-LAST:event_BtnVentasActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
       
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new JFrame_Inicio().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BtnAsistencia;
    private javax.swing.JButton BtnDeportistas;
    private javax.swing.JButton BtnVentas;
    private javax.swing.JPanel Contenido;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
