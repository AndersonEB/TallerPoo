package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class UsuarioValidacionTest {
    //Crear un objeto de la clase que se va a probar
    private UsuarioValidacion validacion;
    //Preparar las pruebas que vamos a realizar
    @BeforeEach
    public void configurarPruebas(){
        this.validacion = new UsuarioValidacion();
        System.out.println("Iniciando Prueba  ");
    }
    //Programamos nuestras pruebas unitarias
    @Test
    public void validarNombresFuncionaCorrectamente(){
        String nombrePrueba = "Anderson Echavarria Blandon"; //Preparo
        Boolean respuesta = Assertions.assertDoesNotThrow(()->this.validacion.validarNombres(nombrePrueba));
        Assertions.assertTrue(respuesta);
    }
    @Test
    public void validarNombresFuncionaIncorrectoPorNumeroDeCaracteres(){
        String nombrePrueba = "Andy ";
        Exception respuesta = Assertions.assertThrows(Exception.class,()->this.validacion.validarNombres(nombrePrueba));
        Assertions.assertEquals(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje(),respuesta.getMessage());

    }
    @Test
    public void validarNombresFuncionaIncorrectoPorCaracteresInvalidos(){
        String nombrePrueba = "4anderson 3chavarria Bland0n";
        Exception respuesta = Assertions.assertThrows(Exception.class,()->this.validacion.validarNombres(nombrePrueba));
        Assertions.assertEquals(Mensaje.NOMBRE_INVALIDO.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarCorreoFuncionaCorrectamente(){
        String correoPrueba = "anderson@gmail.com";
        Boolean respuesta = Assertions.assertDoesNotThrow(()->this.validacion.validarCorreo(correoPrueba));
        Assertions.assertTrue(respuesta);
    }

    @Test
    public void validarCorreoFuncionaIncorrectoPorFormato(){
        String correoPrueba = "anderson.com";
        Exception respuesta = Assertions.assertThrows(Exception.class,()->this.validacion.validarCorreo(correoPrueba));
        Assertions.assertEquals(Mensaje.CORREO_INVALIDO.getMensaje(),respuesta.getMessage());
    }

    @Test
    public void validarUbicacionFuncionaCorrectamente(){
         Integer ubicacionPrueba = 1;
         Boolean respuesta = Assertions.assertDoesNotThrow(()->this.validacion.validarUbicacion(ubicacionPrueba));
         Assertions.assertTrue(respuesta);


    }

    @Test
    public void validarUbicacionFuncionaIncorrecto(){
        Integer ubicacionPrueba = 5;
        Exception respuesta = Assertions.assertThrows(Exception.class,()->this.validacion.validarUbicacion(ubicacionPrueba));
        Assertions.assertEquals(Mensaje.UNICACION_INVALIDA.getMensaje(),respuesta.getMessage());
    }

}