package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.example.utilidades.Util;

import java.time.LocalDate;

public class OfertaValidacion {
    protected Util util = new Util();
    public OfertaValidacion(){

    }

    public boolean validarTitulo(String titulo) throws Exception {
        // 1. Validar que el título de la oferta no sobrepase los 20 caracteres
        if (titulo.length() > 20) {
            throw new Exception(Mensaje.NUMERO_CARACTERES_INVALIDO.getMensaje());
        } else {
            return true;
        }
    }
    public boolean validarCostoPersona(Double costoPersona) throws Exception{
        //El costo por persona no puede ser negativo
        if (costoPersona < 0){
            throw new Exception(Mensaje.VALOR_NEGATIVO.getMensaje());
        }else {
            return true;
        }
    }

    public LocalDate validarFechaInicio(String fechainicio) throws Exception {
        LocalDate fecha = util.validarFomatoFecha(fechainicio, "d/MM/yyyy");
        if (fecha == null) {
            throw new Exception(Mensaje.FECHA_INVALIDA.getMensaje());
        }
        return fecha;
    }

    public LocalDate validarFechaFin(String fechaFin) throws Exception {
        LocalDate fecha = util.validarFomatoFecha(fechaFin, "d/MM/yyyy");
        if (fecha == null) {
            throw new Exception(Mensaje.FECHA_INVALIDA.getMensaje());
        }
        return fecha;
    }


    public Boolean validarRangoFechas(LocalDate fechaInicio, LocalDate fechaFin) throws Exception {
        if (fechaInicio.isAfter(fechaFin)) {
            throw new Exception(Mensaje.FECHA_INVALIDA.getMensaje());
        }
        return true;
    }




}


