/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inicio;

import com.mysql.jdbc.StringUtils;
import java.awt.Component;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.DefaultCellEditor;
import javax.swing.DefaultListCellRenderer;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.UIManager;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableColumn;
import modelos.DetallePedido;
import modelos.Empleado;
import modelos.Pedido;
import modelos.Producto;
import servicios.Conexion;
import servicios.Empleados_servicio;
import servicios.Pedidos_servicio;
import servicios.Productos_servicio;
import servicios.Usuarios_servicio;

/**
 *
 * @author cami
 */
public class Pedidos extends javax.swing.JFrame {

    private Pedido ped = null;
    private JComboBox comboProductos = null;
    private JComboBox comboEmpleados = null;

    /**
     * Creates new form Inicio
     */
    public Pedidos() {
        comboProductos = new JComboBox();
        List<Producto> productos = null;
        try {
            productos = Productos_servicio.getInstance().recuperarTodas();
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }

        for (int i = 0; i < productos.size(); i++) {
            comboProductos.addItem(productos.get(i));

        }
        initComponents();
        cargarComboEmpleado(jComboEmpleado);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanelBusqPed = new javax.swing.JPanel();
        jButtonNuevoPed = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jTextNroPedido = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFecha = new javax.swing.JFormattedTextField();
        jComboEmpleado = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        jButtonBuscar = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTablePedidos = new javax.swing.JTable();
        jPanelModifPed = new javax.swing.JPanel();
        jButtonGuardarPed = new javax.swing.JButton();
        jButtonCancelarPed = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jLabelNped = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jComboEmpleado1 = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTableEditPed = new javax.swing.JTable();
        jButtonAddItem = new javax.swing.JButton();
        jLabel6 = new javax.swing.JLabel();
        jLabelTotal = new javax.swing.JLabel();
        jButtonDeleteItem = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenu4 = new javax.swing.JMenu();
        jMenu5 = new javax.swing.JMenu();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Aplicación Pedidos");
        setSize(new java.awt.Dimension(598, 311));
        addComponentListener(new java.awt.event.ComponentAdapter() {
            public void componentResized(java.awt.event.ComponentEvent evt) {
                formComponentResized(evt);
            }
        });
        getContentPane().setLayout(new java.awt.CardLayout());

        jButtonNuevoPed.setText("Nuevo pedido");
        jButtonNuevoPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNuevoPedActionPerformed(evt);
            }
        });

        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder("Buscar Pedidos"));

        jLabel1.setText("Nro pedido");

        jLabel2.setText("Fecha");

        jTextFecha.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextFechaActionPerformed(evt);
            }
        });

        jComboEmpleado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        jComboEmpleado.setName("");
        jComboEmpleado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEmpleadoActionPerformed(evt);
            }
        });

        jLabel3.setText("Empleado");

        jButtonBuscar.setText("Buscar");
        jButtonBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonBuscarActionPerformed(evt);
            }
        });

        jTablePedidos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Nro. Pedido", "Fecha", "Empleado", "Modificar","Eliminar"
            }
        ));
        jTablePedidos.getColumn("Modificar").setCellRenderer(new ButtonRenderer());
        jTablePedidos.getColumn("Modificar").setCellEditor(
            new ButtonEditor(new JCheckBox()));
        JScrollPane scroll = new JScrollPane(jTablePedidos);
        //jPanel2.add(scroll);
        setSize(400, 100);
        setVisible(true);
        jTablePedidos.getColumn("Eliminar").setCellRenderer(new ButtonRenderer());
        jTablePedidos.getColumn("Eliminar").setCellEditor(
            new ButtonEditor(new JCheckBox()));
        jTablePedidos.setEnabled(true);
        jScrollPane2.setViewportView(jTablePedidos);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButtonBuscar)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 826, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jTextFecha)
                    .addComponent(jTextNroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(2, 2, 2)
                .addComponent(jComboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 371, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel3)
                        .addComponent(jComboEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jTextNroPedido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextFecha, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(24, 24, 24))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(jButtonBuscar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 271, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(16, Short.MAX_VALUE))
        );

        jComboEmpleado.getAccessibleContext().setAccessibleName("\"\"");

        javax.swing.GroupLayout jPanelBusqPedLayout = new javax.swing.GroupLayout(jPanelBusqPed);
        jPanelBusqPed.setLayout(jPanelBusqPedLayout);
        jPanelBusqPedLayout.setHorizontalGroup(
            jPanelBusqPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusqPedLayout.createSequentialGroup()
                .addComponent(jButtonNuevoPed)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jPanelBusqPedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanelBusqPedLayout.setVerticalGroup(
            jPanelBusqPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanelBusqPedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButtonNuevoPed)
                .addGap(30, 30, 30)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jPanelBusqPed, "card2");

        jPanelModifPed.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Pedido"));
        jPanelModifPed.setMinimumSize(new java.awt.Dimension(44, 25));

        jButtonGuardarPed.setText("Guardar");
        jButtonGuardarPed.setName("jButtonGuardarPed"); // NOI18N
        jButtonGuardarPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonGuardarPedActionPerformed(evt);
            }
        });

        jButtonCancelarPed.setText("Cancelar");
        jButtonCancelarPed.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonCancelarPedActionPerformed(evt);
            }
        });

        jLabel4.setText("Número de pedido");

        jLabel5.setText("Empleado");

        jComboEmpleado1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { }));
        jComboEmpleado1.setName(""); // NOI18N
        jComboEmpleado1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboEmpleado1ActionPerformed(evt);
            }
        });

        jTableEditPed.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null}
            },
            new String [] {
                "Producto", "Precio", "Cantidad", "Total"
            }
        ));
        jScrollPane1.setViewportView(jTableEditPed);
        columnaProducto(jTableEditPed, jTableEditPed.getColumnModel().getColumn(0));
        jTableEditPed.getModel().addTableModelListener(new TableModelListener(){
            public void tableChanged(TableModelEvent e){
                if(e.getType()== TableModelEvent.UPDATE)
                {
                    int column = e.getColumn();
                    if (column == 2)
                    {
                        int precio = (Integer)jTableEditPed.getValueAt(jTableEditPed.getSelectedRow(),1);
                        int cant = (Integer) Integer.parseInt((String)jTableEditPed.getValueAt(jTableEditPed.getSelectedRow(),2));
                        int tot = precio*cant;
                        jTableEditPed.setValueAt(tot,jTableEditPed.getSelectedRow(),3);

                        recalculaTotal();
                    }

                }
            }
        });

        jButtonAddItem.setText("+");
        jButtonAddItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonAddItemActionPerformed(evt);
            }
        });

        jLabel6.setText("Total");

        jButtonDeleteItem.setText("-");
        jButtonDeleteItem.setMaximumSize(new java.awt.Dimension(44, 25));
        jButtonDeleteItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonDeleteItemActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanelModifPedLayout = new javax.swing.GroupLayout(jPanelModifPed);
        jPanelModifPed.setLayout(jPanelModifPedLayout);
        jPanelModifPedLayout.setHorizontalGroup(
            jPanelModifPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModifPedLayout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanelModifPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanelModifPedLayout.createSequentialGroup()
                        .addComponent(jButtonCancelarPed)
                        .addGap(30, 30, 30)
                        .addComponent(jButtonGuardarPed)
                        .addGap(12, 12, 12))
                    .addGroup(jPanelModifPedLayout.createSequentialGroup()
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 66, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(22, 22, 22))))
            .addGroup(jPanelModifPedLayout.createSequentialGroup()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabelNped, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModifPedLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
            .addGroup(jPanelModifPedLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jComboEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 245, Short.MAX_VALUE)
                .addComponent(jButtonAddItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButtonDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );
        jPanelModifPedLayout.setVerticalGroup(
            jPanelModifPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanelModifPedLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanelModifPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelNped, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanelModifPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(jComboEmpleado1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonDeleteItem, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButtonAddItem))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, Short.MAX_VALUE)
                .addGroup(jPanelModifPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelTotal, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addGap(49, 49, 49)
                .addGroup(jPanelModifPedLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonGuardarPed)
                    .addComponent(jButtonCancelarPed))
                .addContainerGap())
        );

        getContentPane().add(jPanelModifPed, "card3");

        jMenu1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jMenu1.setForeground(new java.awt.Color(153, 153, 153));
        jMenu1.setText("Pedidos");
        jMenuBar1.add(jMenu1);

        jMenu2.setText("Productos");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("Empleados");
        jMenuBar1.add(jMenu3);

        jMenu4.setText("Reportes");
        jMenuBar1.add(jMenu4);

        jMenu5.setText("Salir");
        jMenuBar1.add(jMenu5);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formComponentResized(java.awt.event.ComponentEvent evt) {//GEN-FIRST:event_formComponentResized
        // TODO add your handling code here:
    }//GEN-LAST:event_formComponentResized

    private void jTextFechaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextFechaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextFechaActionPerformed

    private void jComboEmpleadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmpleadoActionPerformed
        // TODO add your handling code here:


    }//GEN-LAST:event_jComboEmpleadoActionPerformed

    private void jButtonBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBuscarActionPerformed
        cargarPedidos();

    }//GEN-LAST:event_jButtonBuscarActionPerformed

    private void cargarPedidos()  {
        List<Pedido> ped;
        try {
            ped = Pedidos_servicio.getInstance().recuperarTodasEnc(this.jTextNroPedido.getText(), this.jTextFecha.getText(), (String) this.jComboEmpleado.getSelectedItem());
            DefaultTableModel dtm = (DefaultTableModel) jTablePedidos.getModel();
            dtm.setRowCount(0);
            for (int i = 0; i < ped.size(); i++) {
                dtm.addRow(new Object[]{
                    ped.get(i).getIdPedido(),
                    ped.get(i).getFecha(),
                    ped.get(i).getEmpleado().getNombreEmpleado()
                        
                });
                
            }
            
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            JOptionPane.showMessageDialog(this, "Ha surgido un error y no se han podido recuperar los registros");
        }
    }

    private void jButtonGuardarPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGuardarPedActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableEditPed.getModel();
        Producto prod = null;
        Empleado emp = null;
        try {
            Conexion.getConnection().setAutoCommit(false);
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (ped == null) {
            try {
                emp = Empleados_servicio.getInstance().recuperarEmpPorDescripcion(jComboEmpleado1.getSelectedItem().toString());
            } catch (SQLException ex) {
                Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
            }

            Pedidos_servicio.getInstance().guardarPedidoCab(jLabelNped.getText(), emp.getIdEmpleado().toString(), Usuarios_servicio.getInstance().getUsuarioLogeado());

        } else {
            Pedidos_servicio.getInstance().borrarPedidoDet(jLabelNped.getText());
        }
        for (int i = 0; i < model.getRowCount(); i++) {
            prod = (Producto) jTableEditPed.getValueAt(i, 0);
            Pedidos_servicio.getInstance().guardarPedidoDet(jLabelNped.getText(), prod.getIdProducto().toString(), prod.getPrecio().toString(), (String) jTableEditPed.getValueAt(i, 2).toString());

        }
        try {
            Conexion.getConnection().commit();
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        jButtonCancelarPedActionPerformed(evt);
    }//GEN-LAST:event_jButtonGuardarPedActionPerformed

    private void jButtonCancelarPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonCancelarPedActionPerformed
        jPanelModifPed.setVisible(false);
        jComboEmpleado1.setSelectedIndex(0); //ok pero limpiar el combo 
        jComboEmpleado1.removeAllItems();
        DefaultTableModel model = (DefaultTableModel) jTableEditPed.getModel();
        while (model.getRowCount() > 0) {
            for (int i = 0; i < model.getRowCount(); i++) {
                model.removeRow(i);
            }
        }
        model.addRow(new Object[]{"", "", "", ""});
        jLabelTotal.setText(Integer.toString(0));
        jPanelBusqPed.setVisible(true);

    }//GEN-LAST:event_jButtonCancelarPedActionPerformed

    private void jButtonNuevoPedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNuevoPedActionPerformed
        jPanelModifPed.setVisible(true);
        jPanelBusqPed.setVisible(false);
        jPanelModifPed.setBorder(javax.swing.BorderFactory.createTitledBorder("Nuevo Pedido"));
        String ped = "";
        try {
            ped = Pedidos_servicio.getInstance().recuperarIdNuevoPed();
        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
        jLabelNped.setText(ped);
        cargarComboEmpleado(jComboEmpleado1);
    }//GEN-LAST:event_jButtonNuevoPedActionPerformed

    private void jComboEmpleado1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboEmpleado1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jComboEmpleado1ActionPerformed

    private void jButtonAddItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonAddItemActionPerformed
        DefaultTableModel model = (DefaultTableModel) jTableEditPed.getModel();
        model.addRow(new Object[]{"", "", "", ""});
    }//GEN-LAST:event_jButtonAddItemActionPerformed

    private void jButtonDeleteItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonDeleteItemActionPerformed
        ((DefaultTableModel) jTableEditPed.getModel()).removeRow(jTableEditPed.getSelectedRow());
        recalculaTotal();
    }//GEN-LAST:event_jButtonDeleteItemActionPerformed
    private void cargarComboEmpleado(JComboBox combo) {
        try {
            List<Empleado> empleados;
            empleados = Empleados_servicio.getInstance().recuperarTodas();
            for (int i = 0; i < empleados.size(); i++) {
                combo.addItem(empleados.get(i).toString());

            }
            combo.insertItemAt("", 0);
            combo.setSelectedIndex(0);

        } catch (SQLException ex) {
            Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void recalculaTotal() {
        Double total = 0.0;
        Double parcial = 0.0;
        for (int i = 0; i < jTableEditPed.getRowCount(); i++) {
            if (!StringUtils.isNullOrEmpty(jTableEditPed.getValueAt(i, 3).toString())) {
                parcial = Double.valueOf(jTableEditPed.getValueAt(i, 3).toString());
                total = total + parcial;
            }
        }
        jLabelTotal.setText(Double.toString(total));
    }

    /**
     * @param args the command line arguments
     * @throws java.sql.SQLException
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
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Pedidos.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Pedidos().setVisible(true);
            }
        });

    }

    class ButtonRenderer extends JButton implements TableCellRenderer {

        public ButtonRenderer() {
            setOpaque(true);
        }

        public Component getTableCellRendererComponent(JTable table, Object value,
                boolean isSelected, boolean hasFocus, int row, int column) {
            if (isSelected) {
                setForeground(table.getSelectionForeground());
                setBackground(table.getSelectionBackground());
            } else {
                setForeground(table.getForeground());
                setBackground(UIManager.getColor("Button.background"));
            }
            setText((value == null) ? "" : value.toString());
            return this;
        }
    }

    /**
     * @version 1.0 11/09/98
     */
    class ButtonEditor extends DefaultCellEditor {

        protected JButton button;

        private String label;

        private boolean isPushed;

        private int columna;

        public ButtonEditor(JCheckBox checkBox) {
            super(checkBox);
            button = new JButton();
            // button.setOpaque(true);
            try {
                Image img = ImageIO.read(getClass().getResource("src/Imagenes/pencil.png"));
                img.getScaledInstance(10, 10, Image.SCALE_SMOOTH);
                button.setIcon(new ImageIcon(img));
            } catch (Exception ex) {
                System.out.println(ex);
            }
            button.addActionListener(new ActionListener() {
                public void actionPerformed(ActionEvent e) {
                    fireEditingStopped();
                }
            });
        }

        public Component getTableCellEditorComponent(JTable table, Object value,
                boolean isSelected, int row, int column) {
            if (isSelected) {
                button.setForeground(table.getSelectionForeground());
                button.setBackground(table.getSelectionBackground());
            } else {
                button.setForeground(table.getForeground());
                button.setBackground(table.getBackground());
            }
            label = (value == null) ? "" : value.toString();
            button.setText(label);
            isPushed = true;
            columna = column;
            return button;
        }

        public Object getCellEditorValue() {
            if (isPushed) {
                ped = null;
                int fila = jTablePedidos.getSelectedRow();
                try {
                    ped = Pedidos_servicio.getInstance().recuperarPedidoCompleto(jTablePedidos.getValueAt(fila, 0).toString());
                } catch (SQLException ex) {
                    Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
                }
                if (columna == 3) {//modificar                
                    jPanelBusqPed.setVisible(false);
                    jPanelModifPed.setVisible(true);
                    jComboEmpleado1.setEnabled(false);
                    jPanelModifPed.setBorder(javax.swing.BorderFactory.createTitledBorder("Modificar Pedido"));

                    cargarComboEmpleado(jComboEmpleado1);
                    jLabelNped.setText(ped.getIdPedido().toString());
                    jComboEmpleado1.setSelectedItem(ped.getEmpleado().getNombreEmpleado());
                    DefaultTableModel model = (DefaultTableModel) jTableEditPed.getModel();
                    model.removeRow(0);
                    for (DetallePedido det : ped.getDetallesPedido()) {

                        model.addRow(new Object[]{det.getProducto(), det.getPrecio().toString(), det.getCantidad().toString(), String.valueOf(det.getCantidad() * det.getPrecio())});

                    }
                    recalculaTotal();

                } else {
                    try {
                        //eliminar
                        Conexion.getConnection().setAutoCommit(false);
                    } catch (SQLException ex) {
                        Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    Pedidos_servicio.getInstance().borrarPedidoDet(String.valueOf(ped.getIdPedido()));
                    Pedidos_servicio.getInstance().borrarPedidoCab(String.valueOf(ped.getIdPedido()));
                    cargarPedidos();
                    
                    try {
                        Conexion.getConnection().commit();
                    } catch (SQLException ex) {
                        Logger.getLogger(Pedidos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }

            }
            isPushed = false;
            return new String(label);
        }

        public boolean stopCellEditing() {
            isPushed = false;
            return super.stopCellEditing();
        }

        protected void fireEditingStopped() {
            super.fireEditingStopped();
        }
    }

    public void columnaProducto(JTable table,
            TableColumn colProd) {
        //Set up the editor for the sport cells.

        colProd.setCellEditor(new DefaultCellEditor(comboProductos));

        //Set up tool tips for the sport cells.
        DefaultTableCellRenderer renderer
                = new DefaultTableCellRenderer();
        renderer.setToolTipText("Click para obtener productos");
        colProd.setCellRenderer(renderer);
        //relleno el resto de la fila 
        comboProductos.addItemListener(new ItemListener() {

            public void itemStateChanged(ItemEvent e) {
                if (e.getStateChange() == ItemEvent.SELECTED) {
                    Producto prodSel = (Producto) e.getItem();
                    jTableEditPed.setValueAt(prodSel.getPrecio(), jTableEditPed.getSelectedRow(), 1);

                }
            }
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButtonAddItem;
    private javax.swing.JButton jButtonBuscar;
    private javax.swing.JButton jButtonCancelarPed;
    private javax.swing.JButton jButtonDeleteItem;
    private javax.swing.JButton jButtonGuardarPed;
    private javax.swing.JButton jButtonNuevoPed;
    private javax.swing.JComboBox<String> jComboEmpleado;
    private javax.swing.JComboBox<String> jComboEmpleado1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabelNped;
    private javax.swing.JLabel jLabelTotal;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanelBusqPed;
    private javax.swing.JPanel jPanelModifPed;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTableEditPed;
    private javax.swing.JTable jTablePedidos;
    private javax.swing.JFormattedTextField jTextFecha;
    private javax.swing.JTextField jTextNroPedido;
    // End of variables declaration//GEN-END:variables
}
