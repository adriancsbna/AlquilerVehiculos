/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.vehiculos;

import alquilervehiculos.modelo.alquiler.Alquiler;
import alquilervehiculos.modelo.clientes.Cliente;
import alquilervehiculos.modelo.clientes.DatosCliente;
import exceptions.FormatoIncorrectoException;

/**
 * Representa a un vehículo
 *
 * @author Rober
 */
public abstract class Vehiculo {

    private final String matricula;
    private Alquiler alquiler;
    private boolean alquiladoAlgunaVez;
    private static final double PRECIO_ALQUILER_BASE = 50.;

    public Vehiculo(String matricula) throws FormatoIncorrectoException {

        if (matricula.toUpperCase().matches("\\d{4}[A-Z]{3}")) {
            this.matricula = matricula;
        } else {
            throw new FormatoIncorrectoException("La matrícula no es correcta. Imposible crear al vehículo");
        }

        this.alquiladoAlgunaVez = false;
        this.alquiler = null;
    }

    /**
     * Indica si un vehículo está alquilado
     *
     * @return
     */
    public boolean estaAlquilado() {
        return alquiler != null;
    }

    /**
     * Indica si un vehículo ha sido alquilado alguna vez
     *
     * @return
     */
    public boolean haSidoAlquiladoAlgunaVez() {

        return this.alquiladoAlgunaVez;
    }

    public void marcaComoAlquiladoAlgunaVez() {
        this.alquiladoAlgunaVez = true;
    }

    /**
     * Calcula el precio de alquiler de ese vehículo (sin tener en cuenta el dto
     * por cliente)
     *
     * @param numDias
     * @return
     */
    public double calculaPrecioAlquiler(int numDias) {

        return PRECIO_ALQUILER_BASE * numDias;
    }

    /**
     * Calcula el precio de alquiler de ese vehículo (teniendo en cuenta el dto
     * por cliente)
     *
     * @param numDias
     * @return
     */
    public abstract double calculaPrecioAlquilerConDto(int numDias);

    /**
     * Indica si un vehículo tiene una matrícula determinada
     *
     * @param matricula
     * @return
     */
    public boolean tieneEstaMatricula(String matricula) {
        return matricula.equals(this.matricula);
    }

    /**
     * Alquila un vehículo determinado
     *
     * @param dias
     * @param cliente El cliente que alquila ese vehículo
     */
    public void alquilate(int dias, Cliente cliente) {
        if (!this.estaAlquilado()) {
            this.alquiler = new Alquiler(cliente, dias);
            this.alquiladoAlgunaVez = true;
        }
    }

    public void alquilate(Alquiler alquiler) {
        this.alquiler = alquiler;
    }

    /**
     * Realiza un pago sobre un alquiler
     *
     * @param cantidadPagada
     */
    public void realizaPagoSobreAlquiler(double cantidadPagada) {

        if (this.estaAlquilado()) {
            this.alquiler.realizaPago(cantidadPagada);
        }
    }

    /**
     * Calcula el precio del alquiler incluyendo el dto por el tipo de cliente y
     * el estado del vehículo
     *
     * @param precioInicialSinDto
     * @return
     */
    protected double calculaPrecioAlquilerConDto(double precioInicialSinDto) {

        if (!this.estaAlquilado()) {

            return precioInicialSinDto;
        }

        return redondearDecimales(this.alquiler.calculaPrecioAlquilerAplicandoDto(this, precioInicialSinDto), 2);
    }

    private static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }

    /**
     * Comprueba si el alquiler en curso está pendiente de pago
     *
     * @param numDiasFinales
     * @return
     */
    public boolean estaAlquilerPendienteDePago(int numDiasFinales) {

        if (this.estaAlquilado()) {
            double precioAlquiler = this.calculaPrecioAlquiler(numDiasFinales);
            double precioFinalAlquiler = this.alquiler.calculaPrecioAlquilerAplicandoDto(this, precioAlquiler);

            precioFinalAlquiler += this.alquiler.calculaPenalizacionAlquilerPorRetraso(numDiasFinales);

            return this.alquiler.estaAlquilerPendienteDePago(precioFinalAlquiler);
        } else {
            return false;
        }
    }

    /**
     * Obtiene el dinero que está pendiente de pago para el alquiler en curso
     *
     * @param numDiasFinales
     * @return
     */
    public Double dineroPendienteDePago(int numDiasFinales) {

        if (this.estaAlquilado()) {
            double precioAlquiler = this.calculaPrecioAlquiler(numDiasFinales);
            double precioFinalAlquiler = this.alquiler.calculaPrecioAlquilerAplicandoDto(this, precioAlquiler);

            precioFinalAlquiler += this.alquiler.calculaPenalizacionAlquilerPorRetraso(numDiasFinales);

            return this.alquiler.dineroPendienteDePago(precioFinalAlquiler);
        }

        return null;
    }

   

    public void liberaVehiculo() {
        this.alquiler = null;
    }

    @Override
    public String toString() {
        return " Matrícula: " + this.matricula;
    }

    public String datosAIntroducir() {
        return this.getClass().getSimpleName() + "\t\t" + this.matricula;

    }

    public String getMatricula() {
        return this.matricula;

    }

    public Alquiler getAlquiler() {
        return this.alquiler;
    }

    public boolean EstaAlquiladoPorDni(String dni) {
        try {
            Cliente cliente = this.alquiler.getCliente();
            DatosCliente datos = cliente.getDatos();
            String dniCliente = datos.getDni();
            if (dni.equalsIgnoreCase(dniCliente)) {
                return true;
            } else {
                return false;

            }
        } catch (Exception ex) {
        }
        return false;
    }
}
