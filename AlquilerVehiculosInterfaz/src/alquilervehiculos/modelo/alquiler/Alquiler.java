/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.modelo.alquiler;

import alquilervehiculos.modelo.clientes.Cliente;
import alquilervehiculos.modelo.clientes.DatosCliente;
import alquilervehiculos.modelo.vehiculos.Vehiculo;

/**
 * Representa a los datos de un alquiler en curso
 *
 * @author Rober
 */
public class Alquiler {

    private Cliente cliente;
    private int dias;
    private double importePagado;

    private static final double DESCUENTO_VEHICULO_NUEVO = 0.25;

    public Alquiler(Cliente cliente, int dias) {
        this.cliente = cliente;
        this.dias = dias;
    }

    public Alquiler(Cliente cliente, int dias, double importePagado) {
        this.cliente = cliente;
        this.dias = dias;
        this.importePagado = importePagado;

    }

    /**
     * Incremente el importe pagado por un alquiler
     *
     * @param pago
     */
    public void realizaPago(double pago) {
        this.importePagado += pago;
    }

    /**
     * Obtiene el precio de un alquiler, según el vehículo y el precio inicial
     * sin el descuento
     *
     * @param vehiculo
     * @param precioInicialSinDescuento
     * @return
     */
    public double calculaPrecioAlquilerAplicandoDto(Vehiculo vehiculo, double precioInicialSinDescuento) {

        double precioConDto;
        double descuentoPorTipoCliente = this.cliente.obtieneDescuento(vehiculo);
        precioConDto = precioInicialSinDescuento - (precioInicialSinDescuento * descuentoPorTipoCliente);

        if (!vehiculo.haSidoAlquiladoAlgunaVez()) {
            precioConDto -= precioConDto * DESCUENTO_VEHICULO_NUEVO;
        }

        return precioConDto;
    }

    /**
     * Calcula la penalización de alquilar un vehículo con retraso
     *
     * @param numDiasFinal
     * @return
     */
    public int calculaPenalizacionAlquilerPorRetraso(int numDiasFinal) {

        return this.cliente.calculaPenalizacionAlquilerPorRetraso(dias, numDiasFinal);
    }

    /**
     * Indica si un vehículo está pendiente de pago
     *
     * @param precioFinal
     * @return
     */
    public boolean estaAlquilerPendienteDePago(double precioFinal) {

        if ((precioFinal - this.importePagado) > 0) {
            return true;
        }

        return false;
    }

    /**
     * Obtiene el dinero pendiente de pago
     *
     * @param precioFinal
     * @return
     */
    public double dineroPendienteDePago(double precioFinal) {

        return precioFinal - this.importePagado;
    }

    public String toString() {
        DatosCliente datos = this.cliente.getDatos();
        return datos.getDni() + "\t\t" + this.dias + "\t\t" + this.importePagado + "euros";
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public int getDias() {

        return this.dias;
    }

    public void setDias(int dias) {
        this.dias = dias;
    }

    public double getPagado() {
        return this.importePagado;
    }
}
