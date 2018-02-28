/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.vehiculos;

/**
 *
 * @author vesprada
 */
public enum EnumVehiculos {
    COCHE, MICROBUS, FURGONETA, CAMION;

    public String getTipoVehiculo() {
        switch (this) {
            case COCHE:
                return "Coche";
            case MICROBUS:
                return "Microbus";
            case FURGONETA:
                return "Furgoneta";
            case CAMION:
                return "Camion";

        }
        return "";
    }

    public String toString() {
        return getTipoVehiculo();
    }
}
