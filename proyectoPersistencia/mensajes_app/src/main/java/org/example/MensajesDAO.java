package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class MensajesDAO {
    public static void crearMensajeBD(Mensajes mensaje){
        Conexion db_connect = new Conexion();
        try(Connection cnx = db_connect.get_connection();
            PreparedStatement myStamt = cnx.prepareStatement("INSERT INTO employees (mensaje, autor_mensaje) VALUES (?, ?);");){

        } catch (Exception e) {
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
