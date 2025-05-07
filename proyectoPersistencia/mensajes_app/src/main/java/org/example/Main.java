package org.example;

import java.sql.Connection;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);

            int opcion = 0;
            do{
                System.out.println("----------------------------------------------------");
                System.out.println("Aplicacion de mensajes");
                System.out.println("1. Crear mensaje");
                System.out.println("2. Listar mensaje");
                System.out.println("3. Editar mensaje");
                System.out.println("4. Eliminar Mensaje");
                System.out.println("5. Salir");

                opcion = sc.nextInt();

                switch (opcion){
                    case 1:
                        MensajeService.crearMensaje();
                        break;
                    case 2:
                        MensajeService.listarMensajes();
                        break;
                    case 3:
                        MensajeService.editarMensajes();
                        break;
                    case 4:
                        MensajeService.borrarMensajes();
                        break;
                    default:
                        break;
                }

            }while(opcion != 5);
    }
}