/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.Swing;

import java.awt.Color;

/**
 *
 * @author felip
 */
public class P4 extends javax.swing.JPanel {

    /**
     * Creates new form P4
     */
    public P4() {
        initComponents();
        texto.setBackground(new Color(0, 0, 0, 1));
        fondo.setSize(1024, 768);
        lucas.setSize(180, 300);
        serpentina.setSize(230, 250);
        Main.pintarImagen(fondo, "src/main/java/Vista/Imagenes/pozo.png");
        Main.pintarImagen(lucas, "src/main/java/Vista/Imagenes/lucas.png");
        Main.pintarImagen(serpentina, "src/main/java/Vista/Imagenes/serpentina.png");
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
        serpentina = new javax.swing.JLabel();
        continuarBtn = new javax.swing.JButton();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Informal Roman", 0, 70)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 255, 0));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Importante misión");
        add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 720, 96));

        texto.setEditable(false);
        texto.setColumns(20);
        texto.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        texto.setForeground(new java.awt.Color(255, 255, 255));
        texto.setRows(5);
        texto.setText("Luego de que volviera el alma de Lucas, \nSerpentina cuenta la razón de su llegada.\nNecesita ayuda.\nLucas y jugador deben subir a la cima de \nun arbol para ayudar a localizar su comida.\n¡Serpentina tiene mucha hambre, ayudala!");
        texto.setBorder(null);
        add(texto, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 250, 350, 150));
        add(lucas, new org.netbeans.lib.awtextra.AbsoluteConstraints(90, 200, 180, 300));
        add(serpentina, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 230, 230, 250));

        continuarBtn.setText("Continuar");
        continuarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarBtnActionPerformed(evt);
            }
        });
        add(continuarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 600, 250, 60));
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 768));
    }// </editor-fold>//GEN-END:initComponents

    private void continuarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarBtnActionPerformed
        P5 p5 = new P5();
        Main.mostrarPanel(p5);
    }//GEN-LAST:event_continuarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuarBtn;
    private javax.swing.JLabel fondo;
    private javax.swing.JLabel lucas;
    private javax.swing.JLabel serpentina;
    private javax.swing.JTextArea texto;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}