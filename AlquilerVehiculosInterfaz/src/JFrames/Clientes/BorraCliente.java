/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames.Clientes;

import BaseDeDatos.BaseDeDatos;
import JFrames.Notificacion;
import alquilervehiculos.listas.clientes.ListaClientes;
import alquilervehiculos.listas.vehiculos.ListaVehiculos;
import alquilervehiculos.menu.LecturaDatosMenu;
import alquilervehiculos.modelo.vehiculos.Vehiculo;
import exceptions.FormatoIncorrectoException;
import exceptions.NoExisteException;
import javax.swing.JDesktopPane;

/**
 *
 * @author Adrian
 */
public class BorraCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form BorraClientes
     */
    private JDesktopPane Escritorio;
    private ListaClientes listaClientes;
    private ListaVehiculos listaVehiculos;
    private ListaClientesInterfaz listaClientesInterfaz;
    private BaseDeDatos bd;

    public BorraCliente(ListaClientes listaClientes, ListaVehiculos listaVehiculos, JDesktopPane Escritorio,BaseDeDatos bd) {
        super("Borrado de Clientes", true, true, false, true);
        this.Escritorio = Escritorio;
        this.listaVehiculos = listaVehiculos;
        this.listaClientes = listaClientes;
        this.bd=bd;
        this.listaClientesInterfaz = new ListaClientesInterfaz();
        this.listaClientes.informacionDeTodosLosClientes(this.listaClientesInterfaz);
        this.Escritorio.add(this.listaClientesInterfaz);
        super.pack();
        this.setVisible(true);
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        dniCliente = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        BorraCliente = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        dniCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dniClienteActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("DNI");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel2.setText("Borrado de Cliente");

        BorraCliente.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        BorraCliente.setText("Borra Cliente");
        BorraCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BorraClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Selecciona un cliente de la lista");

        jLabel4.setText("o escribe su DNI");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(BorraCliente)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel1)
                                    .addGap(18, 18, 18)
                                    .addComponent(dniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 118, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(jLabel4))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addGap(1, 1, 1)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(dniCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                .addComponent(BorraCliente)
                .addGap(36, 36, 36))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void dniClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dniClienteActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dniClienteActionPerformed

    private void BorraClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BorraClienteActionPerformed
        try {
            dniCliente.setText(this.listaClientesInterfaz.datoSeleccionado());
            String dni = dniCliente.getText();
            LecturaDatosMenu.leeDni(dni);
            dni = dni.toUpperCase();
            this.listaClientes.buscaCliente(dni);
            boolean tieneAlgoAlquilado = false;
            tieneAlgoAlquilado = this.listaVehiculos.buscaAlquilerPorDni(dni, this.listaClientes);
            Vehiculo vehiculo = this.listaVehiculos.VehiculoAlquiladoPorDni(dni);
            if (tieneAlgoAlquilado) {

                EliminarCliente ventana = new EliminarCliente("El cliente " + dni + " tiene algo alquilado.", "¿Realmente quiere eliminarlo?", dni, listaClientes, Escritorio, vehiculo,this.bd);
                Escritorio.add(ventana);
                this.listaClientesInterfaz.dispose();
                this.dispose();

            } else {//si el vehiculo no esta alquilado
                eliminaCliente(dni);
                this.bd.eliminaClientePorDni(dni);
                Notificacion notificacion = new Notificacion("Cliente borrado");
                this.Escritorio.add(notificacion);
                notificacion.toFront();
                this.listaClientesInterfaz.dispose();
                this.dispose();

            }
        } catch (FormatoIncorrectoException | NoExisteException ex) {
            Notificacion notificacion = new Notificacion(ex.getMessage());
            this.Escritorio.add(notificacion);
            notificacion.toFront();
        }


    }//GEN-LAST:event_BorraClienteActionPerformed
    private void eliminaCliente(String dni) {
        try {
            int indice = this.listaClientes.buscaClienteDevuelveIndice(dni);//obtiene el indice para poder borrar el vehiculo
            this.listaClientes.borraCliente(indice);
        } catch (NoExisteException ex) {
        }

    }

    /**
     * @param args the command line arguments
     */
    @Override
    public void dispose() {
        super.dispose();
        this.listaClientesInterfaz.dispose();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BorraCliente;
    private javax.swing.JTextField dniCliente;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
