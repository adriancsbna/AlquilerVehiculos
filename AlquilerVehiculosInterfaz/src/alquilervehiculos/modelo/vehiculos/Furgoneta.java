/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.vehiculos;

import exceptions.FormatoIncorrectoException;

/**
 * Representa a una furgoneta
 * @author Rober
 */
public class Furgoneta extends TransporteCarga{

    public static final double MAX_PMA = 0.5;
    
    public Furgoneta(double PMA, String matricula) throws FormatoIncorrectoException {
        super(PMA, matricula);
    }

    @Override
    public double calculaPrecioAlquiler(int numDias) {
        return super.calculaPrecioAlquiler(numDias);
    }

    @Override
    public double calculaPrecioAlquilerConDto(int numDias) {
        double precioInicialSinDto = super.calculaPrecioAlquiler(numDias);
        return super.calculaPrecioAlquilerConDto(precioInicialSinDto);
    }
    
    @Override
    public String toString() {
        
        return super.toString();
    }
    @Override
     public String datosAIntroducir(){
    return super.datosAIntroducir();
    }
}
