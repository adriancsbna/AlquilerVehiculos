/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames.Clientes;

import BaseDeDatos.BaseDeDatos;
import JFrames.Notificacion;
import alquilervehiculos.listas.clientes.ListaClientes;
import alquilervehiculos.modelo.vehiculos.Vehiculo;
import exceptions.NoExisteException;
import javax.swing.JDesktopPane;

/**
 *
 * @author Adrian
 */
public class EliminarCliente extends javax.swing.JInternalFrame {

    /**
     * Creates new form Eliminar
     */
    private String dni;
    private ListaClientes listaClientes;
    private JDesktopPane Escritorio;
    private Vehiculo vehiculo;
    private BaseDeDatos bd;

    public EliminarCliente(String mensaje, String mensaje2, String dni,  ListaClientes listaClientes, JDesktopPane Escritorio, Vehiculo vehiculo, BaseDeDatos bd) {
        super("Eliminar", false, false, false, false);
        this.dni = dni;
        this.listaClientes = listaClientes;
        this.Escritorio = Escritorio;
        this.vehiculo = vehiculo;
        this.bd = bd;

        initComponents();

        this.jLabel1.setText(mensaje);
        this.jLabel2.setText(mensaje2);
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

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        Si = new javax.swing.JButton();
        No = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("jLabel1");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("jLabel2");

        Si.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        Si.setText("Si");
        Si.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SiActionPerformed(evt);
            }
        });

        No.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        No.setText("No");
        No.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(82, 82, 82)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(Si, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 224, Short.MAX_VALUE)
                        .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(90, 90, 90))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jLabel1)
                .addGap(35, 35, 35)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 50, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Si, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(No, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(21, 21, 21))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void SiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SiActionPerformed
        eliminaCliente(dni);
        Notificacion notificacion = new Notificacion("Cliente borrado");
        this.Escritorio.add(notificacion);
        this.vehiculo.liberaVehiculo();
        notificacion.toFront();
        this.dispose();
// TODO add your handling code here:
    }//GEN-LAST:event_SiActionPerformed

    private void eliminaCliente(String dni) {
        try {
            int indice = this.listaClientes.buscaClienteDevuelveIndice(dni);//obtiene el indice para poder borrar el vehiculo
            this.listaClientes.borraCliente(indice);
            this.bd.eliminaClientePorDni(dni);

        } catch (NoExisteException ex) {
        }

    }


    private void NoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NoActionPerformed
        this.dispose();
    }//GEN-LAST:event_NoActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton No;
    private javax.swing.JButton Si;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables
}