package org.example.utilidades;

public enum Mensaje {
    NUMERO_CARACTERES_INVALIDO("El número de caracteres es inválido"),
    NOMBRE_INVALIDO ("El nombre solo acepta letras y espacio"),
    CORREO_INVALIDO ("Revisa el formato del correo"),
    UNICACION_INVALIDA ("La ubicacion solo puede ser un numero entre 1 y 4"),
    VALOR_NEGATIVO ("El valor no puede ser negativo"),
    VALOR_INVALIDO ("El numero ingresado no es valido"),
    TIPO_DATO_INVALIDO ("El tipo de dato no corresponde al campo"),
    FECHA_INVALIDA ("La fecha ingresada no es válida");



    private String mensaje;

    Mensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
