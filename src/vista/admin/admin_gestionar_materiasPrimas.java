/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Materiasprimas;
import modelo.Proveedores;
import persistencia.MateriasprimasJpaController;
import persistencia.ProveedoresJpaController;

/**
 *
 * @author Kings
 */
public class admin_gestionar_materiasPrimas extends javax.swing.JFrame {
    
    MateriasprimasJpaController cMateriasprimas = new MateriasprimasJpaController();
    ProveedoresJpaController cProveedores = new ProveedoresJpaController();
    Materiasprimas cEdit;
    
    /**
     * Creates new form admin_gestionar_materiasPrimas
     */
    public admin_gestionar_materiasPrimas() {
        initComponents();
        this.setLocationRelativeTo(null);
        CrearModelo();
        Cargar_Informacion();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        txtCantidad = new javax.swing.JTextField();
        bSeleccionar = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txtPrecioC = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNITP = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        bCancelar = new javax.swing.JButton();
        bGuardar = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        jLabel8 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        bActualizar = new javax.swing.JButton();
        txtDescripcion = new javax.swing.JTextField();
        comboUnidad = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        bSeleccionar.setText("Seleccionar");
        bSeleccionar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bSeleccionarActionPerformed(evt);
            }
        });

        jLabel2.setText("Nombre: ");

        jLabel3.setText("Descripcion:");

        jLabel4.setText("Unidad:");

        jLabel5.setText("Cantidad:");

        bCancelar.setText("Cancelar");
        bCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bCancelarActionPerformed(evt);
            }
        });

        bGuardar.setText("Guardar");
        bGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bGuardarActionPerformed(evt);
            }
        });

        jLabel7.setText("NIT Proveedor:");

        tabla.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tabla);

        jLabel8.setText("Valor comprado:");

        bActualizar.setText("Actualizar");
        bActualizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bActualizarActionPerformed(evt);
            }
        });

        comboUnidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Kg", "Gal" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(bCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bSeleccionar, javax.swing.GroupLayout.DEFAULT_SIZE, 101, Short.MAX_VALUE))
                        .addGap(93, 93, 93)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bActualizar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(bGuardar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addGap(104, 104, 104))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtNombre)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(comboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(45, 45, 45)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel8)
                            .addComponent(txtPrecioC, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jLabel3)
                            .addComponent(txtDescripcion, javax.swing.GroupLayout.DEFAULT_SIZE, 148, Short.MAX_VALUE)
                            .addComponent(jLabel7)
                            .addComponent(txtNITP))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 820, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(25, 25, 25))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGap(46, 46, 46)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                        .addComponent(jLabel5)
                        .addGap(6, 6, 6)
                        .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel8)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtPrecioC, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(55, 55, 55)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(comboUnidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtNITP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(95, 95, 95)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bActualizar)
                    .addComponent(bSeleccionar))
                .addGap(45, 45, 45)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bCancelar)
                    .addComponent(bGuardar))
                .addGap(24, 24, 24))
            .addGroup(layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 488, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bSeleccionarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bSeleccionarActionPerformed
        txtNombre.setText(tabla.getValueAt(tabla.getSelectedRow(), 1).toString());
        txtDescripcion.setText(tabla.getValueAt(tabla.getSelectedRow(), 2).toString());
        comboUnidad.setSelectedItem(modelo.getValueAt(tabla.getSelectedRow(), 3).toString());
        txtCantidad.setText(tabla.getValueAt(tabla.getSelectedRow(), 4).toString());
        txtPrecioC.setText(tabla.getValueAt(tabla.getSelectedRow(), 5).toString());   
        txtNITP.setText(tabla.getValueAt(tabla.getSelectedRow(), 6).toString());

        cEdit = cMateriasprimas.findMateriasprimas((Integer) modelo.getValueAt(tabla.getSelectedRow(), 0));
    }//GEN-LAST:event_bSeleccionarActionPerformed

    private void bCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bCancelarActionPerformed
        admin_gestionar ventana = new admin_gestionar();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bCancelarActionPerformed

    private void bGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bGuardarActionPerformed
        try {
            Materiasprimas c = new Materiasprimas();

            c.setMatNombre(txtNombre.getText());
            c.setMatDescripcion(txtDescripcion.getText());
            c.setMatUnidadMedida((String) comboUnidad.getSelectedItem());
            c.setMatCatidad(Integer.parseInt(txtCantidad.getText()));
            c.setMatPrecioComprado(Integer.parseInt(txtPrecioC.getText()));
            Proveedores prov = new Proveedores();
            prov.proNIT = (txtNITP.getText());
            c.setProNIT(prov);

            cMateriasprimas.create(c);
            System.out.println("Los datos fueron guardados");

            CrearModelo();
            Cargar_Informacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("Problema el guardar datos");
        } 
    }//GEN-LAST:event_bGuardarActionPerformed

    private void bActualizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bActualizarActionPerformed
        try{
            cEdit.setMatNombre(txtNombre.getText());
            cEdit.setMatDescripcion(txtDescripcion.getText());
            cEdit.setMatCatidad(Integer.parseInt(txtCantidad.getText()));
            cEdit.setMatPrecioComprado(Integer.parseInt(txtPrecioC.getText()));
            cEdit.setProNIT(cProveedores.findProveedores(txtNITP.getText()));

            cMateriasprimas.edit(cEdit);
            System.out.println("Se actualizo");
            CrearModelo();
            Cargar_Informacion();
        }catch (Exception e){
            JOptionPane.showMessageDialog(null, e.toString() + "error");
            System.out.println("Error al actualizar");
        } 
    }//GEN-LAST:event_bActualizarActionPerformed

    DefaultTableModel modelo;
    private void CrearModelo() {
        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Codigo", "Nombre", "Descripcion",
                        "Unidad", "Cantidad", "P. Comprado",
                        "Proveedor"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false
                };

                @Override
                public Class getColumnClass(int columnIndex) {
                    return types[columnIndex];
                }

                @Override
                public boolean isCellEditable(int rowIndex, int colIndex) {
                    return canEdit[colIndex];
                }
            });
            tabla.setModel(modelo);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error");
            System.out.println("Problema con el modelo de tabla");
        }
    }
    
    
    private void Cargar_Informacion(){
        try{
            Object o[]=null;
            List<Materiasprimas> listP = cMateriasprimas.findMateriasprimasEntities();
            
            for (int i=0; i< listP.size(); i++){
                modelo.addRow(o);
                modelo.setValueAt(listP.get(i).getMatCodigo(), i, 0);
                modelo.setValueAt(listP.get(i).getMatNombre(), i, 1);
                modelo.setValueAt(listP.get(i).getMatDescripcion(), i, 2);
                modelo.setValueAt(listP.get(i).getMatUnidadMedida(), i, 3);
                modelo.setValueAt(listP.get(i).getMatCatidad(), i, 4);
                modelo.setValueAt(listP.get(i).getMatPrecioComprado(), i, 5);
                modelo.setValueAt(listP.get(i).getProNIT().getProNIT(), i, 6);
                
            }                                            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
            System.out.println("problema al cargar datos");
        }
    }
    
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(admin_gestionar_materiasPrimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_gestionar_materiasPrimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_gestionar_materiasPrimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_gestionar_materiasPrimas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_gestionar_materiasPrimas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bActualizar;
    private javax.swing.JButton bCancelar;
    private javax.swing.JButton bGuardar;
    private javax.swing.JButton bSeleccionar;
    private javax.swing.JComboBox<String> comboUnidad;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtNITP;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtPrecioC;
    // End of variables declaration//GEN-END:variables
}
