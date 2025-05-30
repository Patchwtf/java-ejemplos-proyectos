import java.util.HashMap;

import static conectorSQL.procedimientosSQL.*;

//Descargar Imagen de MySQL de Docker
//docker pull mysql:9.3.0
//docker run --name mysql-server -e MYSQL_ROOT_PASSWORD=12345 -p 3306:3306 -d mysql:9.3.0
//docker exec -it some-mysql bash
//Para crear la Base, seguir el archivo ./conector/creacion_base.txt
//Para conectarte dentro del docker: mysql -h 127.0.0.1 -P 3306 -u root -p

public class Main {
    public static void main(String[] args) {
        HashMap<String, String> datos = new HashMap<>(4) {
            {
                put("link", "jdbc:mysql://localhost:3306/project");
                put("user", "root");
                put("pwd", "12345");
                put("query", "");
            }
        };
        HashMap<String, String> empleado = new HashMap<>(2){{put("nombre",null);put("apellidoP",null);put("apellidoM",null);put("mail",null);put("salary",null);}};

        //Primer consulta
        datos.put("query", "SELECT * FROM employees");
        consultaInicial(datos);

        //Insercion de registro
        System.out.println("################################\nInsercion");
        datos.put("query","INSERT INTO employees (first_name,pa_surname,ma_surname,email,salary) values (?,?,?,?,?)");
        empleado.put("nombre","Rosalda");
        empleado.put("apellidoP","Ramirez");
        insercionDatos(datos, empleado);

        datos.put("query", "SELECT * FROM employees");
        consultaInicial(datos);

        //Actualizacion y eliminacion de registro
        System.out.println("################################\n!!Actualizacion!! & Eliminacion");
        datos.put("query", "UPDATE employees SET email = 'rosa@mail.com' where first_name = 'Rosalda'");
        actualizacionDatos(datos);
        System.out.println("################################\nActualizacion & !!Eliminacion!!");
        datos.put("query", "DELETE from employees where first_name = 'Rosalda'");
        actualizacionDatos(datos);

    }
}