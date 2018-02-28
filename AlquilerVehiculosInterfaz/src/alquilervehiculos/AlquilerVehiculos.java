/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos;

import BaseDeDatos.BaseDeDatos;
import alquilervehiculos.menu.Menu;

/**
 *
 * @author Rober
 */
public class AlquilerVehiculos {

    /**
     * 
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        BaseDeDatos bd=new BaseDeDatos();
        bd.cargaBase();
        
        
        
        Menu menu = new Menu(bd);
        menu.importarDatos();
        menu.muestraMenuPrincipal();
    }
}
