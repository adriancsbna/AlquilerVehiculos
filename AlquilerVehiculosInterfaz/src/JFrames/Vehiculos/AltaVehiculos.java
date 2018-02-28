/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JFrames.Vehiculos;

import BaseDeDatos.BaseDeDatos;
import JFrames.Notificacion;
import alquilervehiculos.listas.vehiculos.ListaVehiculos;
import alquilervehiculos.menu.LecturaDatosMenu;
import alquilervehiculos.modelo.vehiculos.Camion;
import alquilervehiculos.modelo.vehiculos.Coche;
import alquilervehiculos.modelo.vehiculos.Furgoneta;
import alquilervehiculos.modelo.vehiculos.Microbus;
import exceptions.FormatoIncorrectoException;
import exceptions.YaExisteException;
import java.text.DecimalFormat;
import javax.swing.JDesktopPane;
import javax.swing.JSpinner;
import javax.swing.SpinnerNumberModel;

/**
 *
 * @author vesprada
 */
public class AltaVehiculos extends javax.swing.JInternalFrame {

    /**
     * Creates new form AltaVehiculos
     */
    private ListaVehiculos listaVehiculos;
    private javax.swing.JDesktopPane Escritorio;
        private BaseDeDatos bd;


    public AltaVehiculos(ListaVehiculos listaVehiculos, JDesktopPane Escritorio, BaseDeDatos bd) {
        super("Alta de Vehiculos", true, true, false, true);

        this.listaVehiculos = listaVehiculos;
        this.Escritorio = Escritorio;
        this.bd=bd;
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

        jPanel5 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        Coche = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        plazasCoche = new javax.swing.JSlider();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        anyadirCoche = new javax.swing.JButton();
        matriculaCoche = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        Microbus = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        plazasMicrobus = new javax.swing.JSlider();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        anyadeMicrobus = new javax.swing.JButton();
        matriculaMicrobus = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        Furgoneta = new javax.swing.JPanel();
        jPanel8 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        anyadirFurgoneta = new javax.swing.JButton();
        matriculaFurgoneta = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        pmaFurgoneta = new javax.swing.JSpinner();
        Camion = new javax.swing.JPanel();
        jPanel12 = new javax.swing.JPanel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        matriculaCamion = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        pmaCamion = new javax.swing.JSpinner();

        plazasCoche.setMajorTickSpacing(1);
        plazasCoche.setMaximum(7);
        plazasCoche.setMinimum(1);
        plazasCoche.setMinorTickSpacing(1);
        plazasCoche.setPaintLabels(true);
        plazasCoche.setPaintTicks(true);
        plazasCoche.setSnapToTicks(true);
        plazasCoche.setToolTipText("");

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Plazas");

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Matricula");

        anyadirCoche.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        anyadirCoche.setText("Añadir Coche");
        anyadirCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anyadirCocheActionPerformed(evt);
            }
        });

        matriculaCoche.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matriculaCoche.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaCocheActionPerformed(evt);
            }
        });

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Coche");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(plazasCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(matriculaCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(46, 46, 46))
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(anyadirCoche))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel6Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(matriculaCoche, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addComponent(plazasCoche, javax.swing.GroupLayout.PREFERRED_SIZE, 43, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(anyadirCoche)
                .addContainerGap())
        );

        javax.swing.GroupLayout CocheLayout = new javax.swing.GroupLayout(Coche);
        Coche.setLayout(CocheLayout);
        CocheLayout.setHorizontalGroup(
            CocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CocheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CocheLayout.setVerticalGroup(
            CocheLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CocheLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Coche", Coche);

        plazasMicrobus.setMajorTickSpacing(2);
        plazasMicrobus.setMaximum(20);
        plazasMicrobus.setMinimum(1);
        plazasMicrobus.setMinorTickSpacing(1);
        plazasMicrobus.setPaintLabels(true);
        plazasMicrobus.setPaintTicks(true);
        plazasMicrobus.setToolTipText("");

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Plazas");

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Matricula");

        anyadeMicrobus.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        anyadeMicrobus.setText("Añadir Microbus");
        anyadeMicrobus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anyadeMicrobusActionPerformed(evt);
            }
        });

        matriculaMicrobus.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matriculaMicrobus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaMicrobusActionPerformed(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel6.setText("Microbus");

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addGap(9, 9, 9)
                        .addComponent(matriculaMicrobus, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(plazasMicrobus, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))))
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(anyadeMicrobus))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel6)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(matriculaMicrobus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(48, 48, 48)
                        .addComponent(jLabel4))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addGap(23, 23, 23)
                        .addComponent(plazasMicrobus, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(28, 28, 28)
                .addComponent(anyadeMicrobus)
                .addContainerGap())
        );

        javax.swing.GroupLayout MicrobusLayout = new javax.swing.GroupLayout(Microbus);
        Microbus.setLayout(MicrobusLayout);
        MicrobusLayout.setHorizontalGroup(
            MicrobusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MicrobusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        MicrobusLayout.setVerticalGroup(
            MicrobusLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(MicrobusLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Microbus", Microbus);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("PMA");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("Matricula");

        anyadirFurgoneta.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        anyadirFurgoneta.setText("Añadir Furgoneta");
        anyadirFurgoneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                anyadirFurgonetaActionPerformed(evt);
            }
        });

        matriculaFurgoneta.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matriculaFurgoneta.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaFurgonetaActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Furgoneta");

        pmaFurgoneta.setModel(new SpinnerNumberModel(0.5, 0, 1, 0.1)
        );
        JSpinner.NumberEditor editor = (JSpinner.NumberEditor)pmaFurgoneta.getEditor();
        DecimalFormat format = editor.getFormat();
        format.setMinimumFractionDigits(1);
        pmaFurgoneta.setName(""); // NOI18N
        pmaFurgoneta.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pmaFurgonetaPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGap(89, 89, 89)
                .addComponent(anyadirFurgoneta)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(jLabel8)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matriculaFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(pmaFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(138, 138, 138))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(matriculaFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(pmaFurgoneta, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(anyadirFurgoneta)
                .addContainerGap())
        );

        javax.swing.GroupLayout FurgonetaLayout = new javax.swing.GroupLayout(Furgoneta);
        Furgoneta.setLayout(FurgonetaLayout);
        FurgonetaLayout.setHorizontalGroup(
            FurgonetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FurgonetaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        FurgonetaLayout.setVerticalGroup(
            FurgonetaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(FurgonetaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Furgoneta", Furgoneta);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("PMA");

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Matricula");

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Añadir Camion");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        matriculaCamion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        matriculaCamion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                matriculaCamionActionPerformed(evt);
            }
        });

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel12.setText("Camion");

        pmaCamion.setModel(new SpinnerNumberModel(0.5, 0, 18.5, 0.1)
        );
        pmaCamion.setName(""); // NOI18N
        pmaCamion.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                pmaCamionPropertyChange(evt);
            }
        });

        javax.swing.GroupLayout jPanel12Layout = new javax.swing.GroupLayout(jPanel12);
        jPanel12.setLayout(jPanel12Layout);
        jPanel12Layout.setHorizontalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                        .addComponent(jLabel11)
                        .addGap(9, 9, 9)))
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(matriculaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(pmaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(147, 147, 147))
            .addGroup(jPanel12Layout.createSequentialGroup()
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(89, 89, 89)
                        .addComponent(jButton4))
                    .addGroup(jPanel12Layout.createSequentialGroup()
                        .addGap(122, 122, 122)
                        .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel12Layout.setVerticalGroup(
            jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel12Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(matriculaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(48, 48, 48)
                .addGroup(jPanel12Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(pmaCamion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(53, 53, 53)
                .addComponent(jButton4)
                .addContainerGap())
        );

        javax.swing.GroupLayout CamionLayout = new javax.swing.GroupLayout(Camion);
        Camion.setLayout(CamionLayout);
        CamionLayout.setHorizontalGroup(
            CamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CamionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        CamionLayout.setVerticalGroup(
            CamionLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(CamionLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel12, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jTabbedPane1.addTab("Camion", Camion);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 351, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(4, 4, 4)
                .addComponent(jTabbedPane1)
                .addGap(2, 2, 2))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(11, 11, 11)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(11, 11, 11))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void anyadirCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anyadirCocheActionPerformed
        try {
            int plazas = plazasCoche.getValue();
            String matricula = matriculaCoche.getText();
            matricula = LecturaDatosMenu.compruebaMatricula(matricula);
            this.listaVehiculos.ExisteVehiculo(matricula);
            Coche coche = new Coche(plazas, matricula);
            this.bd.exportaVehiculo(coche);
            this.listaVehiculos.anyadeVehiculo(coche);
            vehiculoAnyadido();

            this.dispose();
        } catch (FormatoIncorrectoException | YaExisteException ex) {

            Notificacion notificacion = new Notificacion(ex.getMessage());

            this.Escritorio.add(notificacion);
            notificacion.toFront();
        }

    }//GEN-LAST:event_anyadirCocheActionPerformed

    private void matriculaCocheActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaCocheActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaCocheActionPerformed

    private void anyadeMicrobusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anyadeMicrobusActionPerformed
        try {
            int plazas = plazasMicrobus.getValue();
            String matricula = matriculaMicrobus.getText();
            matricula = LecturaDatosMenu.compruebaMatricula(matricula);
            this.listaVehiculos.ExisteVehiculo(matricula);

            Microbus microbus = new Microbus(plazas, matricula);
            this.listaVehiculos.anyadeVehiculo(microbus);
                        this.bd.exportaVehiculo(microbus);

            vehiculoAnyadido();

            this.dispose();
        } catch (FormatoIncorrectoException | YaExisteException ex) {
            Notificacion notificacion = new Notificacion(ex.getMessage());
            this.Escritorio.add(notificacion);
            notificacion.toFront();
        }

    }//GEN-LAST:event_anyadeMicrobusActionPerformed

    private void matriculaMicrobusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaMicrobusActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaMicrobusActionPerformed

    private void anyadirFurgonetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_anyadirFurgonetaActionPerformed
        try {
            String pma = pmaFurgoneta.getValue().toString();
            double pmaReal = Double.parseDouble(pma);
            String matricula = matriculaFurgoneta.getText();
            matricula = LecturaDatosMenu.compruebaMatricula(matricula);
            this.listaVehiculos.ExisteVehiculo(matricula);

            Furgoneta furgoneta = new Furgoneta(pmaReal, matricula);
            this.listaVehiculos.anyadeVehiculo(furgoneta);
                        this.bd.exportaVehiculo(furgoneta);

            vehiculoAnyadido();

            this.dispose();
        } catch (FormatoIncorrectoException | YaExisteException ex) {
            Notificacion notificacion = new Notificacion(ex.getMessage());
            this.Escritorio.add(notificacion);
            notificacion.toFront();
        }

    }//GEN-LAST:event_anyadirFurgonetaActionPerformed

    private void matriculaFurgonetaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaFurgonetaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaFurgonetaActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        try {
            String pma = pmaCamion.getValue().toString();
            double pmaReal = Double.parseDouble(pma);
            String matricula = matriculaCamion.getText();
            matricula = LecturaDatosMenu.compruebaMatricula(matricula);
            this.listaVehiculos.ExisteVehiculo(matricula);

            Camion camion = new Camion(pmaReal, matricula);
            this.listaVehiculos.anyadeVehiculo(camion);
                        this.bd.exportaVehiculo(camion);

            vehiculoAnyadido();
            this.dispose();
        } catch (FormatoIncorrectoException | YaExisteException ex) {
            Notificacion notificacion = new Notificacion(ex.getMessage());
            this.Escritorio.add(notificacion);
            notificacion.toFront();

        }

        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton4ActionPerformed

    private void matriculaCamionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_matriculaCamionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_matriculaCamionActionPerformed

    private void pmaFurgonetaPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pmaFurgonetaPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_pmaFurgonetaPropertyChange

    private void pmaCamionPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_pmaCamionPropertyChange
        // TODO add your handling code here:
    }//GEN-LAST:event_pmaCamionPropertyChange
    private void vehiculoAnyadido() {
        Notificacion notificacion = new Notificacion("Vehiculo añadido");
        this.Escritorio.add(notificacion);
        notificacion.toFront();

    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel Camion;
    private javax.swing.JPanel Coche;
    private javax.swing.JPanel Furgoneta;
    private javax.swing.JPanel Microbus;
    private javax.swing.JButton anyadeMicrobus;
    private javax.swing.JButton anyadirCoche;
    private javax.swing.JButton anyadirFurgoneta;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel12;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField matriculaCamion;
    private javax.swing.JTextField matriculaCoche;
    private javax.swing.JTextField matriculaFurgoneta;
    private javax.swing.JTextField matriculaMicrobus;
    private javax.swing.JSlider plazasCoche;
    private javax.swing.JSlider plazasMicrobus;
    private javax.swing.JSpinner pmaCamion;
    private javax.swing.JSpinner pmaFurgoneta;
    // End of variables declaration//GEN-END:variables

}