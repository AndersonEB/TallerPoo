package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LocalValidacionTest {
    private LocalValidacion validacion;

    @BeforeEach
    public void configurarPruebas(){
        this.validacion = new LocalValidacion();
        System.out.println("Iniciando Prueba   ");
    }
    @Test
    public void  validarNitFuncionaCorrectamente(){
        String nitPrueba = "0987654321";
        Boolean respuesta = Assertions.assertDoesNotThrow(()->this.validacion.validarNit(nitPrueba));
        Assertions.assertTrue(respuesta);
    }
    @Test
    public void validarNitFuncionaIncorrectoPorNumeroDeCaracteres() {
        String nitPrueba = "09876543";
        Exception respuesta = Assertions.assertThrows(Exception.class, () -> this.validacion.validarNit(nitPrueba));
        Assertions.assertEquals(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje(), respuesta.getMessage());
    }

    @Test
    public void validarNitFuncionaIncorrectoPorTipoDeDato(){
        String nitPrueba = "asdfghjklñ";
        Exception respuesta = Assertions.assertThrows(Exception.class,()->this.validacion.validarNit(nitPrueba));
        Assertions.assertEquals(Mensaje.TIPO_DATO_INVALIDO.getMensaje(),respuesta.getMessage()
        );
    }
    @Test
    public void validarNombreFuncionaCorrecto(){
        String nombrePrueba = "Anderson Echavarria Blandon"; //Preparo
        Boolean respuesta = Assertions.assertDoesNotThrow(()->this.validacion.validarNombre(nombrePrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void valoidarNombreFuncionaIncorrectoPorNumeroDeCaracteres(){
        String nombrePrueba = "Teatro Hipopotomonstrosesquipedaliofobia Cesde";
        Exception respuesta = Assertions.assertThrows(Exception.class,()->this.validacion.validarNombre(nombrePrueba));
        Assertions.assertEquals(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje(),respuesta.getMessage());
    }


}