/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package View.Swing;

import java.awt.Color;

/**
 *
 * @author felip
 */
public class P2 extends javax.swing.JPanel {

    
    public P2() {
        initComponents();
        Main.paintImage(backgroundImg, new int[]{1024, 768}, "src/main/java/View/Images/pozo.png");
        this.repaint();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        titleTxt = new javax.swing.JLabel();
        continueBtn = new javax.swing.JButton();
        txt1 = new javax.swing.JTextArea();
        txt2 = new javax.swing.JTextArea();
        backgroundImg = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titleTxt.setFont(new java.awt.Font("Informal Roman", 0, 70)); // NOI18N
        titleTxt.setForeground(new java.awt.Color(0, 255, 0));
        titleTxt.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titleTxt.setText("Un viaje tranquilo... ¿o no?");
        add(titleTxt, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 720, 96));

        continueBtn.setText("Continuar");
        continueBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continueBtnActionPerformed(evt);
            }
        });
        add(continueBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 600, 250, 60));

        txt1.setEditable(false);
        txt1.setBackground(new Color(0, 0, 0, 1));
        txt1.setColumns(20);
        txt1.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt1.setForeground(new java.awt.Color(255, 255, 255));
        txt1.setRows(5);
        txt1.setText("Lucas, el gato, era conocido \nen todo el Bosque del Pozo \npor su curiosidad infinita y su \ntendencia a meterse en \nproblemas. Vivía en una \npequeña cabaña en lo más \nprofundo del bosque, \nrodeado de árboles altísimos \ny criaturas misteriosas.");
        txt1.setBorder(null);
        add(txt1, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 250, -1, 220));

        txt2.setEditable(false);
        txt2.setBackground(new Color(0, 0, 0, 1));
        txt2.setColumns(20);
        txt2.setFont(new java.awt.Font("Arial", 0, 18)); // NOI18N
        txt2.setForeground(new java.awt.Color(255, 255, 255));
        txt2.setRows(5);
        txt2.setText("Contento por tu compañia, \nLucas emprende el viaje a \n‘Concesionario El Minino’ \npara comprar su tan \nanhelado carro.\n¿Sera este un viaje tranquilo?");
        txt2.setBorder(null);
        add(txt2, new org.netbeans.lib.awtextra.AbsoluteConstraints(630, 250, -1, 170));
        add(backgroundImg, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 768));
    }// </editor-fold>//GEN-END:initComponents

    private void continueBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continueBtnActionPerformed
        P3 p3 = new P3();
        Main.showPanel(p3);
    }//GEN-LAST:event_continueBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel backgroundImg;
    private javax.swing.JButton continueBtn;
    private javax.swing.JLabel titleTxt;
    private javax.swing.JTextArea txt1;
    private javax.swing.JTextArea txt2;
    // End of variables declaration//GEN-END:variables
}
