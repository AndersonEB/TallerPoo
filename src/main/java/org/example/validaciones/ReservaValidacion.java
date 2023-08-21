package org.example.validaciones;

import org.example.utilidades.Mensaje;
import org.example.utilidades.Util;

import java.time.LocalDate;

public class ReservaValidacion {
    protected Util util = new Util();
    public  ReservaValidacion(){

    }
    public boolean validarPersonasPorReserva(Integer personasPorReserva) throws Exception{
        //
        if (personasPorReserva > 4){
            throw new Exception(Mensaje.VALOR_INVALIDO.getMensaje());
        }else {
            return true;
        }
    }
    public LocalDate validarFechaReserva(String fechaReserva) throws Exception {
        LocalDate fecha = util.validarFomatoFecha(fechaReserva, "dd/MM/yyyy");
        if (fecha == null) {
            throw new Exception(Mensaje.FECHA_INVALIDA.getMensaje());
        }else{
            return fecha;
        }

    }

}

