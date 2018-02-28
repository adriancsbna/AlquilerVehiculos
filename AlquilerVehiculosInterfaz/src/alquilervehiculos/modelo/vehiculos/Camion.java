/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.vehiculos;

import exceptions.FormatoIncorrectoException;

/**
 * Representa a un vehiculo camión
 * @author Rober
 */
public class Camion extends TransporteCarga{

    public static final double MAX_PMA = 18.5;
    
    public Camion(double PMA, String matricula) throws FormatoIncorrectoException {
        super(PMA, matricula);
    }

    @Override
    public double calculaPrecioAlquiler(int numDias) {
        
        return calculaPrecioAlquilerSinDto(numDias);
        
    }
    
    @Override
    public double calculaPrecioAlquilerConDto(int numDias) {
        
        double precioInicialSinDto = calculaPrecioAlquilerSinDto(numDias);
        return super.calculaPrecioAlquilerConDto(precioInicialSinDto);
    }

    private double calculaPrecioAlquilerSinDto(int numDias) {
        return super.calculaPrecioAlquiler(numDias) + 40.;
    }
    
    @Override
    public String toString() {
        
        return super.toString();
    }
    
    public String datosAIntroducir(){
    return super.datosAIntroducir();
    }
}
