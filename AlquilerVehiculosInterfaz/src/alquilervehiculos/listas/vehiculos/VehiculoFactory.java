/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.listas.vehiculos;

import alquilervehiculos.modelo.vehiculos.Coche;
import alquilervehiculos.modelo.vehiculos.Microbus;
import alquilervehiculos.modelo.vehiculos.Furgoneta;
import alquilervehiculos.modelo.vehiculos.Vehiculo;
import alquilervehiculos.modelo.vehiculos.Camion;
import exceptions.FormatoIncorrectoException;

/**
 * Crea un vehículo segun su tipo
 * @author Rober
 */
public class VehiculoFactory {
    
    public static Vehiculo getVehiculo(String tipo, String matricula, String dato) throws FormatoIncorrectoException{
        
        if (tipo.equals("Coche")) {
            return new Coche(Integer.parseInt(dato), matricula);
        }
        else if (tipo.equals("Microbus")){
            return new Microbus(Integer.parseInt(dato), matricula);
        }
        else if (tipo.equals("Furgoneta")) {
            
           return new Furgoneta(Double.parseDouble(dato), matricula); 
        }
        else if (tipo.equals("Camion")) {
            
            return new Camion(Double.parseDouble(dato), matricula);
        }
        
        return null;
    }
}
