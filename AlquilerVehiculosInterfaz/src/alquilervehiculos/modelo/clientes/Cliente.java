/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.clientes;

import alquilervehiculos.modelo.vehiculos.Vehiculo;
import exceptions.FormatoIncorrectoException;

/**
 * Representa a un cliente del sistema
 * @author Rober
 */
public class Cliente {

    private static final int PENALIZACION_POR_DIA_DE_RETRASO = 10;
    
    private DatosCliente datosCliente;
    
    public Cliente(String dni, String nombre, String direccion, String telefono) throws FormatoIncorrectoException {
        
        this.datosCliente = new DatosCliente(dni, nombre, direccion, telefono);
        
    }
    
    public Cliente (DatosCliente datosCliente) {
        
        this.datosCliente = datosCliente;
    }
    
    /**
     * Indica si un cliente tiene el dni dado
     * @param dni
     * @return 
     */
    public boolean tieneEsteDni(String dni) {
        return this.datosCliente.getDni().equals(dni);
    }

    /**
     * Obtiene el descuento para este tipo de cliente
     * @param vehiculo
     * @return 
     */
    public double obtieneDescuento(Vehiculo vehiculo) {
        
        return 0.;
    }
    
    /**
     * Calcula la penalizacion de este cliente según los días reales de alquiler
     * @param diasContratado
     * @param diasUsado
     * @return 
     */
    public int calculaPenalizacionAlquilerPorRetraso(int diasContratado, int diasUsado){
        
        int diferencia = diasUsado - diasContratado;
        
        if (diferencia > 0) {
            return diferencia * PENALIZACION_POR_DIA_DE_RETRASO;
        }
        
        return 0;
    }

    @Override
    public String toString() {
        return "Cliente{" + "datosCliente=" + datosCliente + '}';
    }
    public String getTipo(){
    String tipo= this.getClass().getSimpleName();
    switch(tipo){
        case "Cliente":
            return "Normal";
        case "ClienteSemiVIP":
            return "SemiVIP";
        case "ClienteVIP":
                return "VIP";
    }
    return null;
    }
    public DatosCliente getDatos(){
    return this.datosCliente;
    }
    
    

}
