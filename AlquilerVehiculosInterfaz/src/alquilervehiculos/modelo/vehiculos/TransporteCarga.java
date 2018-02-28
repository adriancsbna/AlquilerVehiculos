/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.vehiculos;

import exceptions.FormatoIncorrectoException;

/**
 * Representa a los transportes de carga
 * @author Rober
 */
public abstract class TransporteCarga extends Vehiculo{

    private final double PMA;

    public TransporteCarga(double PMA, String matricula) throws FormatoIncorrectoException{
        super(matricula);
        this.PMA = PMA;
    }

    @Override
    public double calculaPrecioAlquiler(int numDias) {
        return super.calculaPrecioAlquiler(numDias) + 20. * this.PMA;
     }

    @Override
    public String toString() {
        return super.toString() + " PMA: " + this.PMA;
    }
    
    @Override
    public String datosAIntroducir(){
        return super.datosAIntroducir()+"\t\t"+this.PMA;
    }
}
