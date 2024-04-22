/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/GUIForms/JPanel.java to edit this template
 */
package Vista.Swing;

import Control.Datos;
import java.util.List;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author felip
 */
public class P7 extends javax.swing.JPanel {

    private DefaultTableModel model;
    private String [] filaSeleccionada = null;
    
    public P7() {
        initComponents();
        fondo.setSize(1024, 768);
        lucas.setSize(200, 320);
        Main.pintarImagen(fondo, "src/main/java/Vista/Imagenes/carros.png");
        Main.pintarImagen(lucas, "src/main/java/Vista/Imagenes/lucas.png");
        
        Datos archivo = new Datos("src/main/java/Modelo/fasecolda.xls");
        List<String[]> listaVehiculos = archivo.obtenerDatos();
        
        model = new DefaultTableModel();

        model.addColumn("Marca");
        model.addColumn("Referencia");
        model.addColumn("Precio");
        
        for (String[] fila : listaVehiculos) {
            model.addRow(fila);
        }
        
        tabla.setModel(model);
        tabla.setDefaultEditor(Object.class, null);
        tabla.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        
        tabla.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (!e.getValueIsAdjusting()) {
                    int selectedRow = tabla.getSelectedRow();
                    if (selectedRow != -1) {
                        // Guardar los datos de la fila seleccionada en un arreglo
                        filaSeleccionada = new String[]{
                                (String) model.getValueAt(selectedRow, 0),
                                (String) model.getValueAt(selectedRow, 1),
                                (String) model.getValueAt(selectedRow, 2)
                        };
                    }
                }
            }
        });
        
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
        lucas = new javax.swing.JLabel();
        continuarBtn = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        fondo = new javax.swing.JLabel();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        titulo.setFont(new java.awt.Font("Informal Roman", 0, 70)); // NOI18N
        titulo.setForeground(new java.awt.Color(0, 255, 0));
        titulo.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        titulo.setText("Seleccion de vehiculo");
        add(titulo, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 50, 720, 96));
        add(lucas, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 220, 200, 320));

        continuarBtn.setText("Continuar");
        continuarBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                continuarBtnActionPerformed(evt);
            }
        });
        add(continuarBtn, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 600, 250, 60));

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Marca", "Referencia", "Precio"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.Double.class
            };
            boolean[] canEdit = new boolean [] {
                false, false, false
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tabla.setColumnSelectionAllowed(true);
        tabla.setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        tabla.getTableHeader().setReorderingAllowed(false);
        jScrollPane1.setViewportView(tabla);
        tabla.getColumnModel().getSelectionModel().setSelectionMode(javax.swing.ListSelectionModel.SINGLE_INTERVAL_SELECTION);
        if (tabla.getColumnModel().getColumnCount() > 0) {
            tabla.getColumnModel().getColumn(0).setResizable(false);
            tabla.getColumnModel().getColumn(0).setHeaderValue("Marca");
            tabla.getColumnModel().getColumn(1).setResizable(false);
            tabla.getColumnModel().getColumn(1).setHeaderValue("Referencia");
            tabla.getColumnModel().getColumn(2).setResizable(false);
            tabla.getColumnModel().getColumn(2).setHeaderValue("Precio");
        }

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 207, -1, 370));
        add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1024, 768));
    }// </editor-fold>//GEN-END:initComponents

    private void continuarBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_continuarBtnActionPerformed
        if (filaSeleccionada != null) {
            P8 p8 = new P8(filaSeleccionada);
            Main.mostrarPanel(p8);
        }
    }//GEN-LAST:event_continuarBtnActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton continuarBtn;
    private javax.swing.JLabel fondo;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lucas;
    private javax.swing.JTable tabla;
    private javax.swing.JLabel titulo;
    // End of variables declaration//GEN-END:variables
}