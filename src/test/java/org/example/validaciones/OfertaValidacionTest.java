package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class OfertaValidacionTest {
    private OfertaValidacion validacion;

    @BeforeEach
    public void configurarPruebas() {
        this.validacion = new OfertaValidacion();
        System.out.println("inicando prueba...");
    }

    @Test
    public void validartituloFuncionaCorrectamente() {
        String tituloPrueba = "LA MAZA ";
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.validacion.validarTitulo(tituloPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarTituloFincionaIncorrectoPorNumeroDeCaracteres() {
        String tituloPrueba = "LA Maza Cuatatatatatatatatata";
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.validacion.validarTitulo(tituloPrueba));
        Assertions.assertEquals(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarCostoPorPersonaFuncionaCorrectamente() {
        Double costoPrueba = 1000.0;
        Boolean respuesta = Assertions.assertDoesNotThrow(() -> this.validacion.validarCostoPersona(costoPrueba));
        Assertions.assertTrue(respuesta);

    }

    @Test
    public void validarCostoPorPersonaFuncionaInorrectoPorValorNegativo() {
        Double costoPrueba = -10.0;
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.validacion.validarCostoPersona(costoPrueba));
        Assertions.assertEquals(Mensaje.VALOR_NEGATIVO.getMensaje(), respuesta.getMessage());


    }
    @Test
    public void  validarFechaInicioFuncionaCorrecto(){
        String fechaPrueba= "06/06/2023";
        LocalDate respuesta= Assertions.assertDoesNotThrow(()->this.validacion.validarFechaInicio(fechaPrueba));
        Assertions.assertNotNull(respuesta);
    }

    @Test
    public void validarFechaInicioFuncionaIncorrectoPorFormato(){
        String fechaPrueba="06/23/06";
        Exception respuesta= Assertions.assertThrows(Exception.class,()->this.validacion.validarFechaInicio (fechaPrueba)) ;
        Assertions.assertEquals(Mensaje.FECHA_INVALIDA .getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarFechaFinFuncionaCorrecto(){
        String fechaPrueba= "06/06/2022";
        LocalDate respuesta= Assertions.assertDoesNotThrow(()->this.validacion.validarFechaFin(fechaPrueba));
        Assertions.assertNotNull(respuesta);
    }

    @Test
    public void validarFechaFinFuncionaInCorrectoPorFormato(){
        String fechaPrueba="01/01/03";
        Exception respuesta= Assertions.assertThrows(Exception.class,()->this.validacion.validarFechaFin(fechaPrueba)) ;
        Assertions.assertEquals(Mensaje.FECHA_INVALIDA .getMensaje(),respuesta.getMessage());
    }


    @Test
    public void validarRangoFechasFuncionaCorrecto(){
        LocalDate fechaIncio = LocalDate.of(2020, 1, 8);
        LocalDate fechaFin = LocalDate.of(2022, 1, 8);
        Boolean respuesta= Assertions.assertDoesNotThrow(()->this.validacion.validarRangoFechas(fechaIncio, fechaFin));
        Assertions.assertTrue(respuesta);

    }

    @Test
    public void validarRangoFechasFuncionaIncorrectoPorRango(){
        LocalDate fechaIncio = LocalDate.of(2022, 1, 8);
        LocalDate fechaFin = LocalDate.of(2020, 1, 8);
        Exception respuesta= Assertions.assertThrows(Exception.class,()->this.validacion.validarRangoFechas(fechaIncio,fechaFin));
        Assertions.assertEquals(Mensaje.FECHA_INVALIDA .getMensaje(),respuesta.getMessage());
    }

}