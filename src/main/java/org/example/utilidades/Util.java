package org.example.utilidades;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Util {
    public Boolean validarExpresionRegular(String cadena, String expresionRegular) {
        Pattern patron = Pattern.compile(expresionRegular);
        Matcher coincidencia = patron.matcher(cadena);
        if (coincidencia.matches()) {
            return true;
        } else {
            return false;
        }

    }

    public Integer generarId() {
        Integer IdR;
        IdR = (int) (Math.random() * 100);
        return IdR;
    }

    public LocalDate validarFomatoFecha(String fecha, String patronFecha){
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern(patronFecha);
            return LocalDate.parse(fecha, formato);
        } catch (DateTimeParseException e) {
            return null;
        }

    }


}

