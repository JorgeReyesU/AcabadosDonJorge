/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.fabrica;

import java.awt.Dimension;
import logica.logica_fabrica_stock_fabrica;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Productos;
import persistencia.ProductosJpaController;
import vista.Inicio;

/**
 *
 * @author Kings
 */
public class fabrica_stock_fabrica extends javax.swing.JFrame {
    ProductosJpaController cProductos = new ProductosJpaController();
    logica_fabrica_stock_fabrica logicaF = new logica_fabrica_stock_fabrica();
    Productos cEdit;
    
    public static int contadorG = 0;
    public static int contadorP = 0;
    /**
     * Creates new form fabrica_stock_fabrica
     */
    public fabrica_stock_fabrica() {
        initComponents();
        this.setMinimumSize(new Dimension(1420, 950));
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

        jScrollPane1 = new javax.swing.JScrollPane();
        tabla = new javax.swing.JTable();
        bAgregar = new javax.swing.JButton();
        bInicio = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bStockM = new javax.swing.JButton();
        bStockF = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(null);

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

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(140, 110, 1210, 740);

        bAgregar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bAgregarL.png"))); // NOI18N
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(bAgregar);
        bAgregar.setBounds(1160, 30, 200, 50);

        bInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bInicio.png"))); // NOI18N
        bInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInicioActionPerformed(evt);
            }
        });
        getContentPane().add(bInicio);
        bInicio.setBounds(0, 0, 80, 80);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bPedidos.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(0, 130, 80, 80);

        bStockM.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bStockM.png"))); // NOI18N
        bStockM.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStockMActionPerformed(evt);
            }
        });
        getContentPane().add(bStockM);
        bStockM.setBounds(0, 250, 80, 80);

        bStockF.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bStockF.png"))); // NOI18N
        bStockF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bStockFActionPerformed(evt);
            }
        });
        getContentPane().add(bStockF);
        bStockF.setBounds(0, 370, 80, 80);

        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bStockU.png"))); // NOI18N
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton3);
        jButton3.setBounds(0, 490, 80, 80);

        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_bObservaciones.png"))); // NOI18N
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(0, 610, 80, 80);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Fabrica_StockF.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1400, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        try {
            List<Productos> listP = cProductos.findProductosEntities();
            //     String productoF = listP.get(i).getProdDescripcion();
            String productoF1 = listP.get(0).getProdNombre();
            String productoF2 = listP.get(1).getProdNombre();
            int numeroo = tabla.getSelectedRow();
            String Nombree = (String) modelo.getValueAt(numeroo, 1);
            if (Nombree.equals(productoF1) && (contadorG < 3)) {
                cEdit = cProductos.findProductos((Integer) modelo.getValueAt(tabla.getSelectedRow(), 0));
                int numero = tabla.getSelectedRow();
                int cantidadS = (int) modelo.getValueAt(numero, 4);
                //System.out.println(cantidadS);

                cEdit.setProdCantidad(cantidadS + 300);
                logicaF.reducirMP(0);
                contadorG++;
            } else if (Nombree.equals(productoF1) && contadorG > 2) {
                JOptionPane.showMessageDialog(null, "ya se agregaron demasiados lotes de graniplas por hoy");
            }

            if (Nombree.equals(productoF2) && (contadorP < 3)) {
                cEdit = cProductos.findProductos((Integer) modelo.getValueAt(tabla.getSelectedRow(), 0));
                int numero = tabla.getSelectedRow();
                int cantidadS = (int) modelo.getValueAt(numero, 4);
                //  System.out.println(cantidadS);

                cEdit.setProdCantidad(cantidadS + 60);
                logicaF.reducirMP(1);
                contadorP++;
            } else if (Nombree.equals(productoF2) && contadorP > 2) {
                JOptionPane.showMessageDialog(null, "ya se agregaron demasiados lotes de pintura por hoy");
            }

            cProductos.edit(cEdit);
            System.out.println("Se actualizo");
            CrearModelo();
            Cargar_Informacion();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.toString() + "error");
            System.out.println("Error al actualizar");
        }
    }//GEN-LAST:event_bAgregarActionPerformed

    private void bInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInicioActionPerformed
        Inicio ventana = new Inicio();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bInicioActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        fabrica_pedidos ventana = new fabrica_pedidos();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bStockMActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStockMActionPerformed
        fabrica_stock_materiasPrimas ventana = new fabrica_stock_materiasPrimas();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bStockMActionPerformed

    private void bStockFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bStockFActionPerformed
        fabrica_stock_fabrica ventana = new fabrica_stock_fabrica();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bStockFActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        fabrica_stock_utileria ventana = new fabrica_stock_utileria();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        fabrica_Observaciones ventana = new fabrica_Observaciones();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton4ActionPerformed

    DefaultTableModel modelo;
    private void CrearModelo() {
        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Codigo", "Nombre", "Descripcion",
                        "Unidad", "Cantidad", "P. Comprado",
                        "P. Venta", "Proveedor"}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false, false, false
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
            List<Productos> listP = cProductos.findProductosEntities();
            int contadorr = 0;
            for (int i=0; i< listP.size(); i++){
                String productoF = listP.get(i).getProdDescripcion();
                String productoF2 = listP.get(0).getProdDescripcion();
                if(productoF.equals(productoF2)){
                    modelo.addRow(o);
                    modelo.setValueAt(listP.get(i).getProdCodigo(), contadorr, 0);
                    modelo.setValueAt(listP.get(i).getProdNombre(), contadorr, 1);
                    modelo.setValueAt(listP.get(i).getProdDescripcion(), contadorr, 2);
                    modelo.setValueAt(listP.get(i).getProdUnidadMedida(), contadorr, 3);
                    modelo.setValueAt(listP.get(i).getProdCantidad(), contadorr, 4);
                    modelo.setValueAt(listP.get(i).getProdPrecioComprado(), contadorr, 5);
                    modelo.setValueAt(listP.get(i).getProdPrecioVenta(), contadorr, 6);
                    modelo.setValueAt(listP.get(i).getProNIT().getProNIT(), contadorr, 7);
                    contadorr++;
                }
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
            java.util.logging.Logger.getLogger(fabrica_stock_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(fabrica_stock_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(fabrica_stock_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(fabrica_stock_fabrica.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new fabrica_stock_fabrica().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bInicio;
    private javax.swing.JButton bStockF;
    private javax.swing.JButton bStockM;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tabla;
    // End of variables declaration//GEN-END:variables
}
