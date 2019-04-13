/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista.venta;

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
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

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

        jButton1.setText("Stock");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Facturacion");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton6.setText("Observaciones");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(bInicio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                .addGap(18, 34, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
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
                                    .addGap(0, 0, Short.MAX_VALUE)))))
                    .addGroup(layout.createSequentialGroup()
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
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
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
                        .addGap(79, 79, 79)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 68, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel labelCliente;
    public static javax.swing.JLabel labelDescuento;
    public static javax.swing.JLabel labelSubtotal;
    public static javax.swing.JLabel labelTotal;
    private javax.swing.JTable tabla;
    private javax.swing.JTextField txtCantidad;
    // End of variables declaration//GEN-END:variables
}
