/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames.Alquileres;

import BaseDeDatos.BaseDeDatos;
import JFrames.Notificacion;
import JFrames.Vehiculos.ListaVehiculosAlquiladosInterfaz;
import alquilervehiculos.listas.vehiculos.ListaVehiculos;
import alquilervehiculos.menu.LecturaDatosMenu;
import alquilervehiculos.modelo.alquiler.Alquiler;
import alquilervehiculos.modelo.vehiculos.Vehiculo;
import exceptions.FormatoIncorrectoException;
import exceptions.NoExisteException;
import exceptions.VehiculoOcupadoException;
import javax.swing.JDesktopPane;

/**
 *
 * @author Adrian
 */
public class DevuelveVehiculo extends javax.swing.JInternalFrame {

    /**
     * Creates new form DevuelveVehiculo
     */
    private JDesktopPane Escritorio;

    private static final int MAX_DIAS_ALQUILER = 365;
    private ListaVehiculos listaVehiculos;
    private String matriculaString;
    private Integer diasInt;
    private Alquiler alquiler;
    private Vehiculo vehiculo;
    private Double dineroPendienteDePago;
    private ListaVehiculosAlquiladosInterfaz listaAlquilados;
    private BaseDeDatos bd;

    public DevuelveVehiculo(ListaVehiculos listaVehiculos, JDesktopPane Escritorio,BaseDeDatos bd) {
        super("Devuelve vehiculo", true, true, false, true);
        try {
            this.listaVehiculos = listaVehiculos;
            this.Escritorio = Escritorio;
            this.bd=bd;
            this.listaAlquilados = new ListaVehiculosAlquiladosInterfaz();
            this.listaVehiculos.informacionDeLosVehiculosAlquilados(this.listaAlquilados);
            this.Escritorio.add(listaAlquilados);
            this.setVisible(true);

            initComponents();
            this.jPanel3.setVisible(false);

        } catch (NoExisteException ex) {
            Notificacion notificacion = new Notificacion(ex.getMessage());
            this.Escritorio.add(notificacion);
            notificacion.toFront();
        }
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
        jPanel1 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        matricula = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        dias = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        deberTexto = new javax.swing.JLabel();
        debes = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        pago = new javax.swing.JTextField();
        pagar = new javax.swing.JButton();
        devolverVehiculo = new javax.swing.JButton();
        comprobar = new javax.swing.JButton();

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel1.setText("Devolver vehiculo");

        jLabel2.setText("Matricula");

        jLabel7.setText("Puedes seleccionar de la lista");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel7))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(matricula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLabel3.setText("Dias");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(dias, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(dias, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        deberTexto.setText("Debes");

        debes.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        debes.setText("0");

        jLabel6.setText("Pago");

        pago.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagoActionPerformed(evt);
            }
        });

        pagar.setText("Pagar");
        pagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                pagarActionPerformed(evt);
            }
        });

        devolverVehiculo.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        devolverVehiculo.setText("Devolver vehiculo");
        devolverVehiculo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                devolverVehiculoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(devolverVehiculo)
                        .addGap(67, 67, 67))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(deberTexto)
                        .addGap(27, 27, 27)
                        .addComponent(debes, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pago)
                    .addComponent(pagar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(47, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(deberTexto)
                    .addComponent(debes)
                    .addComponent(jLabel6)
                    .addComponent(pago, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(devolverVehiculo)
                    .addComponent(pagar))
                .addContainerGap(25, Short.MAX_VALUE))
        );

        comprobar.setText("Comprobar");
        comprobar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comprobarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(102, 102, 102)
                        .addComponent(jLabel1))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(comprobar)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel1)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(37, 37, 37)
                        .addComponent(comprobar)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void devolverVehiculoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_devolverVehiculoActionPerformed
      //  vehiculo.liberaVehiculo(this.historialAlquileres);
          this.alquiler.setDias(this.diasInt);

        this.bd.devuelveVehiculo(vehiculo, this.alquiler.getCliente(), this.alquiler.getDias());
        this.vehiculo.liberaVehiculo();
        this.listaAlquilados.dispose();
        
        Notificacion notificacion = new Notificacion("Vehiculo devuelto");
        this.Escritorio.add(notificacion);
        notificacion.toFront();
        this.dispose();
    }//GEN-LAST:event_devolverVehiculoActionPerformed

    private void comprobarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comprobarActionPerformed
        try {
            String matricula = this.matricula.getText();
            if (matricula.equals("")) {
                this.matricula.setText(this.listaAlquilados.datoSeleccionado());
               matricula = this.matricula.getText();

            }
            this.matriculaString = this.matricula.getText();
            this.matriculaString = LecturaDatosMenu.compruebaMatricula(this.matricula.getText());
            this.listaVehiculos.buscaVehiculo(matricula);
            this.vehiculo = this.listaVehiculos.buscaVehiculoAlquilado(this.matriculaString);

            String diasR = this.dias.getText();
            this.diasInt = Integer.parseInt(diasR);
            this.alquiler = this.vehiculo.getAlquiler();
            int diasOriginales = this.alquiler.getDias();

            this.diasInt = LecturaDatosMenu.compruebaDias(this.diasInt, 1, MAX_DIAS_ALQUILER);
                 if (diasOriginales > this.diasInt) {
                throw new FormatoIncorrectoException("Has introducido menos dias");
            }
            this.dineroPendienteDePago = vehiculo.dineroPendienteDePago(this.diasInt);
            this.dineroPendienteDePago = LecturaDatosMenu.redondearDecimales(this.dineroPendienteDePago, 2);
       

            this.debes.setText(String.valueOf(this.dineroPendienteDePago));

            if (this.vehiculo.estaAlquilerPendienteDePago(this.diasInt)) {

                this.jPanel3.setVisible(true);
                if (this.vehiculo.estaAlquilerPendienteDePago(this.diasInt)) {
                    this.devolverVehiculo.setVisible(false);
                } else {
                    this.devolverVehiculo.setVisible(true);

                }
            } else {
                this.jPanel3.setVisible(true);
                this.pago.setVisible(false);
                this.pagar.setVisible(false);
                this.jLabel6.setVisible(false);
                this.devolverVehiculo.setVisible(true);
            }
        } catch (FormatoIncorrectoException | NoExisteException | VehiculoOcupadoException ex) {
            Notificacion notificacion = new Notificacion(ex.getMessage());
            this.Escritorio.add(notificacion);
            notificacion.toFront();
        } catch (NumberFormatException ex) {
            Notificacion notificacion = new Notificacion("No es un numero");
            this.Escritorio.add(notificacion);
            notificacion.toFront();
        }


    }//GEN-LAST:event_comprobarActionPerformed

    private void pagoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_pagoActionPerformed

    private void pagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_pagarActionPerformed

        try {
            Double pagoR = Double.parseDouble(this.pago.getText());
            LecturaDatosMenu.consultaPagado(pagoR, this.dineroPendienteDePago);
            
            vehiculo.realizaPagoSobreAlquiler(pagoR);

            this.bd.pagaAlquiler(this.alquiler.getPagado(), this.vehiculo.getMatricula(),this.diasInt);
            
            comprobarActionPerformed(evt);
        } catch (FormatoIncorrectoException ex) {
            Notificacion notificacion = new Notificacion(ex.getMessage());
            this.Escritorio.add(notificacion);
            notificacion.toFront();
        } catch (NumberFormatException ex) {
            Notificacion notificacion = new Notificacion("No es un numero");
            this.Escritorio.add(notificacion);
            notificacion.toFront();

        }

    }//GEN-LAST:event_pagarActionPerformed
    @Override
    public void dispose() {
        super.dispose();

        this.listaAlquilados.dispose();
    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton comprobar;
    private javax.swing.JLabel deberTexto;
    private javax.swing.JLabel debes;
    private javax.swing.JButton devolverVehiculo;
    private javax.swing.JTextField dias;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JTextField matricula;
    private javax.swing.JButton pagar;
    private javax.swing.JTextField pago;
    // End of variables declaration//GEN-END:variables
}