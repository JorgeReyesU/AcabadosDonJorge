/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.admin;

import java.awt.Dimension;
import vista.Inicio;

/**
 *
 * @author Kings
 */
public class admin_gestionar extends javax.swing.JFrame {

    /**
     * Creates new form admin_gestionar
     */
    public admin_gestionar() {
        initComponents();
        this.setMinimumSize(new Dimension(1420, 950));
        this.setLocationRelativeTo(null);
       // this.setResizable(false);
       // this.setTitle("Gestionar");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bInicio = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        bCliente = new javax.swing.JButton();
        bProveedor = new javax.swing.JButton();
        bEmpleado = new javax.swing.JButton();
        bProducto = new javax.swing.JButton();
        bMateriaP = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        getContentPane().setLayout(null);

        bInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bInicio.png"))); // NOI18N
        bInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInicioActionPerformed(evt);
            }
        });
        getContentPane().add(bInicio);
        bInicio.setBounds(1, 0, 84, 84);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_bGestionar.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(1, 150, 84, 84);

        bCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_Gestionar_bClientes.png"))); // NOI18N
        bCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClienteActionPerformed(evt);
            }
        });
        getContentPane().add(bCliente);
        bCliente.setBounds(411, 560, 443, 121);

        bProveedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_Gestionar_bProveedores.png"))); // NOI18N
        bProveedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProveedorActionPerformed(evt);
            }
        });
        getContentPane().add(bProveedor);
        bProveedor.setBounds(621, 430, 503, 120);

        bEmpleado.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_Gestionar_bEmpleados.png"))); // NOI18N
        bEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEmpleadoActionPerformed(evt);
            }
        });
        getContentPane().add(bEmpleado);
        bEmpleado.setBounds(641, 690, 443, 123);

        bProducto.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_Gestionar_bProductos.png"))); // NOI18N
        bProducto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bProductoActionPerformed(evt);
            }
        });
        getContentPane().add(bProducto);
        bProducto.setBounds(871, 560, 443, 120);

        bMateriaP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_Gestionar_bMPrimas.png"))); // NOI18N
        bMateriaP.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bMateriaPActionPerformed(evt);
            }
        });
        getContentPane().add(bMateriaP);
        bMateriaP.setBounds(161, 430, 443, 120);

        jButton1.setBackground(new java.awt.Color(58, 58, 128));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_bObservaciones.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1, 300, 84, 84);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_Gestionar.png"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(0, 0, 1400, 900);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void bProductoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProductoActionPerformed
        admin_gestionar_producto ventana = new admin_gestionar_producto();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bProductoActionPerformed

    private void bInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInicioActionPerformed
        Inicio ventana = new Inicio();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bInicioActionPerformed

    private void bClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClienteActionPerformed
       admin_gestionar_clientes ventana = new admin_gestionar_clientes();
       ventana.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_bClienteActionPerformed

    private void bProveedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bProveedorActionPerformed
       admin_gestionar_proveedor ventana = new admin_gestionar_proveedor();
       ventana.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_bProveedorActionPerformed

    private void bEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEmpleadoActionPerformed
       admin_gestionar_empleados ventana = new admin_gestionar_empleados();
       ventana.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_bEmpleadoActionPerformed

    private void bMateriaPActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bMateriaPActionPerformed
       admin_gestionar_materiasPrimas ventana = new admin_gestionar_materiasPrimas();
       ventana.setVisible(true);
       this.setVisible(false);
    }//GEN-LAST:event_bMateriaPActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        admin_observaciones ventana = new admin_observaciones();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

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
            java.util.logging.Logger.getLogger(admin_gestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(admin_gestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(admin_gestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(admin_gestionar.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new admin_gestionar().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bCliente;
    private javax.swing.JButton bEmpleado;
    private javax.swing.JButton bInicio;
    private javax.swing.JButton bMateriaP;
    private javax.swing.JButton bProducto;
    private javax.swing.JButton bProveedor;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}
