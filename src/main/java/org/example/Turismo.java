package org.example;

import org.example.entidades.Local;
import org.example.entidades.Oferta;
import org.example.entidades.Reserva;
import org.example.entidades.Usuario;

import java.util.Scanner;

public class Turismo {
    public static void main(String[] args) throws Exception {

        Usuario usuario = new Usuario();
        Local local = new Local();
        Reserva reserva = new Reserva();
        Oferta oferta = new Oferta();
        Scanner lea = new Scanner(System.in);


        System.out.println("\u001B[35m*****BIENVENIDO******\u001B[0m");
        System.out.println("\u001B[34m1. Datos del usuario: \u001B[0m");
        System.out.print("Digite su nombre y apellidos: ");
        usuario.setNombres(lea.nextLine());
        System.out.println("Digite su documento: ");
        usuario.setDocumento(lea.nextLine());
        System.out.println("Digite su correo: ");
        usuario.setCorreo(lea.nextLine());
        System.out.println("Digite su ubicación: ");
        usuario.setUbicacion(lea.nextInt());

        System.out.println("\u001B[34m1.Local: \u001B[0m");
        System.out.println("Digite el nombre del local: ");
        local.setNombre(lea.nextLine());
        System.out.println("Digite el Nit del local:  ");
        local.setNit(lea.nextLine());
        System.out.println("Digite la descripcion del local: ");
        local.setDescripcion(lea.nextLine());

        System.out.println("\u001B[34m1.Oferta: \u001B[0m");
        System.out.println("Digite el titulo de la oferta: ");
        oferta.setTitulo(lea.nextLine());
        System.out.println("Digite la fecha de inicio: ");
        oferta.setFechaInicio(lea.nextLine());
        System.out.println("Digite la fecha de fin: ");
        oferta.setFechaFin(lea.nextLine());
        System.out.println("Digite el costo por persona");
        oferta.setCostoPersona(lea.nextDouble());
        System.out.println("\u001B[34m1.Reserva: \u001B[0m");
        System.out.println("Ingrese la fecha de su reserva");
        reserva.setFechaReserva(lea.nextLine());
        System.out.println("Ingrese el numero de personas para su reserva");
        reserva.getPersonasPorReserva(lea.nextInt());


    }
}


