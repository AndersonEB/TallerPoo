package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.example.utilidades.Util;

public class LocalValidacion {

    protected Util util = new Util();
    public  LocalValidacion(){

    }
    public boolean validarNit(String nit) throws Exception {
        // 1. Validar que el NIT tenga 10 dígitos
        if (nit.length() != 10) {
            throw new Exception(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje());
        } else if (!nit.matches("^[0-9]+$")) { // 2. El NIT solo puede contener dígitos
            throw new Exception(Mensaje.TIPO_DATO_INVALIDO.getMensaje());
        } else {
            return true;
        }
    }
    public boolean validarNombre(String nombre) throws Exception {
        // 1. Validar que el nombre de la empresa no sobrepase los 30 caracteres
        if (nombre.length() > 30) {
            throw new Exception(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje());
        } else {
            return true;
        }
    }





}
