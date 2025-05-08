package org.example;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MensajeService {

    static List<Mensajes> listaMensajes = new ArrayList<Mensajes>();

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

        listaMensajes = MensajesDAO.leerMensajesBD();
        for(Mensajes msg:listaMensajes){
            System.out.println("ID:" + msg.getId_mensaje() + "\tMensaje: " + msg.getMensaje() + "\t|\tAutor: " + msg.getAutor_mensaje());
        }
    }

    public static void borrarMensajes(){
        System.out.println("Lista de mensajes");
        listarMensajes();
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
        System.out.println("Lista de mensajes");
        listarMensajes();
        System.out.println("Ingrese el ID del mensaje que desea actualizar");
        Scanner sc = new Scanner(System.in);
        int id_mensaje = sc.nextInt();
        sc.nextLine();

        Map<Integer, Mensajes> mapMensajes = listaMensajes.stream().
                collect(Collectors.toMap(Mensajes::getId_mensaje, Function.identity()));
        Mensajes mensaje = mapMensajes.get(id_mensaje);

        System.out.println("Ingrese el nuevo mensaje");
        mensaje.setMensaje(sc.nextLine());
        System.out.println("Ingrese el nuevo autor");
        mensaje.setAutor_mensaje(sc.nextLine());

        MensajesDAO.actualizarMensajesBD(mensaje);
    }
}
