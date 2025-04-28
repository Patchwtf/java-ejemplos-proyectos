package org.example.conectorSQL;

import java.sql.*;
import java.util.HashMap;
import java.util.Objects;

public class procedimientosSQL {
    public static void consultaInicial(HashMap<String,String> conexion) {
        try(Connection myConn = DriverManager.getConnection(conexion.get("link"), conexion.get("user"), conexion.get("pwd"));
            Statement myStamt = myConn.createStatement();
            ResultSet myRes = myStamt.executeQuery(conexion.get("query"));){

            System.out.println("Genial, nos conectamos");
            while(myRes.next()){
                System.out.println(myRes.getString("first_name") + "\t" + myRes.getString("email"));
            }
        } catch (SQLException e){
            System.out.println("Ni modos, algo salió mal \n" + e.getLocalizedMessage() + " | Error Code:" + e.getErrorCode());
        }
    }

    public static void insercionDatos(HashMap<String,String> conexion, HashMap<String,String> empleado) {
        try(Connection myConn = DriverManager.getConnection(conexion.get("link"), conexion.get("user"), conexion.get("pwd"));
            PreparedStatement myStamt = myConn.prepareStatement(conexion.get("query"));){
            System.out.println("Genial, nos conectamos");
            myStamt.setString(1, empleado.get("nombre"));
            myStamt.setString(2, empleado.get("apellidoP"));
            myStamt.setString(3, empleado.get("apellidoM"));
            myStamt.setString(4, empleado.get("mail"));
            if(empleado.get("salary") != null && !empleado.get("salary").isEmpty()) {
                try {
                    myStamt.setDouble(5, Double.parseDouble(empleado.get("salary")));
                } catch (NumberFormatException e) {
                    myStamt.setNull(5, Types.DOUBLE);
                }
            } else {
                myStamt.setNull(5, Types.DOUBLE);
            }
            int rowsAffected = myStamt.executeUpdate();
            if(rowsAffected>0) System.out.println("Se ha creado un nuevo empleado");
        } catch (SQLException e){
            System.out.println("Ni modos, algo salió mal \n" + e.getLocalizedMessage() + " | Error Code:" + e.getErrorCode());
        }
    }

    public static void actualizacionDatos(HashMap<String,String> conexion) {
        try(Connection myConn = DriverManager.getConnection(conexion.get("link"), conexion.get("user"), conexion.get("pwd"));
            Statement myStamt = myConn.createStatement();
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM employees");){
            System.out.println("Genial, nos conectamos");
            int rowsAffected = myStamt.executeUpdate(conexion.get("query"));
            while(myRes.next()) System.out.println(myRes.getString("first_name") +"\t"+ myRes.getString("email"));
        } catch (SQLException e){
            System.out.println("Ni modos, algo salió mal \n" + e.getLocalizedMessage() + " | Error Code:" + e.getErrorCode());
        }
    }

    public static void eliminacionDatos(HashMap<String,String> conexion) {
        try(Connection myConn = DriverManager.getConnection(conexion.get("link"), conexion.get("user"), conexion.get("pwd"));
            Statement myStamt = myConn.createStatement();
            ResultSet myRes = myStamt.executeQuery("SELECT * FROM employees");){
            System.out.println("Genial, nos conectamos");
            int rowsAffected = myStamt.executeUpdate(conexion.get("query"));
            while(myRes.next()) System.out.println(myRes.getString("first_name") +"\t"+ myRes.getString("email"));
        } catch (SQLException e){
            System.out.println("Ni modos, algo salió mal \n" + e.getLocalizedMessage() + " | Error Code:" + e.getErrorCode());
        }
    }
}
