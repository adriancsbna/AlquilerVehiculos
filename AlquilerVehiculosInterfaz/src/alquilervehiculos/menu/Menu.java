/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.menu;

import BaseDeDatos.BaseDeDatos;
import JFrames.Principal;
import alquilervehiculos.listas.clientes.ListaClientes;
import alquilervehiculos.listas.vehiculos.ListaVehiculos;


/**
 * Menú principal
 *
 * @author Rober
 */
public class Menu {

    private final ListaVehiculos listaVehiculos;
    private final ListaClientes listaClientes;
    private final BaseDeDatos bd;


    public Menu(BaseDeDatos bd) {
        this.bd=bd;
        this.listaVehiculos = new ListaVehiculos();

        this.listaClientes = new ListaClientes();

    }

    public void importarDatos(){
    this.bd.importaVehiculos(this.listaVehiculos);
    this.bd.importaClientes(this.listaClientes);
    this.bd.importaAlquileres();
    this.bd.leeVehiculosAlquiladosAlgunaVez();
    
    }

    public void muestraMenuPrincipal() {

       
       Principal principal = new Principal(this.listaVehiculos,  this.listaClientes,this.bd);

        principal.setVisible(true);
        
        
       
    }

    
}
