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
        HashMap<String, String> empleado = new HashMap<>(2){{put("nombre","");put("apellido","");}};

        //Primer consulta
        datos.put("query", "SELECT * FROM employees");
        consultaInicial(datos);

        //Consulta compleja
        datos.put("query","INSERT INTO employees (first_name, pa_surname) values (?,?)");
        empleado.put("nombre","Rosalda");
        empleado.put("apellido","Ramirez");
        insercionDatos(datos, empleado);

        datos.put("query", "SELECT * FROM employees");
        consultaInicial(datos);

    }


}