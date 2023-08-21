package org.example.entidades;

import org.example.utilidades.Util;
import org.example.validaciones.ReservaValidacion;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Reserva {
    Util util = new Util();
    private Integer id;
    private Usuario usuario;
    private Oferta oferta;
    private Double costoTotal;
    private LocalDate fechaReserva;
    private Integer personasPorReserva;
    protected ReservaValidacion validacion = new ReservaValidacion();

    public Reserva() {
    }

    public Reserva(Integer id, Usuario usuario, Oferta oferta, Double costoTotal, LocalDate fechaReserva,Integer personasPorReserva) {
        this.id = id;
        this.usuario = usuario;
        this.oferta = oferta;
        this.costoTotal = costoTotal;
        this.fechaReserva = fechaReserva;
        this.personasPorReserva = personasPorReserva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public Oferta getOferta() {
        return oferta;
    }

    public void setOferta(Oferta oferta) {
        this.oferta = oferta;
    }

    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal + (costoTotal*0.19);
    }

    public LocalDate getFechaReserva() {
        return fechaReserva;
    }

    public void setFechaReserva(String fechaReserva) throws Exception {
        try {
            DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            this.fechaReserva = LocalDate.parse(fechaReserva, formato);
        } catch (DateTimeParseException e) {
            throw new Exception("Ingrese una fecha de reserva válida (dd/mm/yyyy)");
        }
    }

    public Integer getPersonasPorReserva() {
        return personasPorReserva;
    }

    public void setPersonasPorReserva(Integer personasPorReserva) {
        try {
            this.validacion.validarPersonasPorReserva(personasPorReserva);
            this.personasPorReserva = personasPorReserva;
        }catch (Exception error){
            System.out.println("\u001B[31m"+error.getMessage()  + "\u001B[0m");
        }
    }

    }


