
import alquilervehiculos.modelo.clientes.Cliente;
import alquilervehiculos.modelo.clientes.ClienteSemiVIP;
import alquilervehiculos.modelo.clientes.DatosCliente;
import alquilervehiculos.modelo.vehiculos.Camion;
import alquilervehiculos.modelo.vehiculos.Coche;
import exceptions.FormatoIncorrectoException;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Rober
 */
public class TestAlquiler {
    
    public static void main(String [] args) throws FormatoIncorrectoException {
        
        Cliente clienteSemiVIP = new ClienteSemiVIP("11111111A", "Rober", "Calle Uno", "965121212");
        Coche coche = new Coche(3, "1111AAA");
        
        // Compruebo que el cálculo del alquiler para vehiculos no alquilados es correcto
        
        double precioAlquiler = coche.calculaPrecioAlquilerConDto(12);
        double precioEsperado = 72.5;
        
        if (precioAlquiler == precioEsperado) {
            System.out.println("OK");
        }
        else {
            System.out.println("Error, el precio del alquiler debería ser " + precioEsperado);
        }
       
        // Compruebo que al alquilar un vehículo, está efectivamente alquilado y que está pendiente de pago
        
        coche.alquilate(12, clienteSemiVIP);
        
        if (coche.estaAlquilerPendienteDePago(12)) {
            System.out.println("OK");
        }
        else {
            System.out.println("Error, el alquiler debería estar pendiente de paogo");
        }
        
        if (coche.estaAlquilado()) {
            System.out.println("OK");
        }
        else {
            System.out.println("Error, el alquiler debería estar alquilado");
        }
        
        // Compruebo que el precio después de alquilarlo es correcto
        double precioEsperadoConDto = 65.25;
        precioAlquiler = coche.calculaPrecioAlquilerConDto(12);
        
        if (precioAlquiler == precioEsperadoConDto) {
            System.out.println("OK");
        }
        else {
            System.out.println("Error, el precio del alquiler debería ser " + precioEsperado);
        }
        
        
        // Compruebo que al realizar un pago el coche está pendiente de pago para un número de días mayor al alquilado
        coche.realizaPagoSobreAlquiler(65.25);
        
        if (coche.estaAlquilerPendienteDePago(16)) {
            System.out.println("OK");
        }
        else {
            System.out.println("Error, el vehiculo debería estar pendiente de pago");
        }
        
        
        // Compruebo que al realizar el pago sobre el alquiler correspondiente a los días restantes, permite liberar al coche
        coche.realizaPagoSobreAlquiler(coche.calculaPrecioAlquilerConDto(4));
        
        if (!coche.estaAlquilerPendienteDePago(16)) {
            System.out.println("OK");
        }
        else {
            System.out.println("Error, el vehiculo debería estar pendiente de pago");
        }
        
        
    }
}
