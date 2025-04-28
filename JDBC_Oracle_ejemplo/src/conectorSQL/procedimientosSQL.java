package conectorSQL;

import java.sql.*;
import java.util.HashMap;

public class procedimientosSQL {
    public static void consultaInicial(HashMap<String,String> conexion){
        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;
        try{
            myConn = DriverManager.getConnection(conexion.get("link"), conexion.get("user"), conexion.get("pwd"));
            System.out.println("Genial, nos conectamos");
            myStamt = myConn.createStatement();
            myRes = myStamt.executeQuery(conexion.get("query"));
            while(myRes.next()){
                System.out.println(myRes.getString("first_name"));
            }
            myConn.close();
        } catch (SQLException e){
            System.out.println("Ni modos, algo salió mal \n" + e.getLocalizedMessage() + " | Error Code:" + e.getErrorCode());
        }
    }

    public static void insercionDatos(HashMap<String,String> conexion, HashMap<String,String> empleado){
        Connection myConn = null;
        PreparedStatement myStamt = null;
        ResultSet myRes = null;
        try{
            myConn = DriverManager.getConnection(conexion.get("link"), conexion.get("user"), conexion.get("pwd"));
            System.out.println("Genial, nos conectamos");
            myStamt = myConn.prepareStatement(conexion.get("query"));
            myStamt.setString(1, empleado.get("nombre"));
            myStamt.setString(2, empleado.get("apellido"));

            int rowsAffected = myStamt.executeUpdate();

            if(rowsAffected>0) System.out.println("Se ha creado un nuevo empleado");
            myConn.close();
        } catch (SQLException e){
            System.out.println("Ni modos, algo salió mal \n" + e.getLocalizedMessage() + " | Error Code:" + e.getErrorCode());
        }
    }
}
