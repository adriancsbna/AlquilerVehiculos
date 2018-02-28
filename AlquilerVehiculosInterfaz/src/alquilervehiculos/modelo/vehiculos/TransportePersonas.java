/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.vehiculos;

import exceptions.FormatoIncorrectoException;

/**
 * Representa a los transportes de personas
 * @author Rober
 */
public abstract class TransportePersonas extends Vehiculo{

    private final int numPlazas;

    public TransportePersonas(int numPlazas, String matricula) throws FormatoIncorrectoException{
        super(matricula);
        this.numPlazas = numPlazas;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    @Override
    public String toString() {
        return super.toString() + " Número de plazas: " + numPlazas;
    }
    @Override
    public String datosAIntroducir(){
        return super.datosAIntroducir()+"\t\t"+this.numPlazas;
    }
}
