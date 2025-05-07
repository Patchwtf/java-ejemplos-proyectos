package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class MensajesDAO {
    private static Conexion myConn;

    private static Connection getInstance() throws SQLException {
        if(myConn == null) myConn = new Conexion();
        return myConn.get_connection();
    }

    public static void crearMensajeBD(Mensajes mensaje){
        try(Connection cnx = getInstance();
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

    public static List<Mensajes> leerMensajesBD(){
        return null;
    }

    public static void borrarMensajesBD(int id_mensaje){

    }

    public static void actualizarMensajesBD(Mensajes mensaje){

    }
}
