import java.sql.*;

//Descargar Imagen de MySQL de Docker
//docker pull mysql:9.3.0
//
//Para crear la Base, seguir el archivo ./conector/creacion_base.txt

public class Main {
    public static void main(String[] args) {

        Connection myConn = null;
        Statement myStamt = null;
        ResultSet myRes = null;

        try{
            myConn = DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "1234");
            System.out.println("Genial, nos conectamos");

            myStamt = myConn.createStatement();
            myRes = myStamt.executeQuery("SELECT * FROM EMPLOYEES");
        } catch (SQLException e){

            System.out.println("Ni modos, algo salió mal \n" + e.getLocalizedMessage() + " | Error Code:" + e.getErrorCode());
        }

    }
}