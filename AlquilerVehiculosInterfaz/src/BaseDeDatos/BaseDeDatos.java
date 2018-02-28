/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BaseDeDatos;

import alquilervehiculos.listas.clientes.ClienteFactory;
import alquilervehiculos.listas.clientes.ListaClientes;
import alquilervehiculos.listas.vehiculos.ListaVehiculos;
import alquilervehiculos.listas.vehiculos.VehiculoFactory;
import alquilervehiculos.modelo.alquiler.Alquiler;
import alquilervehiculos.modelo.clientes.Cliente;
import alquilervehiculos.modelo.clientes.DatosCliente;
import alquilervehiculos.modelo.vehiculos.Vehiculo;
import exceptions.FormatoIncorrectoException;
import exceptions.NoExisteException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author vesprada
 */
public class BaseDeDatos {

    private final Properties PROPIEDADES = new Properties();
    private String controllerBD = "";
    private String nombreBD = "";
    private String urlBD = "";
    private String usuarioBD = "";
    private String passwordBD = "";
    private Connection connection = null;
    private ListaVehiculos listaVehiculos = null;
    private ListaClientes listaClientes = null;

    public BaseDeDatos() {
        try (FileInputStream in = new FileInputStream("ficheros/conexionmysql.properties")) {

            this.PROPIEDADES.load(in);
            this.controllerBD = this.PROPIEDADES.getProperty("controller");
            this.nombreBD = this.PROPIEDADES.getProperty("nombre");
            this.urlBD = this.PROPIEDADES.getProperty("direccion");
            this.usuarioBD = this.PROPIEDADES.getProperty("usuario");
            this.passwordBD = this.PROPIEDADES.getProperty("contrasenya");

        } catch (FileNotFoundException ex) {
        } catch (IOException ex) {
        }
    }

    public Connection cargaBase() {
        try {
            Class.forName(this.controllerBD);
            this.connection = DriverManager.getConnection(this.urlBD + this.nombreBD, this.usuarioBD, this.passwordBD);
            return this.connection;
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

 

    public void importaVehiculos(ListaVehiculos listaVehiculos) {
        this.listaVehiculos = listaVehiculos;
        leeCoches();
        leeMicrobus();
        leeFurgoneta();
        leeCamion();
    }

    public void leeCoches() {
        String sql = "SELECT c.matricula,tp.numplazas FROM coches c\n"
                + "inner join transportespersonas tp\n"
                + "on c.matricula=tp.matricula";
        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {

                Vehiculo vehiculo = VehiculoFactory.getVehiculo("Coche", rs.getString("matricula"), rs.getString("numplazas"));

                listaVehiculos.anyadeVehiculo(vehiculo);

            }

        } catch (SQLException | FormatoIncorrectoException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leeMicrobus() {
        String sql = "SELECT mb.matricula,tp.numplazas FROM microbuses mb\n"
                + "inner join transportespersonas tp\n"
                + "on mb.matricula=tp.matricula";
        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {

                Vehiculo vehiculo = VehiculoFactory.getVehiculo("Microbus", rs.getString("matricula"), rs.getString("numplazas"));
                this.listaVehiculos.anyadeVehiculo(vehiculo);

            }

        } catch (SQLException | FormatoIncorrectoException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leeFurgoneta() {
        String sql = "SELECT f.matricula, tc.pma FROM furgonetas f\n"
                + "inner join transportescarga tc\n"
                + "on f.matricula=tc.matricula;";
        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {

                Vehiculo vehiculo = VehiculoFactory.getVehiculo("Furgoneta", rs.getString("matricula"), rs.getString("pma"));
                this.listaVehiculos.anyadeVehiculo(vehiculo);

            }

        } catch (SQLException | FormatoIncorrectoException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leeCamion() {
        String sql = "SELECT f.matricula, tc.pma FROM camiones f\n"
                + "inner join transportescarga tc\n"
                + "on f.matricula=tc.matricula;";
        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {

                Vehiculo vehiculo = VehiculoFactory.getVehiculo("Camion", rs.getString("matricula"), rs.getString("pma"));
                this.listaVehiculos.anyadeVehiculo(vehiculo);

            }

        } catch (SQLException | FormatoIncorrectoException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void importaClientes(ListaClientes listaClientes) {
        this.listaClientes = listaClientes;
        String sql = "SELECT tipo,dni,nombre,direccion,telefono FROM clientes;";
        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                DatosCliente datos = new DatosCliente(rs.getString("dni"), rs.getString("nombre"), rs.getString("direccion"), rs.getString("telefono"));
                String tipo = rs.getString("tipo");
                Cliente cliente = ClienteFactory.getCliente(rs.getString("tipo"), datos);
                this.listaClientes.anyadeCliente(cliente);

            }

        } catch (SQLException | FormatoIncorrectoException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void leeVehiculosAlquiladosAlgunaVez() { //esto lee el historial de alquilados y marca como alquilados los que aparezcan

        String sql = "SELECT * FROM historialalquileres;";

        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                Vehiculo vehiculo = this.listaVehiculos.buscaVehiculo(rs.getString("matricula"));//extrae el vehiculo por su matricula
                if (vehiculo != null) {
                    vehiculo.marcaComoAlquiladoAlgunaVez();//el vehiculo se marca como que ha sido alquilado alguna vez
                }

            }

        } catch (SQLException | NoExisteException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void importaAlquileres() {
        String sql = "SELECT v.matricula, a.cliente, a.dias, a.importe FROM alquileres a\n"
                + "inner join vehiculos v\n"
                + "on a.idalquiler=v.alquiler";

        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {

                Double precio = generaNumero(rs.getString("importe"));
                Vehiculo vehiculo = this.listaVehiculos.buscaVehiculo(rs.getString("matricula"));

                Cliente cliente = this.listaClientes.buscaCliente(rs.getString("cliente"));
                Alquiler alquiler = new Alquiler(cliente, Integer.parseInt(rs.getString("dias")), precio);
                vehiculo.alquilate(alquiler);

            }

        } catch (SQLException | NoExisteException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private double generaNumero(String cadena) {
        char[] caracteresCadena = cadena.toCharArray();
        String numeros = "";
        for (int i = 0; i < caracteresCadena.length; i++) {
            if (caracteresCadena[i] < 97 || caracteresCadena[i] > 122) {
                numeros += caracteresCadena[i];

            }

        }
        return Double.parseDouble(numeros);

    }

    public void exportaVehiculo(Vehiculo vehiculo) {

        String claseVehiculo = vehiculo.getClass().getSimpleName();
        String datos = vehiculo.datosAIntroducir();
        String[] datosATrozos = datos.split("\t\t");
        String alquilado = "";
        String matricula = datosATrozos[1];
        double dato = Double.parseDouble(datosATrozos[2]);
        if (vehiculo.haSidoAlquiladoAlgunaVez()) {
            alquilado = "S";
        } else {
            alquilado = "N";
        }
        Integer idalquiler = obtenIdAlquiler(vehiculo);
        String sql = "insert into vehiculos (matricula,alquiladoalgunavez,alquiler)\n"
                + "values (\"" + matricula + "\", \"" + alquilado + "\"," + idalquiler + ");";

        String sql2 = "";
        String sql3 = "";
        switch (claseVehiculo) {

            case "Coche":

                sql2 = "insert into transportespersonas\n"
                        + "values (\"" + matricula + "\", " + dato + ");\n";
                sql3 = "insert into coches\n"
                        + "values (\"" + matricula + "\")";
                break;

            case "Microbus":

                sql2 = "insert into transportespersonas\n"
                        + "values (\"" + matricula + "\", " + dato + ");\n";
                sql3 = "insert into microbuses\n"
                        + "values (\"" + matricula + "\")";
                break;

            case "Camion":

                sql2 = "insert into transportescarga\n"
                        + "values (\"" + matricula + "\", " + dato + ");\n";
                sql3 = "insert into camiones\n"
                        + "values (\"" + matricula + "\")";
                break;

            case "Furgoneta":

                sql2 = "insert into transportescarga\n"
                        + "values (\"" + matricula + "\", " + dato + ");\n";
                sql3 = "insert into furgonetas\n"
                        + "values (\"" + matricula + "\")";
                break;

        }
        try (Statement st = this.connection.createStatement()) {

            st.executeUpdate(sql);
            st.executeUpdate(sql2);
            st.executeUpdate(sql3);

        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaVehiculoParte1(Vehiculo vehiculo, Vehiculo vehiculoNuevo) { //encargado de borrar el vehiculo de las tablas, excepto en la tabla vehiculo
        String claseVehiculo = vehiculo.getClass().getSimpleName();                //asi se mantienen los alquileres y el historial
        String datos = vehiculo.datosAIntroducir();
        String[] datosATrozos = datos.split("\t\t");
        String matricula = datosATrozos[1];
        String sql = "";
        switch (claseVehiculo) {

            case "Coche":

                sql = "delete from transportespersonas\n"
                        + "where matricula=\"" + matricula + "\"";
                break;

            case "Microbus":

                sql = "delete from transportespersonas\n"
                        + "where matricula=\"" + matricula + "\"";
                break;

            case "Camion":

                sql = "delete from transportescarga\n"
                        + "where matricula=\"" + matricula + "\"";
                break;

            case "Furgoneta":

                sql = "delete from transportescarga\n"
                        + "where matricula=\"" + matricula + "\"";
                break;

        }
        try (Statement st = this.connection.createStatement()) {

            st.executeUpdate(sql);
            ModificaVehiculoParte2(vehiculoNuevo);

        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void ModificaVehiculoParte2(Vehiculo vehiculo) {        //se encarga de meter las modificaciones en las tablas que correspondan

        String claseVehiculo = vehiculo.getClass().getSimpleName();
        String datos = vehiculo.datosAIntroducir();
        String[] datosATrozos = datos.split("\t\t");
        String matricula = datosATrozos[1];
        double dato = Double.parseDouble(datosATrozos[2]);

        String sql2 = "";
        String sql3 = "";
        switch (claseVehiculo) {

            case "Coche":

                sql2 = "insert into transportespersonas\n"
                        + "values (\"" + matricula + "\", " + dato + ");\n";
                sql3 = "insert into coches\n"
                        + "values (\"" + matricula + "\")";
                break;

            case "Microbus":

                sql2 = "insert into transportespersonas\n"
                        + "values (\"" + matricula + "\", " + dato + ");\n";
                sql3 = "insert into microbuses\n"
                        + "values (\"" + matricula + "\")";
                break;

            case "Camion":

                sql2 = "insert into transportescarga\n"
                        + "values (\"" + matricula + "\", " + dato + ");\n";
                sql3 = "insert into camiones\n"
                        + "values (\"" + matricula + "\")";
                break;

            case "Furgoneta":

                sql2 = "insert into transportescarga\n"
                        + "values (\"" + matricula + "\", " + dato + ");\n";
                sql3 = "insert into furgonetas\n"
                        + "values (\"" + matricula + "\")";
                break;

        }
        try (Statement st = this.connection.createStatement()) {

            st.executeUpdate(sql2);
            st.executeUpdate(sql3);

        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void eliminaVehiculoPorMatricula(String matricula) {
        int id = obtenIdPorMatricula(matricula);
        String sql = "delete from vehiculos\n"
                + "where matricula=\"" + matricula + "\"";
        String sql2 = "delete from alquileres where idalquiler=" + id + ";";
        try (Statement st = this.connection.createStatement()) {

            st.executeUpdate(sql);
            if (id != 0) {
                st.executeUpdate(sql2);
            }
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    }


    private Integer obtenIdAlquiler(Vehiculo vehiculo) {
        Alquiler alquiler = vehiculo.getAlquiler();
        if (alquiler != null) {
            String matricula = vehiculo.getMatricula();
            Cliente cliente = alquiler.getCliente();
            DatosCliente datos = cliente.getDatos();
            String dni = datos.getDni();
            String sql = "SELECT a.idalquiler FROM alquileres a\n"
                    + "inner join vehiculos v\n"
                    + "on a.idalquiler=v.alquiler\n"
                    + "where a.cliente=\"" + dni + "\" and v.matricula=\"" + matricula + "\";";

            try (Statement st = this.connection.createStatement();
                    ResultSet rs = st.executeQuery(sql)) {
                while (rs.next()) {

                    return rs.getInt("idalquiler");
                }
            } catch (SQLException ex) {
                Logger.getLogger(BaseDeDatos.class
                        .getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void eliminaClientePorDni(String dni) {

        String sql = "delete from clientes\n"
                + "where dni=\"" + dni + "\"";
        String sql2 = "delete from alquileres where cliente='" + dni + "'";
        try (Statement st = this.connection.createStatement()) {

            st.executeUpdate(sql2);
            st.executeUpdate(sql);

        } catch (SQLException ex) {
            try (Statement st = this.connection.createStatement()) {

                st.executeUpdate(sql);

            } catch (SQLException ex1) {
                Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
    }

    public void exportaCliente(Cliente cliente) {

        String claseCliente = cliente.getClass().getSimpleName();
        int tipoCliente = 1;
        switch (claseCliente) {
            case "ClienteSemiVIP":
                tipoCliente = 2;
                break;
            case "ClienteVIP":
                tipoCliente = 3;
                break;
        }
        DatosCliente datos = cliente.getDatos();
        String dni = datos.getDni();
        String direccion = datos.getDireccion();
        String telefono = datos.getTelefono();
        String nombre = datos.getNombre();

        String sql = "insert into clientes\n"
                + "values (\"" + dni + "\",\"" + nombre + "\",\"" + direccion + "\"," + telefono + "," + tipoCliente + ")";

        try (Statement st = this.connection.createStatement()) {

            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void modificaCliente(Cliente cliente) {

        String claseCliente = cliente.getClass().getSimpleName();
        String tipoCliente = "Normal";
        switch (claseCliente) {
            case "ClienteSemiVIP":
                tipoCliente = "SemiVip";
                break;
            case "ClienteVIP":
                tipoCliente = "Vip";
                break;
        }
        DatosCliente datos = cliente.getDatos();
        String dni = datos.getDni();
        String direccion = datos.getDireccion();
        String telefono = datos.getTelefono();
        String nombre = datos.getNombre();

        String sql = "UPDATE `clientes` SET `nombre`='" + nombre + "', `direccion`='" + direccion + "', `telefono`='" + telefono + "', `tipo`='" + tipoCliente + "' WHERE `dni`='" + dni + "';";

        try (Statement st = this.connection.createStatement()) {

            st.executeUpdate(sql);

        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public double finanzas(javax.swing.JTable jTable1) {
        String sql = "SELECT * FROM historialalquileres;";
        double importeTotal = 0;
        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                String matricula = rs.getString("matricula");//extrae el vehiculo por su matricula
                String dni = rs.getString("dni");
                int dias = rs.getInt("numdias");
                Vehiculo vehiculo = this.listaVehiculos.buscaVehiculo(matricula);//extraemos el vehiculo de la lista
                Cliente cliente = null;

                cliente = this.listaClientes.buscaCliente(dni);//extraemos el cliente de la lista
                Alquiler alquilerOriginal = vehiculo.getAlquiler();//del vehiculo obtenido sacamos el alquiler y lo guardamos en un alquiler auxiliar
                vehiculo.alquilate(dias, cliente);//alquilamos el vehiculo con los datos del fichero y el cliente extraido
                Object[] newRaw = {"Matricula: " + matricula + " DNI: " + dni + " " + vehiculo.calculaPrecioAlquilerConDto(dias) + " euros"};
                DefaultTableModel dtm = (DefaultTableModel) jTable1.getModel();
                dtm.addRow(newRaw);
                importeTotal += vehiculo.calculaPrecioAlquilerConDto(dias);
                vehiculo.alquilate(alquilerOriginal);//realquilamos el vehiculo con el alquiler auxiliar

            }

        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        } catch (NoExisteException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return importeTotal;
    }

    public void alquilaVehiculo(Cliente cliente, Vehiculo vehiculo, double importe, int dias) {
        DatosCliente datos = cliente.getDatos();
        String dni = datos.getDni();
        String matricula = vehiculo.getMatricula();
        int idAlquiler = obtenIdUltimoAlquiler() + 1;
        String sql = "INSERT INTO `alquileres` VALUES (" + idAlquiler + ",'" + dni + "', '" + dias + "', '" + importe + "');";
        String sql2 = "UPDATE `vehiculos` SET `alquiler`='" + idAlquiler + "' WHERE `matricula`='" + matricula + "';";

        try (Statement st = this.connection.createStatement()) {

            st.executeUpdate(sql);
            st.executeUpdate(sql2);

        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private int obtenIdUltimoAlquiler() {
        String sql = "select idalquiler from alquileres\n"
                + "order by idalquiler desc\n"
                + "limit 1;";
        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                return rs.getInt("idalquiler");

            }

        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }
     private int obtenIdUltimoHistorialAlquiler() {
        String sql = "select id from historialalquileres\n"
                + "order by id desc\n"
                + "limit 1;";
        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                return rs.getInt("id");

            }

        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return 0;
    }

    public void devuelveVehiculo(Vehiculo vehiculo, Cliente cliente, int dias) {
        String matricula = vehiculo.getMatricula();
        int idHistorial = obtenIdUltimoHistorialAlquiler() + 1;
        int id=obtenIdAlquiler(vehiculo);
        String dni = cliente.getDatos().getDni();
        String sql = "INSERT INTO `historialalquileres`VALUES (" + idHistorial + ", '" + matricula + "', '" + dni + "', " + dias + ");";
        String sql2 = "UPDATE `vehiculos` SET `alquiler`=NULL WHERE `matricula`='" + matricula + "';";
        String sql3 = "DELETE FROM `alquileres` WHERE `idalquiler`=" + id + ";";

        try (Statement st = this.connection.createStatement()) {

            st.executeUpdate(sql);
            st.executeUpdate(sql2);
            st.executeUpdate(sql3);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

  

    private int obtenIdPorMatricula(String matricula) {
        String sql = "SELECT alquiler FROM vehiculos where matricula='" + matricula + "';";
        try (Statement st = this.connection.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {
                int id = rs.getInt("alquiler");

                return id;
            }
        } catch (SQLException ex) {
            return 0;
        }
        return 0;
    }
    public void pagaAlquiler(double pago, String matricula, int dias) {
        int id = obtenIdPorMatricula(matricula);
        String sql = "UPDATE `alquileres` SET `dias`="+dias+",`importe`=" + pago + " WHERE `idalquiler`=" + id + ";";
        try (Statement st = this.connection.createStatement()) {

            st.executeUpdate(sql);
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    public void cierraConexion(){
        try {
            this.connection.close();
        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }
}
