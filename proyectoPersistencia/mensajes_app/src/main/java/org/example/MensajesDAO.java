package org.example;

import java.lang.module.ResolutionException;
import java.sql.*;
import java.util.ArrayList;
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
        try(Connection cnx = getInstance();
            Statement myStamt = cnx.createStatement();
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM mensajes");){
            List<Mensajes> recopilado = new ArrayList<>();
            while(myRes.next()){
                Mensajes msg = new Mensajes();
                msg.setId_mensaje(myRes.getInt("id_mensaje"));
                msg.setMensaje(myRes.getString("mensaje"));
                msg.setAutor_mensaje(myRes.getString("autor_mensaje"));
                msg.setFecha_mensaje(myRes.getString("fecha_mensaje"));
                recopilado.add(msg);
            }
            return recopilado;
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public static void borrarMensajesBD(int id_mensaje) throws SQLException {
        try(Connection cnx = getInstance();
            PreparedStatement myStamt = cnx.prepareStatement("DELETE FROM mensajes WHERE id_mensaje = ?")){
            myStamt.setInt(1, id_mensaje);
            int row_affeced = myStamt.executeUpdate();
            System.out.println("Filas afectadas: " + row_affeced);
        }
    }

    public static void actualizarMensajesBD(Mensajes mensaje){

    }
}
