/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.Swing;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author felip
 */
public class P9 extends javax.swing.JPanel {
    
    private boolean baila = false;
    
    public P9() {
        initComponents();
        texto.setBackground(new Color(0, 0, 0, 1));
        fondo.setSize(1024, 768);
        lucas.setSize(200, 320);
        Main.pintarImagen(fondo, "src/main/java/Vista/Imagenes/pozo.png");
        Main.pintarImagen(lucas, "src/main/java/Vista/Imagenes/lucas.png");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titulo = new javax.swing.JLabel();
        texto = new javax.swing.JTextArea();
        lucas = new javax.swing.JLabel();
        bailarBtn = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Informal Roman", 0, 70)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 255, 0));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Has seleccionado:");
        add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 720, 96));

        texto.setEditable(false);
        texto.setColumns(20);
        texto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 255, 255));
        texto.setRows(5);
        texto.setText("Lucas está muy feliz con su nueva \nadquisición. Gracias por ayudar a Lucas.\nLucas baila con mucha emocion.\n¡Has que Lucas baile!");
        texto.setBorder(null);
        add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(550, 300, 350, 150));
        add(lucas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 200, 320));

        bailarBtn.setText("Bailar");
        bailarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bailarBtnActionPerformed(evt);
            }
        });
        add(bailarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 560, 140, 60));
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 768));
    }// </editor-fold>//GEN-END:initComponents

    private void bailarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bailarBtnActionPerformed
        if (!baila) {
            bailar();
        } else {
            Main.pintarImagen(lucas, "src/main/java/Vista/Imagenes/lucas.png");
        }
        baila = !baila;
    }//GEN-LAST:event_bailarBtnActionPerformed

    public void bailar() {
        Main.pintarImagen(lucas, "src/main/java/Vista/Imagenes/lucas.gif");
    }

    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bailarBtn;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lucas;
    private javax.swing.JTextArea texto;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}
