/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames.Clientes;

import BaseDeDatos.BaseDeDatos;
import JFrames.Notificacion;
import alquilervehiculos.listas.clientes.ClienteFactory;
import alquilervehiculos.listas.clientes.ListaClientes;
import alquilervehiculos.menu.LecturaDatosMenu;
import alquilervehiculos.modelo.clientes.Cliente;
import alquilervehiculos.modelo.clientes.DatosCliente;
import exceptions.FormatoIncorrectoException;
import exceptions.NoExisteException;
import javax.swing.JDesktopPane;

/**
 *
 * @author Adrian
 */
public class ModificaClientes extends javax.swing.JInternalFrame {

    /**
     * Creates new form ModificaClientes
     */
    private ListaClientes listaClientes;
    private Cliente cliente;
    private JDesktopPane Escritorio;
    private ListaClientesInterfaz listaClientesInterfaz;
    private BaseDeDatos bd;

    public ModificaClientes(ListaClientes listaClientes,  JDesktopPane Escritorio,BaseDeDatos bd) {
        super("ModificaClientes", true, true, false, true);
        this.listaClientes = listaClientes;
        this.Escritorio = Escritorio;
        this.bd=bd;
        this.listaClientesInterfaz = new ListaClientesInterfaz();
        this.listaClientes.informacionDeTodosLosClientes(listaClientesInterfaz);
        this.Escritorio.add(this.listaClientesInterfaz);

        initComponents();
        this.jPanel2.setVisible(false);
        this.jPanel3.setVisible(false);
        this.setVisible(true);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        tipoCliente = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        dniCliente = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        Cliente = new javax.swing.JRadioButton();
        SemiVIP = new javax.swing.JRadioButton();
        VIP = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        Nombre = new javax.swing.JTextField();
        Direccion = new javax.swing.JTextField();
        Telefono = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();

        tipoCliente.add(Cliente);
        tipoCliente.add(SemiVIP);
        tipoCliente.add(VIP);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Modifica cliente");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("DNI del cliente a modificar");

        dniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniClienteActionPerformed(evt);
            }
        });

        jButton1.setText("Buscar cliente");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        tipoCliente.add(Cliente);
        Cliente.setText("Cliente");

        tipoCliente.add(SemiVIP);
        SemiVIP.setText("Semi VIP");

        tipoCliente.add(VIP);
        VIP.setText("VIP");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel3.setText("Tipo de cliente");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(SemiVIP)
                    .addComponent(VIP)
                    .addComponent(Cliente)
                    .addComponent(jLabel3))
                .addGap(0, 8, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap(17, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(Cliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(SemiVIP)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(VIP)
                .addContainerGap())
        );

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel4.setText("Datos del cliente");

        jLabel6.setText("Nombre");

        jLabel7.setText("Direccion");

        jLabel8.setText("Telefono");

        Direccion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DireccionActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Modificar Cliente");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7)
                            .addComponent(jLabel6))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, 94, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Direccion)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addGap(18, 18, 18)
                                .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton2))
                        .addGap(57, 57, 57)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(Nombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(Direccion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(Telefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addComponent(jButton2)
                .addGap(0, 0, 0))
        );

        jLabel5.setText("Selecciona un cliente de la lista");

        jLabel9.setText("o escribe su DNI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addComponent(dniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel9))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jButton1)))
                .addGap(85, 85, 85))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel1)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(43, 43, 43)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 27, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jLabel2)
                    .addContainerGap(219, Short.MAX_VALUE)))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(33, 33, 33)
                .addComponent(dniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jButton1)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(1, 1, 1)
                        .addComponent(jLabel9)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(14, Short.MAX_VALUE))
            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel1Layout.createSequentialGroup()
                    .addGap(74, 74, 74)
                    .addComponent(jLabel2)
                    .addContainerGap(209, Short.MAX_VALUE)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniClienteActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {
            dniCliente.setText(this.listaClientesInterfaz.datoSeleccionado());
            String dni = dniCliente.getText();
            dni = LecturaDatosMenu.leeDni(dni);
            this.cliente = this.listaClientes.buscaCliente(dni);
            String claseCliente = this.cliente.getClass().getSimpleName();
            enciendeBoton(claseCliente);
            DatosCliente datos = this.cliente.getDatos();
            this.Nombre.setText(datos.getNombre());
            this.Direccion.setText(datos.getDireccion());
            this.Telefono.setText(datos.getTelefono());
            this.jPanel2.setVisible(true);
            this.jPanel3.setVisible(true);
        } catch (FormatoIncorrectoException | NoExisteException ex) {

            Notificacion notificacion = new Notificacion(ex.getMessage());
            Escritorio.add(notificacion);
            notificacion.toFront();

        }

    }//GEN-LAST:event_jButton1ActionPerformed

    private void enciendeBoton(String claseCliente) {

        switch (claseCliente) {
            case "Cliente":
                this.Cliente.setSelected(true);
                break;
            case "ClienteSemiVIP":
                this.SemiVIP.setSelected(true);
                break;
            case "ClienteVIP":
                this.VIP.setSelected(true);
                break;

        }

    }

    private void DireccionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DireccionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DireccionActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed

        try {
            String opcion = "";
            String dni = dniCliente.getText();
            dni = LecturaDatosMenu.leeDni(dni);
            String nombre = Nombre.getText();
            String telefono = Telefono.getText();
            String direccion = Direccion.getText();
            DatosCliente datosCliente = new DatosCliente(dni, nombre, direccion, telefono);
            int indice = this.listaClientes.buscaClienteDevuelveIndice(dni);
            if (Cliente.isSelected()) {
                opcion = "Cliente";
            } else if (SemiVIP.isSelected()) {
                opcion = "Semi VIP";
            } else if (VIP.isSelected()) {
                opcion = "VIP";
            }
            if (opcion != null) {

                switch (opcion) {

                    case "Cliente":
                        cliente = ClienteFactory.getCliente("", datosCliente);
                        this.listaClientes.sustituyeCliente(indice, cliente);
                        break;

                    case "Semi VIP":

                        cliente = ClienteFactory.getCliente("ClienteSemiVIP", datosCliente);
                        this.listaClientes.sustituyeCliente(indice, cliente);
                        break;

                    case "VIP":
                        cliente = ClienteFactory.getCliente("ClienteVIP", datosCliente);
                        this.listaClientes.sustituyeCliente(indice, cliente);
                        break;
                }
                this.bd.modificaCliente(cliente);
                
                Notificacion notificacion = new Notificacion("Cliente modificado");
                this.Escritorio.add(notificacion);
                notificacion.toFront();
                this.dispose();

            }
        } catch (FormatoIncorrectoException | NoExisteException ex) {
            Notificacion notificacion = new Notificacion(ex.getMessage());
            this.Escritorio.add(notificacion);
            notificacion.toFront();
        }

    }//GEN-LAST:event_jButton2ActionPerformed

    @Override
    public void dispose(){
super.dispose();
    this.listaClientesInterfaz.dispose();
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JRadioButton Cliente;
    private javax.swing.JTextField Direccion;
    private javax.swing.JTextField Nombre;
    private javax.swing.JRadioButton SemiVIP;
    private javax.swing.JTextField Telefono;
    private javax.swing.JRadioButton VIP;
    private javax.swing.JTextField dniCliente;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.ButtonGroup tipoCliente;
    // End of variables declaration//GEN-END:variables
}
