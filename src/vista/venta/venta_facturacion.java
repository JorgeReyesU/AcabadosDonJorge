/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.venta;

import java.awt.Dimension;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import logica.logica_venta_facturacion;
import modelo.Clientes;
import modelo.Detallesorden;
import modelo.Productos;
import modelo.Ordenes;
import persistencia.ClientesJpaController;
import persistencia.DetallesordenJpaController;
import persistencia.OrdenesJpaController;
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
    OrdenesJpaController cOrdenes = new OrdenesJpaController();
    public static Ordenes Ordennnn;
    
    /**
     * Creates new form venta_facturacion
     */
    public venta_facturacion() {
        initComponents();
        this.setMinimumSize(new Dimension(1420, 950));
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
        bInicio = new javax.swing.JButton();
        bAgregar = new javax.swing.JButton();
        labelSubtotal = new javax.swing.JLabel();
        labelDescuento = new javax.swing.JLabel();
        labelTotal = new javax.swing.JLabel();
        bPagar = new javax.swing.JButton();
        bCliente = new javax.swing.JButton();
        bDescuento = new javax.swing.JButton();
        comboClientes = new javax.swing.JComboBox<>();
        labelCliente = new javax.swing.JLabel();
        bEliminar = new javax.swing.JButton();
        bFinalizar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();

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
        jScrollPane1.setBounds(130, 120, 1230, 490);

        getContentPane().add(comboProducto);
        comboProducto.setBounds(230, 50, 169, 30);

        getContentPane().add(comboColor);
        comboColor.setBounds(530, 50, 193, 30);

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 20)); // NOI18N
        txtCantidad.setForeground(new java.awt.Color(58, 58, 128));
        txtCantidad.setText("0");
        txtCantidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCantidadActionPerformed(evt);
            }
        });
        getContentPane().add(txtCantidad);
        txtCantidad.setBounds(840, 50, 157, 31);

        bInicio.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/bInicio.png"))); // NOI18N
        bInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bInicioActionPerformed(evt);
            }
        });
        getContentPane().add(bInicio);
        bInicio.setBounds(0, 0, 80, 80);

        bAgregar.setText("Agregar");
        bAgregar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bAgregarActionPerformed(evt);
            }
        });
        getContentPane().add(bAgregar);
        bAgregar.setBounds(1120, 50, 95, 30);

        labelSubtotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelSubtotal.setForeground(new java.awt.Color(58, 58, 128));
        labelSubtotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelSubtotal.setText("-");
        getContentPane().add(labelSubtotal);
        labelSubtotal.setBounds(1200, 660, 127, 40);

        labelDescuento.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelDescuento.setForeground(new java.awt.Color(58, 58, 128));
        labelDescuento.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelDescuento.setText("0");
        getContentPane().add(labelDescuento);
        labelDescuento.setBounds(1200, 720, 127, 30);

        labelTotal.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        labelTotal.setForeground(new java.awt.Color(58, 58, 128));
        labelTotal.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        labelTotal.setText("-");
        getContentPane().add(labelTotal);
        labelTotal.setBounds(1200, 770, 127, 30);

        bPagar.setText("Pagar");
        bPagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bPagarActionPerformed(evt);
            }
        });
        getContentPane().add(bPagar);
        bPagar.setBounds(1200, 830, 130, 30);

        bCliente.setText("Registrar - Modificar");
        bCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bClienteActionPerformed(evt);
            }
        });
        getContentPane().add(bCliente);
        bCliente.setBounds(230, 800, 149, 25);

        bDescuento.setText("Eplicar Desc.");
        bDescuento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bDescuentoActionPerformed(evt);
            }
        });
        getContentPane().add(bDescuento);
        bDescuento.setBounds(230, 730, 149, 25);

        getContentPane().add(comboClientes);
        comboClientes.setBounds(270, 670, 180, 22);

        labelCliente.setText("-");
        getContentPane().add(labelCliente);
        labelCliente.setBounds(1116, 1580, 185, 16);

        bEliminar.setText("Eliminar");
        bEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bEliminarActionPerformed(evt);
            }
        });
        getContentPane().add(bEliminar);
        bEliminar.setBounds(1260, 50, 103, 30);

        bFinalizar.setText("Finalizar");
        bFinalizar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                bFinalizarActionPerformed(evt);
            }
        });
        getContentPane().add(bFinalizar);
        bFinalizar.setBounds(841, 830, 130, 30);

        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Venta_bStock.png"))); // NOI18N
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(0, 240, 80, 80);

        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/venta_bFacturacion.png"))); // NOI18N
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(0, 120, 80, 80);

        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Admin_bObservaciones.png"))); // NOI18N
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(0, 350, 80, 80);

        jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/vista/img/Venta_Facturacion.png"))); // NOI18N
        getContentPane().add(jLabel7);
        jLabel7.setBounds(0, 0, 1400, 900);

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
    public static int subtotal = 0;
    int total = 0;
    private void bAgregarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bAgregarActionPerformed
        List<Productos> listP = cProductos.findProductosEntities();
        int codigo = 0;
        String prodNombre = (String) comboProducto.getSelectedItem();
        for (int i = 0; i < listP.size(); i++) {
            if (listP.get(i).getProdNombre() == prodNombre) {
                codigo = listP.get(i).getProdCodigo();
            }
        }
        String prodColor = (String) comboColor.getSelectedItem();
        int cantidadP = Integer.parseInt(txtCantidad.getText());
        System.out.println(cantidadP);
        String unidad = cProductos.findProductos(codigo).getProdUnidadMedida();
        int valorU = cProductos.findProductos(codigo).getProdPrecioVenta();
        int totalP = cantidadP * valorU;
       // JOptionPane.showMessageDialog(null, cantidadP);
        int cantidadProd = cProductos.findProductos(codigo).getProdCantidad();
        if (cantidadP > 0) {
            if (cantidadP <= cantidadProd) {
                 
                logica_venta_facturacion.agregarItemTabla(contadorAgregar, prodNombre, prodColor, cantidadP, unidad, valorU, totalP);
                contadorAgregar++;
            } else {
                JOptionPane.showMessageDialog(null, "No existe en stock la cantidad solicitada de este producto. \n"
                        + "Solo quedan: " + cantidadProd + " Unidades de " + prodNombre);
            }
        } else {
            JOptionPane.showMessageDialog(null, "Ingrese una cantidad mayor a 0.");
        }
        //JOptionPane.showMessageDialog(null, totalP);
        logica_venta_facturacion.subtotalL(contadorAgregar, totalP); //Subtotal
        logica_venta_facturacion.totalL();
    }//GEN-LAST:event_bAgregarActionPerformed

    private void bClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bClienteActionPerformed
         venta_gestionar_clientes ventana = new venta_gestionar_clientes();
         ventana.setVisible(true);
    }//GEN-LAST:event_bClienteActionPerformed

    private void bDescuentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bDescuentoActionPerformed
        ClientesJpaController sClientes = new ClientesJpaController();
        
        labelDescuento.setText(String.valueOf(sClientes.findClientes(String.valueOf(comboClientes.getSelectedItem())).getCliDescuento()));
        logica_venta_facturacion.totalL();
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
        logica_venta_facturacion.totalL();
    }//GEN-LAST:event_bEliminarActionPerformed
    
    public static int Descuento;
    public static String NITCliente;
    private void bPagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_bPagarActionPerformed
        try{
            if(contadorAgregar > 0){
                NITCliente = String.valueOf(comboClientes.getSelectedItem());
                Descuento = Integer.parseInt(labelDescuento.getText());
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
  
        /*   List<Productos> listP = cProductos.findProductosEntities();
    for(int i=0; i< contadorAgregar; i++){
        for (int j = 0; j < listP.size(); j++) {
                        if (listP.get(j).getProdNombre() == modelo.getValueAt(i, 0)) {
                            //Prod = cProductos.findProductos(j);
                            System.out.println("scnksbchsdbchsajc");
                        }}}*/
                        
        if(contadorAgregar > 0){
        if (venta_pago.ordenN == 1) {
        //    for (int i = 0; i < contadorAgregar; i++) {System.out.println(modelo.getValueAt(i, 0));}}}
            try {
                for (int i = 0; i < contadorAgregar; i++) {
                    List<Productos> listP = cProductos.findProductosEntities();
                    String prodN = (String) modelo.getValueAt(i, 0);
                    int cantidadd = (Integer) modelo.getValueAt(i, 2);
                    int contadorw = 0;
                    while (listP.get(contadorw).getProdNombre() != prodN) {
                        contadorw++;
                    }
                    contadorw++;
                    //Productos Prod = cProductos.findProductos(contadorw);
                   // System.out.println(Prod);
                    
                    String colorr = (String) comboColor.getSelectedItem();
                    
                    Detallesorden c = new Detallesorden();
                   // OrdenesJpaController cOrdenes = new OrdenesJpaController();
                    int num = cOrdenes.getOrdenesCount();
                    Ordenes ordenn = cOrdenes.findOrdenes(num);
                    c.setOrdCodigo(ordenn);
                    c.setProdCodigo(cProductos.findProductos(contadorw));
                    c.setDetCantidad(cantidadd);
                    c.setDetDescripcion(colorr);
                    cDetalles.create(c);
                    
                    
                  //  logica_venta_facturacion.crearDeta(Prod,cantidadd,colorr);
                    Productos pEdit = (Productos) cProductos.findProductos(contadorw);
                    System.out.println("Se realizo detalles");
                    int cantidaddd = pEdit.getProdCantidad();
                    pEdit.setProdCantidad(cantidaddd - cantidadd)
                            ;
                    cProductos.edit(pEdit);
                }
               
                 // CrearModelo();
            } catch (Exception e) {
                JOptionPane.showMessageDialog(null, e.getMessage());
                System.out.println("Error al crear los detalles de ordenes");
            }
        }else{
            JOptionPane.showMessageDialog(null, "No ha realizado pago");
        }
    }else{
            JOptionPane.showMessageDialog(null, "Agregue al menos un producto");
    }
      /*  int numOrden = cOrdenes.getOrdenesCount();
            if (contadorAgregar > 0) {
            if (venta_pago.ordenN == 1) {
                
                    try {
                        for (int i = 0; i < contadorAgregar; i++) {
                            Detallesorden c = new Detallesorden();
                            //c.setOrdCodigo(cOrdenes.findOrdenes(numOrden).getOrdCodigo());   // ordCodigo!!
                            c.setOrdCodigo(cOrdenes.findOrdenes(numOrden));
                            String prodN = (String) modelo.getValueAt(i, 0);
                            List<Productos> listP = cProductos.findProductosEntities();
                            int codigoF = 0;
                            for (int f = 0; f < listP.size(); f++) {
                                if (listP.get(f).getProdNombre() == prodN) {
                                    codigoF = listP.get(f).getProdCodigo();
                                }
                            }
                            Productos prod = cProductos.findProductos(codigoF);
                            c.setProdCodigo(prod); // prodCodigo!!
                            c.setDetCantidad((int) modelo.getValueAt(i, 2));
                            c.setDetDescripcion((String) modelo.getValueAt(i, 1));
                            cDetalles.create(c);
                            //   this.getContentPane().invalidate();
                            //  this.getContentPane().validate();
                            //  this.getContentPane().repaint();
                        
                        System.out.println("Los datos fueron guardados");}
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, e.getMessage());
                        System.out.println("Error al crear los detalles de ordenes");
                    }
                
            } else {
                JOptionPane.showMessageDialog(null, "No ha realizado pago");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Agregue al menos un producto");
        }
     */   venta_pago.ordenN = 0;
     
    }//GEN-LAST:event_bFinalizarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        venta_stock ventana = new venta_stock();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        subtotal = 0;
        total = 0;
        contadorAgregar = 0;
        venta_facturacion ventana = new venta_facturacion();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        venta_observaciones ventana = new venta_observaciones();
        ventana.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_jButton6ActionPerformed

    public static DefaultTableModel modelo;
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
    public static javax.swing.JComboBox<String> comboClientes;
    private javax.swing.JComboBox<String> comboColor;
    private javax.swing.JComboBox<String> comboProducto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCliente;
    public static javax.swing.JLabel labelDescuento;
    public static javax.swing.JLabel labelSubtotal;
    public static javax.swing.JLabel labelTotal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
