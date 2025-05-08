package org.example;

import java.sql.SQLException;
import java.util.Scanner;

public class MensajeService {
    public static void crearMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("¿Cual mensaje quieres escribir?");
        String mensajeText = sc.nextLine();
        System.out.println("Tu nombre:");
        String nombre = sc.nextLine();

        Mensajes registro = new Mensajes();
        registro.setMensaje(mensajeText);
        registro.setAutor_mensaje(nombre);

        MensajesDAO.crearMensajeBD(registro);
    }
    public static void listarMensajes(){
        for(Mensajes msg:MensajesDAO.leerMensajesBD()){
            System.out.println("Mensaje: " + msg.getMensaje() + "\t|\tAutor: " + msg.getAutor_mensaje());
        }

        System.out.println(MensajesDAO.leerMensajesBD());
    }

    public static void borrarMensajes(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el id del mensaje a eliminar");
        int id_mensaje = sc.nextInt();
        try {
            MensajesDAO.borrarMensajesBD(id_mensaje);
            System.out.println("Mensaje eliminado correctamente");
        } catch (SQLException e) {
            System.out.println("No se logró eliminar el mensaje.\nCausa:");
            throw new RuntimeException(e);
        }
    }

    public static void editarMensajes(){

    }
}
