package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MensajesDAO {
    public static void crearMensajeBD(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection cnx = db_connect.get_connection();
            PreparedStatement myStamt = cnx.prepareStatement("INSERT INTO mensajes (mensaje, autor_mensaje) VALUES (?, ?)");){
            myStamt.setString(1, mensaje.getMensaje());
            myStamt.setString(2, mensaje.getAutor_mensaje());
            myStamt.executeUpdate();
            System.out.println("El mensaje se creó correctamente");
        } catch (Exception e) {
            System.out.println("El mensaje no se logró crear :(\n");
            throw new RuntimeException(e);
        }
    }

    public static void leerMensajesBD(){

    }

    public static void borrarMensajesBD(int id_mensaje){

    }

    public static void actualizarMensajesBD(Mensajes mensaje){

    }
}
