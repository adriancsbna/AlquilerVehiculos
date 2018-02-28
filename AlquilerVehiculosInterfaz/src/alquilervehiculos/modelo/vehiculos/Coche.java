/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.vehiculos;

import exceptions.FormatoIncorrectoException;

/**
 * Representa a un coche
 *
 * @author Rober
 */
public class Coche extends TransportePersonas {

    public static final int MAX_PLAZAS = 7;

    public Coche(int numPlazas, String matricula) throws FormatoIncorrectoException {
        super(numPlazas, matricula);
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
        return super.calculaPrecioAlquiler(numDias) + 1.5 * (super.getNumPlazas() + numDias);
    }

    @Override
    public String toString() {

        return super.toString();
    }

    @Override
    public String datosAIntroducir() {
        return super.datosAIntroducir();
    }

}
