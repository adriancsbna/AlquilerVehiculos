/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.listas.clientes;

import JFrames.Clientes.ListaClientesInterfaz;
import alquilervehiculos.modelo.alquiler.Alquiler;
import alquilervehiculos.modelo.clientes.Cliente;
import alquilervehiculos.modelo.clientes.DatosCliente;
import alquilervehiculos.modelo.vehiculos.Vehiculo;
import exceptions.NoExisteException;
import exceptions.YaExisteException;
import java.io.BufferedWriter;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Controla el listado de clientes dados de alta en el sistema
 *
 * @author Rober
 */
public class ListaClientes {

    private ArrayList<Cliente> listaClientes;

    public ListaClientes() {
        this.listaClientes = new ArrayList();

    }

    public void anyadeCliente(Cliente cliente) {

        this.listaClientes.add(cliente);
    }

   
    public Cliente buscaCliente(String dni) throws NoExisteException {
        for (Cliente i : this.listaClientes) {

            if ((i).tieneEsteDni(dni)) {

                return (i);
            }
        }

        throw new NoExisteException("El cliente no existe");
    }

    public void existeCliente(String dni) throws YaExisteException {
        for (Cliente i : this.listaClientes) {

            if ((i).tieneEsteDni(dni)) {
                throw new YaExisteException("El cliente ya existe");
            }
        }

    }

    public int buscaClienteDevuelveIndice(String dni) throws NoExisteException {//busca cliente por DNI y devuelve su indice
        int contador = 0;
        for (Cliente i : this.listaClientes) {

            if ((i).tieneEsteDni(dni)) {
                return contador;

            }
            contador++;
        }
        throw new NoExisteException("El cliente no existe");
    }

    public void borraCliente(int indice) {

        this.listaClientes.remove(indice);
    }

 
    public String informacionDeTodosLosClientes() {

        String infoTodosClientes = "";
        for (Cliente i : this.listaClientes) {

            infoTodosClientes += (i) + "\n";
        }

        if (infoTodosClientes.length() == 0) {
            infoTodosClientes = "No hay clientes en la lista";
        }

        return infoTodosClientes;
    }

    public void introduceDatos(BufferedWriter out) throws IOException {//va introduciendo los datos en el archivo
        out.write("NumDNI\t\tNombre\t\tDireccion\t\tTelefono\t\tVIP");
        out.newLine();
        for (int i = 0; i < listaClientes.size(); i++) {

            out.write(this.datosAIntroducir(i));

            out.newLine();

        }

    }

    public String datosAIntroducir(int i) {//hace un return de los datos del cliente que deseamos introducir
        Cliente cliente = this.listaClientes.get(i);
        String tipoCliente = cliente.getTipo();
        DatosCliente datos = cliente.getDatos();
        return datos.getDni() + "\t\t" + datos.getNombre() + "\t\t" + datos.getDireccion() + "\t\t" + datos.getTelefono() + "\t\t" + tipoCliente;

    }

    public boolean alquilerCliente(Vehiculo vehiculo, String dni, boolean compararOBorrar) throws NoExisteException {//

        Cliente cliente = buscaCliente(dni);// se busca el cliente con X dni
        Alquiler alquiler = vehiculo.getAlquiler();//obtiene el alquiler
        if (alquiler != null) {//si  hay alquiler
            Cliente clienteAlquiler = alquiler.getCliente();

            if (cliente == clienteAlquiler) {
                if (compararOBorrar) {
                    System.out.println("Tiene alquilado: " + vehiculo.toString());
                }

                return true;

            }

        }
        return false;

    }
     public String informacionDeTodosLosClientes(ListaClientesInterfaz listaClientes) {
         
        String infoTodosClientes = "";
        for (Cliente i : this.listaClientes) {
            listaClientes.introduceDatosEnTabla((i).toString());
            infoTodosClientes += (i) + "\n";
        }
        
        if (infoTodosClientes.length() == 0) {
            infoTodosClientes = "No hay vehículos en la lista";
        }
        
        return infoTodosClientes;
    }
     
      public void sustituyeCliente(int indice, Cliente cliente){
            this.listaClientes.set(indice,cliente);

    }
    
}
