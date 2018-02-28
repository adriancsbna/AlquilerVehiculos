/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.clientes;

import exceptions.FormatoIncorrectoException;

/**
 * Almacena los datos de un clientes
 * @author Rober
 */
public class DatosCliente {
    
    private final String dni;
    private final String nombre;

    
    private final String direccion;
    private final String telefono;

    public DatosCliente(String dni, String nombre, String direccion, String telefono) throws FormatoIncorrectoException {
        if (!dni.matches("\\d{8}[A-Z]{1}")) {
            throw new FormatoIncorrectoException("El formato del dni es erróneo");
        }
        
        if (!telefono.toUpperCase().matches("\\d{9}")) {
            throw new FormatoIncorrectoException("El formato del teléfono es erróneo");
        }
        
        this.dni = dni;
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    public String getDni() {
        return dni;
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public String getTelefono() {
        return telefono;
    }

    @Override
    public String toString() {
        return "DatosCliente{" + "dni=" + dni + ", nombre=" + nombre + ", direccion=" + direccion + ", telefono=" + telefono + '}';
    }
    
    
}
