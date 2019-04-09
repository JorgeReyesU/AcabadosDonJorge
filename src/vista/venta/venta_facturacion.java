/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.venta;

import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import modelo.Clientes;
import modelo.Detallesorden;
import modelo.Productos;
import persistencia.ClientesJpaController;
import persistencia.DetallesordenJpaController;
import persistencia.ProductosJpaController;
import vista.Inicio;

/**
 *
 * @author Kings
 */
public class venta_facturacion extends javax.swing.JFrame {
    
    ProductosJpaController cProductos = new ProductosJpaController();
    ClientesJpaController cClientes = new ClientesJpaController();
    DetallesordenJpaController cDetalles = new DetallesordenJpaController();
    
    /**
     * Creates new form venta_facturacion
     */
    public venta_facturacion() {
        initComponents();
        this.setLocationRelativeTo(null);
        CrearModelo();
        Cargar_Informacion_Combos();
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
        comboProducto = new javax.swing.JComboBox<>();
        comboColor = new javax.swing.JComboBox<>();
        txtCantidad = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        bInicio = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        bAgregar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        labelSubtotal = new javax.swing.JLabel();
        labelDescuento = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        bPagar = new javax.swing.JButton();
        bCliente = new javax.swing.JButton();
        bDescuento = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        comboClientes = new javax.swing.JComboBox<>();
        labelCliente = new javax.swing.JLabel();
        bEliminar = new javax.swing.JButton();
        bFinalizar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

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

        txtCantidad.setText("0");
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });

        jLabel1.setText("Producto:");

        bInicio.setText("Inicio");
        bInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInicioActionPerformed(evt);
            }
        });

        jLabel2.setText("Color:");

        jLabel3.setText("Cantidad:");

        bAgregar.setText("Agregar");
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });

        jLabel4.setText("Subtotal: ");

        jLabel5.setText("% Descuento:");

        jLabel6.setText("Total: ");

        labelSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtotal.setText("-");

        labelDescuento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDescuento.setText("0");

        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal.setText("-");

        bPagar.setText("Pagar");
        bPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPagarActionPerformed(evt);
            }
        });

        bCliente.setText("Registrar - Modificar");
        bCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClienteActionPerformed(evt);
            }
        });

        bDescuento.setText("Eplicar Desc.");
        bDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDescuentoActionPerformed(evt);
            }
        });

        jLabel10.setText("Cliente: ");

        labelCliente.setText("-");

        bEliminar.setText("Aliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });

        bFinalizar.setText("Finalizar");
        bFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFinalizarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(bInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(0, 133, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6)
                                    .addComponent(jLabel5))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(labelDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 127, Short.MAX_VALUE)
                                    .addComponent(labelSubtotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(labelTotal, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 1068, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(bCliente)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(52, 52, 52)
                                        .addComponent(jLabel10)))
                                .addGap(34, 34, 34)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(bDescuento, javax.swing.GroupLayout.DEFAULT_SIZE, 149, Short.MAX_VALUE)
                                    .addComponent(comboClientes, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(bFinalizar)
                                        .addGap(221, 221, 221)
                                        .addComponent(bPagar, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(53, 53, 53)
                                        .addComponent(labelCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 185, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(0, 0, Short.MAX_VALUE))))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel1))
                        .addGap(49, 49, 49)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(59, 59, 59)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel3))
                        .addGap(59, 59, 59)
                        .addComponent(bAgregar, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(37, 37, 37)
                        .addComponent(bEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(24, 24, 24)))
                .addGap(48, 48, 48))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(bInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 57, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(11, 11, 11)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(bAgregar)
                        .addComponent(bEliminar))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(comboProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(comboColor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtCantidad, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(69, 69, 69)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(36, 36, 36)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(labelSubtotal))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(labelDescuento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(comboClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(labelCliente))
                .addGap(2, 2, 2)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(labelTotal))
                .addGap(28, 28, 28)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(bPagar)
                    .addComponent(bDescuento)
                    .addComponent(bCliente)
                    .addComponent(bFinalizar))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void bInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bInicioActionPerformed
        Inicio ventana = new Inicio();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_bInicioActionPerformed

    private void txtCantidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCantidadActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCantidadActionPerformed

    int contadorAgregar = 0;
    int subtotal = 0;
    int total = 0;
    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        if(Integer.parseInt(txtCantidad.getText()) > 0 && Integer.parseInt(txtCantidad.getText()) < 2000){
            try {
                Object o[] = null;
                List<Productos> listP = cProductos.findProductosEntities();
                int contadorw = 0;
                while (listP.get(contadorw).getProdNombre() != comboProducto.getSelectedItem()) {
                    contadorw++;
                }
                contadorw++;
                ProductosJpaController sProductos = new ProductosJpaController();

                modelo.addRow(o);
                modelo.setValueAt(comboProducto.getSelectedItem(), contadorAgregar, 0); //Nombre
                modelo.setValueAt(comboColor.getSelectedItem(), contadorAgregar, 1); //Color
                modelo.setValueAt(txtCantidad.getText(), contadorAgregar, 2); //Cantidad
                modelo.setValueAt(sProductos.findProductos(contadorw).getProdUnidadMedida(), contadorAgregar, 3); //Unidad
                modelo.setValueAt(sProductos.findProductos(contadorw).getProdPrecioVenta(), contadorAgregar, 4); //Precio
                modelo.setValueAt((sProductos.findProductos(contadorw).getProdPrecioVenta()) * (Integer.parseInt(txtCantidad.getText())), contadorAgregar, 5); //Precio total          
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.println("problema al agregar un producto");
            }

            subtotalA();
            total();

            contadorAgregar++;
        }
        
    }//GEN-LAST:event_bAgregarActionPerformed
    
    public void subtotalA(){
        subtotal = subtotal + (int) modelo.getValueAt(contadorAgregar, 5);    
        labelSubtotal.setText(String.valueOf(subtotal));
    }
    
    public void total(){
        total = subtotal - ((Integer.parseInt(labelDescuento.getText()) * subtotal)/100);
        labelTotal.setText(String.valueOf(total));
    }
    
    private void bClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClienteActionPerformed
        venta_gestionar_clientes ventana = new venta_gestionar_clientes();
        ventana.setVisible(true);
    }//GEN-LAST:event_bClienteActionPerformed

    private void bDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDescuentoActionPerformed
        ClientesJpaController sClientes = new ClientesJpaController();
        
        labelDescuento.setText(String.valueOf(sClientes.findClientes(String.valueOf(comboClientes.getSelectedItem())).getCliDescuento()));
        total();
    }//GEN-LAST:event_bDescuentoActionPerformed

    private void bEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bEliminarActionPerformed
        try{
            if(contadorAgregar > 0){
                int numero = (int) tabla.getValueAt(tabla.getSelectedRow(), 5);
                subtotal = subtotal - numero;

                modelo.removeRow(tabla.getSelectedRow());
                contadorAgregar --;
               // System.out.println(subtotal);
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Selecciona un producto para eliminar.");
        }  
        labelSubtotal.setText(String.valueOf(subtotal));
        total();
    }//GEN-LAST:event_bEliminarActionPerformed
    
    public static String Descuento = "";
    public static String NITCliente = "";
    private void bPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPagarActionPerformed
        try{
            if(contadorAgregar > 0){
                NITCliente = String.valueOf(comboClientes.getSelectedItem());
                Descuento = labelDescuento.getText();
                venta_pago ventana = new venta_pago();
                ventana.setVisible(true);
            }else {
                JOptionPane.showMessageDialog(null, "No hay ningun producto para pagar");
            }
        } catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error al pagar");
        }
            
        
        
    }//GEN-LAST:event_bPagarActionPerformed

    private void bFinalizarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bFinalizarActionPerformed
        if (contadorAgregar > 0) {
            venta_pago ventap = new venta_pago();
            try {
                for (int i = 0; i < contadorAgregar; i++) {
                    Detallesorden c = new Detallesorden();

                    c.setOrdCodigo(ventap.Orden);

                    String prodN = (String) modelo.getValueAt(i, 0);
                    List<Productos> listP = cProductos.findProductosEntities();
                    int contadorw = 0;
                    while (listP.get(contadorw).getProdNombre() != prodN) {
                        contadorw++;
                    }
                    contadorw++;
                    Productos prod = new Productos();
                    prod.prodCodigo = contadorw;

                    System.out.println(prod);
                    c.setProdCodigo(prod);

                    c.setDetCantidad(Integer.parseInt((String) modelo.getValueAt(i, 2)));
                    c.setDetDescripcion((String) modelo.getValueAt(i, 1));

                    cDetalles.create(c);
                    //  System.out.println(c.getDetCodigo());
                }
                // System.out.println(ventap.Orden);
                System.out.println("Los datos fueron guardados");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.println("No ha realizado pago");
            }
        }else {
            JOptionPane.showMessageDialog(null, "Selecciones como minimo un producto.");
        }
           
    }//GEN-LAST:event_bFinalizarActionPerformed

    DefaultTableModel modelo;
    private void CrearModelo() {
        try {
            modelo = (new DefaultTableModel(
                    null, new String[]{
                        "Producto", "Color", "Cantidad",
                        "Unidad", "Valor Unitario", "Valor Total",}) {
                Class[] types = new Class[]{
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class,
                    java.lang.String.class
                };
                boolean[] canEdit = new boolean[]{
                    false, false, false, false, false, false
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
    
    private void Cargar_Informacion_Combos(){
        try{
            List<Productos> listP = cProductos.findProductosEntities();
            
            for (int i=0; i< listP.size(); i++){
                comboProducto.addItem(listP.get(i).getProdNombre());     
            } 
            
            List<Clientes> listC = cClientes.findClientesEntities();
            
            for (int i=0; i< listC.size(); i++){
                comboClientes.addItem(listC.get(i).getCliNIT());     
            }
            
            comboColor.addItem("-");
            comboColor.addItem("123");
            comboColor.addItem("132");
            comboColor.addItem("213");
            comboColor.addItem("231");
            comboColor.addItem("312");
            comboColor.addItem("321");
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
            java.util.logging.Logger.getLogger(venta_facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(venta_facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(venta_facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(venta_facturacion.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new venta_facturacion().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton bAgregar;
    private javax.swing.JButton bCliente;
    private javax.swing.JButton bDescuento;
    private javax.swing.JButton bEliminar;
    private javax.swing.JButton bFinalizar;
    private javax.swing.JButton bInicio;
    private javax.swing.JButton bPagar;
    private javax.swing.JComboBox<String> comboClientes;
    private javax.swing.JComboBox<String> comboColor;
    private javax.swing.JComboBox<String> comboProducto;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCliente;
    private javax.swing.JLabel labelDescuento;
    private javax.swing.JLabel labelSubtotal;
    private javax.swing.JLabel labelTotal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
