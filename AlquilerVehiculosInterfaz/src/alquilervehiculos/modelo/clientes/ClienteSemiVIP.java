/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.clientes;

import alquilervehiculos.modelo.vehiculos.TransportePersonas;
import alquilervehiculos.modelo.vehiculos.Vehiculo;
import exceptions.FormatoIncorrectoException;

/**
 * Cliente Semi VIP
 * @author Rober
 */
public class ClienteSemiVIP extends Cliente{
    
    private static final double DESCUENTO = 0.10;

    public ClienteSemiVIP(String dni, String nombre, String direccion, String telefono) throws FormatoIncorrectoException {
        super(dni, nombre, direccion, telefono);
    }
    
    public ClienteSemiVIP (DatosCliente datosCliente) {
        
        super(datosCliente);
    }

    @Override
    public double obtieneDescuento(Vehiculo vehiculo) {
        
        if (vehiculo instanceof TransportePersonas)
            return DESCUENTO;
        else 
            return 0.;
    }

    @Override
    public int calculaPenalizacionAlquilerPorRetraso(int diasContratado, int diasUsado) {
        return 0;
    }
    
    
    
}
