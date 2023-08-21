package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

class ReservaValidacionTest {

    private ReservaValidacion validacion;

    @BeforeEach
    public void configurarPruebas(){
        this.validacion = new ReservaValidacion();
        System.out.println("Iniciando Prueba   ");
    }

    @Test
    public void validarPersonasPorReservaFuncionaCorrectamente(){
        Integer numeroPrueba = 1;
        Boolean respuesta = Assertions.assertDoesNotThrow(()->this.validacion.validarPersonasPorReserva(numeroPrueba));
        Assertions.assertTrue(respuesta);
    }
    @Test
    public void validarPersonasPorReservaFincionaIncorrectoPorNumeroDePersonasPorREserva(){
        Integer numeroPrueba = 5;
        Exception respuesta = Assertions.assertThrows(Exception.class,()->this.validacion.validarPersonasPorReserva(numeroPrueba));
        Assertions.assertEquals(Mensaje.VALOR_INVALIDO.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarFechaReservaFuncionaCorrectamente(){
        String fechaPrueba = "20/08/2023";
        LocalDate respuesta = Assertions.assertDoesNotThrow(()->this.validacion.validarFechaReserva(fechaPrueba));
        Assertions.assertNotNull(respuesta);

    }
    @Test
    public void validarFechaReservaFuncionaIncorrectoPorFormato(){
        String fechaPrueba = "10-12-2023";
        Exception respuesta = Assertions.assertThrows(Exception.class,()->this.validacion.validarFechaReserva(fechaPrueba));
        Assertions.assertEquals(Mensaje.FECHA_INVALIDA.getMensaje(),respuesta.getMessage());
    }

}