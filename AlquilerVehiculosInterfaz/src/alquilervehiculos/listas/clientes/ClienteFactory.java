/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.listas.clientes;

import alquilervehiculos.modelo.clientes.DatosCliente;
import alquilervehiculos.modelo.clientes.Cliente;
import alquilervehiculos.modelo.clientes.ClienteSemiVIP;
import alquilervehiculos.modelo.clientes.ClienteVIP;

/**
 * Crea un cliente según su tipo
 * @author Rober
 */
public class ClienteFactory {
    
     public static Cliente getCliente(String tipo, DatosCliente datosCliente) {
        
        if (tipo.equals("")||tipo.equals("Normal")) {
            return new Cliente(datosCliente);
        }
        else if (tipo.equals("ClienteVIP")||tipo.equals("Vip")){
            return new ClienteVIP(datosCliente);
        }
        else if (tipo.equals("ClienteSemiVIP")||tipo.equals("SemiVip")) {
            
           return new ClienteSemiVIP(datosCliente); 
        }
        
        return null;
    }
}
