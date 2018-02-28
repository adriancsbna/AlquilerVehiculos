/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.listas.vehiculos;

import BaseDeDatos.BaseDeDatos;
import JFrames.Vehiculos.ListaVehiculosAlquiladosInterfaz;
import JFrames.Vehiculos.ListaVehiculosInterfaz;
import JFrames.Vehiculos.ListaVehiculosNoAlquiladosInterfaz;
import alquilervehiculos.listas.clientes.ListaClientes;
import alquilervehiculos.modelo.alquiler.Alquiler;
import alquilervehiculos.modelo.clientes.Cliente;
import alquilervehiculos.modelo.clientes.DatosCliente;
import alquilervehiculos.modelo.vehiculos.Vehiculo;
import exceptions.NoExisteException;
import exceptions.VehiculoOcupadoException;
import exceptions.YaExisteException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Gestiona la lista de vehiculos del sistema
 *
 * @author Rober
 */
public class ListaVehiculos {

    private ArrayList<Vehiculo> listaVehiculos;

    public ListaVehiculos() {

        this.listaVehiculos = new ArrayList();
    }

    /**
     * Añade un vehículo al sistema
     *
     * @param vehiculo El vehículo que será añadido
     */
    public void anyadeVehiculo(Vehiculo vehiculo) {

        this.listaVehiculos.add(vehiculo);
    }

    /**
     * Obtiene el precio de alquiler del vehiculo
     *
     * @param matricula Matricula del vehiculo a calcular su precio de alquiler
     * @param numDias Numero de dias que ha durado el alquiler
     * @return un precio del alquiler mayor que 0 en caso de que el vehiculo
     * exista, si no existe o no hay vehiculos en el sistema devolverá null
     */
    public Double obtienePrecioAlquiler(String matricula, int numDias) throws NoExisteException {

        for (Vehiculo i : this.listaVehiculos) {

            if ((i).tieneEstaMatricula(matricula)) {

                return (i).calculaPrecioAlquiler(numDias);
            }
        }

        throw new NoExisteException("El vehículo no existe");
    }

    /**
     * Muestra la información de todos los vehículos del programa
     *
     * @return
     */
    public String informacionDeTodosLosVehiculos(ListaVehiculosInterfaz listaVehiculos) {

        String infoTodosVehiculos = "";
        for (Vehiculo i : this.listaVehiculos) {
            listaVehiculos.introduceDatosEnTabla((i).toString());
            infoTodosVehiculos += (i) + "\n";
        }

        if (infoTodosVehiculos.length() == 0) {
            infoTodosVehiculos = "No hay vehículos en la lista";
        }

        return infoTodosVehiculos;
    }

    /**
     * Crea la información referente a los vehículos no alquilados
     *
     * @return
     */
    public String informacionDeLosVehiculosSinAlquilar() {

        String infoTodosVehiculos = "";
        for (Vehiculo i : this.listaVehiculos) {

            if (!(i).estaAlquilado()) {

                infoTodosVehiculos += (i) + "\n";
            }
        }

        if (infoTodosVehiculos.length() == 0) {
            infoTodosVehiculos = "No hay vehículos sin alquiler";
        }

        return infoTodosVehiculos;
    }

    public String informacionDeLosVehiculosSinAlquilar(ListaVehiculosNoAlquiladosInterfaz listaNoAlquilados) {

        String infoTodosVehiculos = "";
        for (Vehiculo i : this.listaVehiculos) {

            if (!(i).estaAlquilado()) {
                listaNoAlquilados.introduceDatosEnTabla((i).toString());
                infoTodosVehiculos += (i) + "\n";
            }
        }

        if (infoTodosVehiculos.length() == 0) {
            infoTodosVehiculos = "No hay vehículos sin alquiler";
        }

        return infoTodosVehiculos;
    }

    /**
     * Crea la información referente a los vehículos
     *
     * @return
     */
    public String informacionDeLosVehiculosAlquilados() throws NoExisteException {

        String infoTodosVehiculos = "";
        for (Vehiculo i : this.listaVehiculos) {

            if ((i).estaAlquilado()) {
                infoTodosVehiculos += (i) + "\n";
            }
        }

        if (infoTodosVehiculos.length() == 0) {
            throw new NoExisteException("No hay vehiculos alquilados");
        }

        return infoTodosVehiculos;
    }

    public String informacionDeLosVehiculosAlquilados(ListaVehiculosAlquiladosInterfaz listaAlquilados) throws NoExisteException {

        String infoTodosVehiculos = "";
        for (Vehiculo i : this.listaVehiculos) {

            if ((i).estaAlquilado()) {
                listaAlquilados.introduceDatosEnTabla((i).toString());

                infoTodosVehiculos += (i) + "\n";
            }
        }

        if (infoTodosVehiculos.length() == 0) {
            throw new NoExisteException("No hay vehiculos alquilados");
        }

        return infoTodosVehiculos;
    }

    public void obtenAlquiler(BufferedWriter out) throws IOException {
        out.write("Matricula\t\tCliente\t\tDias\t\tImportePagado");
        out.newLine();
        for (Vehiculo i : this.listaVehiculos) {

            if ((i).estaAlquilado()) {
                Alquiler alquiler = (i).getAlquiler();

                String datos = (i).getMatricula() + "\t\t" + alquiler.toString();
                out.write(datos);
                out.newLine();

            }
        }
        out.close();
    }

    /**
     * Busca el vehículo indicado en la lista y lo devuelve si no está alquilado
     *
     * @param matricula La matrícula del vehículo a buscar
     * @return El vehículo no alquilado encontrado
     * @throws NoExisteException En caso de que la matrícula no corresponda con
     * ningún vehículo del sistem
     * @throws VehiculoOcupadoException En caso de que la matrícula corresponda
     * un vehículo alquilado
     *
     *
     */
    public Vehiculo buscaVehiculo(String matricula) throws NoExisteException {
        for (Vehiculo i : this.listaVehiculos) {
            if ((i).tieneEstaMatricula(matricula)) {
                return (i);

            }
        }
        throw new NoExisteException("El vehiculo no existe");
    }

    public void ExisteVehiculo(String matricula) throws YaExisteException {
        for (Vehiculo i : this.listaVehiculos) {
            if ((i).tieneEstaMatricula(matricula)) {
                throw new YaExisteException("El vehiculo ya existe");

            }
        }
    }

    public int buscaVehiculoObtieneIndice(String matricula) {
        int contador = 0;
        for (Vehiculo i : this.listaVehiculos) {
            if ((i).tieneEstaMatricula(matricula)) {
                return contador;

            }
            contador++;
        }
        return 0;
    }

    public void borraVehiculo(int indice) {
        this.listaVehiculos.remove(indice);
    }

    public void sustituyeVehiculo(int indice, Vehiculo vehiculo) {
        this.listaVehiculos.set(indice, vehiculo);

    }

    public Vehiculo buscaVehiculoNoAlquilado(String matricula) throws NoExisteException, VehiculoOcupadoException {

        for (Vehiculo i : this.listaVehiculos) {

            if ((i).tieneEstaMatricula(matricula)) {

                if (!(i).estaAlquilado()) {
                    return (i);
                } else {
                    throw new VehiculoOcupadoException("El vehículo está ocupado");
                }
            }
        }

        throw new NoExisteException("El vehículo no existe");

    }

    /**
     * Busca el vehículo indicado en la lista y lo devuelve si está alquilado
     *
     * @param matricula La matrícula del vehículo a buscar
     * @return El vehículo alquilado encontrado
     * @throws NoExisteException En caso de que la matrícula no corresponda con
     * ningún vehículo del sistem
     * @throws VehiculoOcupadoException En caso de que la matrícula corresponda
     * un vehículo no alquilado
     */
    public Vehiculo buscaVehiculoAlquilado(String matricula) throws NoExisteException, VehiculoOcupadoException {

        for (Vehiculo i : this.listaVehiculos) {

            if ((i).tieneEstaMatricula(matricula)) {

                if (!(i).estaAlquilado()) {

                    throw new VehiculoOcupadoException("El vehículo no está ocupado");
                } else {
                    return (i);
                }
            }
        }

        throw new NoExisteException("El vehículo no existe");

    }

    public void introduceDatos(BufferedWriter out) throws IOException {//introduce los datos obtenidos con el metodo de abajo
        out.write("Vehiculo\t\tMatricula\t\tNumPlazas / PMA");
        out.newLine();
        for (int i = 0; i < listaVehiculos.size(); i++) {

            out.write(this.datosAIntroducir(i));

            out.newLine();

        }

    }

    public String datosAIntroducir(int i) {//retorna todos los datos de los vehiculos a introducir
        return this.listaVehiculos.get(i).datosAIntroducir();

    }

    public boolean buscaAlquilerPorDni(String dni, ListaClientes listaClientes) throws NoExisteException {//confirma o desmiente si hay algun vehiculo
        boolean tieneAlgoAlquilado = false;
        boolean siTiene = false;
        for (Vehiculo i : this.listaVehiculos) {

            tieneAlgoAlquilado = listaClientes.alquilerCliente(i, dni, false);//si es true se imprimen los vehiculos alquilados por x cliente
            if (tieneAlgoAlquilado) {
                siTiene = true;

            }

        }
        return siTiene;

    }

    public Double obtienePrecioAlquilerConDto(String matricula, int numDias) throws NoExisteException {

        for (Vehiculo i : this.listaVehiculos) {

            if ((i).tieneEstaMatricula(matricula)) {

                return (i).calculaPrecioAlquilerConDto(numDias);
            }
        }

        throw new NoExisteException("El vehículo no existe");
    }

    public Vehiculo VehiculoAlquiladoPorDni(String dni) {
        for (Vehiculo i : this.listaVehiculos) {

            if ((i).EstaAlquiladoPorDni(dni)) {
                return (i);
            }

        }

        return null;
    }

    public void exportaVehiculos(Connection conexion) {

        for (Vehiculo i : this.listaVehiculos) {
            String claseVehiculo = (i).getClass().getSimpleName();
            String datos = (i).datosAIntroducir();
            String[] datosATrozos = datos.split("\t\t");
            String alquilado = "";
            if ((i).haSidoAlquiladoAlgunaVez()) {
                alquilado = "S";
            } else {
                alquilado = "N";
            }
            Integer idalquiler = obtenIdAlquiler(i, conexion);
            String sql = "";
            switch (claseVehiculo) {

                case "Coche":

                    sql = "insert into vehiculos (matricula,alquiladoalgunavez,alquiler)\n"
                            + "values (" + datosATrozos[1] + ", " + alquilado + "," + idalquiler + ");\n"
                            + "insert into transportespersonas\n"
                            + "values (" + datosATrozos[1] + ", " + datosATrozos[2] + ");\n"
                            + "insert into coches\n"
                            + "values (" + datosATrozos[1] + ")";
                    break;

                case "Microbus":
                    sql = "insert into vehiculos (matricula,alquiladoalgunavez,alquiler)\n"
                            + "values (" + datosATrozos[1] + ", " + alquilado + "," + idalquiler + ");\n"
                            + "insert into transportespersonas\n"
                            + "values (" + datosATrozos[1] + ", " + datosATrozos[2] + ");\n"
                            + "insert into microbus\n"
                            + "values (" + datosATrozos[1] + ")";
                    break;

                case "Camion":
                    sql = "insert into vehiculos (matricula,alquiladoalgunavez,alquiler)\n"
                            + "values (" + datosATrozos[1] + ", " + alquilado + "," + idalquiler + ");\n"
                            + "insert into transportescarga\n"
                            + "values (" + datosATrozos[1] + ", " + datosATrozos[2] + ");\n"
                            + "insert into camion\n"
                            + "values (" + datosATrozos[1] + ")";
                    break;

                case "Furgoneta":
                    sql = "insert into vehiculos (matricula,alquiladoalgunavez,alquiler)\n"
                            + "values (" + datosATrozos[1] + ", " + alquilado + "," + idalquiler + ");\n"
                            + "insert into transportescarga\n"
                            + "values (" + datosATrozos[1] + ", " + datosATrozos[2] + ");\n"
                            + "insert into furgoneta\n"
                            + "values (" + datosATrozos[1] + ")";
                    break;

            }
            try (Statement st = conexion.createStatement()) {
                st.executeUpdate("SET FOREIGN_KEY_CHECKS = 0;\n"
                        + "TRUNCATE vehiculos;\n"
                        + "TRUNCATE transportepersonas;\n"
                        + "TRUNCATE transportecargas;\n"
                        + "TRUNCATE coches;\n"
                        + "TRUNCATE microbuses;\n"
                        + "TRUNCATE furgonetas;\n"
                        + "TRUNCATE camiones;\n"
                        + "SET FOREIGN_KEY_CHECKS = 1;");
                st.executeUpdate(sql);

            } catch (SQLException ex) {
                Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

    public Integer obtenIdAlquiler(Vehiculo vehiculo, Connection conexion) {
        Alquiler alquiler = vehiculo.getAlquiler();
        String matricula = vehiculo.getMatricula();
        Cliente cliente = alquiler.getCliente();
        DatosCliente datos = cliente.getDatos();
        String dni = datos.getDni();
        String sql = "SELECT a.idalquiler FROM alquileres a\n"
                + "inner join vehiculos v\n"
                + "on a.idalquiler=v.alquiler\n"
                + "where a.cliente=\"" + dni + "\" and v.matricula=\"" + matricula + "\";";

        try (Statement st = conexion.createStatement();
                ResultSet rs = st.executeQuery(sql)) {
            while (rs.next()) {

                return rs.getInt("idalquiler");

            }

        } catch (SQLException ex) {
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
