/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.clientes;

import alquilervehiculos.modelo.vehiculos.Vehiculo;
import exceptions.FormatoIncorrectoException;

/**
 * Cliente VIP
 * @author Rober
 */
public class ClienteVIP extends Cliente {
    
    private static final double DESCUENTO = 0.15;
    public ClienteVIP(String dni, String nombre, String direccion, String telefono) throws FormatoIncorrectoException {
        super(dni, nombre, direccion, telefono);
    }
    
    public ClienteVIP (DatosCliente datosCliente) {
        
        super(datosCliente);
    }

    @Override
    public double obtieneDescuento(Vehiculo vehiculo) {
        return DESCUENTO;
    }
    
    @Override
    public int calculaPenalizacionAlquilerPorRetraso(int diasContratado, int diasUsado) {
        return 0;
    }
}
