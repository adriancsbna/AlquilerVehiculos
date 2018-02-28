/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package alquilervehiculos.menu;

import exceptions.FormatoIncorrectoException;

/**
 *
 * @author Rober
 */
public final class LecturaDatosMenu {

    public static String compruebaMatricula(String matricula) throws FormatoIncorrectoException {

        return leeDatoSegunPatron("Matrícula:", "\\d{4}[A-Z]{3}", "No se cumple con el patrón de matriculas", matricula);
    }

    public static String leeDni(String dni) throws FormatoIncorrectoException {
        return leeDatoSegunPatron("Dni:", "\\d{8}[a-zA-Z]{1}", "No se cumple con el patrón de dni", dni);
    }

    private static String leeDatoSegunPatron(String descripcionDato, String patron, String mensajeError, String datoAControlar) throws FormatoIncorrectoException {

        if (datoAControlar.toUpperCase().matches(patron)) {

            return datoAControlar.toUpperCase();
        } else {
            throw new FormatoIncorrectoException(mensajeError);
        }
    }

    public static Integer compruebaDias(Integer numero, double minimo, double maximo) throws FormatoIncorrectoException {

        if (numero >= minimo && numero <= maximo) {
            return numero;
        } else {
            throw new FormatoIncorrectoException("Has superado el numero de dias");

        }

    }

    public static boolean consultaPagado(double pagado, double precio) throws FormatoIncorrectoException {
        if (pagado <= precio) {
            return true;
        } else {
            throw new FormatoIncorrectoException("Has pagado mas de lo debido");
        }

    }

    public static double redondearDecimales(double valorInicial, int numeroDecimales) {
        double parteEntera, resultado;
        resultado = valorInicial;
        parteEntera = Math.floor(resultado);
        resultado = (resultado - parteEntera) * Math.pow(10, numeroDecimales);
        resultado = Math.round(resultado);
        resultado = (resultado / Math.pow(10, numeroDecimales)) + parteEntera;
        return resultado;
    }
}
